package MultiArray;

public class Arrays {
    public static void main(String[] args) {
        generateMysterySequence(11); //1, 3, 7, 12, 18, 26, 35, 45, 56, 69, 83.
        int lockers[][] = lockersStatus(10);
        System.out.println();
        for(int i = 0; i < lockers.length; i++) {
            for(int j = 0; j < lockers[i].length; j++) {
                System.out.print(lockers[i][j]);
                if(j < lockers[i].length-1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }

        /**
         * 	0, 0, 0, 0, 0, 0, 0, 0, 0, 0
         0, 1, 0, 1, 0, 1, 0, 1, 0, 1
         0, 1, 1, 1, 0, 0, 0, 1, 1, 1
         0, 1, 1, 0, 0, 0, 0, 0, 1, 1
         0, 1, 1, 0, 1, 0, 0, 0, 1, 0
         0, 1, 1, 0, 1, 1, 0, 0, 1, 0
         0, 1, 1, 0, 1, 1, 1, 0, 1, 0
         0, 1, 1, 0, 1, 1, 1, 1, 1, 0
         0, 1, 1, 0, 1, 1, 1, 1, 0, 0
         */

    }

    /**
     * This Method generates the Mystery Sequence
     * that consist of adding R(n-1) + S(n-1) to get R(n)
     * Where n > 1 and S is increasing one by one not having any
     * number that has been already in R(n)
     * R(n) will be represented as sequence[]
     * @param n - amount of numbers of the sequence
     */
    public static void generateMysterySequence(int n) {
        int sequence[] = new int[n];
        sequence[0] = 1; //the first number of the array is 1
        int s = 2; //the initial value of s is 2

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < sequence.length; j++) {
                if(sequence[j] == s) {
                    s++; //if the value of s is found in the array of sequence it will increase
                }
            }

            sequence[i] = sequence[i-1] + s; //sequence[i] will become the previous value, sequence[i-1], + the value of s
            s++; //at the end s will increase by 1
            System.out.print(sequence[i-1] + ", "); //the sequence will be printed here
        }

        System.out.println(sequence[n-1] + "."); //since the previous loop ends before the last element can be printed I added this element

    }

    public static int[][] lockersStatus(int n) {
        int[][] lockers = new int[n-1][n];
        int counter = 2;

        for(int i = 1; i < lockers.length; i++) { //starts at 1 since lockers[0] is all zeros

            for(int k = 0; k < lockers[i].length; k++) {
                lockers[i][k] = lockers[i-1][k]; //this for look copies previous row to new row
            }

            for(int j = i; j < lockers[i].length; j += counter) { //j will increase the number of counter
                if(lockers[i-1][j] == 0) {
                    lockers[i][j] = 1; //if the previous row with j column had a 0 it will become a 1
                }else {
                    lockers[i][j] = 0; //if it had a 1 it will become a 0
                }
            }
            counter++; //counter will increase after a row representing the third, fourth, fifth locker etc
        }

        return lockers;
    }
}