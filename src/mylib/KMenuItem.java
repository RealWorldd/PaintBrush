package mylib;

import java.awt.*;

public class KMenuItem extends KAbstractButton{

	public KMenuItem() {
		super();
		width = 50;
		height = 25;
	}
	public KMenuItem(String text) {
		super(text);
		width = 50;
		height = 25;
	}

	@Override
	public void draw(Graphics g, int x_, int y_) {
		g.clearRect(x_, y_, width, height);
		g.drawString(text, x_+2, y_+17);
	}
}