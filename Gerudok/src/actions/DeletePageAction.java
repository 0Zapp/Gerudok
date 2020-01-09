package actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

import document.Document;
import gui.MainFrame;
import page.Page;

public class DeletePageAction extends AbstractAction {

	public DeletePageAction(boolean icon) {
		if (icon) {
			putValue(SMALL_ICON, new ImageIcon("images/delete-page.png"));
			putValue(SHORT_DESCRIPTION, "Delete page");
		}
		putValue(NAME, "Delete page");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object p = MainFrame.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
		if (p instanceof Page) {
			MainFrame.getInstance().getWorkspaceTree()
					.setSelectionPath(MainFrame.getInstance().getPathToParentOfSelectedNode());
			Document d = (Document) MainFrame.getInstance().getWorkspaceTree().getSelectionPath().getPathComponent(2);
			d.removeChild((Page) p);
			SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getWorkspaceTree());
		}

	}

}
