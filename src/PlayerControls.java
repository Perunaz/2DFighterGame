import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public class PlayerControls {

    private Scene scene;
    private CanvasCreator canvasCreator;
    private GraphicsContext graphicsContext;
    private Player player;

    public PlayerControls(Scene scene, GraphicsContext graphicsContext, CanvasCreator canvasCreator, Player player) {
        this.scene = scene;
        this.graphicsContext = graphicsContext;
        this.canvasCreator = canvasCreator;
        this.player = player;

        controls();
    }

    public void controls() {
        scene.addEventFilter(KeyEvent.KEY_PRESSED, key -> {
            if (key.getCode() == KeyCode.W) {
                if (player.getLocationY() > 0) {
                    player.setLocationY(player.getLocationY() - 1);
                }
            }
            if (key.getCode() == KeyCode.S) {
                if (player.getLocationY() < canvasCreator.getHeight()) {
                    player.setLocationY(player.getLocationY() + 1);
                }
            }
            if (key.getCode() == KeyCode.A) {
                if (player.getLocationX() > 0) {
                    player.setLocationX(player.getLocationX() - 1);
                }
            }
            if (key.getCode() == KeyCode.D) {
                if (player.getLocationX() < canvasCreator.getWidth()) {
                    player.setLocationX(player.getLocationX() + 1);
                }
            }
            graphicsContext.setFill(Color.BLACK);
            graphicsContext.fillRect(0, 0, canvasCreator.getWidth()*canvasCreator.getCornersize(), canvasCreator.getHeight()*canvasCreator.getCornersize());

            graphicsContext.setFill(Color.RED);
            graphicsContext.fillRect(player.getLocationX() * canvasCreator.getCornersize(), player.getLocationY() * canvasCreator.getCornersize(), canvasCreator.getCornersize() - 1, canvasCreator.getCornersize() - 1);
        });
    }
}
