/**
 *
 */
package com.codeaholicguy.dota2.matchticker.dto;

import com.codeaholicguy.dota2.matchticker.constant.MatchType;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author HoangNN6
 */
public class UpCommingMatchDto extends MatchDto {

    private String liveIn;

    public UpCommingMatchDto() {
        super();
        setType(MatchType.UPCOMMING_MATCH);
    }

    public UpCommingMatchDto(String liveIn) {
        super();
        setType(MatchType.UPCOMMING_MATCH);
        this.liveIn = liveIn;
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
                .append("liveIn", liveIn)
                .toString();
    }
}
