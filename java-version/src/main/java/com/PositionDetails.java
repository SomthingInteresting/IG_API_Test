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

    public double getContractSize() {
        return contractSize;
    }

    public void setContractSize(double contractSize) {
        this.contractSize = contractSize;
    }

    public String getCreatedDateUTC() {
        return createdDateUTC;
    }

    public void setCreatedDateUTC(String createdDateUTC) {
        this.createdDateUTC = createdDateUTC;
    }

    public String getDealId() {
        return dealId;
    }

    public void setDealId(String dealId) {
        this.dealId = dealId;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public double getLevel() {
        return level;
    }

    public void setLevel(double level) {
        this.level = level;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

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
