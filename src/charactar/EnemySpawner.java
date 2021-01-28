package charactar;

import canvas.CanvasCreator;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import location.Coordinate;

import java.util.ArrayList;
import java.util.Random;

public class EnemySpawner {
    private CanvasCreator canvasCreator;
    private GraphicsContext graphicsContext;
    private ArrayList<Enemy> enemies;

    public EnemySpawner(CanvasCreator canvasCreator, GraphicsContext graphicsContext) {
        this.canvasCreator = canvasCreator;
        this.graphicsContext = graphicsContext;
        this.enemies = new ArrayList<>();
    }

    public void spawn(int times) {
        Random random = new Random();

        for (int i = 0; i < times; i++) {
            Coordinate coordinate = new Coordinate(random.nextInt(canvasCreator.getWidth()), random.nextInt(canvasCreator.getHeight()));

            if (!canvasCreator.getCharacterChecker().get(coordinate.getID())) {
                Enemy enemy = new Enemy(random.nextInt(canvasCreator.getWidth()), random.nextInt(canvasCreator.getHeight()));
                enemies.add(enemy);
                colorLocation(coordinate);
            } else {
                i--;
            }
        }
    }

    public void colorLocation(Coordinate coordinate) {
        graphicsContext.setFill(Color.RED);
        graphicsContext.fillRect(coordinate.getX() * canvasCreator.getCornersize(), coordinate.getY() * canvasCreator.getCornersize(), canvasCreator.getCornersize() - 1, canvasCreator.getCornersize() - 1);
    }

    public ArrayList<Enemy> getEnemies() {
        return this.enemies;
    }
}
