package location;

public class Coordinate {
    private int x;
    private int y;
    private String ID;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;

        StringBuilder sb = new StringBuilder();
        sb.append(x);
        sb.append(y);

        this.ID = sb.toString();
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getID() {
        return ID;
    }
}
