package workspace;

import javax.swing.tree.DefaultTreeModel;

import factory.ObservableNode;

public class WorkspaceModel extends DefaultTreeModel {

	public WorkspaceModel() {
		super(new Workspace());

	}

	public void addProject(ObservableNode project) {
		((Workspace) getRoot()).addChild(project);
	}

}
