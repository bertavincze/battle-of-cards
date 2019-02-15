package com.codecool.api;

public enum Attribute {

    BROCCOLI("Megevett brokkoli(kg)"),
    WEIGHT("Súly"),
    SANDBUCKETSIZE("Homokozóvödör űrtartalma"),
    MONEY("Apu foglalkozása");

    private String displayString;

    Attribute(String displayString) {
        this.displayString = displayString;
    }

    @Override
    public String toString() {
        return displayString;
    }
}
