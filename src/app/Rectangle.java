package app;

import java.awt.*;

public class Rectangle extends Figure {
    public Rectangle(int x, int y, int width, int height, Color figureColor, boolean fill) {
        super(x, y, width, height, figureColor, fill);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(figureColor);
        if (fill) {
            g.fillRect(x, y, width, height);
        } else {
            g.drawRect(x, y, width, height);
        }
    }
}
