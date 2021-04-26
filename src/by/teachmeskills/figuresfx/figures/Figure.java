package by.teachmeskills.figuresfx.figures;

import by.teachmeskills.figuresfx.drawutils.Drawable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Figure implements Drawable {
    public static final int FIGURE_TYPE_CIRCLE = 0;
    public static final int FIGURE_TYPE_RECTANGLE = 1;
    public static final int FIGURE_TYPE_SQUARE = 2;
    public static final int FIGURE_TYPE_TRIANGLE = 3;

    private final int type;

    protected double cx;
    protected double cy;
    protected double lineWidth;
    protected Color color;

    public Figure(int type, double cx, double cy, double lineWidth, Color color) {
        this.type = type;
        this.cx = cx;
        this.cy = cy;
        this.lineWidth = lineWidth;
        this.color = color;
    }

    public abstract void draw(GraphicsContext graphicsContext);

    public int getType() {
        return type;
    }
}
