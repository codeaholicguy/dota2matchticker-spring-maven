/**
 *
 */
package com.codeaholicguy.dota2.matchticker.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author HoangNN6
 */
public class TeamDto {

    private String name;
    private String logo;
    private String country;
    private String ranked;

    public TeamDto() {
    }

    public TeamDto(String name, String logo, String country, String ranked) {
        this.name = name;
        this.logo = logo;
        this.country = country;
        this.ranked = ranked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRanked() {
        return ranked;
    }

    public void setRanked(String ranked) {
        this.ranked = ranked;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .append("logo", logo)
                .append("country", country)
                .append("ranked", ranked)
                .toString();
    }
}
