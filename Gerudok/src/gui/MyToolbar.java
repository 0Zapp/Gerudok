package gui;

import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class MyToolbar extends JToolBar {

	public MyToolbar() {

		super(SwingConstants.HORIZONTAL);

		add(MainFrame.getInstance().getActionManager().getNewNodeAction(true));
		add(MainFrame.getInstance().getActionManager().getOpenProjectAction(true));
		addSeparator();
		add(MainFrame.getInstance().getActionManager().getChangeWorkspaceAction(true));
		addSeparator();
		add(MainFrame.getInstance().getActionManager().getSaveAction(true));
		add(MainFrame.getInstance().getActionManager().getSaveAsAction(true));
		addSeparator();
		add(MainFrame.getInstance().getActionManager().getDeleteProjectAction(true));
		add(MainFrame.getInstance().getActionManager().getDeleteDocumentAction(true));
		add(MainFrame.getInstance().getActionManager().getDeletePageAction(true));
		addSeparator();
		add(MainFrame.getInstance().getActionManager().getCloseTabAction(true));
		add(MainFrame.getInstance().getActionManager().getCloseAllTabsAction(true));
		addSeparator();
		add(MainFrame.getInstance().getActionManager().getRenameAction(true));
		addSeparator();
		add(MainFrame.getInstance().getActionManager().getCutAction(true));
		add(MainFrame.getInstance().getActionManager().getCopyAction(true));
		add(MainFrame.getInstance().getActionManager().getPasteAction(true));
		addSeparator();
		add(MainFrame.getInstance().getActionManager().getUndoAction(true));
		add(MainFrame.getInstance().getActionManager().getRedoAction(true));

		setFloatable(true);

	}

}
