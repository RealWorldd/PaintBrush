package app;

import java.awt.*;

public class Oval extends Figure {
    public Oval(int x, int y, int width, int height, Color figureColor, boolean fill) {
        super(x, y, width, height, figureColor, fill);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(figureColor);
        if (fill) {
            g.fillOval(x, y, width, height);
        } else {
            g.drawOval(x, y, width, height);
        }
    }
}
