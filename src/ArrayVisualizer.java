import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

/**
 * ____ _ _ _ _ _
 * | _ \ ___ _ __ ___ | |_ ___ __| (_) |_ | |
 * | | | |/ _ \ | '_ \ / _ \| __| / _ \/ _` | | __| | |
 * | |_| | (_) | | | | | (_) | |_ | __/ (_| | | |_ |_|
 * |____/ \___/ |_| |_|\___/ \__| \___|\__,_|_|\__| (_)
 * <p>
 * This is support code for the lab. You may look at it if you are interested,
 * but you will not have to change anything to complete your lab.
 */

/*
 * This class creates a visualizer for ArrayBuilder to display the different
 * Arrays
 */
public class ArrayVisualizer {

    enum Action {
        GENERATE,
        LINEUP,
        COLOR,
        REMOVEBLUE,
        ROWTOCOL,
        REVEALEVIL
    }

    private Tab arrayTab;
    private Tab array2DTab;
    private Pane arrayContentPane;
    private Pane array2DContentPane;
    private AlienArrayCreator myAlienArrayCreator;
    private AlienArrayCreator2D myAlienArrayCreator2D;

    public ArrayVisualizer() {
        this.arrayTab = new Tab("Arrays");
        this.arrayTab.setContent(this.createArrayContent());
        this.array2DTab = new Tab("2D Arrays");
        this.array2DTab.setContent(this.create2DArrayContent());
        this.myAlienArrayCreator = new AlienArrayCreator(this.arrayContentPane);
        this.myAlienArrayCreator2D = new AlienArrayCreator2D(this.array2DContentPane);
    }

    /*
     * This creates the root pane and adds the control Pane and content
     * Pane to it.
     */
    private Node createArrayContent() {
        BorderPane pane = new BorderPane();
        pane.setPrefSize(Constants.PANEL_W, Constants.PANEL_H + Constants.CP_HEIGHT);
        pane.setBottom(this.createArrayControlPane());
        this.arrayContentPane = new Pane();
        pane.setCenter(this.arrayContentPane);
        return pane;
    }

    /*
     * This creates the root pane and adds the control Pane and content
     * Pane to it.
     */
    private Node create2DArrayContent() {
        BorderPane pane = new BorderPane();
        pane.setPrefSize(Constants.PANEL_W, Constants.PANEL_H + Constants.CP_HEIGHT);
        pane.setBottom(this.create2DArrayControlPane());
        this.array2DContentPane = new Pane();
        pane.setCenter(this.array2DContentPane);
        return pane;
    }

    /*
     * This creates the control Pane with the buttons to control the
     * displayed squares
     */
    private Pane createArrayControlPane() {
        HBox controlPane = new HBox(5);
        controlPane.setAlignment(Pos.CENTER);
        controlPane.setPadding(new Insets(5, 5, 5, 5));
        Button generateButton = new Button("Generate");
        generateButton.setOnMouseReleased(new ArrayButtonListener(Action.GENERATE));
        Button inLineButton = new Button("In Line");
        inLineButton.setOnMouseReleased(new ArrayButtonListener(Action.LINEUP));
        Button alternatingColorsButton = new Button("Alternating Colors");
        alternatingColorsButton.setOnMouseReleased(new ArrayButtonListener(Action.COLOR));
        Button removeBlueButton = new Button("Remove Blue");
        removeBlueButton.setOnMouseReleased(new ArrayButtonListener(Action.REMOVEBLUE));
        controlPane.getChildren().addAll(generateButton, inLineButton, alternatingColorsButton, removeBlueButton);
        return controlPane;
    }

    /*
     * This creates the control Pane with the buttons to control the
     * displayed squares
     */
    private Pane create2DArrayControlPane() {
        HBox controlPane = new HBox(5);
        controlPane.setAlignment(Pos.CENTER);
        controlPane.setPadding(new Insets(5, 5, 5, 5));
        Button generateButton = new Button("Generate");
        generateButton.setOnMouseReleased(new Array2DButtonListener(Action.GENERATE));
        Button inLineButton = new Button("In Line");
        inLineButton.setOnMouseReleased(new Array2DButtonListener(Action.LINEUP));
        Button inLineCMajorButton = new Button("In Line - Column Major");
        inLineCMajorButton.setOnMouseReleased(new Array2DButtonListener(Action.ROWTOCOL));
        Button revealEvilButton = new Button("Reveal Evil");
        revealEvilButton.setOnMouseReleased(new Array2DButtonListener(Action.REVEALEVIL));
        controlPane.getChildren().addAll(generateButton, inLineButton, inLineCMajorButton, revealEvilButton);
        return controlPane;
    }

    /*
     * This method returns the ArrayVisualizer tab.
     */
    public Tab arrayTab() {
        return this.arrayTab;
    }

    public Tab array2DTab() {
        return this.array2DTab;
    }

    private class ArrayButtonListener implements EventHandler<MouseEvent> {

        private Action buttonAction;

        public ArrayButtonListener(Action buttonAction) {
            this.buttonAction = buttonAction;
        }

        @Override
        public void handle(MouseEvent event) {
            switch (this.buttonAction) {
                case GENERATE:
                    ArrayVisualizer.this.myAlienArrayCreator.generateAliens();
                    break;
                case COLOR:
                    ArrayVisualizer.this.myAlienArrayCreator.alternateAlienColors();
                    break;
                case LINEUP:
                    ArrayVisualizer.this.myAlienArrayCreator.lineUpAliens();
                    break;
                case REMOVEBLUE:
                    ArrayVisualizer.this.myAlienArrayCreator.removeBlue();
                    break;

            }
        }
    }

    private class Array2DButtonListener implements EventHandler<MouseEvent> {

        private Action buttonAction;

        public Array2DButtonListener(Action buttonAction) {
            this.buttonAction = buttonAction;
        }

        @Override
        public void handle(MouseEvent event) {
            switch (this.buttonAction) {
                case GENERATE:
                    ArrayVisualizer.this.myAlienArrayCreator2D.generateAliens();
                    break;
                case LINEUP:
                    ArrayVisualizer.this.myAlienArrayCreator2D.lineUpAliens();
                    break;
                case ROWTOCOL:
                    ArrayVisualizer.this.myAlienArrayCreator2D.rowToCol();
                    break;
                case REVEALEVIL:
                    ArrayVisualizer.this.myAlienArrayCreator2D.revealEvil();
                    break;
            }
        }
    }
}