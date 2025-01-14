package org.example.memory_game_projekt;

import javafx.scene.Node;

import javafx.scene.image.Image;

public class Card extends Node {
    private Image context; // Card context like image/text
    private boolean isMatched; // if card matched

    public Card(String ImagePlace) { //Constructor
        this.context = new Image(ImagePlace);
        this.isMatched = false;
    }

    public Image getContext() {
        return context;
    }

    public boolean isMatched() {
        return isMatched;
    }

    public void setMatched(boolean matched) {
        isMatched = matched;
    }

    @Override
    public Node getStyleableNode() {
        return super.getStyleableNode();
    }
}