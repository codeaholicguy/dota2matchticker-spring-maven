/**
 * 
 */
package com.codeaholicguy.dota2.matchticker.response;

import com.codeaholicguy.dota2.matchticker.dto.MatchesDto;

/**
 * @author HoangNN6
 * 
 */
/**
 * @author HoangNN6
 * 
 */
public class MatchesResponse extends BaseResponse {

	private MatchesDto data;

	public MatchesResponse() {
	}

	public MatchesDto getData() {
		return data;
	}

	public void setData(MatchesDto data) {
		this.data = data;
	}

}
