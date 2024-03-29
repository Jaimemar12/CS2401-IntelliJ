package Sorting;

//Runtime O(N log N)
//Memory O(N)
public class MergeSorting {

    public static void Merge(int []numbers, int i, int j, int k) {
        int  mergedSize = k - i + 1;                // Size of merged partition
        int mergePos = 0;                          // Position to insert merged number
        int leftPos = 0;                           // Position of elements in left partition
        int rightPos = 0;                          // Position of elements in right partition
        int[] mergedNumbers = new int[mergedSize];   // Dynamically allocates temporary array
        // for merged numbers

        leftPos = i;                           // Initialize left partition position
        rightPos = j + 1;                      // Initialize right partition position

        // Add smallest element from left or right partition to merged numbers
        while (leftPos <= j && rightPos <= k) {
            if (numbers[leftPos] <= numbers[rightPos]) {
                mergedNumbers[mergePos] = numbers[leftPos];
                ++leftPos;
            }
            else {
                mergedNumbers[mergePos] = numbers[rightPos];
                ++rightPos;

            }
            ++mergePos;
        }

        // If left partition is not empty, add remaining elements to merged numbers
        while (leftPos <= j) {
            mergedNumbers[mergePos] = numbers[leftPos];
            ++leftPos;
            ++mergePos;
        }

        // If right partition is not empty, add remaining elements to merged numbers
        while (rightPos <= k) {
            mergedNumbers[mergePos] = numbers[rightPos];
            ++rightPos;
            ++mergePos;
        }

        // Copy merge number back to numbers
        for (mergePos = 0; mergePos < mergedSize; ++mergePos) {
            numbers[i + mergePos] = mergedNumbers[mergePos];
        }
    }

    public static void MergeSort(int []numbers, int i, int k) {
        int j = 0;

        if (i < k) {
            j = (i + k) / 2;  // Find the midpoint in the partition

            // Recursively sort left and right partitions
            MergeSort(numbers, i, j);
            MergeSort(numbers, j + 1, k);

            // Merge left and right partition in sorted order
            Merge(numbers, i, j, k);
        }
    }

    public static void main(String[] args) {
        int [] numbers = { 10, 2, 78, 4, 45, 32, 7, 11 };
        int NUMBERS_SIZE = 8;
        int i = 0;

        System.out.print("UNSORTED: ");
        for(i = 0; i < NUMBERS_SIZE; ++i) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();

        MergeSort(numbers, 0, NUMBERS_SIZE - 1);

        System.out.print("SORTED: ");
        for(i = 0; i < NUMBERS_SIZE; ++i) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
    }
}
