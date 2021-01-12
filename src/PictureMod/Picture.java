package PictureMod;

/**
 * RGB channel conversions referenced from:
 * https://dyclassroom.com/image-processing-project/how-to-get-and-set-pixel-value-in-java
 */

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Picture {

    BufferedImage myBufferedImage;
    private Pixel[][] myImageMatrix;

    /**
     * Creates a Picture object from an image filename.
     */
    public Picture(String filename) {
        try {
            File infile = new File(filename);
            myBufferedImage = ImageIO.read(ImageTransformations.class.getResource("/images/miners.png"));
        } catch(IOException e) {
            System.out.println(e);
        }

        int numRows = myBufferedImage.getHeight();
        int numCols = myBufferedImage.getWidth();
        myImageMatrix = new Pixel[numRows][numCols];
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                int rgb = myBufferedImage.getRGB(col, row);
                int r = (rgb>>16) & 0xff;
                int g = (rgb>>8) & 0xff;
                int b = rgb & 0xff;
                myImageMatrix[row][col] = new Pixel(r, g, b);
            }
        }
    }

    /**
     * Creates a Picture object from a Pixel-matrix representation of an image.
     */
    public Picture(Pixel[][] imageMatrix) {
        myImageMatrix = imageMatrix;
        myBufferedImage = new BufferedImage(myImageMatrix[0].length, myImageMatrix.length, 5);
    }

    /**
     * Returns the Pixel-matrix representation of the Picture.
     */
    public Pixel[][] getImageMatrix() {
        return myImageMatrix;
    }

    /**
     * Saves the Picture as a .png file at the specified filename.
     */
    public void save(String filename) {
        for (int row = 0; row < myBufferedImage.getHeight(); row++) {
            for (int col = 0; col < myBufferedImage.getWidth(); col++) {
                int alpha = (myBufferedImage.getRGB(col, row)>>24) & 0xff;
                Pixel pixel = myImageMatrix[row][col];
                int rgb = (alpha<<24) | (pixel.getR()<<16) | (pixel.getG()<<8) | pixel.getB();
                myBufferedImage.setRGB(col, row, rgb);
            }
        }

        try {
            File outfile = new File(filename);
            ImageIO.write(myBufferedImage, "png", outfile);
        } catch(IOException e) {
            System.out.println(e);
        }
    }
}