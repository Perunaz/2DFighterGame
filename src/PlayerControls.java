import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public class PlayerControls {

    private Player player;
    private Scene scene;
    private CanvasCreator canvasCreator;
    private GraphicsContext graphicsContext;

    private static final String UP = "W";
    private static final String DOWN = "S";
    private static final String LEFT = "A";
    private static final String RIGHT = "D";

    public PlayerControls(Player player, Scene scene, CanvasCreator canvasCreator, GraphicsContext graphicsContext) {
        this.player = player;
        this.scene = scene;
        this.canvasCreator = canvasCreator;
        this.graphicsContext = graphicsContext;

        controls();
    }

    public void controls() {
        scene.addEventFilter(KeyEvent.KEY_PRESSED, key -> {
            if (key.getCode() == KeyCode.getKeyCode(UP)) {
                if (player.getLocationY() > 0) {
                    player.setLocationY(player.getLocationY() - 1);
                }
            }
            if (key.getCode() == KeyCode.getKeyCode(DOWN)) {
                if (player.getLocationY() < canvasCreator.getHeight()) {
                    player.setLocationY(player.getLocationY() + 1);
                }
            }
            if (key.getCode() == KeyCode.getKeyCode(LEFT)) {
                if (player.getLocationX() > 0) {
                    player.setLocationX(player.getLocationX() - 1);
                }
            }
            if (key.getCode() == KeyCode.getKeyCode(RIGHT)) {
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
