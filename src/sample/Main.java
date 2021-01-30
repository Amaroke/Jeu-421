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

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        // On définit le titre de la fenêtre.
        primaryStage.setTitle("Jeu 421");

        // On définit le BorderPane.
        BorderPane root = new BorderPane();
        primaryStage.setScene(new Scene(root, 300, 275));

        // On s'occupe du bouton jouer.
        Button boutonJouer = new Button("Jouer");
        root.setBottom(boutonJouer);
        Image face1 = new Image(getClass().getResourceAsStream("../ressources/1.png"), 50, 50, true, true);
        ArrayList<Button> des = new ArrayList<>(3);
        AtomicBoolean[] desBloque = new AtomicBoolean[3];
        for (int i = 0; i < 3; i++) {
            des.add(new Button());
            desBloque[i] = new AtomicBoolean(false);
            int finalI = i;
            des.get(i).setOnAction(e -> {
                desBloque[finalI].set(!desBloque[finalI].get());
                if (desBloque[finalI].get()) {
                    System.out.println("Vous avez bloqué le dé "+ (finalI+1) +" !");
                } else {
                    System.out.println("Vous avez débloqué le dé " + (finalI+1) +" !");
                }
            });
            des.get(i).setGraphic(new ImageView(face1));
        }
        // On gère les affichage des compteurs.
        Label nombreClique = new Label("Nombre de cliques : 0 ");
        Label nombreDe421 = new Label("Nombre de 421 : 0");
        boutonJouer.setOnAction(new Ecouteur(des, nombreClique, nombreDe421, desBloque));

        // On gère le bouton quitter.
        Button boutonQuitter = new Button("");
        Image image = new Image(getClass().getResourceAsStream("../ressources/quitter.png"), 35, 35, true, true);
        ImageView icon = new ImageView(image);
        boutonQuitter.setGraphic(icon);
        boutonQuitter.setOnAction(e -> Platform.exit());

        // On gère l'affichage des boutons dubas.
        HBox boutonsBas = new HBox();
        boutonsBas.getChildren().addAll(boutonJouer, boutonQuitter);
        boutonsBas.setAlignment(Pos.CENTER);
        boutonsBas.setSpacing(50);
        boutonsBas.setPadding(new Insets(0, 0, 20, 0));
        root.setBottom(boutonsBas);

        // On gère l'affichage des dés.
        HBox desBox = new HBox();
        desBox.getChildren().addAll(des);
        desBox.setAlignment(Pos.CENTER);
        desBox.setSpacing(25);
        root.setCenter(desBox);

        // On gère l'affichage des compteurs.
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
