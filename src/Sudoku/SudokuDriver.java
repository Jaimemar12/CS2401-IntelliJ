package Sudoku;

public class SudokuDriver {

    public static void main(String[] args) {
        int[][] board =
                {{0, 0, 0, 0, 0, 0, 0, 0, 0},  //0 	empty row
                        {1, 0, 0, 0, 0, 0, 0, 0, 0},  //1	incomplete rows
                        {4, 0, 3, 0, 2, 0, 1, 0, 0},  //2
                        {8, 6, 7, 4, 1, 2, 5, 9, 3},  //3	complete row
                        {0, 0, 8, 0, 0, 8, 0, 0, 0},  //4 	incomplete but invalid
                        {8, 6, 2, 4, 1, 2, 5, 9, 3},  //5 	complete but invalid
                        {0, 0, 0, 0, 0, 0, 0, 0, 0},  //6
                        {0, 0, 0, 0, 0, 0, 0, 0, 0},  //7
                        {0, 0, 0, 0, 0, 0, 0, 0, 0}}; //8

        int[][] solvedBoard =
                {{1, 2, 3, 4, 5, 6, 7, 8, 9},
                        {7, 8, 9, 1, 2, 3, 4, 5, 6},
                        {4, 5, 6, 7, 8, 9, 1, 2, 3},
                        {5, 1, 2, 6, 4, 7, 9, 3, 8},
                        {9, 3, 4, 8, 1, 5, 2, 6, 7},
                        {8, 6, 7, 9, 3, 2, 5, 1, 4},
                        {2, 4, 8, 3, 7, 1, 6, 9, 5},
                        {3, 9, 5, 2, 6, 4, 8, 7, 1},
                        {6, 7, 1, 5, 9, 8, 3, 4, 2}};

        Sudoku sudoku = new Sudoku(board);
        Sudoku sudoku2 = new Sudoku(solvedBoard);

        System.out.println("Unsolved Sudoku\t\t\t\t|\tSolved Sudoku");
        System.out.println("Row 0: Expected true, actual " + sudoku.isRowValid(0) + "\t|\tExpected true, actual " + sudoku2.isRowValid(0));
        System.out.println("Row 1: Expected true, actual " + sudoku.isRowValid(1) + "\t|\tExpected true, actual " + sudoku2.isRowValid(1));
        System.out.println("Row 2: Expected true, actual " + sudoku.isRowValid(2) + "\t|\tExpected true, actual " + sudoku2.isRowValid(2));
        System.out.println("Row 3: Expected true, actual " + sudoku.isRowValid(3) + "\t|\tExpected true, actual " + sudoku2.isRowValid(3));
        System.out.println("Row 4: Expected false, actual " + sudoku.isRowValid(4) + "\t|\tExpected true, actual " + sudoku2.isRowValid(4));
        System.out.println("Row 5: Expected false, actual " + sudoku.isRowValid(5) + "\t|\tExpected true, actual " + sudoku2.isRowValid(5));
        System.out.println("Row 6: Expected true, actual " + sudoku.isRowValid(6) + "\t|\tExpected true, actual " + sudoku2.isRowValid(6));
        System.out.println("Row 7: Expected true, actual " + sudoku.isRowValid(7) + "\t|\tExpected true, actual " + sudoku2.isRowValid(7));
        System.out.println("Row 8: Expected true, actual " + sudoku.isRowValid(8) + "\t|\tExpected true, actual " + sudoku2.isRowValid(8));

        System.out.println("\t\t\t\t\t|");

        System.out.println("Column 0: Expected false, actual " + sudoku.isColumnValid(0) + "\t|\tExpected true, actual " + sudoku2.isColumnValid(0));
        System.out.println("Column 1: Expected false, actual " + sudoku.isColumnValid(1) + "\t|\tExpected true, actual " + sudoku2.isColumnValid(1));
        System.out.println("Column 2: Expected true, actual " + sudoku.isColumnValid(2) + "\t|\tExpected true, actual " + sudoku2.isColumnValid(2));
        System.out.println("Column 3: Expected false, actual " + sudoku.isColumnValid(3) + "\t|\tExpected true, actual " + sudoku2.isColumnValid(3));
        System.out.println("Column 4: Expected false, actual " + sudoku.isColumnValid(4) + "\t|\tExpected true, actual " + sudoku2.isColumnValid(4));
        System.out.println("Column 5: Expected false, actual " + sudoku.isColumnValid(5) + "\t|\tExpected true, actual " + sudoku2.isColumnValid(5));
        System.out.println("Column 6: Expected false, actual " + sudoku.isColumnValid(6) + "\t|\tExpected true, actual " + sudoku2.isColumnValid(6));
        System.out.println("Column 7: Expected false, actual " + sudoku.isColumnValid(7) + "\t|\tExpected true, actual " + sudoku2.isColumnValid(7));
        System.out.println("Column 8: Expected false, actual " + sudoku.isColumnValid(8) + "\t|\tExpected true, actual " + sudoku2.isColumnValid(8));

        System.out.println("\t\t\t\t\t|");

        System.out.println("Square 0: Expected true, actual " + sudoku.isSquareValid(0) + "\t|\tExpected true, actual " + sudoku2.isSquareValid(0));
        System.out.println("Square 1: Expected true, actual " + sudoku.isSquareValid(1) + "\t|\tExpected true, actual " + sudoku2.isSquareValid(1));
        System.out.println("Square 2: Expected true, actual " + sudoku.isSquareValid(2) + "\t|\tExpected true, actual " + sudoku2.isSquareValid(2));
        System.out.println("Square 3: Expected false, actual " + sudoku.isSquareValid(3) + "\t|\tExpected true, actual " + sudoku2.isSquareValid(3));
        System.out.println("Square 4: Expected false, actual " + sudoku.isSquareValid(4) + "\t|\tExpected true, actual " + sudoku2.isSquareValid(4));
        System.out.println("Square 5: Expected false, actual " + sudoku.isSquareValid(5) + "\t|\tExpected true, actual " + sudoku2.isSquareValid(5));
        System.out.println("Square 6: Expected true, actual " + sudoku.isSquareValid(6) + "\t|\tExpected true, actual " + sudoku2.isSquareValid(6));
        System.out.println("Square 7: Expected true, actual " + sudoku.isSquareValid(7) + "\t|\tExpected true, actual " + sudoku2.isSquareValid(7));
        System.out.println("Square 8: Expected true, actual " + sudoku.isSquareValid(8) + "\t|\tExpected true, actual " + sudoku2.isSquareValid(8));

        System.out.println("\t\t\t\t\t|");

        System.out.println("Board: Expected false, actual " + sudoku.isBoardValid() + "\t|\tExpected true, actual " + sudoku2.isBoardValid());
    }
}
