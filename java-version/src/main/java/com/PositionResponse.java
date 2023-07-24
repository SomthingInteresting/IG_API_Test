package com;

import java.util.List;

public class PositionResponse {

    private List<Position> positions;

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

    @Override
    public String toString() {
        return "PositionResponse [positions=" + positions + "]";
    }
}
