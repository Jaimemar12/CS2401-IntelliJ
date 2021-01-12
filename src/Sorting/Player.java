package Sorting;

public class Player {

    private String name;
    private String team;
    private int number;

    public Player(String name, String team, int number) {
        this.name = name;
        this.team = team;

        if (number < 0) {
            this.number = 0;
        } else if (number > 55) {
            this.number = 55;
        } else {
            this.number = number;
        }
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public int getNumber() {
        return number;
    }

    public String toString() {
        return name + " - " + team + " (" + number + ")";
    }
}
