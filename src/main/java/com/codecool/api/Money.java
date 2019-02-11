package com.codecool.api;

public enum Money {

    BENEFIT(1),
    MINIMUMWAGE(2),
    SELFEMPLOYED(3),
    COMPANYOWNER(4),
    SMUGGLER(5),
    TAXEVADER(6);

    private int value;

    Money(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
