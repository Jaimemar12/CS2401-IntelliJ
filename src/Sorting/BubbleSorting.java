package Sorting;

//Runtime O(N^2)
public class BubbleSorting {

    public static void BubbleSort(int [] numbers, int numbersSize) {

        for (int i = 0; i < numbersSize - 1; i++) {

            for (int j = 0; j < numbersSize - i - 1; j++) {

                if (numbers[j] > numbers[j+1]) {

                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] numbers = { 10, 2, 78, 4, 45, 32, 7};
        int NUMBERS_SIZE = 8;
        int i = 0;

        System.out.print("UNSORTED: ");


        for(i = 0; i < NUMBERS_SIZE; ++i) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();

        BubbleSort(numbers, NUMBERS_SIZE);

        System.out.print("SORTED: ");

        for(i = 0; i < NUMBERS_SIZE; ++i) {
            System.out.print(numbers[i] + " ");
        }
    }
}
