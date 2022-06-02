package mylib;

import java.awt.*;
import java.awt.event.MouseEvent;


public class KComponent{
	protected int x, y, width, height;
	protected boolean visible;
	protected String text = null;
	protected KMouseListener kMouseListener;

	public KComponent() {}

	public KComponent(String text){
		this.text = text;
	}

	public void addKMouseListener(KMouseListener l) {
		kMouseListener = l;
	}

	public void draw(Graphics g, int x_, int y_) {}

	public boolean isContain(int x_, int y_) {
		return x <= x_ && x_ <= (x + width) && y <= y_ && y_ <= (y + height);
	}

	public void paint(Graphics g) {}

	public void processMouseEvent(MouseEvent e) {
		KMouseListener listener = kMouseListener;
		if (listener != null) {
			int id = e.getID();
			switch (id) {
				case MouseEvent.MOUSE_PRESSED:
					listener.mousePressed(e);
					break;
				case MouseEvent.MOUSE_RELEASED:
					listener.mouseReleased(e);
					break;
				case MouseEvent.MOUSE_CLICKED:
					listener.mouseClicked(e);
					break;
			}
		}
	}

	public void setBounds(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
}

