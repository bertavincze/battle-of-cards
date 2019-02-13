package com.codecool.api;

import java.util.Comparator;

public class Card {

    private String id;
    private String name;
    private int broccoliInKg;
    private int weight;
    private int sandBucketSize;
    private Money money;
    private State state;

    public Card(String id, String name, int broccoliInKg, int weight, int sandBucketSize, Money money) {
        this.id = id;
        this.name = name;
        this.broccoliInKg = broccoliInKg;
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

    public int getEatedBrokkoliInKg() {
        return broccoliInKg;
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
    public String toString() {
        return "id: " + id +
            ", name:" + name + ", rank: " + broccoliInKg + ", weight: " + weight + ", sandBucketSize: " + sandBucketSize + ", money: " + money;
    }
}
