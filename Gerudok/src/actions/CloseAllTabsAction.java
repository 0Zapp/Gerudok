package actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

import document.DocumentView;
import gui.MainFrame;
import project.ProjectView;

public class CloseAllTabsAction extends AbstractAction {

	public CloseAllTabsAction(boolean icon) {
		// putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N,
		// ActionEvent.CTRL_MASK));
		if (icon) {
			putValue(SMALL_ICON, new ImageIcon("images/close-all-tabs.png"));
			putValue(SHORT_DESCRIPTION, "Close All Tabs");
		}
		putValue(NAME, "Close All Tabs");

	}

	public void actionPerformed(ActionEvent arg0) {
		ProjectView pv = MainFrame.getInstance().getSupportProjectView();
		for (DocumentView dv : pv.getDocumentViews()) {
			dv.setOpen(false);
		}
	}
}