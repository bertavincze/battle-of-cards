package com.codecool.api;

public enum Rank {

    FIRSTYEAR(1),
    SECONDYEAR(2),
    THIRDYEAR(3),
    REPEATERS(4);

    private int value;

    Rank(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
