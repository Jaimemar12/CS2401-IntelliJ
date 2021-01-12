package PictureMod;

public class Pixel {

    private int myR, myG, myB;

    /**
     * Constructs a pixels with the specified rgb values.
     */
    public Pixel(int r, int g, int b) {
        setR(r);
        setG(g);
        setB(b);
    }


    // Accessor Methods
    public int getR() {
        return myR;
    }

    public int getG() {
        return myG;
    }

    public int getB() {
        return myB;
    }


    // Mutator Methods
    public void setR(int r) {
        myR = clampColorValue(r);
    }

    public void setG(int g) {
        myG = clampColorValue(g);
    }

    public void setB(int b) {
        myB = clampColorValue(b);
    }

    // Computes the brightness (grayscale value) of a Pixel;
    public int getBrightness() {
        return (myR + myG + myB) / 3;
    }

    /**
     * Clamps the input value to the range [0, 255].
     */
    private static int clampColorValue(int val) {
        return Math.min(255, Math.max(0, val));
    }
}