package Sudoku;

public class SudokuDriverSolve {

    public static void main(String[] args) throws InterruptedException {

        // This is a simple Sudoku puzzle, just for debugging.
        int[][] almostDoneBoard =
                {{0, 0, 0, 0, 0, 0, 0, 1, 9},
                        {0, 3, 0, 0, 9, 0, 0, 0, 8},
                        {0, 0, 6, 2, 4, 0, 0, 0, 0},
                        {8, 0, 0, 0, 6, 0, 0, 0, 0},
                        {1, 7, 0, 9, 0, 4, 0, 0, 2},
                        {0, 0, 0, 0, 3, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1},
                        {0, 5, 0, 3, 8, 0, 2, 9, 0},
                        {3, 0, 9, 0, 0, 5, 0, 0, 4}};
        SudokuSolve almostDoneSudoku = new SudokuSolve(almostDoneBoard);
        almostDoneSudoku.solve();
        almostDoneSudoku.printBoard();

        // This is an actual Sudoku puzzle, that actual people actually try to solve.
        // It may have a different solution than the board above.
        // The board above has several solutions, this board only has one.
        int[][] board =
                {{5, 3, 0, 0, 7, 0, 0, 0, 0},
                        {6, 0, 0, 1, 9, 5, 0, 0, 0},
                        {0, 9, 8, 0, 0, 0, 0, 6, 0},
                        {8, 0, 0, 0, 6, 0, 0, 0, 3},
                        {4, 0, 0, 8, 0, 3, 0, 0, 1},
                        {7, 0, 0, 0, 2, 0, 0, 0, 6},
                        {0, 6, 0, 0, 0, 0, 2, 8, 0},
                        {0, 0, 0, 4, 1, 9, 0, 0, 5},
                        {0, 0, 0, 0, 8, 0, 0, 7, 9}};
        SudokuSolve sudoku = new SudokuSolve(board);
        sudoku.solve();
        sudoku.printBoard();
    }
}