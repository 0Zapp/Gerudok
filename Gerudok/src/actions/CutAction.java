package actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

import ccp.PageElementsSelection;
import factory.NodeCreator;
import factory.ObservableNode;
import gui.MainFrame;
import page.PageView;
import project.Project;
import project.ProjectView;
import workspace.Workspace;

public class CutAction extends AbstractAction {// ispravi

	public CutAction(boolean icon) {
		// putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N,
		// ActionEvent.CTRL_MASK));
		putValue(NAME, "Cut");
		if (icon) {
			putValue(SMALL_ICON, new ImageIcon("images/cut.png"));
			putValue(SHORT_DESCRIPTION, "Cut");
		}

	}

	public void actionPerformed(ActionEvent arg0) {
		if (!(((PageView) (MainFrame.getInstance().getSelectedPageView())).getPage().getSelectionModel()
				.getSelectionListSize() == 0)) {

			PageElementsSelection contents = new PageElementsSelection(
					((PageView) (MainFrame.getInstance().getSelectedPageView())).getPage().getSelectionModel()
							.getSelected());
			MainFrame.getInstance().getClipboard().setContents(contents, MainFrame.getInstance());
		}
		SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getWorkspaceTree());
		// nedostaje brisanje selektovanih elemenata sa dijagrama
	}
}
