package app;

import java.awt.*;

public class Figure extends FigureThing{
    public Figure(int x, int y, int width, int height, Color figureColor) {
        super(x, y, width, height, figureColor);
    }

    @Override
    public void draw(Graphics g) {}
}
