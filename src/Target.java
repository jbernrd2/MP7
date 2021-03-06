import java.util.Random;

public class Target {
    private int x; private int y; private int hitXmin; private int hitYmin;
    private int hitXmax; private int hitYmax; private int l, h;

    public Target() {
    }
    public Target(int i,int j, int length, int height) {
        this.x = i; this.y = j; this.hitXmin = i - length/2; this.hitYmin = j - height/2;
        this.hitXmax = i + length/2; this.hitYmax = j + height/2; this.l = length; this.h = height;
    }
    public int[] getHitBox() {

        int[] a = new int[4];
        a[0] = this.hitXmin;
        a[1] = this.hitXmax;
        a[2] = this.hitYmin;
        a[3] = this.hitYmax;
        return (a);

    }
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
    public void move(int i, int j) {
        if (this.x + i > 100 && this.x < 600) {
            this.x += i;
            this.hitXmin = this.x - l/2; this.hitXmax = this.x + l/2;
        }
        if (this.y + j > 100 && this.y + j < 900) {
            this.y += j;
            this.hitYmin = this.y - h/2; this.hitYmax = this.y + h/2;
        }
    }
}
