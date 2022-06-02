package app;

import mylib.KMouseListener;
import mylib.KPanel;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

public class DrawingPanel extends KPanel {

    int figuretype = 0;
    int drawX, drawY, drawWidth, drawHeight;
    boolean figurePressed = false;
    boolean isInside;
    Color figureColor = Color.BLACK;

    ArrayList<FigureThing> figurelist = new ArrayList<>();

    public DrawingPanel() {
        addKMouseListener(new MyMouseListener());
    }

    class MyMouseListener implements KMouseListener {
        @Override
        public void mousePressed(MouseEvent e) {
            if (!isContain(e.getX(), e.getY())) {//커서가 패널 안에 없을 때 종료
                isInside = false;
                return;
            }
            drawX = e.getX();
            drawY = e.getY();
            figurePressed = isFigureContain(drawX, drawY);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if (!isContain(e.getX(), e.getY()) || !isInside) {//커서가 패널 안에 없을 때 종료
                isInside = true;
                return;
            }

            if (figurePressed) {//도형이 클릭되었을 때 이동 , 삭제 , 복사
                ArrayList<FigureThing> temparr = new ArrayList<>();
                for (FigureThing figureThing : figurelist) {
                    if (figureThing.contain(drawX, drawY)) {
                        temparr.add(figureThing);
                    }
                }
                if (figuretype == 4) {//figuretype == 4 일때 선택한 도형 삭제
                    FigureThing tempFigureThing = temparr.get(temparr.size() - 1);
                    for (FigureThing figureThing : figurelist) {
                        if (figureThing.equals(tempFigureThing)) {
                            figurelist.remove(figureThing);
                            break;
                        }
                    }
                } else if (figuretype == 5) {//figuretype == 5 일때 선택한 도형 복사
                    FigureThing tempFigureThing = temparr.get(temparr.size() - 1);
                    FigureThing copyFigureThing = tempFigureThing.clone();
                    copyFigureThing.x += 10;
                    figurelist.add(copyFigureThing);
                } else {//선택한 도형 이동
                    temparr.get(temparr.size() - 1).move(drawX, e.getX(), drawY, e.getY());
                }
                figurePressed = false;
                e.getComponent().repaint();
            } else if (figuretype == 3) {//복합도형 모드
                int count = 0;
                drawWidth = Math.abs(e.getX() - drawX);
                drawHeight = Math.abs(e.getY() - drawY);
                FigureBox figureBox = new FigureBox(drawX, drawY, drawWidth, drawHeight, Color.LIGHT_GRAY);
                for (int i = 0; i < figurelist.size(); i++) {
                    if (figurelist.get(i).inside(drawX, drawY, drawWidth, drawHeight)) {
                        figureBox.add(figurelist.get(i));
                        count++;
                    }
                }
                if (count == 0) {
                    return;
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
                    if (figureThing.inside(drawX, drawY, drawWidth, drawHeight)) {
                        iterator.remove();
                    }
                }
                figureBox.x = minPoint.x;
                figureBox.y = minPoint.y;
                figureBox.width = maxPoint.x - minPoint.x;
                figureBox.height = maxPoint.y - minPoint.y;
                figurelist.add(figureBox);
                e.getComponent().repaint();
            } else {//도형 그리기
                int minx, miny;

                minx = Math.min(drawX, e.getX());
                miny = Math.min(drawY, e.getY());

                drawWidth = e.getX() - drawX;
                drawHeight = e.getY() - drawY;
                if (figuretype == 2) {
                    addFigure(drawX, drawY, drawWidth, drawHeight, figureColor);
                } else {
                    addFigure(minx, miny, drawWidth, drawHeight, figureColor);
                }
                e.getComponent().repaint();
            }
        }

        @Override
        public void mouseClicked(MouseEvent e) {

        }
    }

    public void addFigure(int a, int b, int c, int d, Color color) {
        switch (figuretype) {
            case 0:
                figurelist.add(new Rectangle(a, b, Math.abs(c), Math.abs(d), color));
                break;
            case 1:
                figurelist.add(new Oval(a, b, Math.abs(c), Math.abs(d), color));
                break;
            case 2:
                figurelist.add(new Line(a, b, c, d, color));
                break;
            default:
                break;
        }
    }

    public boolean isFigureContain(int x, int y) {
        for (FigureThing figureThing : figurelist) {
            if (figureThing.contain(x, y)) {
                return true;
            }
        }
        return false;
    }

    public void setFiguretype(int figuretype) {
        this.figuretype = figuretype;
    }

    public void setFigureColor(Color figureColor) {
        this.figureColor = figureColor;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (FigureThing figureThing : figurelist) {
            figureThing.draw(g);
        }
    }

}
