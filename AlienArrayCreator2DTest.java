package lab7;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AlienArrayCreator2DTest {

    @Test
    public void testCheckEvilRow() {
        // Instantiating necessary values
        Pane pane = new Pane();
        AlienArrayCreator2D creator2D = new AlienArrayCreator2D(pane);
        // Creating a row of 10 aliens
        Alien[] row = new Alien[10];

        /* TODO:
            1. Populate the row array by creating 10 aliens (for-loop)
            2. Use the Alien's setIsEvil method to set them all to be false
            3. How many Aliens do you need to set as evil to test the checkEvilAliens method using row
         */
    }
}
