package app;

import java.awt.*;

public class Oval extends Figure{
    public Oval(int x, int y, int width, int height, Color figureColor) {
        super(x, y, width, height, figureColor);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(figureColor);
        g.drawOval(x, y, width, height);
    }
}
