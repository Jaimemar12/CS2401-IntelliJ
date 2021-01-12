package ModPicture;

public class Blur {

    // Returns a *new* image, a blurred version of the input image.
    public static Pixel[][] blur(Pixel[][] image) {
        // TODO: Write this method.

        Pixel[][] result = new Pixel[image.length][image[0].length];
        for(int i = 0; i < image.length; i++) {
            for(int j = 0; j < image[i].length; j++) {
                int sumRed = 0;
                int sumBlue = 0;
                int sumGreen = 0;

                Pixel currentPixel = image[i][j];
                sumRed += currentPixel.getR();

                if(j > 0) {
                    Pixel leftNeighbor = image[i][j-1];
                    sumRed += leftNeighbor.getR();
                    //finish for blue and green
                }

                if(j < 0) {
                    Pixel rightNeighbor = image[i][j+1];
                    sumRed += rightNeighbor.getR();
                }

                if(i > 0) {
                    Pixel upNeighbor = image[i-1][j];
                    sumRed += upNeighbor.getR();
                }

                if(i < 0) {
                    Pixel downNeighbor = image[i+1][j];
                    sumRed += downNeighbor.getR();
                }



                //same thing for up, down, right neightbors

                Pixel averagePixel = new Pixel(sumRed/5, sumGreen/5, sumBlue/5);
                result[i][j] = averagePixel;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Picture pic = new Picture("utep_cs_building_small.jpeg");
        Pixel[][] original = pic.getImageMatrix();
        Pixel[][] blurred = blur(original);
        Picture result = new Picture(blurred);
        result.save("utep_cs_blur.png");
    }
}