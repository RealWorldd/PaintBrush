package app;

import java.awt.*;

public class Figure extends FigureThing{
    public Figure(int x, int y, int width, int height, Color figureColor, boolean fill) {
        super(x, y, width, height, figureColor, fill);
    }

    @Override
    public void draw(Graphics g) {}
}
