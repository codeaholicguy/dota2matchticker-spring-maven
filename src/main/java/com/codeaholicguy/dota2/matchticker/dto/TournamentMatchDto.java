/**
 *
 */
package com.codeaholicguy.dota2.matchticker.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author HoangNN6
 */
public class TournamentMatchDto {

    private String matchUrl;
    private String liveIn;
    private TournamentDto tournament;

    public TournamentMatchDto() {
    }

    public TournamentMatchDto(String matchUrl, String liveIn, TournamentDto tournament) {
        this.matchUrl = matchUrl;
        this.liveIn = liveIn;
        this.tournament = tournament;
    }

    public String getMatchUrl() {
        return matchUrl;
    }

    public void setMatchUrl(String matchUrl) {
        this.matchUrl = matchUrl;
    }

    public TournamentDto getTournament() {
        return tournament;
    }

    public void setTournament(TournamentDto tournament) {
        this.tournament = tournament;
    }

    public String getLiveIn() {
        return liveIn;
    }

    public void setLiveIn(String liveIn) {
        this.liveIn = liveIn;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("matchUrl", matchUrl)
                .append("liveIn", liveIn)
                .append("tournament", tournament)
                .toString();
    }
}
