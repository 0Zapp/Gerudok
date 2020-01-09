package actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

import gui.MainFrame;

public class RotateAction extends AbstractAction {

	public RotateAction(boolean icon) {
		// putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N,
		// ActionEvent.CTRL_MASK));
		putValue(NAME, "Rotate");
		if (icon) {
			putValue(SMALL_ICON, new ImageIcon("images/rotate.png"));
			putValue(SHORT_DESCRIPTION, "Rotate");
		}

	}

	public void actionPerformed(ActionEvent arg0) {

		(MainFrame.getInstance().getSelectedPageView()).getPage().startRotateState();
	}
}
