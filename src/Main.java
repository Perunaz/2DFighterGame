import canvas.CanvasCreator;
import charactar.EnemySpawner;
import charactar.Player;
import charactar.PlayerMovement;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Random;

public class Main extends Application {
    private CanvasCreator canvasCreator = new CanvasCreator(25, 25, 25);
    private Random random = new Random();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        VBox root = new VBox();
        Canvas canvas = canvasCreator.Create();
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        Player player = new Player(random.nextInt(canvasCreator.getWidth()), random.nextInt(canvasCreator.getHeight()), canvasCreator);

        graphicsContext.setFill(Color.BLACK);
        graphicsContext.fillRect(0, 0, canvasCreator.getWidth()*canvasCreator.getCornersize(), canvasCreator.getHeight()*canvasCreator.getCornersize());

        EnemySpawner enemySpawner = new EnemySpawner(canvasCreator, graphicsContext);
        enemySpawner.spawn(15);

        root.getChildren().add(canvas);

        graphicsContext.setFill(Color.BLUE);
        graphicsContext.fillRect(player.getLocationX() * canvasCreator.getCornersize(), player.getLocationY() * canvasCreator.getCornersize(), canvasCreator.getCornersize() - 1, canvasCreator.getCornersize() - 1);

        Scene scene = new Scene(root, canvasCreator.getWidth()*canvasCreator.getCornersize(), canvasCreator.getHeight()*canvasCreator.getCornersize());
        PlayerMovement playerMovement = new PlayerMovement(player, scene, canvasCreator, graphicsContext, enemySpawner.getEnemies());

        stage.setTitle("2DFighterGame");
        stage.setScene(scene);
        stage.show();
    }
}
