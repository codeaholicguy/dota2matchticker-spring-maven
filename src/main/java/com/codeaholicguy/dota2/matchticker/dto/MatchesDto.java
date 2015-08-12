/**
 *
 */
package com.codeaholicguy.dota2.matchticker.dto;

import com.google.common.base.Objects;

import java.util.List;

/**
 * @author HoangNN6
 */
public class MatchesDto {

    private String type;
    private List<? extends MatchDto> matches;

    public MatchesDto() {
    }

    public MatchesDto(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<?> getMatches() {
        return matches;
    }

    public void setMatches(List<? extends MatchDto> matches) {
        this.matches = matches;
    }

    @Override
    public String toString() {
        return new org.apache.commons.lang3.builder.ToStringBuilder(this)
                .append("type", type)
                .append("matches", matches)
                .toString();
    }
}
