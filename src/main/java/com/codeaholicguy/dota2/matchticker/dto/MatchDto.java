/**
 * 
 */
package com.codeaholicguy.dota2.matchticker.dto;

/**
 * @author HoangNN6
 * 
 */
public class MatchDto {

	private String type;
	private TeamDto team1;
	private String team1BetPercentage;
	private TeamDto team2;
	private String team2BetPercentage;
	private TournamentDto tournament;
	private String bestOf;
	private String date;

	public MatchDto() {
	}

	public MatchDto(String type, TeamDto team1, String team1BetPercentage, TeamDto team2, String team2BetPercentage, TournamentDto tournament, String bestOf, String date) {
		this.type = type;
		this.team1 = team1;
		this.team1BetPercentage = team1BetPercentage;
		this.team2 = team2;
		this.team2BetPercentage = team2BetPercentage;
		this.tournament = tournament;
		this.bestOf = bestOf;
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public TeamDto getTeam1() {
		return team1;
	}

	public void setTeam1(TeamDto team1) {
		this.team1 = team1;
	}

	public String getTeam1BetPercentage() {
		return team1BetPercentage;
	}

	public void setTeam1BetPercentage(String team1BetPercentage) {
		this.team1BetPercentage = team1BetPercentage;
	}

	public TeamDto getTeam2() {
		return team2;
	}

	public void setTeam2(TeamDto team2) {
		this.team2 = team2;
	}

	public String getTeam2BetPercentage() {
		return team2BetPercentage;
	}

	public void setTeam2BetPercentage(String team2BetPercentage) {
		this.team2BetPercentage = team2BetPercentage;
	}

	public TournamentDto getTournament() {
		return tournament;
	}

	public void setTournament(TournamentDto tournament) {
		this.tournament = tournament;
	}

	public String getBestOf() {
		return bestOf;
	}

	public void setBestOf(String bestOf) {
		this.bestOf = bestOf;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return new org.apache.commons.lang3.builder.ToStringBuilder(this)
				.append("type", type)
				.append("team1", team1)
				.append("team1BetPercentage", team1BetPercentage)
				.append("team2", team2)
				.append("team2BetPercentage", team2BetPercentage)
				.append("tournament", tournament)
				.append("bestOf", bestOf)
				.append("date", date)
				.toString();
	}
}
