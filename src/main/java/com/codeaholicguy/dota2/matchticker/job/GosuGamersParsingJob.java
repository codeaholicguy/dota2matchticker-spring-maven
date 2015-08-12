/**
 * 
 */
package com.codeaholicguy.dota2.matchticker.job;

import java.io.IOException;

import javax.annotation.PostConstruct;

import com.codeaholicguy.dota2.matchticker.parser.GosuGamersParser;
import net.sf.ehcache.CacheException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.codeaholicguy.dota2.matchticker.constant.MatchType;

/**
 * @author HoangNN6
 * 
 */
public class GosuGamersParsingJob {

	private static final Log LOGGER = LogFactory.getLog(GosuGamersParsingJob.class);

	private static final Integer INTERVAL = 120000;

	ApplicationContext springContext = WebApplicationContextUtils.getWebApplicationContext(ContextLoaderListener.getCurrentWebApplicationContext().getServletContext());

	CacheManager cacheManager = (CacheManager) springContext.getBean("cacheManager");

	private TaskScheduler scheduler = new ConcurrentTaskScheduler();

	@PostConstruct
	private void executeJob() {
		scheduler.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				executeParsing();
			}
		}, INTERVAL);
	}

	/**
	 * Parse from gosugamer.
	 */
	private void executeParsing() {
		try {
			Long start = System.currentTimeMillis();
			Cache matchesCache = cacheManager.getCache(MatchType.MATCHES);
			synchronized (matchesCache) {
				matchesCache.put(MatchType.LIVE_MATCH, GosuGamersParser.getInstance().getLiveMatches());
				matchesCache.put(MatchType.UPCOMMING_MATCH, GosuGamersParser.getInstance().getUpCommingMatches());
				matchesCache.put(MatchType.RECENT_MATCH, GosuGamersParser.getInstance().getRecentResultMatches());
			}
			Long end = System.currentTimeMillis();
			LOGGER.info("finish parsing: " + ((end - start) / 1000) + "s");
		} catch (IllegalArgumentException e) {
			LOGGER.error(e.getMessage());
		} catch (IllegalStateException e) {
			LOGGER.error(e.getMessage());
		} catch (CacheException e) {
			LOGGER.error(e.getMessage());
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}
	}
}
