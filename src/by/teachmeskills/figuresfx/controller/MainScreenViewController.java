package by.teachmeskills.figuresfx.controller;

import by.teachmeskills.figuresfx.drawutils.Drawer;
import by.teachmeskills.figuresfx.figures.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import org.apache.log4j.Logger;

public class MainScreenViewController implements Initializable {
    private ArrayList<Figure> figures = new ArrayList<>();
    private Random random;
    @FXML
    private Canvas canvas;
    private static final Logger logger = Logger.getLogger(MainScreenViewController.class);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        figures = new ArrayList<>();
        random = new Random(System.currentTimeMillis());
    }

    private void addFigure(Figure figure) {
            figures.add(figure);
    }

    private Figure createFigure(double x, double y) throws ExceptionFigures {
        Figure figure = null;
        switch (random.nextInt(4)) {
            case Figure.FIGURE_TYPE_CIRCLE:
                figure = new Circle(x, y, random.nextInt(3), Color.GREEN, random.nextInt(50));
                break;
            case Figure.FIGURE_TYPE_RECTANGLE:
                figure = new Rectangle(x, y, random.nextInt(3), Color.RED, random.nextInt(60), random.nextInt(100));
                break;
            case Figure.FIGURE_TYPE_SQUARE:
                figure = new Square(x, y, random.nextInt(3), Color.BLUE, random.nextInt(60));
                break;
            case Figure.FIGURE_TYPE_TRIANGLE:
                figure = new Triangle(x, y, random.nextInt(3), Color.PURPLE);
                break;
            default:
                System.out.println("Unknown figure type!");
        }

        return figure;
    }

    private void repaint() {
        canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        Drawer<Figure> drawer = new Drawer<>(figures);
        drawer.draw(canvas.getGraphicsContext2D());
    }

    @FXML
    private void onMusClicked(MouseEvent mouseEvent) {
        try {
            addFigure(createFigure(mouseEvent.getX(), mouseEvent.getY()));
        } catch (ExceptionFigures e) {
            logger.error(e.getMessage(), e);
        }
        repaint();
    }
}
