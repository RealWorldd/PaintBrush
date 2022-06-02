package mylib;

import java.awt.*;

public class KButton extends KAbstractButton {

    public KButton(){
        super(null);
        width = 30;
        height = 25;
    }

    public KButton(String text) {
        super(text);
        width = 30;
        height = 25;
    }

    @Override
    public void draw(Graphics g, int x_, int y_) {
        x = x_;
        y = y_;
        g.drawRect(x, y, width, height);
        g.drawString(text, x+2, y+17);
    }


}
