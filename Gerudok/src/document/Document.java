package document;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Observable;

import javax.swing.tree.TreeNode;

import factory.ObservableNode;
import page.Page;
import project.Project;

public class Document extends ObservableNode {

	public Document(String name) {
		super(name);
	}

	public void addChild(ObservableNode node) {
		int i = 1;
		node.setName("New Page: " + i);
		while (isNameTaken(node.getName())) {
			i++;
			node.setName("New Page: " + i);
		}
		children.add(node);
		setChanged();
		notifyObservers(node);
	}

}
