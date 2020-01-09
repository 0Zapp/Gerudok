package factory;

import page.Page;

public class PageFactory implements AbstractFactory {

	public ObservableNode createNode(String name) {
		ObservableNode p = new Page(name);
		return p;
	}

}