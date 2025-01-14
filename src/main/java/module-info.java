module org.example.memory_game_projekt {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.ikonli.javafx;

    opens org.example.memory_game_projekt to javafx.fxml;
    exports org.example.memory_game_projekt;
}