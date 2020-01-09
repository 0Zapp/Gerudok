package actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

import gui.MainFrame;
import page.PageView;

public class PasteAction extends AbstractAction {// ispravi

	public PasteAction(boolean icon) {
		// putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N,
		// ActionEvent.CTRL_MASK));
		putValue(NAME, "Paste");
		if (icon) {
			putValue(SMALL_ICON, new ImageIcon("images/paste.png"));
			putValue(SHORT_DESCRIPTION, "Paste");
		}

	}

	public void actionPerformed(ActionEvent arg0) {
		((PageView) (MainFrame.getInstance().getSelectedPageView())).paste();
		SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getWorkspaceTree());
	}
}
