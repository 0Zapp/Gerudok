package factory;

import javax.swing.SwingUtilities;

import document.Document;
import gui.MainFrame;
import page.Page;
import project.Project;
import project.ProjectView;
import workspace.Workspace;

public class NodeCreator {
	public static ObservableNode createNode(Object clicked) {
		ObservableNode node = null;
		if (clicked instanceof Workspace || clicked == null) {
			node = new ProjectFactory().createNode("Projekat iz akcije");
		} else if (clicked instanceof Project) {
			node = new DocumentFactory().createNode("Dokument iz akcije");
		} else if (clicked instanceof Document) {
			node = new PageFactory().createNode("Page iz akcije");
		}
		return node;
	}
}
