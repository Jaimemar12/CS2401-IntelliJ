package Sorting;

//Runtime O(N^2) Nearly Sorted is O(N)
public class InsertionSorting {

    public static void InsertionSort(int [] numbers, int numbersSize) {
        int i = 0;
        int j = 0;
        int temp = 0;  // Temporary variable for swap

        for (i = 1; i < numbersSize; ++i) {
            j = i;
            // Insert numbers[i] into sorted part
            // stopping once numbers[i] in correct position
            while (j > 0 && numbers[j] < numbers[j - 1]) {

                // Swap numbers[j] and numbers[j - 1]
                temp = numbers[j];
                numbers[j] = numbers[j - 1];
                numbers[j - 1] = temp;
                --j;
            }
        }
    }

    public static void main(String[] args) {
        int[] numbers = { 10, 2, 78, 4, 45, 32, 7, 11 };
        int NUMBERS_SIZE = 8;
        int i = 0;

        System.out.print("UNSORTED: ");


        for(i = 0; i < NUMBERS_SIZE; ++i) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();

        InsertionSort(numbers, NUMBERS_SIZE);

        System.out.print("SORTED: ");

        for(i = 0; i < NUMBERS_SIZE; ++i) {
            System.out.print(numbers[i] + " ");
        }
    }


}
