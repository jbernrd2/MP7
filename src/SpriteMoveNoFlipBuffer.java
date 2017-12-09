import java.io.File;

import edu.illinois.cs.cs125.lib.zen.Zen;

/**
 * Example program written using Zen Graphics.
 *
 * @see <a href="https://github.com/cs125-illinois/Zen">Zen on GitHub</a>
 * @see <a href="https://cs125-illinois.github.io/Zen/">Zen Documentation</a>
 * @see <a href="https://cs125.cs.illinois.edu/lab/1/#zen">Lab 1 Writeup</a>
 */
public class SpriteMoveNoFlipBuffer {

    /**
     * This example shows what happens if we don't use buffer swapping.
     *
     * Because the buffer is never cleared, all images drawn on it stay on the screen forever.
     *
     * @param unused unused input parameters
     */
    public static void main(final String[] unused) {
        /*
         * The X coordinate of the image that we are going to draw.
         */
        int x = 100;

        /*
         * Get the path to our sprite image.
         */
        ClassLoader classLoader = SpriteMoveFlipBuffer.class.getClassLoader();
        File spriteFile = new File(classLoader.getResource("sprite1.gif").getFile());

        /*
         * This loop will run until the user exits the program.
         */
        while (Zen.isRunning()) {
            Zen.drawImage(spriteFile.getAbsolutePath(), x, 200);
            Zen.sleep(50);
            x = x + 5;
            /*
             * Don't flip buffers here, so all images will always be shown.
             */
        }
    }
}
