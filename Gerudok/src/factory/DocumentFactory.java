package factory;

import document.Document;

public class DocumentFactory implements AbstractFactory {

	public ObservableNode createNode(String name) {
		ObservableNode d = new Document(name);
		return d;
	}

}
