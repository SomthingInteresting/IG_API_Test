package com;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Market {

    @JsonProperty("instrumentName")
    private String instrumentName;

    @JsonProperty("instrumentType")
    private String instrumentType;

    @JsonProperty("lotSize")
    private double lotSize;

    @JsonProperty("high")
    private double high;

    @JsonProperty("low")
    private Double low;

    @JsonProperty("percentageChange")
    private double percentageChange;

    @JsonProperty("netChange")
    private double netChange;

    @JsonProperty("updateTimeUTC")
    private String updateTimeUTC;

    @JsonProperty("marketStatus")
    private String marketStatus;

    @JsonProperty("expiry")
    private String expiry;

    @JsonProperty("epic")
    private String epic;

    @JsonProperty("bid")
    private Double bid;

    @JsonProperty("offer")
    private Double offer;

    @JsonProperty("updateTime")
    private String updateTime;

    @JsonProperty("delayTime")
    private int delayTime;

    @JsonProperty("streamingPricesAvailable")
    private boolean streamingPricesAvailable;

    @JsonProperty("scalingFactor")
    private int scalingFactor;

    // getters and setters...

    // ... existing getters and setters ...

    @Override
    public String toString() {
        return "Market{" +
                "instrumentName='" + instrumentName + '\'' +
                ", instrumentType='" + instrumentType + '\'' +
                ", lotSize=" + lotSize +
                ", high=" + high +
                ", low=" + low +
                ", percentageChange=" + percentageChange +
                ", netChange=" + netChange +
                ", updateTimeUTC='" + updateTimeUTC + '\'' +
                ", marketStatus='" + marketStatus + '\'' +
                // add other fields similarly
                '}';
    }
}
