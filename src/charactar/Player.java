package charactar;

import canvas.CanvasCreator;
import location.Coordinate;

public class Player implements Character {
    private Coordinate coordinate;

    public Player(int locationX, int locationY, CanvasCreator canvasCreator) {
        this.coordinate = new Coordinate(locationX, locationY);

        canvasCreator.getCharacterChecker().put(this.coordinate.getID(), true);
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
