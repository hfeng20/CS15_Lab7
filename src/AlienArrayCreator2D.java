import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class AlienArrayCreator2D {

    private Pane alienPane;
    private Alien[][] alienArray2D = new Alien[7][5]; // here's the declaration of the array variable!

    public AlienArrayCreator2D(Pane alienPane) {
        this.alienPane = alienPane;
    }

    public void generateAliens() {
        this.reset(); // don't worry about this! it's just to make sure you don't double generate

        /*
         * TODO:
         * 1. Loop to each array in your array of arrays
         * 2. Loop through each index in each array in your array of arrays
         * (hint: it's a double for-loop!)
         * 3. At each internal loop, create an Alien object
         * 4. Alien color should be BLUE if the major index is even, otherwise GREEN
         * 3. Store the Alien object in the array at that index pair
         * 4. Don't forget to add the Alien to the pane! - Use the helper method
         */
        for (int i = 0; i < 7; i++) {
            for (int t = 0; t < 5; t++) {
                Alien tempAlien = new Alien(Color.LIGHTGREEN);
                this.alienArray2D[i][t] = tempAlien;
                tempAlien.addToPane(this.alienPane);
            }
        }
    }

    public void lineUpAliens() {
        /*
         * TODO:
         * 1. Loop through your 2d array (double for-loop again!)
         * 2. For every alien, make the x and y positions dependent on the alien's
         * location in the array
         * Remember that in a 2D array there is a pair of indices that correspond to an
         * alien's location
         * If my alien is at indices (4, 2) (alienArray2D[4][2]) maybe I want my alien
         * to exist
         * at coordinates (40, 20)
         * 3. Set the y position based on the row (major index)
         * 4. Set the x position based on the column (minor index)
         */
        for (int i = 0; i < 7; i++) {
            for (int t = 0; t < 5; t++) {
                this.alienArray2D[i][t].setXPos(i * 60 + 60);
                this.alienArray2D[i][t].setYPos(t * 80 + 30);
            }
        }
    }

    public void rowToCol() {
        /*
         * TODO:
         * After the lineup method, your array should be organized in a row-major
         * fashion
         * this means the 2d array is organized as a stack of row arrays, which we want
         * to change to column arrays.
         * ____________ | | |
         * ____________ ---> | | |
         * ____________ | | |
         * 1. Loop through your alien array
         * 2. Set the y position based on the column (major index)
         * 3. Set the x position based on the row (minor index)
         */
        for (int i = 0; i < 7; i++) {
            for (int t = 0; t < 5; t++) {
                this.alienArray2D[i][t].setYPos(i * 60 + 60);
                this.alienArray2D[i][t].setXPos(t * 70 + 30);
            }
        }
    }

    public boolean checkEvilAliens(Alien[] aliens) {
        /*
         * TODO:
         * You want to check whether the given 1-D array of aliens contains at least 3
         * evil aliens. If
         * it contains at least 3 evil aliens then the whole row is evil and you want to
         * return true
         * and false otherwise.
         * 1. Loop through the given 1-D array of aliens and keep track of how many evil
         * aliens you have
         * 2. Return true when you see that the number of evil aliens is 3
         * 3. If the for-loop finishes and it did not count 3 evil aliens within the
         * loop then return
         * false
         */
        int numEvil = 0;
        for (Alien alien : aliens) {
            if (alien.getIsEvil()) {
                numEvil++;
                if (numEvil == 3) {
                    return true;
                }
            }
        }
        return false;
    }

    public void revealEvil() {
        /*
         * TODO:
         * You want to check each of the rows (or columns if you have them lined up in
         * column-major) and
         * determine whether it is an evil row which is based on the boolean returned by
         * the
         * checkEvilAliens method. If a row (or column) is determined to be evil then
         * set the color
         * of all aliens in that row to be red.
         * 1. Loop through all the rows (or columns if column-major) of alien array
         * 2. Check if the row (or column) is evil
         * 3. If the row is evil, change the color of all aliens to be red
         */
        for (Alien[] row : this.alienArray2D) {
            if (checkEvilAliens(row)) {
                for (Alien alien : row) {
                    alien.setColor(Color.RED);
                }
            }
        }
    }

    /**
     * These are helper methods that we call in your code. Feel free to read through
     * them but please
     * don't change anything!
     **/

    public void reset() {
        this.alienArray2D = new Alien[7][5];
        this.alienPane.getChildren().clear();
    }
}
