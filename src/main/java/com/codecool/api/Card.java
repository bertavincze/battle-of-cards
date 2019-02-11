package com.codecool.api;

public class Card implements Comparable<Card>{

    private String id;
    private String name;
    private Rank rank;
    private int weight;
    private int sandBucketSize;
    private Money money;
    private State state;

    public Card(String id, String name, Rank rank, int weight, int sandBucketSize, Money money) {
        this.id = id;
        this.name = name;
        this.rank = rank;
        this.weight = weight;
        this.sandBucketSize = sandBucketSize;
        this.money = money;
        this.state = State.DOWN;
    }

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

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public int compareTo(Card o) {
        return 0;
    }
}
