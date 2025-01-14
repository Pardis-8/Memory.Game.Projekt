package org.example.memory_game_projekt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    private List<Card> cards; //All cards in game
    private int score;

    public Game(List<String> context) {
        cards = new ArrayList<>();

        for (int i = 0; i < context.size(); i++) {
            String Context = context.get(i); //retrieve context

            cards.add(new Card(Context)); //First card with image
            cards.add(new Card(Context)); //Second card with same image
        }
        shuffleCards();
        score = 0;
    }
    public void shuffleCards() {
        Collections.shuffle(cards);
    }
    public boolean MatchCheck(int card1, int card2) {
        if(card1 == card2 || cards.get(card1).isMatched() || cards.get(card2).isMatched()) {
            return false; //Invalid move
        }
        boolean isMatched = cards.get(card1).getContext().equals(cards.get(card2).getContext());
        if(isMatched) {
            cards.get(card1).setMatched(true);
            cards.get(card2).setMatched(true);
            score++;
        }
        return isMatched;
    }
    public int getScore() {
        return score;
    }
    public List<Card> getCards() {
        return cards;
    }
}