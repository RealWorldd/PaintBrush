package mylib;


public class KFrame extends KContainer{

	public KFrame() {
		super();
	}

	public void setKMenuBar(KMenuBar menuBar) {
		// 원래 메뉴바는 frame에 있는게 정상이지만..
		add(menuBar);
	}

}
