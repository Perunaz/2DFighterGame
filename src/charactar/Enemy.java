package charactar;

import location.Coordinate;

public class Enemy implements Character{
    private Coordinate coordinate;

    public Enemy(int locationX, int locationY) {
        this.coordinate = new Coordinate(locationX, locationY);
    }

    @Override
    public int getLocationX() {
        return coordinate.getX();
    }

    @Override
    public int getLocationY() {
        return coordinate.getY();
    }

    @Override
    public Coordinate getCoordinate() {
        return this.coordinate;
    }

    @Override
    public void setLocationX(int locationX) {
        this.coordinate.setX(locationX);
    }

    @Override
    public void setLocationY(int locationY) {
        this.coordinate.setY(locationY);
    }
}
