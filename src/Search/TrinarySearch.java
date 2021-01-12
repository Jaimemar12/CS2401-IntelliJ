package Search;

import java.util.Random;

public class TrinarySearch {

    // This method should be only one line -- returning the value of a call to trinarySearchHelper.
    // You may not add any additional parameters to this method.
    public static int trinarySearch(Movie[] movies, int movieNumber) {
        return trinarySearchHelper(movies, movieNumber);

    }


    public static int trinarySearchHelper(Movie[] movies, int movieNumber) {
        int start = 0;
        int end = movies.length-1;

        while (end >= start) {

            int s = (end - start) / 3;
            int mid1 = start + s;
            //int mid2 = end - s / 3;
            int mid2 = end - s;

            if(movies[mid1].getNumberInSeries() == movieNumber) {
                return mid1;
            }else if(movies[mid2].getNumberInSeries() == movieNumber) {
                return mid2;
            }

            if(movieNumber < movies[mid1].getNumberInSeries()) {
                end = mid1 - 1;
            }else if(movieNumber > movies[mid2].getNumberInSeries()) {
                start = mid2 + 1;
            }else {
                end = mid2 - 1;
                start = mid1 + 1;
            }
        }


        return -1;

    }

    private static Movie[] getRandomSortedMovieArray(int length) {
        Movie[] movies = new Movie[50];

        int seriesNumber = 0;
        for (int i = 0; i < length; i++) {
            seriesNumber++;
            if (Math.random() > .8) {
                seriesNumber++;
            }

            movies[i] = new Movie(seriesNumber);
        }

        return movies;
    }

    public static void main(String[] args) {
        Movie[] movies = getRandomSortedMovieArray(50);

        System.out.println("Our collection: ");
        for (int i = 0; i < movies.length; i++) {
            System.out.println(movies[i]);
        }

        // You can search for different Fast and Furious titles here.
        System.out.println();
        Random num = new Random();
        for(int i = 0; i < 10; i++) {
            int key = num.nextInt(59) + 1;
            System.out.print("Searching for Fast and Furious " + key + "\t");
            int index = trinarySearch(movies, key);

            if(index != -1) {
                System.out.println("Results: " + key + " was found at index " + index);
            }else {
                System.out.println("Results: " + key + " was not found");
            }
        }
    }
}