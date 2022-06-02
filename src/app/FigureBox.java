package app;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class FigureBox extends FigureThing implements Cloneable{
    public FigureBox(int x, int y, int width, int height, Color figureColor) {
        super(x, y, width, height, figureColor);
    }

    ArrayList<FigureThing> figurebox = new ArrayList<>();

    public void add(FigureThing figureThing) {
        figurebox.add(figureThing);
    }

    @Override
    public void move(int a, int b, int c, int d) {
        super.move(a, b, c, d);
        for (Iterator iterator = figurebox.iterator(); iterator.hasNext();) {
            FigureThing figureThing = (FigureThing) iterator.next();
            figureThing.move(a, b, c, d);
        }
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(figureColor);
        g.drawRect(x, y, width, height);
        for (Iterator iterator = figurebox.iterator(); iterator.hasNext(); ) {
            FigureThing figureThing = (FigureThing) iterator.next();
            figureThing.draw(g);
        }
    }

    @Override
    public FigureBox clone() {
        FigureBox clone = (FigureBox) super.clone();
        ArrayList<FigureThing> copyArray = new ArrayList<>();
        for (FigureThing figureThing : figurebox) {
            FigureThing temp = figureThing.clone();
            temp.x += 10;
            copyArray.add(temp);
        }
        clone.figurebox = copyArray;
        // TODO: copy mutable state here, so the clone can't change the internals of the original
        return clone;
    }
}
