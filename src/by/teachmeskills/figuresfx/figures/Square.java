package by.teachmeskills.figuresfx.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Objects;

public class Square extends Figure{
    private double side;

    private Square(double cx, double cy, double lineWidth, Color color) {
        super(FIGURE_TYPE_SQUARE, cx, cy, lineWidth, color);
    }

    public Square(double cx, double cy, double lineWidth, Color color, double side) {
        this(cx, cy, lineWidth, color);
        this.side = side < 30 ? 30 : side;
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.setLineWidth(lineWidth);
        graphicsContext.setStroke(color);
        graphicsContext.strokeRect(cx - side / 2, cy - side / 2, side, side);
    }

    @Override
    public String toString() {
        return "Square{" +
                "cx=" + cx +
                ", cy=" + cy +
                ", lineWidth=" + lineWidth +
                ", color=" + color +
                ", side=" + side +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return Double.compare(square.side, side) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(side);
    }
}
