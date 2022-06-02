package mylib;

import java.util.ArrayList;

public class KContainer extends KComponent{
	public ArrayList<KComponent> compoList = new ArrayList<>();

	public KContainer() {}

	public KContainer(String text) {
		super(text);
	}

	public void add(KComponent kComponent) {
		compoList.add(kComponent);
	}
}