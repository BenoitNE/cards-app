package com.benoitnerin.cardsappapi.util;

import java.util.List;

public class CardUtil {

    public static final int CARDS_QUANTITY = 10;
    public static final List<String> geColors(){
        return List.of(COEUR_COLOR,CARREAU_COLOR, TREFLE_COLOR, PIQUE_COLOR);
    }
    public static final List<String> getValue(){
        return List.of(AS_VALUE, DEUX_VALUE, TROIS_VALUE, QUATRE_VALUE, CINQ_VALUE, SIX_VALUE, SEPT_VALUE, HUIT_VALUE, NEUF_VALUE ,DIX_VALUE, VALET_VALUE, DAME_VALUE, ROI_VALUE);
    }

    public static final List<Integer> getScore(){
        return List.of(AS_SCORE, DEUX_SCORE, TROIS_SCORE, QUATRE_SCORE, CINQ_SCORE, SIX_SCORE, SEPT_SCORE, HUIT_SCORE, NEUF_SCORE ,DIX_SCORE, VALET_SCORE, DAME_SCORE, ROI_SCORE);
    }

    public static final String COEUR_COLOR = "coeur";
    public static final String CARREAU_COLOR = "carreau";
    public static final String TREFLE_COLOR = "trefle";
    public static final String PIQUE_COLOR = "pique";

    public static final String AS_VALUE = "as";
    public static final String DEUX_VALUE = "2";
    public static final String TROIS_VALUE = "3";
    public static final String QUATRE_VALUE = "4";
    public static final String CINQ_VALUE = "5";
    public static final String SIX_VALUE = "6";
    public static final String SEPT_VALUE = "7";
    public static final String HUIT_VALUE = "8";
    public static final String NEUF_VALUE = "9";
    public static final String DIX_VALUE = "10";
    public static final String VALET_VALUE = "valet";
    public static final String DAME_VALUE = "dame";
    public static final String ROI_VALUE = "roi";

    public static final int AS_SCORE = 1;
    public static final int DEUX_SCORE = 2;
    public static final int TROIS_SCORE = 3;
    public static final int QUATRE_SCORE = 4;
    public static final int CINQ_SCORE = 5;
    public static final int SIX_SCORE = 6;
    public static final int SEPT_SCORE = 7;
    public static final int HUIT_SCORE = 8;
    public static final int NEUF_SCORE = 9;
    public static final int DIX_SCORE = 10;
    public static final int VALET_SCORE = 11;
    public static final int DAME_SCORE = 12;
    public static final int ROI_SCORE = 13;

}
