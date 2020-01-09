package actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

import gui.MainFrame;

public class TriangleAction extends AbstractAction {

	public TriangleAction(boolean icon) {
		// putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N,
		// ActionEvent.CTRL_MASK));
		putValue(NAME, "New Triangle");
		if (icon) {
			putValue(SMALL_ICON, new ImageIcon("images/new-triangle.png"));
			putValue(SHORT_DESCRIPTION, "New Triangle");
		}

	}

	public void actionPerformed(ActionEvent arg0) {

		(MainFrame.getInstance().getSelectedPageView()).getPage().startTriangleState();

	}
}
