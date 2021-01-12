package Recursion;

public class Recursive {
    public static void recursive1(int x) {
        if (x == 1) {
            // BASE CASE
            System.out.println("Cadabra");
        } else {
            // RECURSIVE CASE
            System.out.println("Abra");
            recursive1(x / 2);
        }
    }

    public static int recursive2(int number, int power) {
        if (power == 1) {
            // BASE CASE
            return number;
        } else {
            // RECURSIVE CASE -- your code here
            return number * recursive2(number, power-1);
        }
    }

    public static int recursive3(int number) {
        //BASE CASE
        if (number == 0) {
            return 0;
        }

        //RECURSIVE CASE
        int digit = number % 10;
        if (digit == 3) {
            return 1 + recursive3(number / 10);
        }

        return recursive3(number / 10);
    }

    public static void main(String[] args) {
        recursive1(8);

        System.out.println(recursive2(3, 4));

        System.out.println(recursive3(837533));
    }
}