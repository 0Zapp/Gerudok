package actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

import gui.MainFrame;
import page.PageView;

public class SelectAction extends AbstractAction {

	public SelectAction(boolean icon) {
		// putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N,
		// ActionEvent.CTRL_MASK));
		putValue(NAME, "Select");
		if (icon) {
			putValue(SMALL_ICON, new ImageIcon("images/select.png"));
			putValue(SHORT_DESCRIPTION, "Select");
		}

	}

	public void actionPerformed(ActionEvent arg0) {

		(MainFrame.getInstance().getSelectedPageView()).getPage().startSelectState();
	}
}
