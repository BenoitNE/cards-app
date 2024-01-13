package com.benoitnerin.cardsappapi.service;

import com.benoitnerin.cardsappapi.pojo.Card;
import com.benoitnerin.cardsappapi.util.CardUtil;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CardServiceImplTest {

    @Test
    void createCardsDeck() {
        CardService cardService = new CardServiceImpl();
        List<Card> deck = cardService.createCardsDeck();

        assertEquals(52, deck.size());
    }

    @Test
    void createRandomHand() {
        CardService cardService = new CardServiceImpl();
        List<Card> hand = cardService.getRandomCards(CardUtil.CARDS_QUANTITY);

        assertEquals(10, hand.size());
    }

    @Test
    void filterCardsByValue() {
        CardService cardService = new CardServiceImpl();
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(CardUtil.CARREAU_COLOR, CardUtil.ROI_VALUE, CardUtil.ROI_SCORE));
        hand.add(new Card(CardUtil.TREFLE_COLOR, CardUtil.DEUX_VALUE, CardUtil.DEUX_SCORE));
        hand.add(new Card(CardUtil.COEUR_COLOR, CardUtil.DIX_VALUE, CardUtil.DIX_SCORE));
        hand.add(new Card(CardUtil.PIQUE_COLOR, CardUtil.NEUF_VALUE, CardUtil.NEUF_SCORE));
        hand.add(new Card(CardUtil.COEUR_COLOR, CardUtil.DAME_VALUE, CardUtil.DAME_SCORE));
        hand.add(new Card(CardUtil.TREFLE_COLOR, CardUtil.DIX_VALUE, CardUtil.DIX_SCORE));
        hand.add(new Card(CardUtil.PIQUE_COLOR, CardUtil.DEUX_VALUE, CardUtil.DEUX_SCORE));
        hand.add(new Card(CardUtil.TREFLE_COLOR, CardUtil.VALET_VALUE, CardUtil.VALET_SCORE));
        hand.add(new Card(CardUtil.CARREAU_COLOR, CardUtil.AS_VALUE, CardUtil.AS_SCORE));
        hand.add(new Card(CardUtil.TREFLE_COLOR, CardUtil.AS_VALUE, CardUtil.AS_SCORE));

        List<Card> expectedHand = List.of(
                new Card(CardUtil.CARREAU_COLOR, CardUtil.AS_VALUE, CardUtil.AS_SCORE),
                new Card(CardUtil.TREFLE_COLOR, CardUtil.AS_VALUE, CardUtil.AS_SCORE),
                new Card(CardUtil.TREFLE_COLOR, CardUtil.DEUX_VALUE, CardUtil.DEUX_SCORE),
                new Card(CardUtil.PIQUE_COLOR, CardUtil.DEUX_VALUE, CardUtil.DEUX_SCORE),
                new Card(CardUtil.PIQUE_COLOR, CardUtil.NEUF_VALUE, CardUtil.NEUF_SCORE),
                new Card(CardUtil.COEUR_COLOR, CardUtil.DIX_VALUE, CardUtil.DIX_SCORE),
                new Card(CardUtil.TREFLE_COLOR, CardUtil.DIX_VALUE, CardUtil.DIX_SCORE),
                new Card(CardUtil.TREFLE_COLOR, CardUtil.VALET_VALUE, CardUtil.VALET_SCORE),
                new Card(CardUtil.COEUR_COLOR, CardUtil.DAME_VALUE, CardUtil.DAME_SCORE),
                new Card(CardUtil.CARREAU_COLOR, CardUtil.ROI_VALUE, CardUtil.ROI_SCORE)
                );

        hand = cardService.filterCardsByValue(hand);

        for (int i = 0; i < expectedHand.size(); i++) {
            assertEquals(expectedHand.get(i).getColor(), hand.get(i).getColor());
            assertEquals(expectedHand.get(i).getValue(), hand.get(i).getValue());
            assertEquals(expectedHand.get(i).getScore(), hand.get(i).getScore());
        }

    }

    @Test
    void filterCardsByColor() {
        CardService cardService = new CardServiceImpl();
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(CardUtil.CARREAU_COLOR, CardUtil.ROI_VALUE, CardUtil.ROI_SCORE));
        hand.add(new Card(CardUtil.TREFLE_COLOR, CardUtil.DEUX_VALUE, CardUtil.DEUX_SCORE));
        hand.add(new Card(CardUtil.COEUR_COLOR, CardUtil.DIX_VALUE, CardUtil.DIX_SCORE));
        hand.add(new Card(CardUtil.PIQUE_COLOR, CardUtil.NEUF_VALUE, CardUtil.NEUF_SCORE));
        hand.add(new Card(CardUtil.COEUR_COLOR, CardUtil.DAME_VALUE, CardUtil.DAME_SCORE));
        hand.add(new Card(CardUtil.TREFLE_COLOR, CardUtil.DIX_VALUE, CardUtil.DIX_SCORE));
        hand.add(new Card(CardUtil.PIQUE_COLOR, CardUtil.DEUX_VALUE, CardUtil.DEUX_SCORE));
        hand.add(new Card(CardUtil.TREFLE_COLOR, CardUtil.VALET_VALUE, CardUtil.VALET_SCORE));
        hand.add(new Card(CardUtil.CARREAU_COLOR, CardUtil.AS_VALUE, CardUtil.AS_SCORE));
        hand.add(new Card(CardUtil.TREFLE_COLOR, CardUtil.AS_VALUE, CardUtil.AS_SCORE));

        List<Card> expectedHand = List.of(
                new Card(CardUtil.CARREAU_COLOR, CardUtil.ROI_VALUE, CardUtil.ROI_SCORE),
                new Card(CardUtil.CARREAU_COLOR, CardUtil.AS_VALUE, CardUtil.AS_SCORE),
                new Card(CardUtil.COEUR_COLOR, CardUtil.DIX_VALUE, CardUtil.DIX_SCORE),
                new Card(CardUtil.COEUR_COLOR, CardUtil.DAME_VALUE, CardUtil.DAME_SCORE),
                new Card(CardUtil.PIQUE_COLOR, CardUtil.NEUF_VALUE, CardUtil.NEUF_SCORE),
                new Card(CardUtil.PIQUE_COLOR, CardUtil.DEUX_VALUE, CardUtil.DEUX_SCORE),
                new Card(CardUtil.TREFLE_COLOR, CardUtil.DEUX_VALUE, CardUtil.DEUX_SCORE),
                new Card(CardUtil.TREFLE_COLOR, CardUtil.DIX_VALUE, CardUtil.DIX_SCORE),
                new Card(CardUtil.TREFLE_COLOR, CardUtil.VALET_VALUE, CardUtil.VALET_SCORE),
                new Card(CardUtil.TREFLE_COLOR, CardUtil.AS_VALUE, CardUtil.AS_SCORE));

        hand = cardService.filterCardsByColor(hand);

        for (int i = 0; i < expectedHand.size(); i++) {
            assertEquals(expectedHand.get(i).getColor(), hand.get(i).getColor());
            assertEquals(expectedHand.get(i).getValue(), hand.get(i).getValue());
            assertEquals(expectedHand.get(i).getScore(), hand.get(i).getScore());
        }
    }
}