package PictureMod;

public class ImageTransformations {

    /**
     * Returns a grayscale version of originalImage as a 2D Pixel array..
     */
    public static Pixel[][] convertToGrayscale(Pixel[][] originalImage) {
        Pixel[][] grayImage = new Pixel[originalImage.length][originalImage[0].length];

        for(int i = 0; i < originalImage.length; i++){
            for(int j = 0; j < originalImage[i].length; j++){
                Pixel p = originalImage[i][j];
                int b = p.getBrightness();

                Pixel grayPixel = new Pixel(b, b, b);
                grayImage[i][j] = grayPixel;
            }
        }

        return grayImage;
    }

    /**
     * Returns a vertically-mirrored version of originalImage as a new 2D Pixel array.
     *
     * For the columns it traverses right to left so now the newImageMirror from right to left gets originalImage from left to right
     */
    public static Pixel[][] mirrorVertically(Pixel[][] originalImage) {
        Pixel[][] newImageMirror = new Pixel[originalImage.length][originalImage[0].length];
        int counter = 0;

        for(int i = 0; i < newImageMirror.length; i++){ //rows
            for(int j = newImageMirror[i].length -1; j >= 0; j--){ //columns
                newImageMirror[i][j] = originalImage[i][counter++];
            }
            counter = 0;
        }

        return newImageMirror;
    }

    /**
     * Returns a clockwise-rotated version of originalImage as a new 2D Pixel array.
     *
     * It traverses the column size of the originalImage as the row size of the newImageRotated and the row size of the originalImage as the column size of the newImageRotated because newImageRotated now is different size than the originalImage.
     * In the nested loop newImageRotated gets the rows of the originalImage as its columns and the columns of the originalImage as its rows.
     */
    public static Pixel[][] rotateClockwise(Pixel[][] originalImage) {
        Pixel[][] newImageRotated = new Pixel[originalImage[0].length][originalImage.length];
        int counter = 0;

        for(int i=0; i < originalImage[0].length; i++){ //columns
            for(int j = originalImage.length-1; j>=0; j--){ //rows
                newImageRotated[i][j] = originalImage[counter++][i];
            }
            counter = 0;
        }

        return newImageRotated;
    }

    public static void main(String[] args) {
        // Read miners.png into a 2D Pixel array.
        Picture picture = new Picture("miners.png");
        Pixel[][] originalImage = picture.getImageMatrix();
        Pixel[][] fixedPicture = rotateClockwise(mirrorVertically(convertToGrayscale(originalImage)));

        // TODO: Fix the image by using your convertToGrayscale, mirrorVertically, and
        // rotateClcokwise methods.

        // TODO: To save your image, uncomment the lines below and add your Pixel array as the
        // argument to the Picture constructor.
        Picture result = new Picture(fixedPicture);
        result.save("miners_fixed.png");
    }
}