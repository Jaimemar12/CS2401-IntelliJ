package ModPicture;

public class GreenScreen {

    private Pixel[][] foreground;
    private int[][] mask;

    public GreenScreen(Pixel[][] foreground) {
        this.foreground = foreground;
        this.mask = createMask();
    }

    private int[][] createMask() {
        int[][] mask = new int[foreground.length][foreground[0].length];
        createMaskHelper(mask, foreground[0][0], 0, 0);
        return mask;
    }

    /**
     * A method to help debug mask creation. Returns a *new* image with black-and-white Pixels
     * based on the mask values.
     */
    public Pixel[][] getMaskAsImage() {
        // TODO: Write this method.

        return foreground;
    }

    // A recursive helper method for createMask. This method does all of the work.
    private void createMaskHelper(int[][] mask, Pixel reference, int row, int col) {
        // TODO: Write this method.
    }

    /**
     * Creates a *new* image, replacing the background of the foreground image with the input image.
     * The mask must have already been computed to use this method.
     */
    private Pixel[][] replaceBackground(Pixel[][] background) {
        // TODO: Write this method.

        return background;
    }

    public static void main(String[] args) {
        // Uncomment this section when you have completed the createMask/createMaskHelper methods.
      /*Picture fg = new Picture("utep_cs_building_small.jpeg");
      GreenScreen greenScreen = new GreenScreen(fg.getImageMatrix());*/

        // Uncomment this section when you have completed the getMaskAsImage method.
      /*Pixel[][] maskImage = greenScreen.getMaskAsImage();
      Picture maskPicture = new Picture(maskImage);
      maskPicture.save("mask_utep.png");*/

        // Uncomment this section when you have completed the replaceBackground method.
      /*Picture bg1 = new Picture("starrynight.jpg");
      Pixel[][] starryNightUtep = greenScreen.replaceBackground(bg1.getImageMatrix());
      Picture result1 = new Picture(starryNightUtep);
      result1.save("starrynight_utep.png");

      Picture bg2 = new Picture("thisisfine.jpeg");
      Pixel[][] thisIsFineUtep = greenScreen.replaceBackground(bg2.getImageMatrix());
      Picture result2 = new Picture(thisIsFineUtep);
      result2.save("thisisfine_utep.png");*/
    }
}