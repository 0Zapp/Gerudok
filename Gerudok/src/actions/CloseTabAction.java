package actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

import document.DocumentView;
import gui.MainFrame;
import project.ProjectView;

public class CloseTabAction extends AbstractAction {

	public CloseTabAction(boolean icon) {
		// putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N,
		// ActionEvent.CTRL_MASK));
		if (icon) {
			putValue(SMALL_ICON, new ImageIcon("images/close-tab.png"));
			putValue(SHORT_DESCRIPTION, "Close Tab");
		}
		putValue(NAME, "Close Tab");

	}

	public void actionPerformed(ActionEvent arg0) {
		ProjectView pv = (ProjectView) MainFrame.getInstance().getProjectDisplay();
		DocumentView selectedDocumentTab = (DocumentView) pv.getTpane().getSelectedComponent();
		selectedDocumentTab.setOpen(false);
	}
}