package actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

import gui.MainFrame;

public class MoveAction extends AbstractAction {

	public MoveAction(boolean icon) {
		// putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N,
		// ActionEvent.CTRL_MASK));
		putValue(NAME, "Move");
		if (icon) {
			putValue(SMALL_ICON, new ImageIcon("images/move.png"));
			putValue(SHORT_DESCRIPTION, "Move");
		}

	}

	public void actionPerformed(ActionEvent arg0) {

		(MainFrame.getInstance().getSelectedPageView()).getPage().startMoveState();
	}
}
