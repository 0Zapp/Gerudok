package actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

import document.Document;
import gui.MainFrame;
import project.Project;

public class DeleteDocumentAction extends AbstractAction {

	public DeleteDocumentAction(boolean icon) {
		if (icon) {
			putValue(SMALL_ICON, new ImageIcon("images/delete-document.png"));
			putValue(SHORT_DESCRIPTION, "Delete document");
		}
		putValue(NAME, "Delete document");
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object d = MainFrame.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
		if (d instanceof Document) {
			MainFrame.getInstance().getWorkspaceTree()
			.setSelectionPath(MainFrame.getInstance().getPathToParentOfSelectedNode());
			Project p = (Project) MainFrame.getInstance().getWorkspaceTree().getSelectionPath().getPathComponent(1);
			p.removeChild((Document) d);
			SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getWorkspaceTree());
		}

	}

}
