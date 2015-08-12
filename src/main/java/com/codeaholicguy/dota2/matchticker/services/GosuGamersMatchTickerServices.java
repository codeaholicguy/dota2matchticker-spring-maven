/**
 * 
 */
package com.codeaholicguy.dota2.matchticker.services;

import java.io.IOException;

import com.codeaholicguy.dota2.matchticker.dto.MatchesDto;

/**
 * @author HoangNN6
 * 
 */
public interface GosuGamersMatchTickerServices {

	MatchesDto getUpCommingMatchs() throws IOException;

	MatchesDto getRecentResultMatchs() throws IOException;

	MatchesDto getLiveMatchs() throws IOException;

}
