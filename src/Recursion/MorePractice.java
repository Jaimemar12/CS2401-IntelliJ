package Recursion;

public class MorePractice {

    public static void main(String[] args) {
        System.out.println(canMakeChange(65, 3, 3, 2));
        printSpecialSequences(4);
    }

    public static boolean canMakeChange(int amount, int numGoogles, int numAndroids, int numBetas) {

        //BASE CASES
        if(amount == 0) {
            return true;
        }

        if(amount < 0) {
            return false;
        }

        if(numAndroids < 0 || numGoogles < 0 || numBetas < 0) {
            return false;
        }

        //RECURSION CASE
        return canMakeChange(amount - 14, numGoogles - 1, numAndroids, numBetas) ||
                canMakeChange(amount - 9, numGoogles, numAndroids - 1, numBetas) ||
                canMakeChange(amount - 5, numGoogles, numAndroids, numBetas - 1);
    }

    public static void printSpecialSequences(int length) {
        helper(length, "");
    }

    public static void helper(int length, String word) {

        //BASE CASE
        if(word.length() == length) {
            System.out.println(word);
        }

        //RECURSION CASE
        if(word.length() == 0) {
            helper(length, word + "L");
            helper(length, word + "R");
        }else {
            helper(length, word + "R");
            if(word.charAt(word.length() - 1)  != 'L') {
                helper(length, word + "L");
            }
        }
    }
}
