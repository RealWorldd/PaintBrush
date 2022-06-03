package app;

import java.awt.*;

public class FigureThing implements Cloneable{

    int x, y, width, height;
    Color figureColor;
    boolean fill;

    public FigureThing(int x, int y, int width, int height, Color figureColor, boolean fill) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.figureColor = figureColor;
        this.fill = fill;
    }

    public boolean contain(int x_, int y_) {
        return x <= x_ && x_ <= x + width && y <= y_ && y_ <= y + height;
    }

    public void move(int a, int b, int c, int d) {
        if (a < b && c < d) {
            x += b - a;
            y += d - c;
        } else if (a < b && c > d) {
            x += b - a;
            y -= c - d;
        } else if (a > b && c < d) {
            x -= a - b;
            y += d - c;
        } else if (a > b && c > d) {
            x -= a - b;
            y -= c - d;
        }
    }

    public Point getMaxPoint(){
        return new Point(Math.max(x, x + width), Math.max(y, y + height));
    }

    public Point getMinPoint(){
        return new Point(Math.min(x, x + width), Math.min(y, y + height));
    }

    public boolean inside(int x_, int y_, int width_, int height_) {
        return x_ <= x+width&&x+width<= x_ + width_ && y_ <= y +height&& y +height<= y_ + height_;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void draw(Graphics g) {}

    @Override
    public FigureThing clone() {
        try {
            FigureThing clone = (FigureThing) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
