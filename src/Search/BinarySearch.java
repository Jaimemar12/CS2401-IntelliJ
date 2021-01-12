package Search;

public class BinarySearch {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] A = {2, 5, 9, 1, 3, 4, 10};
        System.out.println(search(A, 0, A.length-1, 2));
    }

    public static int search(int arr[], int start, int end, int x) {
        // TODO Auto-generated method stub
        if (end < start) {
            int mid = start + (end - start) / 2;

            // If the element is present at the
            // middle itself
            if (arr[mid] == x)
                return mid;

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr[mid] > x)
                return search(arr, start, mid - 1, x);

            // Else the element can only be present
            // in right subarray
            return search(arr, mid + 1, end, x);
        }

        // We reach here when element is not present
        // in array
        return -1;
    }
}