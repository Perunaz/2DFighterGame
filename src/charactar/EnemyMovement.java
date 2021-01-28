package charactar;

import canvas.CanvasCreator;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import location.Coordinate;

public class EnemyMovement {

    private Player player;
    private Enemy enemy;
    private CanvasCreator canvasCreator;
    private GraphicsContext graphicsContext;

    public EnemyMovement(Player player, Enemy enemy, CanvasCreator canvasCreator, GraphicsContext graphicsContext) {
        this.player = player;
        this.enemy = enemy;
        this.canvasCreator = canvasCreator;
        this.graphicsContext = graphicsContext;
    }

    public void movement() {
        int distanceX = 0;
        int distanceY = 0;
        String idOfNextCoordinate;
        String idCurrentLocation = enemy.getCoordinate().getID();

        if (player.getLocationX() < enemy.getLocationX()) {
            distanceX = enemy.getLocationX() - player.getLocationX();
        } else if (player.getLocationX() > enemy.getLocationX()) {
            distanceX = player.getLocationX() - enemy.getLocationX();
        } else {
            distanceX = 0;
        }

        if (player.getLocationY() < enemy.getLocationY()) {
            distanceY = enemy.getLocationY() - player.getLocationY();
        } else if (player.getLocationY() > enemy.getLocationY()) {
            distanceY = player.getLocationY() - enemy.getLocationY();
        } else {
            distanceY = 0;
        }

        if (distanceX <= distanceY && player.getLocationY() <= enemy.getLocationY()) {
            idOfNextCoordinate = new Coordinate(enemy.getLocationX(), enemy.getLocationY() - 1).getID();

            if (enemy.getLocationY() > 0 && !canvasCreator.getCharacterChecker().get(idOfNextCoordinate)) {
                this.canvasCreator.getCharacterChecker().put(idCurrentLocation, false);
                enemy.setLocationY(enemy.getLocationY() - 1);
                this.canvasCreator.getCharacterChecker().put(enemy.getCoordinate().getID(), true);
            }
        } else if (distanceX <= distanceY && player.getLocationY() >= enemy.getLocationY()) {
            idOfNextCoordinate = new Coordinate(enemy.getLocationX(), enemy.getLocationY() + 1).getID();

            if (enemy.getLocationY() < canvasCreator.getHeight() - 1 && !canvasCreator.getCharacterChecker().get(idOfNextCoordinate)) {
                this.canvasCreator.getCharacterChecker().put(idCurrentLocation, false);
                enemy.setLocationY(enemy.getLocationY() + 1);
                this.canvasCreator.getCharacterChecker().put(enemy.getCoordinate().getID(), true);
            }
        } else if (distanceX >= distanceY && player.getLocationX() <= enemy.getLocationX()) {
            idOfNextCoordinate = new Coordinate(enemy.getLocationX() - 1, enemy.getLocationY()).getID();

            if (enemy.getLocationX() > 0 && !canvasCreator.getCharacterChecker().get(idOfNextCoordinate)) {
                this.canvasCreator.getCharacterChecker().put(idCurrentLocation, false);
                enemy.setLocationX(enemy.getLocationX() - 1);
                this.canvasCreator.getCharacterChecker().put(enemy.getCoordinate().getID(), true);
            }
        } else if (distanceX >= distanceY && player.getLocationX() >= enemy.getLocationX()) {
            idOfNextCoordinate = new Coordinate(enemy.getLocationX() + 1, enemy.getLocationY()).getID();

            if (enemy.getLocationX() < canvasCreator.getWidth() - 1 && !canvasCreator.getCharacterChecker().get(idOfNextCoordinate)) {
                this.canvasCreator.getCharacterChecker().put(idCurrentLocation, false);
                enemy.setLocationX(enemy.getLocationX() + 1);
                this.canvasCreator.getCharacterChecker().put(enemy.getCoordinate().getID(), true);
            }
        }

        graphicsContext.setFill(Color.RED);
        graphicsContext.fillRect(enemy.getLocationX() * canvasCreator.getCornersize(), enemy.getLocationY() * canvasCreator.getCornersize(), canvasCreator.getCornersize() - 1, canvasCreator.getCornersize() - 1);
    }
}
