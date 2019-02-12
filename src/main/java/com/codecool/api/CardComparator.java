package com.codecool.api;

import java.util.Comparator;

public class CardComparator implements Comparator<Card> {

    private Attribute attribute;

    public CardComparator(Attribute attribute) {
        this.attribute = attribute;
    }

    @Override
    public int compare(Card o1, Card o2) {
        switch (attribute) {
            case RANK:
                return o1.getRank().getValue() - o2.getRank().getValue();

            case MONEY:
                return o1.getMoney().getValue() - o2.getMoney().getValue();

            case WEIGHT:
                return o1.getWeight() - o2.getWeight();

            case SANDBUCKETSIZE:
                 return o1.getSandBucketSize() - o2.getSandBucketSize();

             default:
                 throw new IllegalStateException("To handle any attribute not in the switch block.");
        }
    }
}
