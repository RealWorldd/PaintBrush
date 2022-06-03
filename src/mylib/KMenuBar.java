package mylib;

import java.awt.*;
import java.awt.event.MouseEvent;

public class KMenuBar extends KContainer{

	public KMenuBar() {
		super();
		x = 0;
		y = 31;
		width = 4096;
		height = 30;
	}

	public KMenuBar(String text) {
		super(text);
		x = 0;
		y = 31;
		width = 4096;
		height = 30;
	}

	public void add(KMenu kMenu) {
		super.add(kMenu);
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(new Color(60, 63, 65));
		g.fillRect(x, y, width , height);
		int index = 9;
		for (KComponent kComponent : compoList) {
			kComponent.draw(g, index, 34);
			index += 53;
		}
	}

	@Override
	public void processMouseEvent(MouseEvent e) {
		for (KComponent kComponent : compoList) {
			kComponent.processMouseEvent(e);
		}
	}

}
