import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;

public class EnemySpawner {
    private CanvasCreator canvasCreator;
    private GraphicsContext graphicsContext;

    public EnemySpawner(CanvasCreator canvasCreator, GraphicsContext graphicsContext) {
        this.canvasCreator = canvasCreator;
        this.graphicsContext = graphicsContext;
    }

    public void spawn(int times) {
        Random random = new Random();

        for (int i = 0; i < times; i++) {
            Coordinate coordinate = new Coordinate(random.nextInt(canvasCreator.getWidth()), random.nextInt(canvasCreator.getHeight()));

            if (!canvasCreator.getCharacterChecker().get(coordinate.getID())) {
                Enemy enemy = new Enemy(random.nextInt(canvasCreator.getWidth()), random.nextInt(canvasCreator.getHeight()));
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
}
