package com.smcodinglab.xkcd.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comic {

    @JsonProperty("num")
    private int num;

    @JsonProperty("day")
    private String day;

    @JsonProperty("month")
    private String month;

    @JsonProperty("year")
    private String year;

    @JsonProperty("link")
    private String link;

    @JsonProperty("news")
    private String news;

    @JsonProperty("title")
    private String title;

    @JsonProperty("safe_title")
    private String safeTitle;

    @JsonProperty("transcript")
    private String transcript;

    @JsonProperty("alt")
    private String alt;

    @JsonProperty("img")
    private String img;

}
