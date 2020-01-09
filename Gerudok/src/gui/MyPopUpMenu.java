package gui;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import document.Document;
import page.Page;
import project.Project;
import workspace.Workspace;

public class MyPopUpMenu extends JPopupMenu {
	JMenuItem anItem;

	public MyPopUpMenu() {

		Object o = MainFrame.getInstance().getWorkspaceTree().getLastSelectedPathComponent();

		if (o == null) {
			add(MainFrame.getInstance().getActionManager().getOpenProjectAction(false));
			add(MainFrame.getInstance().getActionManager().getNewNodeAction(false));
			addSeparator();
			add(MainFrame.getInstance().getActionManager().getChangeWorkspaceAction(false));
			addSeparator();
			add(MainFrame.getInstance().getActionManager().getCloseTabAction(false));
			add(MainFrame.getInstance().getActionManager().getCloseAllTabsAction(false));
			addSeparator();
			add(MainFrame.getInstance().getActionManager().getHelpAboutAction());
			addSeparator();
			add(MainFrame.getInstance().getActionManager().getCutAction(false));
			add(MainFrame.getInstance().getActionManager().getCopyAction(false));
			add(MainFrame.getInstance().getActionManager().getPasteAction(false));
			addSeparator();
			add(MainFrame.getInstance().getActionManager().getUndoAction(false));
			add(MainFrame.getInstance().getActionManager().getRedoAction(false));

		} else if (o instanceof Workspace) {

			add(MainFrame.getInstance().getActionManager().getOpenProjectAction(false));
			add(MainFrame.getInstance().getActionManager().getNewNodeAction(false));
			addSeparator();
			add(MainFrame.getInstance().getActionManager().getChangeWorkspaceAction(false));
			addSeparator();
			add(MainFrame.getInstance().getActionManager().getCloseTabAction(false));
			add(MainFrame.getInstance().getActionManager().getCloseAllTabsAction(false));
			addSeparator();
			add(MainFrame.getInstance().getActionManager().getHelpAboutAction());
			addSeparator();
			add(MainFrame.getInstance().getActionManager().getCutAction(false));
			add(MainFrame.getInstance().getActionManager().getCopyAction(false));
			add(MainFrame.getInstance().getActionManager().getPasteAction(false));
			addSeparator();
			add(MainFrame.getInstance().getActionManager().getUndoAction(false));
			add(MainFrame.getInstance().getActionManager().getRedoAction(false));

		} else if (o instanceof Project) {
			add(MainFrame.getInstance().getActionManager().getNewNodeAction(false));
			add(MainFrame.getInstance().getActionManager().getDeleteProjectAction(false));
			addSeparator();
			add(MainFrame.getInstance().getActionManager().getChangeWorkspaceAction(false));
			addSeparator();
			add(MainFrame.getInstance().getActionManager().getSaveAction(false));
			add(MainFrame.getInstance().getActionManager().getSaveAsAction(false));
			addSeparator();
			add(MainFrame.getInstance().getActionManager().getCloseTabAction(false));
			add(MainFrame.getInstance().getActionManager().getCloseAllTabsAction(false));
			addSeparator();
			add(MainFrame.getInstance().getActionManager().getRenameAction(false));
			addSeparator();
			add(MainFrame.getInstance().getActionManager().getHelpAboutAction());
			addSeparator();
			add(MainFrame.getInstance().getActionManager().getCutAction(false));
			add(MainFrame.getInstance().getActionManager().getCopyAction(false));
			add(MainFrame.getInstance().getActionManager().getPasteAction(false));
			addSeparator();
			add(MainFrame.getInstance().getActionManager().getUndoAction(false));
			add(MainFrame.getInstance().getActionManager().getRedoAction(false));

		} else if (o instanceof Document) {

			add(MainFrame.getInstance().getActionManager().getNewNodeAction(false));
			add(MainFrame.getInstance().getActionManager().getDeleteDocumentAction(false));
			addSeparator();
			add(MainFrame.getInstance().getActionManager().getChangeWorkspaceAction(false));
			addSeparator();
			add(MainFrame.getInstance().getActionManager().getSaveAction(false));
			add(MainFrame.getInstance().getActionManager().getSaveAsAction(false));
			addSeparator();
			add(MainFrame.getInstance().getActionManager().getCloseTabAction(false));
			add(MainFrame.getInstance().getActionManager().getCloseAllTabsAction(false));
			addSeparator();
			add(MainFrame.getInstance().getActionManager().getRenameAction(false));
			addSeparator();
			add(MainFrame.getInstance().getActionManager().getHelpAboutAction());
			addSeparator();
			add(MainFrame.getInstance().getActionManager().getCutAction(false));
			add(MainFrame.getInstance().getActionManager().getCopyAction(false));
			add(MainFrame.getInstance().getActionManager().getPasteAction(false));
			addSeparator();
			add(MainFrame.getInstance().getActionManager().getUndoAction(false));
			add(MainFrame.getInstance().getActionManager().getRedoAction(false));

		} else if (o instanceof Page) {

			add(MainFrame.getInstance().getActionManager().getChangeWorkspaceAction(false));
			addSeparator();
			add(MainFrame.getInstance().getActionManager().getSaveAction(false));
			add(MainFrame.getInstance().getActionManager().getSaveAsAction(false));
			addSeparator();
			add(MainFrame.getInstance().getActionManager().getDeletePageAction(false));
			addSeparator();
			add(MainFrame.getInstance().getActionManager().getCloseTabAction(false));
			add(MainFrame.getInstance().getActionManager().getCloseAllTabsAction(false));
			addSeparator();
			add(MainFrame.getInstance().getActionManager().getRenameAction(false));
			addSeparator();
			add(MainFrame.getInstance().getActionManager().getHelpAboutAction());
			addSeparator();
			add(MainFrame.getInstance().getActionManager().getCutAction(false));
			add(MainFrame.getInstance().getActionManager().getCopyAction(false));
			add(MainFrame.getInstance().getActionManager().getPasteAction(false));
			addSeparator();
			add(MainFrame.getInstance().getActionManager().getUndoAction(false));
			add(MainFrame.getInstance().getActionManager().getRedoAction(false));

		}

	}
}
