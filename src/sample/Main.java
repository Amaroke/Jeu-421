package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        primaryStage.setTitle("Jeu 421");

        BorderPane root = new BorderPane();
        primaryStage.setScene(new Scene(root, 300, 275));

        Button boutonJouer = new Button("Jouer");
        root.setBottom(boutonJouer);
        Image face1 = new Image(getClass().getResourceAsStream("../ressources/1.png"), 50, 50, true, true);
        Label des1 = new Label("");
        Label des2 = new Label("");
        Label des3 = new Label("");
        des1.setGraphic(new ImageView(face1));
        des2.setGraphic(new ImageView(face1));
        des3.setGraphic(new ImageView(face1));
        Label nombreClique = new Label("Nombre de cliques : 0 ");
        Label nombreDe421 = new Label("Nombre de 421 : 0");
        boutonJouer.setOnAction(new Ecouteur(des1, des2, des3, nombreClique, nombreDe421));

        Button boutonQuitter = new Button("");
        Image image = new Image(getClass().getResourceAsStream("../ressources/quitter.png"), 35, 35, true, true);
        ImageView icon = new ImageView(image);
        boutonQuitter.setGraphic(icon) ;
        boutonQuitter.setOnAction(e ->Platform.exit());

        HBox boutonsBas = new HBox();
        boutonsBas.getChildren().addAll(boutonJouer, boutonQuitter);
        boutonsBas.setAlignment(Pos.CENTER);
        boutonsBas.setSpacing(50);
        boutonsBas.setPadding(new Insets(0, 0, 20, 0));
        root.setBottom(boutonsBas);

        HBox des = new HBox();
        des.getChildren().addAll(des1, des2, des3);
        des.setAlignment(Pos.CENTER);
        des.setSpacing(25);
        root.setCenter(des);

        HBox compteurs = new HBox();
        compteurs.getChildren().addAll(nombreClique, nombreDe421);
        compteurs.setAlignment(Pos.CENTER);
        compteurs.setSpacing(10);
        compteurs.setPadding(new Insets(20, 0, 0, 0));
        root.setTop(compteurs);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
