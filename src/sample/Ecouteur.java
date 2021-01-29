package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Ecouteur implements EventHandler<ActionEvent> {

    private int nombreCliques;
    private final Label labelNombreCliques;
    private final Label des1;
    private final Label des2;
    private final Label des3;
    private int nombreDe421;
    private final Label labelNombreDe421;

    public Ecouteur(Label des1, Label des2, Label des3, Label nombreCliques, Label nombreDe421) {
        this.nombreCliques = 0;
        this.labelNombreCliques = nombreCliques;
        this.des1 = des1;
        this.des2 = des2;
        this.des3 = des3;
        this.nombreDe421 = 0;
        this.labelNombreDe421 = nombreDe421;
    }

    @Override
    public void handle(ActionEvent event) {
        if (nombreCliques == 0) {
            System.out.println("Bienvenue !\n");
        }
        nombreCliques++;

        System.out.println("Il y a eu " + nombreCliques + " cliques");
        System.out.println("Il y a eu " + nombreDe421 + " 421\n");
        labelNombreCliques.setText("Nombre de cliques : " + nombreCliques + " ");
        labelNombreDe421.setText("Nombre de 421 : " + nombreDe421);

        int lancer1 = (int) (Math.random() * 6 + 1);
        int lancer2 = (int) (Math.random() * 6 + 1);
        int lancer3 = (int) (Math.random() * 6 + 1);

        if ((lancer1 == 1 && lancer2 == 2 && lancer3 == 4) || (lancer1 == 1 && lancer2 == 4 && lancer3 == 2) || (lancer1 == 2 && lancer2 == 1 && lancer3 == 4) || (lancer1 == 2 && lancer2 == 4 && lancer3 == 1) || (lancer1 == 4 && lancer2 == 2 && lancer3 == 1) || (lancer1 == 4 && lancer2 == 1 && lancer3 == 2)) {
            nombreDe421++;
        }

        Image face1 = new Image(getClass().getResourceAsStream("../ressources/1.png"), 50, 50, true, true);
        Image face2 = new Image(getClass().getResourceAsStream("../ressources/2.png"), 50, 50, true, true);
        Image face3 = new Image(getClass().getResourceAsStream("../ressources/3.png"), 50, 50, true, true);
        Image face4 = new Image(getClass().getResourceAsStream("../ressources/4.png"), 50, 50, true, true);
        Image face5 = new Image(getClass().getResourceAsStream("../ressources/5.png"), 50, 50, true, true);
        Image face6 = new Image(getClass().getResourceAsStream("../ressources/6.png"), 50, 50, true, true);

        switch (lancer1) {
            case 1:
                des1.setGraphic(new ImageView(face1));
                break;
            case 2:
                des1.setGraphic(new ImageView(face2));
                break;
            case 3:
                des1.setGraphic(new ImageView(face3));
                break;
            case 4:
                des1.setGraphic(new ImageView(face4));
                break;
            case 5:
                des1.setGraphic(new ImageView(face5));
                break;
            case 6:
                des1.setGraphic(new ImageView(face6));
                break;
        }

        switch (lancer2) {
            case 1:
                des2.setGraphic(new ImageView(face1));
                break;
            case 2:
                des2.setGraphic(new ImageView(face2));
                break;
            case 3:
                des2.setGraphic(new ImageView(face3));
                break;
            case 4:
                des2.setGraphic(new ImageView(face4));
                break;
            case 5:
                des2.setGraphic(new ImageView(face5));
                break;
            case 6:
                des2.setGraphic(new ImageView(face6));
                break;
        }

        switch (lancer3) {
            case 1:
                des3.setGraphic(new ImageView(face1));
                break;
            case 2:
                des3.setGraphic(new ImageView(face2));
                break;
            case 3:
                des3.setGraphic(new ImageView(face3));
                break;
            case 4:
                des3.setGraphic(new ImageView(face4));
                break;
            case 5:
                des3.setGraphic(new ImageView(face5));
                break;
            case 6:
                des3.setGraphic(new ImageView(face6));
                break;
        }
    }
}