import javafx.scene.canvas.Canvas;

public class CanvasCreator {
    private int height;
    private int width;
    private int cornersize;

    public CanvasCreator(int height, int width, int cornersize) {
        this.height = height;
        this.width = width;
        this.cornersize = cornersize;
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
}
