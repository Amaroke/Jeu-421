package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class Ecouteur implements EventHandler<ActionEvent> {

    private int nombreCliques;
    private final Label labelNombreCliques;
    private final ArrayList<Button> des = new ArrayList<>();
    private final AtomicBoolean[] desBloque = new AtomicBoolean[3];
    private int nombreDe421;
    private final Label labelNombreDe421;
    private final int[] lancers = new int[3];

    public Ecouteur(ArrayList<Button> des, Label nombreCliques, Label nombreDe421, AtomicBoolean[] desBloque) {
        this.nombreCliques = 0;
        this.labelNombreCliques = nombreCliques;
        this.des.addAll(des);
        this.nombreDe421 = 0;
        this.labelNombreDe421 = nombreDe421;
        for (int i = 0; i < 3; ++i) {
            this.desBloque[i] = desBloque[i];
            this.lancers[i] = 1;
        }
    }

    @Override
    public void handle(ActionEvent event) {
        // Si on a pas encore joué, on affiche un message de bienvenu
        if (nombreCliques == 0) {
            System.out.println("Bienvenue !\n");
        }
        nombreCliques++;

        System.out.println("Il y a eu " + nombreCliques + " cliques");
        System.out.println("Il y a eu " + nombreDe421 + " 421\n");
        labelNombreCliques.setText("Nombre de cliques : " + nombreCliques + " ");
        labelNombreDe421.setText("Nombre de 421 : " + nombreDe421);

        // On lance les dés.
        for (int i = 0; i < 3; i++) {
            if (!desBloque[i].get()) {
                lancers[i] = (int) (Math.random() * 6 + 1);
            }
        }

        // On regarde s'il y a un 421.
        if ((lancers[0] == 1 && lancers[1] == 2 && lancers[2] == 4) || (lancers[0] == 1 && lancers[1] == 4 && lancers[2] == 2) || (lancers[0] == 2 && lancers[1] == 1 && lancers[2] == 4) || (lancers[0] == 2 && lancers[1] == 4 && lancers[2] == 1) || (lancers[0] == 4 && lancers[1] == 2 && lancers[2] == 1) || (lancers[0] == 4 && lancers[1] == 1 && lancers[2] == 2)) {
            nombreDe421++;
        }

        // On charge les images des dés.
        Image face1 = new Image(getClass().getResourceAsStream("../ressources/1.png"), 50, 50, true, true);
        Image face2 = new Image(getClass().getResourceAsStream("../ressources/2.png"), 50, 50, true, true);
        Image face3 = new Image(getClass().getResourceAsStream("../ressources/3.png"), 50, 50, true, true);
        Image face4 = new Image(getClass().getResourceAsStream("../ressources/4.png"), 50, 50, true, true);
        Image face5 = new Image(getClass().getResourceAsStream("../ressources/5.png"), 50, 50, true, true);
        Image face6 = new Image(getClass().getResourceAsStream("../ressources/6.png"), 50, 50, true, true);
        Image[] faces = {face1, face2, face3, face4, face5, face6};

        // On applique les bonnes images au dés.
        for (int i = 0; i < 3; i++) {
            des.get(i).setGraphic(new ImageView(faces[lancers[i] - 1]));
        }
    }
}