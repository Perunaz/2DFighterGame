import javafx.scene.canvas.Canvas;

import java.util.HashMap;

public class CanvasCreator {
    private int height;
    private int width;
    private int cornersize;
    private HashMap<String, Boolean> characterChecker;

    public CanvasCreator(int height, int width, int cornersize) {
        this.height = height;
        this.width = width;
        this.cornersize = cornersize;
        this.characterChecker = new HashMap<>();

        for (int a = 0; a < height; a++) {
            for (int b = 0; b < width; b++) {
                StringBuilder sb = new StringBuilder();
                sb.append(b);
                sb.append(a);

                characterChecker.put(sb.toString(), false);
            }
        }
    }

    public Canvas Create() {
        return new Canvas(this.width*this.cornersize, this.height*this.cornersize);
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getCornersize() {
        return cornersize;
    }

    public HashMap<String, Boolean> getCharacterChecker() {
        return characterChecker;
    }
}
