/**
 *
 */
package com.codeaholicguy.dota2.matchticker.controller;

import com.codeaholicguy.dota2.matchticker.config.SessionConfiguration;
import com.codeaholicguy.dota2.matchticker.response.BaseResponse;
import com.codeaholicguy.dota2.matchticker.response.MatchesResponse;
import com.codeaholicguy.dota2.matchticker.services.GosuGamersMatchTickerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author HoangNN6
 */
@Controller
@RequestMapping("/gosugamer/matches")
public class GosuGamersMatchTickerController {

    @Autowired
    GosuGamersMatchTickerServices gosuGamersMatchTickerServices;

    @RequestMapping(value = "/upcomming", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    Object getUpCommingMatches(@RequestParam(value = "key", required = true) String key) {
        BaseResponse response;
        try {
            SessionConfiguration.checkAuthority(key);
        } catch (Exception e) {
            response = new BaseResponse(BaseResponse.FAIL, e.getMessage());
            return response;
        }

        try {
            MatchesResponse upCommingMatchesResponse = new MatchesResponse();
            upCommingMatchesResponse.setData(gosuGamersMatchTickerServices.getUpCommingMatchs());
            upCommingMatchesResponse.setResult(BaseResponse.SUCCESS);

            return upCommingMatchesResponse;
        } catch (Exception e) {
            response = new BaseResponse(BaseResponse.FAIL, e.getMessage());
            return response;
        }
    }

    @RequestMapping(value = "/result", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    Object getRecentResultMatches(@RequestParam(value = "key", required = true) String key) {
        BaseResponse response;
        try {
            SessionConfiguration.checkAuthority(key);
        } catch (Exception e) {
            response = new BaseResponse(BaseResponse.FAIL, e.getMessage());
            return response;
        }

        try {
            MatchesResponse upCommingMatchesResponse = new MatchesResponse();
            upCommingMatchesResponse.setData(gosuGamersMatchTickerServices.getRecentResultMatchs());
            upCommingMatchesResponse.setResult(BaseResponse.SUCCESS);

            return upCommingMatchesResponse;
        } catch (Exception e) {
            response = new BaseResponse(BaseResponse.FAIL, e.getMessage());
            return response;
        }
    }

    @RequestMapping(value = "/live", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    Object getLiveMatches(@RequestParam(value = "key", required = true) String key) {
        BaseResponse response;
        try {
            SessionConfiguration.checkAuthority(key);
        } catch (Exception e) {
            response = new BaseResponse(BaseResponse.FAIL, e.getMessage());
            return response;
        }

        try {
            MatchesResponse liveMatchesResponse = new MatchesResponse();
            liveMatchesResponse.setData(gosuGamersMatchTickerServices.getLiveMatchs());
            liveMatchesResponse.setResult(BaseResponse.SUCCESS);

            return liveMatchesResponse;
        } catch (Exception e) {
            response = new BaseResponse(BaseResponse.FAIL, e.getMessage());
            return response;
        }
    }
}