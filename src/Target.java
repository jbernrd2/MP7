
public class Target {
	
	private int x; private int y; private int hitXmin; private int hitYmin;
    private int hitXmax; private int hitYmax;

    public Target() {
    }
    public Target(int i,int j, int length, int height) {
        this.x = i; this.y = j; this.hitXmin = i - length/2; this.hitYmin = j - length/2;
        this.hitXmax = i + length/2; this.hitYmax = j + length/2;
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

}
