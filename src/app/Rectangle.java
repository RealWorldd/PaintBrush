package app;

import java.awt.*;

public class Rectangle extends Figure{
    public Rectangle(int x, int y, int width, int height, Color figureColor) {
        super(x, y, width, height, figureColor);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(figureColor);
        g.drawRect(x, y, width, height);

    }
}
