package mylib;

import java.awt.*;
import java.awt.event.MouseEvent;

public class KToolBar extends KContainer{

    public KToolBar() {
        super();
        x = 0;
        y = 61;
        width = 42;
        height = 4096;
    }

    public KToolBar(String text) {
        super(text);
        x = 0;
        y = 61;
        width = 42;
        height = 4096;
    }

    public void add(KButton kButton) {
        compoList.add(kButton);
    }

    @Override
    public void paint(Graphics g) {
        g.drawRect(x, y, width, height);
        int index = 200;
        for (KComponent kComponent : compoList) {
            kComponent.draw(g, 9, index);
            index += 27;
        }
    }

    @Override
    public void processMouseEvent(MouseEvent e) {
        for (KComponent kComponent : compoList) {
            kComponent.processMouseEvent(e);
        }
    }


}
