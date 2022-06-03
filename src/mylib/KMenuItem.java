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
		x = x_;
		y = y_;
		g.setColor(new Color(60, 63, 65));
		g.fillRect(x, y, width, height);
		g.setColor(Color.LIGHT_GRAY);
		g.drawRect(x, y, width, height);
		g.setColor(Color.WHITE);
		g.drawString(text, x+2, y+17);
	}
}