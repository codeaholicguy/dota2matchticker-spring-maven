/**
 *
 */
package com.codeaholicguy.dota2.matchticker.dto;

import com.codeaholicguy.dota2.matchticker.constant.MatchType;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author HoangNN6
 */
public class RecentResultMatchDto extends MatchDto {

    private String result;
    private TeamDto winner;

    public RecentResultMatchDto() {
        super();
        setType(MatchType.RECENT_MATCH);
    }

    public RecentResultMatchDto(String result, TeamDto winner) {
        super();
        setType(MatchType.RECENT_MATCH);
        this.result = result;
        this.winner = winner;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public TeamDto getWinner() {
        return winner;
    }

    public void setWinner(TeamDto winner) {
        this.winner = winner;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("result", result)
                .append("winner", winner)
                .toString();
    }
}
