package com.codecool.api;

import java.util.Comparator;

public class CardComparator implements Comparator<Card> {

    private Attribute attribute;

    public CardComparator (Attribute attribute) {
        this.attribute = attribute;
    }

    @Override
    public int compare(Card o1, Card o2) {
        switch (attribute) {
            case RANK:
                if (o1.getRank().getValue() > o2.getRank().getValue()) {
                    return 1;
                }
                if (o1.getRank().getValue() < o2.getRank().getValue()) {
                    return -1;
                }
                if (o1.getRank().getValue() == o2.getRank().getValue()) {
                    return 0;
                }
            case MONEY:
                if (o1.getMoney().getValue() > o2.getMoney().getValue()) {
                    return 1;
                }
                if (o1.getMoney().getValue() < o2.getMoney().getValue()) {
                    return -1;
                }
                if (o1.getMoney().getValue() == o2.getMoney().getValue()) {
                    return 0;
                }
            case WEIGHT:
                if (o1.getWeight() > o2.getWeight()) {
                    return 1;
                }
                else if (o1.getWeight() < o2.getWeight()) {
                    return -1;
                }
                else if (o1.getWeight() == o2.getWeight()) {
                    return 0;
                }
            case SANDBUCKETSIZE:
                if (o1.getSandBucketSize() > o2.getSandBucketSize()) {
                    return 1;
                }
                else if (o1.getSandBucketSize() < o2.getSandBucketSize()) {
                    return -1;
                }
                else if (o1.getSandBucketSize() == o2.getSandBucketSize()) {
                    return 0;
                }
        }
        return 0;
    }
}
