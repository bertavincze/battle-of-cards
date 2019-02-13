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
    
    @Override
    public String toString() {
        String result;
        switch (this){
            case BENEFIT:
                result = "Naplopó" + "(" + getValue() + ")";
                break;
            case MINIMUMWAGE:
                result = "Közmunkás" + "(" + getValue() + ")";
                break;
            case SELFEMPLOYED:
                result = "Vállalkozó" + "(" + getValue() + ")";
                break;
            case COMPANYOWNER:
                result = "Cégtulaj" + "(" + getValue() + ")";
                break;
            case SMUGGLER:
                result = "Csempész" + "(" + getValue() + ")";
                break;
            case TAXEVADER:
                result = "Adócsaló" + "(" + getValue() + ")";
                break;
                default:
                    result = "Ezt nem fogjuk látni! :)";
                    break;
        }
        return result;
    }
}
