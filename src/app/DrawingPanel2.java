/*package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

public class DrawingPanel2 extends JPanel {

    static int figuretype = 0;
    int x, y, width, height;
    boolean figurePressed = false;

    ArrayList<FigureThing> figurelist = new ArrayList<>();

    public DrawingPanel2() {
        MyMouseListener myMouseListener = new MyMouseListener();
        addMouseListener(myMouseListener);
        JButton jButton = new JButton("hello");
        add(jButton);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton jButton1 = (JButton) e.getSource();
                if (jButton1 == jButton) {
                    System.out.println("true");
                }
            }
        });

    }

    class MyMouseListener extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            x = e.getX();
            y = e.getY();
            figurePressed = isContain(x, y);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if (figurePressed) {
                for (FigureThing figureThing : figurelist) {
                    if (figureThing.contain(x, y)) {
                        figureThing.move(x, e.getX(), y, e.getY());
                        paint(getGraphics());
                    }
                }
                figurePressed = false;
            } else if (figuretype == 3) {
                width = Math.abs(e.getX() - x);
                height = Math.abs(e.getY() - y);
                FigureBox figureBox = new FigureBox(x, y, width, height, Color.LIGHT_GRAY);
                for (int i = 0; i < figurelist.size(); i++) {
                    if (figurelist.get(i).inside(x, y, width, height)) {
                        figureBox.add(figurelist.get(i));
                    }
                }
                ArrayList<FigureThing> tempList = figureBox.figurebox;
                Point maxPoint = tempList.get(0).getMaxPoint();
                Point minPoint = tempList.get(0).getMinPoint();
                for (int i = 1; i < tempList.size(); i++) {
                    if (tempList.get(i).getMaxPoint().x > maxPoint.x) {
                        maxPoint.x = tempList.get(i).getMaxPoint().x;
                    }
                    if (tempList.get(i).getMaxPoint().y > maxPoint.y) {
                        maxPoint.y = tempList.get(i).getMaxPoint().y;
                    }
                    if (tempList.get(i).getMinPoint().x < minPoint.x) {
                        minPoint.x = tempList.get(i).getMinPoint().x;
                    }
                    if (tempList.get(i).getMinPoint().y < minPoint.y) {
                        minPoint.y = tempList.get(i).getMinPoint().y;
                    }
                }

                for (Iterator iterator = figurelist.iterator(); iterator.hasNext(); ) {
                    FigureThing figureThing = (FigureThing) iterator.next();
                    if (figureThing.inside(x, y, width, height)) {
                        iterator.remove();
                    }
                }
                figureBox.x = minPoint.x;
                figureBox.y = minPoint.y;
                figureBox.width = maxPoint.x - minPoint.x;
                figureBox.height = maxPoint.y - minPoint.y;
                figurelist.add(figureBox);
                paint(getGraphics());

            } else {
                int minx, miny;

                minx = Math.min(x, e.getX());
                miny = Math.min(y, e.getY());

                width = e.getX() - x;
                height = e.getY() - y;
                if (figuretype == 2) {
                    addFigure(x, y, width, height, ColorFrame.color);
                } else {
                    addFigure(minx, miny, width, height, ColorFrame.color);
                }
                paint(getGraphics());
            }
        }

    }


    public void addFigure(int a, int b, int c, int d, Color color) {
        if (figuretype == 0) {
            figurelist.add(new Rectangle(a, b, Math.abs(c), Math.abs(d), color));
        } else if (figuretype == 1) {
            figurelist.add(new Oval(a, b, Math.abs(c), Math.abs(d), color));
        } else {
            figurelist.add(new Line(a, b, c, d, color));
        }
    }

    public boolean isContain(int x, int y) {
        for (FigureThing figureThing : figurelist) {
            if (figureThing.contain(x, y)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        for (FigureThing figureThing : figurelist) {
            figureThing.draw(graphics);
        }
    }
}

 */

