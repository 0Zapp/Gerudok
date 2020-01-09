package actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import gui.AboutDialog;
import gui.MainFrame;

public class HelpAboutAction extends AbstractAction {

	public HelpAboutAction() {

		// putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_O,
		// ActionEvent.CTRL_MASK));
		putValue(NAME, "About");
		// putValue(SHORT_DESCRIPTION, "About");
	}

	public void actionPerformed(ActionEvent arg0) {
		AboutDialog dialog = new AboutDialog(MainFrame.getInstance(), "About", true);
		dialog.setVisible(true);
	}

}
