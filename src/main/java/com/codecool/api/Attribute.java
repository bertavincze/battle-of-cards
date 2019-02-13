package com.codecool.api;

public enum Attribute {

    BROCCOLI,
    WEIGHT,
    SANDBUCKETSIZE,
    MONEY;

    @Override
    public String toString() {
        String result;
        switch (this) {
            case BROCCOLI:
                result = "Megevett brokkoli(kg)";
                break;
            case WEIGHT:
                result = "Súly";
                break;
            case SANDBUCKETSIZE:
                result = "Homokozóvödör űrtartalma";
                break;
            case MONEY:
                result = "Apu foglalkozása";
                break;
            default:
                result = "Ezt nem fogjuk látni! :)";
                break;
        }
        return result;
    }
}
