package com.benoitnerin.cardsappapi.controller;

import com.benoitnerin.cardsappapi.pojo.Card;
import com.benoitnerin.cardsappapi.pojo.Hand;
import com.benoitnerin.cardsappapi.service.CardService;
import com.benoitnerin.cardsappapi.util.CardUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping(value = "/cards-app")
public class CardController {

    private CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping(value = "/random-cards", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getRandomHand() {
        try {
            List<Card> cards = cardService.getRandomCards(CardUtil.CARDS_QUANTITY);
            return new ResponseEntity<>(new Hand(cards), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/cards-by-value", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getFilteredCardsByValue(@RequestBody Hand hand) {
        try {
            List<Card> cards = cardService.filterCardsByValue(hand.getCards());
            return new ResponseEntity<>(new Hand(cards), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping(value = "/cards-by-color", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getFilteredCardsByColor(@RequestBody Hand hand) {
        try {
            List<Card> cards = cardService.filterCardsByColor(hand.getCards());
            return new ResponseEntity<>(new Hand(cards), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
