package com;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PositionDetails {

    @JsonProperty("contractSize")
    private double contractSize;

    @JsonProperty("createdDateUTC")
    private String createdDateUTC;

    @JsonProperty("dealId")
    private String dealId;

    @JsonProperty("size")
    private double size;

    @JsonProperty("direction")
    private String direction;

    @JsonProperty("level")
    private double level;

    @JsonProperty("currency")
    private String currency;

    @Override
    public String toString() {
        return "PositionDetails{" +
                "contractSize=" + contractSize +
                ", createdDateUTC='" + createdDateUTC + '\'' +
                ", dealId='" + dealId + '\'' +
                ", size=" + size +
                ", direction='" + direction + '\'' +
                ", level=" + level +
                ", currency='" + currency + '\'' +
                '}';
    }
}
