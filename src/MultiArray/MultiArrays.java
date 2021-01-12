package MultiArray;

public class MultiArrays
{
    public static void main(String[] args){
        // your code goes below:
        int[][] table = new int[3][];
        for(int i = 0; i < 3; i++) {
            table[i] = simpleArray(5);

        }
        print(table);
        System.out.println();
        element(table, 2, 4);
        System.out.println();
        address(table, 1);
        System.out.println();
        column(table, 0);
        System.out.println("\n" + diagonal(table));
    }

    public static int[] simpleArray(int n) {
        int[] result = new int[n];
        for (int i=0; i<n; i++) {
            result[i] = i+1;
        }
        return result;
    }

    public static void print(int[] row) {

        try {
            for (int i=0; i<row.length; i++)
                System.out.print(row[i] + " ");
            System.out.println();
        }catch (NullPointerException e) {
            System.out.println("There are no elements in this row");
        }

    }

    public static void print(int[][] table) {

        try {
            for(int i = 0; i < table.length; i++){ //rows
                for(int j = 0; j < table[i].length; j++){ //columns
                    System.out.print(table[i][j] + " ");
                }
                System.out.println("");
            }
        }catch (NullPointerException e) {
            System.out.println("There are no elements in this 2D Array");
        }

    }

    public static void element(int[][] table,  int row, int column) {
        // your code goes below:
        try {
            System.out.println("Row: " + row + ", Column: " + column + " = " + table[row][column]);
        }catch(ArrayIndexOutOfBoundsException a) {
            if(row > table.length - 1) {
                System.out.println("Index of row is out of bounce");
            }else {
                System.out.println("Index of column is out of bounce");
            }
        }catch(NullPointerException e) {
            System.out.println("There are no elements in this indeces");
        }
    }

    public static void address(int[][] table,  int row) {
        // your code goes below:
        try {
            System.out.println(table[row]);
        }catch(ArrayIndexOutOfBoundsException a){
            System.out.println("Index of row is out of bounce");
        }

    }

    public static void column(int[][] table,  int column) {
        // your code goes below:
        try {
            for(int i = 0; i < table.length; i++) {
                System.out.println(table[i][column]);
            }
        }catch(NullPointerException e) {
            System.out.println("There are no elements in this column");
        }catch(ArrayIndexOutOfBoundsException a) {
            System.out.println("Index of column is out of bounce");
        }

    }

    public static int diagonal(int[][] table) {
        // your code goes below:
        int diagSum = 0;
        try {
            for (int i = 0; i < table.length; i++) {
                diagSum += table[i][i];
            }
            return diagSum;
        }catch (NullPointerException e) {
            System.out.println("There are no elements in this 2D Array");
            return -1; //which symbolizes an error
        }
    }
}