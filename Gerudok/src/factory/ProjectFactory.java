package factory;

import gui.MainFrame;
import project.Project;
import project.ProjectView;

public class ProjectFactory implements AbstractFactory {

	public ObservableNode createNode(String name) {
		ObservableNode p = new Project(name);
		return p;
	}

}
