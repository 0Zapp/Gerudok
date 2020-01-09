package actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

import ccp.PageElementsSelection;
import gui.MainFrame;
import page.PageView;

public class CopyAction extends AbstractAction {// ispravi

	public CopyAction(boolean icon) {
		// putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N,
		// ActionEvent.CTRL_MASK));
		putValue(NAME, "Copy");
		if (icon) {
			putValue(SMALL_ICON, new ImageIcon("images/copy.png"));
			putValue(SHORT_DESCRIPTION, "Copy");
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
	}
}
