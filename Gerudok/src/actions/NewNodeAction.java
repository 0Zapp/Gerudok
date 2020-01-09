package actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

import document.Document;
import factory.NodeCreator;
import factory.ObservableNode;
import gui.MainFrame;
import page.Page;
import project.Project;
import project.ProjectView;
import workspace.Workspace;

public class NewNodeAction extends AbstractAction {// ispravi

	public NewNodeAction(boolean icon) {
		// putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N,
		// ActionEvent.CTRL_MASK));
		putValue(NAME, "New");
		if (icon) {
			putValue(SMALL_ICON, new ImageIcon("images/new-page.png"));
			putValue(SHORT_DESCRIPTION, "New");
		}

	}

	public void actionPerformed(ActionEvent arg0) {
		Object o = MainFrame.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
		if (o == null)
			o = MainFrame.getInstance().getWorkspaceTree().getModel().getRoot();
		ObservableNode node = NodeCreator.createNode(o);
		((ObservableNode) o).addChild(node);
		if (o instanceof Workspace) {
			ProjectView pv = new ProjectView();
			pv.setProject((Project) node);
			MainFrame.getInstance().changeProjectView(pv);
		}
		SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getWorkspaceTree());
	}
}
