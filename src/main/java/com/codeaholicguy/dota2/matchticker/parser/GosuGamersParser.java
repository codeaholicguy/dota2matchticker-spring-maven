/**
 *
 */
package com.codeaholicguy.dota2.matchticker.parser;

import com.codeaholicguy.dota2.matchticker.constant.GosuGamers;
import com.codeaholicguy.dota2.matchticker.constant.HTML;
import com.codeaholicguy.dota2.matchticker.constant.MatchType;
import com.codeaholicguy.dota2.matchticker.dto.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author HoangNN6
 */
public class GosuGamersParser {

    private static GosuGamersParser instance;

    public static GosuGamersParser getInstance() {
        if (instance == null) {
            instance = new GosuGamersParser();
        }
        return instance;
    }

    private GosuGamersParser() {
    }

    /**
     * Parse live match information from Gosugamers.
     *
     * @param matchUrl url of detail from Gosugamers
     * @return LiveMatchDto
     * @throws IOException
     */
    public LiveMatchDto parseLiveMatch(String matchUrl) throws IOException {
        // Get page source.
        Document matchDoc = Jsoup.connect(GosuGamers.BASE_URL + matchUrl).userAgent(HTML.AGENT).get();

        // Get best of information.
        Elements bestOfElements = matchDoc.getElementsByClass(GosuGamers.BEST_OF_CLASS);
        LiveMatchDto liveMatchDto = new LiveMatchDto();
        if (bestOfElements != null && bestOfElements.size() > 0) {
            liveMatchDto.setBestOf(bestOfElements.get(0).text());
        }

        // Get team 1 information.
        Elements team1Elements = matchDoc.getElementsByClass(GosuGamers.TEAM_1_CLASS);
        TeamDto team1 = new TeamDto();
        if (team1Elements != null && team1Elements.size() > 0) {
            team1.setName(team1Elements.get(0).getElementsByTag(HTML.A_TAG).text());
            team1.setLogo(GosuGamers.BASE_URL + team1Elements.get(0).getElementsByTag(HTML.IMG_TAG).attr(HTML.SRC_ATTR));
            team1.setRanked(team1Elements.get(0).getElementsByTag(HTML.P_TAG).text());
            team1.setCountry(team1Elements.get(0).getElementsByTag(HTML.SPAN_TAG).attr(HTML.TITLE_ATTR));
            liveMatchDto.setTeam1(team1);
        }

        // Get team 2 information.
        Elements team2Elements = matchDoc.getElementsByClass(GosuGamers.TEAM_2_CLASS);
        TeamDto team2 = new TeamDto();
        if (team2Elements != null && team2Elements.size() > 0) {
            team2.setName(team2Elements.get(0).getElementsByTag(HTML.A_TAG).text());
            team2.setLogo(GosuGamers.BASE_URL + team2Elements.get(0).getElementsByTag(HTML.IMG_TAG).attr(HTML.SRC_ATTR));
            team2.setRanked(team2Elements.get(0).getElementsByTag(HTML.P_TAG).text());
            team2.setCountry(team2Elements.get(0).getElementsByTag(HTML.SPAN_TAG).attr(HTML.TITLE_ATTR));
            liveMatchDto.setTeam2(team2);
        }

        // Get bet percentage information.
        Elements percentageElements = matchDoc.getElementsByClass(GosuGamers.BET_PERCENTAGE_CLASS);
        if (percentageElements != null && percentageElements.size() > 0) {
            liveMatchDto.setTeam1BetPercentage(percentageElements.get(0).text());
            liveMatchDto.setTeam2BetPercentage(percentageElements.get(1).text());
        }

        // Get result.
        Elements scoreElements = matchDoc.getElementsByClass(GosuGamers.VS_CLASS).get(0).getElementsByClass(HTML.HIDDEN_CLASS);
        if (!scoreElements.isEmpty()) {
            liveMatchDto.setResult(scoreElements.get(0).text());
        } else {
            liveMatchDto.setResult(GosuGamers.DEUCE_RESULT);
        }

        return liveMatchDto;
    }

    /**
     * Parse upcomming match information from Gosugamers.
     *
     * @param matchUrl url of detail from Gosugamers
     * @return UpCommingMatchDto
     * @throws IOException
     */
    public UpCommingMatchDto parseUpCommingMatch(String matchUrl) throws IOException {
        // Get page source.
        Document matchDoc = Jsoup.connect(GosuGamers.BASE_URL + matchUrl).userAgent(HTML.AGENT).get();

        // Get best of information.
        Elements bestOfElements = matchDoc.getElementsByClass(GosuGamers.BEST_OF_CLASS);
        UpCommingMatchDto upCommingMatchDto = new UpCommingMatchDto();
        if (bestOfElements != null && bestOfElements.size() > 0) {
            upCommingMatchDto.setBestOf(bestOfElements.get(0).text());
        }

        // Get team 1 information.
        Elements team1Elements = matchDoc.getElementsByClass(GosuGamers.TEAM_1_CLASS);
        TeamDto team1 = new TeamDto();
        if (team1Elements != null && team1Elements.size() > 0) {
            team1.setName(team1Elements.get(0).getElementsByTag(HTML.A_TAG).text());
            team1.setLogo(GosuGamers.BASE_URL + team1Elements.get(0).getElementsByTag(HTML.IMG_TAG).attr(HTML.SRC_ATTR));
            team1.setRanked(team1Elements.get(0).getElementsByTag(HTML.P_TAG).text());
            team1.setCountry(team1Elements.get(0).getElementsByTag(HTML.SPAN_TAG).attr(HTML.TITLE_ATTR));
            upCommingMatchDto.setTeam1(team1);
        }

        // Get team 2 information.
        Elements team2Elements = matchDoc.getElementsByClass(GosuGamers.TEAM_2_CLASS);
        TeamDto team2 = new TeamDto();
        if (team2Elements != null && team2Elements.size() > 0) {
            team2.setName(team2Elements.get(0).getElementsByTag(HTML.A_TAG).text());
            team2.setLogo(GosuGamers.BASE_URL + team2Elements.get(0).getElementsByTag(HTML.IMG_TAG).attr(HTML.SRC_ATTR));
            team2.setRanked(team2Elements.get(0).getElementsByTag(HTML.P_TAG).text());
            team2.setCountry(team2Elements.get(0).getElementsByTag(HTML.SPAN_TAG).attr(HTML.TITLE_ATTR));
            upCommingMatchDto.setTeam2(team2);
        }

        // Get live in information.
        Elements dateTimeElements = matchDoc.getElementsByClass(GosuGamers.DATETIME_CLASS);
        if (dateTimeElements != null && dateTimeElements.size() > 0) {
            upCommingMatchDto.setDate(dateTimeElements.get(0).text());
        }

        // Get bet percentage information.
        Elements percentageElements = matchDoc.getElementsByClass(GosuGamers.BET_PERCENTAGE_CLASS);
        if (percentageElements != null && percentageElements.size() > 0) {
            upCommingMatchDto.setTeam1BetPercentage(percentageElements.get(0).text());
            upCommingMatchDto.setTeam2BetPercentage(percentageElements.get(1).text());
        }

        return upCommingMatchDto;
    }

    /**
     * Parse recent results from Gosugamers.
     *
     * @param matchUrl url of detail from Gosugamers
     * @return UpCommingMatchDto
     * @throws IOException
     */
    public RecentResultMatchDto parseRecentResultMatch(String matchUrl) throws IOException {
        // Get page source.
        Document matchDoc = Jsoup.connect(GosuGamers.BASE_URL + matchUrl).userAgent(HTML.AGENT).get();

        // Get best of information.
        Elements bestOfElements = matchDoc.getElementsByClass(GosuGamers.BEST_OF_CLASS);
        RecentResultMatchDto recentResultMatchDto = new RecentResultMatchDto();
        if (bestOfElements != null && bestOfElements.size() > 0) {
            recentResultMatchDto.setBestOf(bestOfElements.get(0).text());
        }

        // Get team 1 information.
        Elements team1Elements = matchDoc.getElementsByClass(GosuGamers.TEAM_1_CLASS);
        TeamDto team1 = new TeamDto();
        if (team1Elements != null && team1Elements.size() > 0) {
            team1.setName(team1Elements.get(0).getElementsByTag(HTML.A_TAG).text());
            team1.setLogo(GosuGamers.BASE_URL + team1Elements.get(0).getElementsByTag(HTML.IMG_TAG).attr(HTML.SRC_ATTR));
            team1.setRanked(team1Elements.get(0).getElementsByTag(HTML.P_TAG).text());
            team1.setCountry(team1Elements.get(0).getElementsByTag(HTML.SPAN_TAG).attr(HTML.TITLE_ATTR));
            recentResultMatchDto.setTeam1(team1);
        }

        // Get team 2 information.
        Elements team2Elements = matchDoc.getElementsByClass(GosuGamers.TEAM_2_CLASS);
        TeamDto team2 = new TeamDto();
        if (team2Elements != null && team2Elements.size() > 0) {
            team2.setName(team2Elements.get(0).getElementsByTag(HTML.A_TAG).text());
            team2.setLogo(GosuGamers.BASE_URL + team2Elements.get(0).getElementsByTag(HTML.IMG_TAG).attr(HTML.SRC_ATTR));
            team2.setRanked(team2Elements.get(0).getElementsByTag(HTML.P_TAG).text());
            team2.setCountry(team2Elements.get(0).getElementsByTag(HTML.SPAN_TAG).attr(HTML.TITLE_ATTR));
            recentResultMatchDto.setTeam2(team2);
        }

        // Get live in information.
        Elements dateTimeElements = matchDoc.getElementsByClass(GosuGamers.DATETIME_CLASS);
        if (dateTimeElements != null && dateTimeElements.size() > 0) {
            recentResultMatchDto.setDate(dateTimeElements.get(0).text());
        }

        // Get bet percentage information.
        Elements percentageElements = matchDoc.getElementsByClass(GosuGamers.BET_PERCENTAGE_CLASS);
        if (percentageElements != null && percentageElements.size() > 0) {
            recentResultMatchDto.setTeam1BetPercentage(percentageElements.get(0).text());
            recentResultMatchDto.setTeam2BetPercentage(percentageElements.get(1).text());
        }

        // Get result.
        Elements scoreElements = matchDoc.getElementsByClass(GosuGamers.VS_CLASS).get(0).getElementsByClass(HTML.HIDDEN_CLASS);
        recentResultMatchDto.setResult(scoreElements.get(0).text());

        Elements winnerElements = matchDoc.select(GosuGamers.WINNER_CLASS).get(0).getElementsByTag(HTML.H5_TAG);
        if (winnerElements.size() > 0) {
            if (winnerElements.get(0).text().equalsIgnoreCase(team1.getName())) {
                recentResultMatchDto.setWinner(team1);
            } else {
                recentResultMatchDto.setWinner(team2);
            }
        }

        return recentResultMatchDto;
    }

    /**
     * Get live matches from Gosugamers.
     *
     * @return MatchesDto
     * @throws IOException
     */
    public MatchesDto getLiveMatches() throws IOException {
        MatchesDto matchesDto = new MatchesDto(MatchType.LIVE_MATCH);

        // Get all recent result match urls.
        List<TournamentMatchDto> tournamentMatchDtos = getInstance().parseMatchUrls(MatchType.LIVE_MATCH);
        List<LiveMatchDto> liveMatchDtos = new ArrayList<>();
        for (TournamentMatchDto tournamentMatchDto : tournamentMatchDtos) {

            // Get match information.
            String matchUrl = tournamentMatchDto.getMatchUrl();
            LiveMatchDto liveMatchDto = instance.parseLiveMatch(matchUrl);
            liveMatchDto.setTournament(tournamentMatchDto.getTournament());
            liveMatchDtos.add(liveMatchDto);
        }

        matchesDto.setMatches(liveMatchDtos);
        return matchesDto;
    }

    /**
     * Get upcomming matches from Gosugamers.
     *
     * @return MatchesDto
     * @throws IOException
     */
    public MatchesDto getUpCommingMatches() throws IOException {
        MatchesDto matchesDto = new MatchesDto(MatchType.UPCOMMING_MATCH);

        // Get all upcomming match urls.
        List<TournamentMatchDto> tournamentMatchDtos = getInstance().parseMatchUrls(MatchType.UPCOMMING_MATCH);
        List<UpCommingMatchDto> upCommingMatchDtos = new ArrayList<>();
        for (TournamentMatchDto tournamentUpCommingMatchDto : tournamentMatchDtos) {

            // Get match information.
            String matchUrl = tournamentUpCommingMatchDto.getMatchUrl();
            UpCommingMatchDto upCommingMatchDto = getInstance().parseUpCommingMatch(matchUrl);
            upCommingMatchDto.setTournament(tournamentUpCommingMatchDto.getTournament());
            upCommingMatchDto.setLiveIn(tournamentUpCommingMatchDto.getLiveIn());
            upCommingMatchDtos.add(upCommingMatchDto);
        }

        matchesDto.setMatches(upCommingMatchDtos);
        return matchesDto;
    }

    /**
     * Get recent result matches from Gosugamers.
     *
     * @return MatchesDto
     * @throws IOException
     */
    public MatchesDto getRecentResultMatches() throws IOException {
        MatchesDto matchesDto = new MatchesDto(MatchType.RECENT_MATCH);

        // Get all recent result match urls.
        List<TournamentMatchDto> tournamentMatchDtos = getInstance().parseMatchUrls(MatchType.RECENT_MATCH);
        List<RecentResultMatchDto> recentResultMatchDtos = new ArrayList<>();
        for (TournamentMatchDto tournamentMatchDto : tournamentMatchDtos) {

            // Get match information.
            String matchUrl = tournamentMatchDto.getMatchUrl();
            RecentResultMatchDto recentResultMatchDto = getInstance().parseRecentResultMatch(matchUrl);
            recentResultMatchDto.setTournament(tournamentMatchDto.getTournament());
            recentResultMatchDtos.add(recentResultMatchDto);
        }

        matchesDto.setMatches(recentResultMatchDtos);
        return matchesDto;
    }

    /**
     * Parse match urls from Gosugamers.
     *
     * @param matchType matchType: live, upcomming, recent...
     * @return TournamentMatchDtos
     * @throws IOException
     */
    public List<TournamentMatchDto> parseMatchUrls(String matchType) throws IOException {
        List<TournamentMatchDto> tournamentMatchDtos = new ArrayList<>();
        Document doc = Jsoup.connect(GosuGamers.BASE_URL + GosuGamers.MATCH_TICKER_PAGE).userAgent(HTML.AGENT).get();

        // Get title page by matchType
        String matchTypeTitle;
        switch (matchType) {
            case MatchType.LIVE_MATCH:
                matchTypeTitle = GosuGamers.LIVE_TITLE;
                break;
            case MatchType.UPCOMMING_MATCH:
                matchTypeTitle = GosuGamers.UPCOMMING_TITLE;
                break;
            case MatchType.RECENT_MATCH:
                matchTypeTitle = GosuGamers.RECENT_RESULT_TITLE;
                break;
            default:
                matchTypeTitle = GosuGamers.RECENT_RESULT_TITLE;
                break;
        }

        boolean founded = false;

        // Get all box.
        Elements boxElements = doc.getElementsByClass(GosuGamers.DIV_BOX_CLASS);
        for (Element boxElement : boxElements) {
            if (founded) {
                break;
            }
            Elements headerElements = boxElement.getElementsByTag(HTML.H2_TAG);
            if (MatchType.LIVE_MATCH.equals(matchType)) {
                headerElements = boxElement.getElementsByTag(HTML.H1_TAG);
            }
            for (Element headerElement : headerElements) {

                // Check title if equal matchTypeTitle.
                if (headerElement.text().contains(matchTypeTitle)) {
                    Elements tableElements = boxElement.getElementsByTag(HTML.TABLE_TAG);
                    Elements tableRowElements = tableElements.select(HTML.TR_TAG_NOT_INCLUDE_THEAD);

                    // Get tournament match information.
                    for (Element tableRowElement : tableRowElements) {
                        Elements columnItems = tableRowElement.getElementsByTag(HTML.TD_TAG);

                        // Create tournament match.
                        TournamentMatchDto tournamentMatchDto = new TournamentMatchDto();
                        tournamentMatchDto.setMatchUrl(columnItems.get(0).select(GosuGamers.A_WITH_MATCH_CLASS).attr(HTML.HREF_ATTR));
                        if (MatchType.UPCOMMING_MATCH.equals(matchType)) {
                            tournamentMatchDto.setLiveIn(columnItems.get(1).getElementsByClass(GosuGamers.LIVE_IN_CLASS).text());
                        }
                        // Parse tournament information.
                        TournamentDto tournamentDto = new TournamentDto();
                        Elements tournamentLogoItems = columnItems.get(columnItems.size() - 1).getElementsByTag(HTML.IMG_TAG);
                        tournamentDto.setLogo(GosuGamers.BASE_URL + tournamentLogoItems.get(0).attr(HTML.SRC_ATTR));
                        tournamentMatchDto.setTournament(tournamentDto);
                        tournamentMatchDtos.add(tournamentMatchDto);
                    }

                    // Set founded and break header check loop
                    founded = true;

                    break;
                }
            }
        }
        return tournamentMatchDtos;
    }
}
