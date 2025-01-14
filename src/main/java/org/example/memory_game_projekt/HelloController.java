package org.example.memory_game_projekt;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.util.List;

public class HelloController {
    private Game game;
    private int firstCard = -1;
    @FXML
    private GridPane gameGrid;
    private ImageView backImage;
    private ImageView frontImage;
    private javafx.scene.image.ImageView ImageView;

    @FXML
    public void initialize() {
        game = new Game(List.of("file: resources/images/image1.png",
                "\"file: resources/images/C:\\Users\\pardi\\OneDrive\\Desktop\\Blumen.jpg\"",
                "file: resources/images/C:\\Users\\pardi\\OneDrive\\Desktop\\nails.jpg",
                "file: resources/images/C:\\Users\\pardi\\OneDrive\\Desktop\\chatgpt_pink.jpg",
                "file: resources/images/C:\\Users\\pardi\\OneDrive\\Desktop\\meme_pic.jpg",
                "file: resources/images/C:\\Users\\pardi\\OneDrive\\Desktop\\cat_mermaid.jpg",
                "C:\\Users\\pardi\\OneDrive\\Desktop\\group_pic.jpg"));
        displayCards();
    }

    private void displayCards() {
        gameGrid.getChildren().clear(); //child node
        for (int i = 0; i < game.getCards().size(); i++) {
            Button click = new Button("");
            int cardIndex = i;

            ImageView = backImage = new ImageView("file:resouces/images/C:\\Users\\pardi\\OneDrive\\Desktop\\back_image.jpg");
            backImage.setFitWidth(100);
            backImage.setFitHeight(200);
            click.setGraphic(backImage);


            click.setOnAction(event -> handleCardClick(cardIndex, click));
            gameGrid.add(click, i % 4, i / 4);
        }
    }

    private void handleCardClick(int cardIndex, Button click) {
        Card clicked = game.getCards().get(cardIndex);

        if ((clicked).isMatched() || cardIndex == firstCard) {
            return;
        }

        ImageView = frontImage = new ImageView(clicked.getContext());
        frontImage.setFitHeight(100);
        frontImage.setFitWidth(200);
        click.setGraphic(frontImage);

        if (firstCard == -1) {
            firstCard = cardIndex; //First card selected
        } else {
            boolean isMatched = game.MatchCheck(firstCard, cardIndex);
            if (!isMatched) {
                new Thread(() -> { //Delay to hide cards again
                    try {
                        Thread.sleep(1000); //1s delay
                        javafx.application.Platform.runLater(() -> {
                            click.setGraphic(new ImageView("file: resource/image/C:\\Users\\pardi\\OneDrive\\Desktop\\back_image.jpg"));
                            Button firstButton = (Button) gameGrid.getChildren().get(firstCard);
                            firstButton.setGraphic(new ImageView("file: resources/image/C:\\Users\\pardi\\OneDrive\\Desktop\\back_image.jpg"));
                            firstCard = -1;
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).start();
            } else {
                firstCard = -1;
            }
        }
    }

    public void onHelloButtonClick(ActionEvent actionEvent) {
    }
}