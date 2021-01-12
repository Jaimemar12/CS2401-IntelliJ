package Sorting;

import java.util.LinkedList;

public class BucketSort {

    public static LinkedList<Player> bucketSort(Player[] players) {
        //addAll not append
        LinkedList<Player>[] buckets = new LinkedList[56];
        for(int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<Player>();
        }

        for(int j = 0; j < players.length; j++) {
            buckets[players[j].getNumber()].add(players[j]);
        }

        LinkedList<Player> result = new LinkedList<Player>();
        for(int k = 0; k < buckets.length; k++) {
            result.addAll(buckets[k]);
        }

        return result;
    }

    public static void removeMonstars(LinkedList<Player> players) {

        //the counter will keep track of the original list size minus the Monstars removed to not get out of bounds
        int counter = players.size();
        for(int i = 0; i < players.size(); i++) {

            while(i < counter) {

                if(players.get(i).getTeam().equals("Monstars")) {
                    players.remove(i);
                    counter--;

                }else {
                    break;
                }
            }
        }
    }


    public static Player getRandomPlayer() {
        String[] firstNames = {
                "Shooter", "Dash", "Sporty", "\'The Beast\'", "Michael-Jordan", "Lola", "Airbud", "[NOFIRSTNAME]", "Danielle", "Daniel"};

        String[] lastNames = {
                "Hooper", "Basketball", "Swisher", "Longarms", "Longlegs", "Thoreau", "Pointz", "[NOLASTNAME]", "McSports", "#1"};

        String[] teamNames = {
                "Miners", "Androids", "Objects", "Base Cases", "Monstars", "Tune Squad"};

        return new Player(
                firstNames[(int) (Math.random() * firstNames.length)] + " " + lastNames[(int) (Math.random() * lastNames.length)],
                teamNames[(int) (Math.random() * teamNames.length)],
                (int) (Math.random() * 56));
    }

    public static void main(String[] args) {
        // You can use this array of random players, or make your own.
        Player[] players = new Player[200];


        for (int i = 0; i < players.length; i++) {
            players[i] = getRandomPlayer();
        }

        // Show us that it works -- sort the array, remove the Monstars, and print the result.
        // ...
        System.out.print("UNSORTED: ");

        for(int i = 0; i < players.length; i++) {
            System.out.print(players[i].getNumber() + " ");
        }

        System.out.print("\nSORTED:\t  ");

        LinkedList<Player> sorted = bucketSort(players);
        for(int i = 0; i < sorted.size(); i++) {
            System.out.print(sorted.get(i).getNumber() + " ");
        }

        System.out.print("\n\nBefore: ");

        for(int i = 0; i < sorted.size(); i++) {
            System.out.print(sorted.get(i).getTeam() + " ");
        }

        removeMonstars(sorted);

        System.out.print("\nAfter: ");

        for(int i = 0; i < sorted.size(); i++) {
            System.out.print(sorted.get(i).getTeam() + " ");
        }
    }
}