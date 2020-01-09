package actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

import gui.MainFrame;

public class ResizeAction extends AbstractAction {

	public ResizeAction(boolean icon) {
		// putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N,
		// ActionEvent.CTRL_MASK));
		putValue(NAME, "Resize");
		if (icon) {
			putValue(SMALL_ICON, new ImageIcon("images/resize.png"));
			putValue(SHORT_DESCRIPTION, "Resize");
		}

	}

	public void actionPerformed(ActionEvent arg0) {

		(MainFrame.getInstance().getSelectedPageView()).getPage().startResizeState();

	}
}
