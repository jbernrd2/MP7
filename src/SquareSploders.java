import java.io.File;

public class SquareSploders {

	public static void main(final String[] unused) {
        Zen.create(700, 1000, "stretch");
        int x = 100, y = 900; int[] a = null; Target[] targetArray = new Target[5];

        boolean s1 = true; boolean s2 = true; Laser laser1 = null; Target target = null;
        Laser laser2 = null; Laser laser3 = null; Laser[] laserray = new Laser[5];
        int count = 0; Laser activeLaser = new Laser(); laser1 = activeLaser; int count1 = 0;

        ClassLoader classLoader = SpriteMoveFlipBuffer.class.getClassLoader();
        File spriteFile = new File(classLoader.getResource("sprite1.gif").getFile()); int xj = 5; int yj = 5;

        int j; for (j = 0; j < targetArray.length; j++) {
            targetArray[j] = new Target(xj , yj, 20, 20);
            xj = xj + 40;

        }

        while (Zen.isRunning()) {
            if (s1 == true) {
                target = new Target(350, 100, 20, 20);
                s1 = false;
            }
            for (j = 0; j < targetArray.length; j++) {
                if (targetArray[j] != null) {
                    a = targetArray[j].getHitBox();
                    Zen.fillRect(targetArray[j].getX(), targetArray[j].getY(), a[1] - a[0] - 10, a[3] - a[2] - 10);
                } else {
                    a = null;
                }
            }
            if (y > 0 && Zen.isVirtualKeyPressed(KeyEvent.VK_W)) {
                y = y - 2;
            }
            if (y < Zen.getZenHeight() - 32 && Zen.isVirtualKeyPressed(KeyEvent.VK_S)) {
                y = y + 2;
            }
            if (x > 0 && Zen.isVirtualKeyPressed(KeyEvent.VK_A)) {
                x = x - 2;
            }
            if (x < Zen.getZenWidth() - 32 && Zen.isVirtualKeyPressed(KeyEvent.VK_D)) {
                x = x + 2;
            }
            if (Zen.isVirtualKeyPressed(KeyEvent.VK_SPACE) && s2 == true) {
                laserray[count] = new Laser(x,y);
                count++; s2 = false;
                if (count >= laserray.length) {
                    count = 0;
                }

            }
            if (count1 % 20 == 0) {
                s2 = true;
            }

            int i;
            for (i = 0; i < laserray.length; i++) {
                if (laserray[i] != null) {
                    laserray[i].move();
                    Laser laser = laserray[i]; Zen.fillOval(laser.getX(), laser.getY(), 6, 12);
                    for (j = 0; j < targetArray.length; j++) {
                        if (targetArray[j] != null) {
                            a = targetArray[j].getHitBox();
                            if (laser.getX() >= a[0] && laser.getX() <= a[1] && laser.getY() >= a[2] && laser.getY() <= a[3]) {
                                targetArray[j] = null; a = null;
                            }
                        } else {
                            a = null;
                        }
                    }
                }
            }
            count1++;
            Zen.drawImage(spriteFile.getAbsolutePath(), x, y);
            Zen.flipBuffer();
            Zen.sleep(8);
        }
    }
}
