package project;

import document.Document;
import factory.ObservableNode;

public class Project extends ObservableNode {

	private String path;

	public Project(String name) {
		super(name);		
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	public void addChild(ObservableNode node) {
		int i = 1;
		node.setName("New Document: " + i);
		while (isNameTaken(node.getName())) {
			i++;
			node.setName("New Document: " + i);
		}
		children.add(node);
		setChanged();
		notifyObservers(node);
	}	
	
}
