package com;

public class Position {

    private PositionDetails position;
    private Market market;

    public PositionDetails getPosition() {
        return position;
    }

    public void setPosition(PositionDetails position) {
        this.position = position;
    }

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }

    @Override
    public String toString() {
        return "Position{" +
        
                "position=" + position +
                ", market=" + market +
                '}';
    }
}
