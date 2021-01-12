package Sudoku;

public class Sudoku {

    // A 9-by-9 array representing a Sudoku board. A 0 means the square has
    // not been assigned yet.
    private int[][] board;

    /**
     * Precondition: board is a 9-by-9 array with only the numbers 0-9 as values.
     */
    public Sudoku(int[][] board) {
        this.board = board;
    }

    /**
     * Returns whether or not the Sudoku board is valid. Each row, column, or
     * 3-by-3 subsquare is valid if it contains the numbers 1-9 exactly once
     * with any number of unassigned squares.
     */
    public boolean isBoardValid() {
        // TODO: Implement this function.

        //this loop goes 0 - 8
        for(int i = 0; i < board.length; i++) {

            if(!(isRowValid(i) && isColumnValid(i) && isSquareValid(i))) { //if one of the methods returns false it will immediately return false
                return false;
            }
        }

        //if everything was true it will return true
        return true;
    }

    /**
     * Returns true if and only if row r is a valid Sudoku row.
     * Precondition: row is in the range [0, 9).
     */
    public boolean isRowValid(int row) {
        // TODO: Implement this function.

        //returns what isNumberSetValid function returned with board[row] as row
        return isNumberSetValid(board[row]);
    }

    /**
     * Returns true if and only if column c is a valid Sudoku column.
     * Precondition: column is in the range [0, 9).
     */
    public boolean isColumnValid(int column) {
        // TODO: Implement this function.
        boolean[] value = new boolean[10];

        //goes through all the elements in each column of the board
        for(int i = 0; i < board.length; i++){

            //if the element is not 0 and boolean array value is true at index of element board[i][column] it will return false indicating repeats
            if(board[i][column] != 0 && value[board[i][column]] == true) {
                return false;

                //if it was false at value[board[i][column]] that element in the array will now become true
            }else if (board[i][column] != 0 && value[board[i][column]] == false){
                value[board[i][column]] = true;
            }
        }

        //if no duplicates were found it will return true
        return true;
    }

    /**
     * Returns true if and only if 3-by-3 subsquare containing the entry at row, column
     * is a valid Sudoku subsquare.
     * Precondition: squareIndex is in the range [0, 9).
     */
    public boolean isSquareValid(int squareIndex) {
        // TODO: Implement this function.
        int row = 3 * (squareIndex / 3);
        int col = 3 * (squareIndex % 3);
        boolean[] value = new boolean[10];

        //goes through all the elements in each row and column of the board 2D array
        for(int i = row; i < row+3; i++){
            for(int j = col; j < col+3; j++) {

                //if the element is not 0 and boolean array value is true at index of element board[i][j] it will return false indicating repeats
                if(board[i][j] != 0 && value[board[i][j]] == true) {
                    return false;

                    //if it was false at value[board[i][j]] that element in the array will now become true
                }else if (board[i][j] != 0 && value[board[i][j]] == false){
                    value[board[i][j]] = true;
                }
            }
        }

        //if no duplicates were found it will return true
        return true;
    }

    /**
     * Returns whether the input set could constitute a valid row, column, or subsquare.
     */
    public static boolean isNumberSetValid(int[] set) {
        boolean[] value = new boolean[10];

        //goes through all the elements in the set array
        for(int i = 0; i < set.length; i++){

            //if the element is not 0 and boolean array value is true at index of element set[i] it will return false indicating repeats
            if(set[i] != 0 && value[set[i]] == true) {
                return false;

                //if it was false at value[set[i]] that element in the array will now become true
            }else if (set[i] != 0 && value[set[i]] == false){
                value[set[i]] = true;
            }
        }

        //if no duplicates were found it will return true
        return true;
    }
}