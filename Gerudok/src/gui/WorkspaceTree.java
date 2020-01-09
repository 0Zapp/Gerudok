package gui;

import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultTreeCellRenderer;

import project.Project;
import workspace.WorkspaceModel;
import workspace.WorkspaceTreeCellRendered;
import workspace.WorkspaceTreeController;
import workspace.WorkspaceTreeEditor;

public class WorkspaceTree extends JTree {

	public WorkspaceTree() {

		addTreeSelectionListener(new WorkspaceTreeController());
		setCellEditor(new WorkspaceTreeEditor(this, new DefaultTreeCellRenderer()));
		setCellRenderer(new WorkspaceTreeCellRendered());
		setEditable(true);
	}

	public void addProject(Project project) {
		((WorkspaceModel) getModel()).addProject(project);
		SwingUtilities.updateComponentTreeUI(this);
	}

}
