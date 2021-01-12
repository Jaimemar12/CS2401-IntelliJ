package MouseAI;

public class Board {

    public final static int BOARD_SIZE = 20;

    private Cat cat;
    private Mouse[] mice;

    /**
     * Initializes the correct number of mice at random locations.
     * Initializes one cat with the given appetite.
     */
    public Board(int numMice, int catAppetite) {
        mice = new Mouse[5];
        for(int i = 0; i < mice.length; i++) {
            mice[i] = new Mouse((int) (Math.random() * BOARD_SIZE), (int) (Math.random() * BOARD_SIZE));
        }

        cat = new Cat((int) (Math.random() * BOARD_SIZE), (int) (Math.random() * BOARD_SIZE), 5);
    }

    // Moves each mouse and the cat.
    public void step() {
        for(int i = 0; i < mice.length; i++) {
            if(!mice[i].isEaten()) {
                mice[i].move();
            }
        }

        cat.chaseMice(mice);
    }

    // Creates a 2D char array to represent the Board.
    public char[][] getDisplayArray() {
        char[][] displayArray = new char[BOARD_SIZE][BOARD_SIZE];

        // Empty squares are dots.
        for (int r = 0; r < BOARD_SIZE; r++) {
            for (int c = 0; c < BOARD_SIZE; c++) {
                displayArray[r][c] = '.';
            }
        }

        // Fill in the live mice.
        for(int i = 0; i < mice.length; i++) {
            if(!mice[i].isEaten()) {
                displayArray[mice[i].getRow()][mice[i].getCol()] = 'M';
            }
        }

        // Fill in the cat.
        displayArray[cat.getRow()][cat.getCol()] = 'C';

        return displayArray;
    }
}