/**
 * 
 */
package com.codeaholicguy.dota2.matchticker.services;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import com.codeaholicguy.dota2.matchticker.constant.MatchType;
import com.codeaholicguy.dota2.matchticker.dto.MatchesDto;

/**
 * @author HoangNN6
 * 
 */
@Service
public class GosuGamersMatchTickerServicesImpl implements GosuGamersMatchTickerServices {

	@Autowired
	CacheManager cacheManager;

	@Override
	public MatchesDto getUpCommingMatchs() throws IOException {
		return (MatchesDto) cacheManager.getCache(MatchType.MATCHES).get(MatchType.UPCOMMING_MATCH).get();
	}

	@Override
	public MatchesDto getRecentResultMatchs() throws IOException {
		return (MatchesDto) cacheManager.getCache(MatchType.MATCHES).get(MatchType.RECENT_MATCH).get();
	}

	@Override
	public MatchesDto getLiveMatchs() throws IOException {
		return (MatchesDto) cacheManager.getCache(MatchType.MATCHES).get(MatchType.LIVE_MATCH).get();
	}

}
