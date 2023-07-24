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

    // other fields...

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
