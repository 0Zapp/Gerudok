package actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

import gui.MainFrame;

public class CircleAction extends AbstractAction {

	public CircleAction(boolean icon) {
		// putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N,
		// ActionEvent.CTRL_MASK));
		putValue(NAME, "New Circle");
		if (icon) {
			putValue(SMALL_ICON, new ImageIcon("images/new-circle.png"));
			putValue(SHORT_DESCRIPTION, "New Circle");
		}

	}

	public void actionPerformed(ActionEvent arg0) {

		(MainFrame.getInstance().getSelectedPageView()).getPage().startCircleState();

	}
}
