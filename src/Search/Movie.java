package Search;

public class Movie {

    private String name;
    private int numberInSeries;
    private int runtime;

    public Movie(int index) {
        this.numberInSeries = index;
        this.name = "Fast and Furious " + index;
        this.runtime = (int) (Math.random() * 50) + 80;
    }

    public String getName() {
        return name;
    }

    public int getNumberInSeries() {
        return numberInSeries;
    }

    public int getRuntime() {
        return runtime;
    }

    public String toString() {
        return name;
    }
}