package actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import javax.swing.tree.TreePath;

import gui.MainFrame;
import project.Project;
import workspace.Workspace;

public class DeleteProjectAction extends AbstractAction {

	public DeleteProjectAction(boolean icon) {
		if (icon) {
			putValue(SMALL_ICON, new ImageIcon("images/delete-project.png"));
			putValue(SHORT_DESCRIPTION, "Delete project");
		}
		putValue(NAME, "Delete project");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object p = MainFrame.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
		if (p instanceof Project) {
			MainFrame.getInstance().getWorkspaceTree()
					.setSelectionPath(MainFrame.getInstance().getPathToParentOfSelectedNode());
			Workspace w = (Workspace) MainFrame.getInstance().getWorkspaceTree().getSelectionPath().getPathComponent(0);
			w.removeChild((Project) p);
			SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getWorkspaceTree());
		}

	}

}
