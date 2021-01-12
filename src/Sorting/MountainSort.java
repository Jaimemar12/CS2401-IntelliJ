package Sorting;

public class MountainSort {

    // Performs an in-place Mountain Sort on a.
    public static void sort(int[] a) {

        int maxIndex = 0;

        for(int i = 0; i < a.length; i++) {
            if(a[i] > a[maxIndex]) {
                maxIndex = i;
            }


        }

        if(maxIndex != 0) {
            sortAscending(a, maxIndex);
        }
        if(maxIndex != a.length-1) {
            sortDecending(a, maxIndex);
        }
    }

    //selection sort
    public static void sortAscending(int[] a, int maxIndex) {
        int temp = 0;  // Temporary variable for swap

        for (int i = 0; i < maxIndex; ++i) {

            int max = 0;
            for(int j = 0; j < maxIndex - i; j++) {
                if(a[j] > a[max]) {
                    max = j;
                }
            }

            swap(a, max, maxIndex-1-i);
        }
    }

    //bubble sort
    public static void sortDecending(int[] a, int maxIndex) {


        int endIndex = a.length -1;
        Boolean swap = true;

        while(endIndex >=2 && swap) {
            swap = bubbling(a, maxIndex, endIndex);
            endIndex--;
        }
    }

    public static Boolean bubbling(int[] a, int maxIndex, int end) {

        int aux;
        Boolean swap = false;

        for(int i = maxIndex; i < end; i++){

            if(a[i] < a[i+1]){

                swap = true;
                swap(a, i, i+1);
            }
        }
        return swap;
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {

        // Show us that your Mountain Sort works.
        int[] numbers = {6, 1, -5, 4, 37, 2, 9, 19, 5, 13, 18, 14};
        int NUMBERS_SIZE = numbers.length;
        int i = 0;

        System.out.print("UNSORTED: ");

        for(i = 0; i < NUMBERS_SIZE; ++i) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();

        sort(numbers);

        System.out.print("SORTED: ");

        for(i = 0; i < NUMBERS_SIZE; ++i) {
            System.out.print(numbers[i] + " ");
        }
    }
    //4, 6, 13, 18, 37, 19, 14, 9, 5, 2, 1, -5
}
