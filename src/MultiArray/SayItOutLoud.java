package MultiArray;

import java.util.Scanner;

public class SayItOutLoud {


    /*
     * 1
     * 11
     * 21
     * 1211
     * 111221
     * 312211
     * 13112221
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(80630922%10000);
        System.out.print("Enter a value for the sequence: ");
        int limit = sc.nextInt();

        for(int i = 1; i < limit+1; i++) {
            System.out.print(sayItOutLoud(i) + ", ");
            //System.out.print("\t" + sayItOutLoud2(i));
        }

    }

    public static String sayItOutLoud(int limit) {

        StringBuilder word = new StringBuilder();


        if (limit<=0) {
            return "Nothing was returned";
        }

        String result = "32"; //initialized as 1


        for(int i = 1; i < limit; i++) {

            int counter = 1;

            for (int j = 1; j < result.length(); j++) {

                if(result.charAt(j) == result.charAt(j-1)) { //if the letter matches with its previous it will increase the counter
                    counter++;
                } else { //if the letters don't match it will create a word that has the number of times the symbol was counted and the previous symbol
                    word.append(counter);
                    word.append(result.charAt(j-1));
                    counter = 1; //resets the counter
                }
            }
            word.append(counter); //it will create the word with previous symbols and number of times for the symbols
            word.append(result.charAt(result.length()-1)); //it will also add the previous symbol
            result = word.toString(); //it will be stored in result

            word.setLength(0); //clearinng its values
        }

        return result;
    }

    public static String sayItOutLoud2(int limit) {

        StringBuilder word = new StringBuilder();


        if (limit<=0) {
            return "Nothing was returned";
        }

        String result = "2"; //initialized as 1


        for(int i = 1; i < limit; i++) {

            int counter = 1;

            for (int j = 1; j < result.length(); j++) {

                if(result.charAt(j) == result.charAt(j-1)) { //if the letter matches with its previous it will increase the counter
                    counter++;
                } else { //if the letters don't match it will create a word that has the number of times the symbol was counted and the previous symbol
                    word.append(counter);
                    word.append(result.charAt(j-1));
                    counter = 1; //resets the counter
                }
            }
            word.append(counter); //it will create the word with previous symbols and number of times for the symbols
            word.append(result.charAt(result.length()-1)); //it will also add the previous symbol
            result = word.toString(); //it will be stored in result

            word.setLength(0); //clearinng its values
        }

        return result;
    }

}