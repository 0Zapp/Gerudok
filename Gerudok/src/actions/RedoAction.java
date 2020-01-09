package actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

import gui.MainFrame;
import page.PageView;

public class RedoAction extends AbstractAction {// ispravi

	public RedoAction(boolean icon) {
		// putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N,
		// ActionEvent.CTRL_MASK));
		putValue(NAME, "Redo");
		if (icon) {
			putValue(SMALL_ICON, new ImageIcon("images/redo.png"));
			putValue(SHORT_DESCRIPTION, "Redo");
		}

	}

	public void actionPerformed(ActionEvent arg0) {
		PageView view = (PageView) MainFrame.getInstance().getSelectedPageView();
		view.getCommandManager().doCommand();
		SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getWorkspaceTree());
	}
}
