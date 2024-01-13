package com.benoitnerin.cardsappapi.pojo;

public class Card implements Comparable<Card> {
    private String color;
    private String value;
    private int score;

    public Card() {
    }

    public Card(String color, String value, int score) {
        this.color = color;
        this.value = value;
        this.score = score;
    }

    public String getColor() {
        return color;
    }

    public String getValue() {
        return value;
    }

    public int getScore() {
        return score;
    }

    @Override
    public int compareTo(Card other) {
        return Integer.compare(this.score, other.score);
    }
}
