package com.codecool.api;

public class Card implements Comparable<Card>{

    private String id;
    private String name;
    private Rank rank;
    private int weight;
    private int sandBucketSize;
    private Money money;
    private State state;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getSandBucketSize() {
        return sandBucketSize;
    }

    public Rank getRank() {
        return rank;
    }

    public Money getMoney() {
        return money;
    }

    public State getState() {
        return state;
    }

    @Override
    public int compareTo(Card o) {
        return 0;
    }
}
