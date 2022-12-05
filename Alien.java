package lab7;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;

/**
 * ____                      _              _ _ _     _
 * |  _ \  ___    _ __   ___ | |_    ___  __| (_) |_  | |
 * | | | |/ _ \  | '_ \ / _ \| __|  / _ \/ _` | | __| | |
 * | |_| | (_) | | | | | (_) | |_  |  __/ (_| | | |_  |_|
 * |____/ \___/  |_| |_|\___/ \__|  \___|\__,_|_|\__| (_)
 * <p>
 * This is support code for the lab. You may look at it if you are interested,
 * but you will not have to change anything to complete your lab.
 */

public class Alien {

    private Circle body;
    private Circle leftEye;
    private Circle rightEye;
    private boolean isEvil;

    public Alien(Color bodyColor) {
        this.setUpAlien(bodyColor);
    }

    public void setIsEvil(boolean isEvil) {
        this.isEvil = isEvil;
    }

    private void setUpAlien(Color bodyColor) {
        int xPos = this.randomLocGenerator();
        int yPos = this.randomLocGenerator();
        this.body = new Circle(xPos, yPos, 20, bodyColor);
        this.leftEye = new Circle(xPos - 5, yPos - 7, 4, Color.BLACK);
        this.rightEye = new Circle(xPos + 5, yPos - 7, 4, Color.BLACK);
        this.isEvil = this.randomEvilGenerator();
    }

    private boolean randomEvilGenerator() {
        double p = Math.random();
        // 60% chance of the alien being evil
        return p > 0.4;
    }

    public boolean getIsEvil() {
        return this.isEvil;
    }

    public void setXPos(int xPos) {
        this.body.setCenterX(xPos);
        this.leftEye.setCenterX(xPos - 5);
        this.rightEye.setCenterX(xPos + 5);

    }

    public void setYPos(int yPos) {
        this.body.setCenterY(yPos);
        this.leftEye.setCenterY(yPos - 7);
        this.rightEye.setCenterY(yPos - 7);
    }

    public void addToPane(Pane alienPane) {
        alienPane.getChildren().addAll(this.body, this.leftEye, this.rightEye);
    }

    public void removeFromPane(Pane alienPane) {
        alienPane.getChildren().removeAll(this.body, this.leftEye, this.rightEye);
    }

    public void setColor(Color bodyColor) {
        this.body.setFill(bodyColor);
    }

    public Color getColor() {
        return (Color) this.body.getFill();
    }

    public int randomLocGenerator() {
        //generates a random integer between 0 and panel width
        return (int) ((Constants.PANEL_H - 100) * Math.random());
    }

    public Color randomColorGenerator() {
        return Color.color(Math.random(), Math.random(), Math.random());
    }

    public Node getBody() {
        return this.body;
    }

    public Node getLeftEye() {
        return this.leftEye;
    }

    public Node getRightEye() {
        return this.rightEye;
    }


}
