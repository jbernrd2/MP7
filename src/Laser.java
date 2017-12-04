
public class Laser {
	
	private int x; private int y; public int v = -10;

    public Laser() {
    }
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
    public void setXY(int i, int j) {
        this.x = i; this.y = j;
    }
    public void move() {
        this.y = this.y + v;
    }
    public Laser(int i, int j) {
        new Laser();
        this.setXY(i, j);
    }
}
