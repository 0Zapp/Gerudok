package actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

import gui.MainFrame;

public class RectangleAction extends AbstractAction {

	public RectangleAction(boolean icon) {
		// putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N,
		// ActionEvent.CTRL_MASK));
		putValue(NAME, "New Rectangle");
		if (icon) {
			putValue(SMALL_ICON, new ImageIcon("images/new-rectangle.png"));
			putValue(SHORT_DESCRIPTION, "New Rectangle");
		}

	}

	public void actionPerformed(ActionEvent arg0) {

		(MainFrame.getInstance().getSelectedPageView()).getPage().startRectangleState();
	}
}
