package com.benoitnerin.cardsappapi.service;

import com.benoitnerin.cardsappapi.pojo.Card;

import java.util.List;

public interface CardService {
    List<Card> createCardsDeck();

    List<Card> getRandomCards(int cardQuantity);

    List<Card> filterCardsByValue(List<Card> cards);

    List<Card> filterCardsByColor(List<Card> cards);
}
