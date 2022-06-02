package app;

import java.awt.*;

public class Line extends Figure {
    public Line(int x, int y, int width, int height, Color figureColor) {
        super(x, y, width, height, figureColor);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(figureColor);
        g.drawLine(x, y, x + width, y + height);
    }
}
