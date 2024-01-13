package com.benoitnerin.cardsappapi.service;

import com.benoitnerin.cardsappapi.pojo.Card;
import com.benoitnerin.cardsappapi.util.CardUtil;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    @Override
    public List<Card> createCardsDeck() {
        List<Card> deck = new ArrayList<>();

        for (String color : CardUtil.geColors()) {
            for(int i = 0; i < CardUtil.getValue().size(); i++){
                deck.add(new Card(color, CardUtil.getValue().get(i), CardUtil.getScore().get(i)));
            }
        }

        return deck;
    }

    @Override
    public List<Card> getRandomCards(int cardQuantity) {
        List<Card> deck = createCardsDeck();
        List<Card> cards = new ArrayList<>();

        Collections.shuffle(deck);

        for(int i = 0; i < cardQuantity; i++){
            cards.add(deck.get(i));
        }

        return cards;
    }

    @Override
    public List<Card> filterCardsByValue(List<Card> cards) {
        Collections.sort(cards);
        return cards;
    }

    @Override
    public List<Card> filterCardsByColor(List<Card> cards) {
        Collections.sort(cards, Comparator.comparing(Card::getColor));
        return cards;
    }
}
