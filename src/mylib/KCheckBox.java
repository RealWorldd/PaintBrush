package mylib;

import java.awt.*;

public class KCheckBox extends KAbstractButton {

    boolean selected;

    public KCheckBox() {
        super(null);
        selected = false;
        width = 10;
        height = 10;
    }

    public KCheckBox(String text) {
        super(text);
        selected = false;
        width = 20;
        height = 20;
    }


    @Override
    public void draw(Graphics g, int x_, int y_) {
        x = x_;
        y = y_;
        if (selected) {
            g.setColor(Color.GREEN);
            g.fillRoundRect(x_, y_, width, height, 20, 20);
            g.setColor(Color.WHITE);
            g.drawString("Fill", x+3, y+34);
        } else {
            g.setColor(Color.GRAY);
            g.fillRoundRect(x_, y_, width, height, 20, 20);
            g.setColor(Color.WHITE);
            g.drawString("Unfill", x+3, y+34);
        }

    }

    @Override
    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    @Override
    public boolean getSelected() {
        return selected;
    }


}
