package MouseAI;

public class Cat {

    private int row;
    private int col;
    private int appetite;
    private int numMiceEaten;

    /**
     * Sets row, col, and appetite based on the inputs.
     * Sets numMiceEaten to 0.
     */
    public Cat(int r, int c, int a) {
        row = r;
        col = c;
        appetite = a;
        numMiceEaten = 0;
    }

    /**
     * If the cat has already filled its appetite or all the mice have already been eaten, do nothing.
     * Chooses one not-yet-eaten Mouse from the input array as the target and moves towards that Mouse.
     * The cat is allowed to move up, down, left, right, or diagonally one space.
     * After the move, eat any mice that are at the cat's location.
     */
    public void chaseMice(Mouse[] mice) {
        double distances[] = new double[mice.length];
        double min;
        int target = 0;

        for(int i = 0; i < distances.length; i++) {
            if(!mice[i].isEaten()) {
                distances[i] = Math.sqrt(Math.pow(col - mice[i].getCol(), 2) + Math.pow(row - mice[i].getRow(), 2));
            }else {
                distances[i] = Integer.MAX_VALUE;
            }
        }

        min = distances[0];
        for(int j = 0; j < distances.length; j++) {
            if(distances[j] < min) {
                target = j;
                min = distances[j];
            }
        }

        if(numMiceEaten == appetite) {
            System.exit(0);
        }

        if(mice[target].getRow() < row && row > 0) {
            row--;
        }else if(mice[target].getRow() > row && row < Board.BOARD_SIZE - 1){
            row++;
        }

        if(mice[target].getCol() < col && col > 0) {
            col--;
        }else if(mice[target].getCol() > col && col < Board.BOARD_SIZE - 1){
            col++;
        }

        if(row == mice[target].getRow() && col == mice[target].getCol() && !mice[target].isEaten()) {
            mice[target].beEaten();
            numMiceEaten++;
        }
    }

    // Returns the cat's row.
    public int getRow() {
        return row;
    }

    // Returns the cat's column.
    public int getCol() {
        return col;
    }
}