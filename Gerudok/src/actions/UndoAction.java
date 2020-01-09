package actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

import gui.MainFrame;
import page.PageView;

public class UndoAction extends AbstractAction {// ispravi

	public UndoAction(boolean icon) {
		// putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N,
		// ActionEvent.CTRL_MASK));
		putValue(NAME, "Undo");
		if (icon) {
			putValue(SMALL_ICON, new ImageIcon("images/undo.png"));
			putValue(SHORT_DESCRIPTION, "Undo");
		}

	}

	public void actionPerformed(ActionEvent arg0) {
		PageView view = (PageView) MainFrame.getInstance().getSelectedPageView();
		view.getCommandManager().undoCommand();
		SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getWorkspaceTree());
	}
}
