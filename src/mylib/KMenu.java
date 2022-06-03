package mylib;

import java.awt.*;
import java.awt.event.MouseEvent;

public class KMenu extends KContainer {

    boolean isClicked;

    public KMenu() {
        super();
        width = 50;
        height = 25;
        isClicked = false;
    }

    public KMenu(String text) {
        super(text);
        width = 50;
        height = 25;
        isClicked = false;
    }

    public void add(KMenuItem menuItem) {
        super.add(menuItem);
    }

    @Override
    public void draw(Graphics g, int x_, int y_) {
        x = x_;
        y = y_;
        g.setColor(Color.WHITE);
        g.drawRect(x, y, width, height);
        g.drawString(text, x + 2, y + 17);
    }


    @Override
    public void paint(Graphics g){
        for (KComponent kComponent : compoList) {
            kComponent.paint(g);
        }
    }

    @Override
    public void processMouseEvent(MouseEvent e) {
        int id = e.getID();
        Graphics g = e.getComponent().getGraphics();
        if (id == MouseEvent.MOUSE_RELEASED) {
            if (isContain(e.getX(), e.getY())) {
                if (!isClicked) {
                    int index = y + height;
                    for (KComponent kComponent : compoList) {
                        kComponent.draw(g, x, index);
                        kComponent.visible = true;
                        index += 25;
                    }
                    isClicked = true;
                } else {
                    e.getComponent().repaint();
                    for (KComponent kComponent : compoList) {
                        kComponent.visible = false;
                    }
                    isClicked = false;
                }
            }
        }

    }

}