package gui;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class MyMenuBar extends JMenuBar {

	private JFrame parent = null;

	public MyMenuBar(JFrame parent) {

		this.parent = parent;

		JMenu fileMenu = new JMenu("File");
		fileMenu.add(MainFrame.getInstance().getActionManager().getNewNodeAction(false));
		fileMenu.add(MainFrame.getInstance().getActionManager().getOpenProjectAction(false));// Open project
		fileMenu.addSeparator();
		fileMenu.add(MainFrame.getInstance().getActionManager().getChangeWorkspaceAction(false));
		fileMenu.addSeparator();
		fileMenu.add(MainFrame.getInstance().getActionManager().getSaveAction(false));
		fileMenu.add(MainFrame.getInstance().getActionManager().getSaveAsAction(false));
		add(fileMenu);

		JMenu editMenu = new JMenu("Edit");
		editMenu.add(MainFrame.getInstance().getActionManager().getDeleteProjectAction(false));
		editMenu.add(MainFrame.getInstance().getActionManager().getDeleteDocumentAction(false));
		editMenu.add(MainFrame.getInstance().getActionManager().getDeletePageAction(false));
		editMenu.addSeparator();
		editMenu.add(MainFrame.getInstance().getActionManager().getCloseTabAction(false));
		editMenu.add(MainFrame.getInstance().getActionManager().getCloseAllTabsAction(false));
		editMenu.addSeparator();
		editMenu.add(MainFrame.getInstance().getActionManager().getRenameAction(false));
		editMenu.addSeparator();
		editMenu.add(MainFrame.getInstance().getActionManager().getCutAction(false));
		editMenu.add(MainFrame.getInstance().getActionManager().getCopyAction(false));
		editMenu.add(MainFrame.getInstance().getActionManager().getPasteAction(false));
		editMenu.addSeparator();
		editMenu.add(MainFrame.getInstance().getActionManager().getUndoAction(false));
		editMenu.add(MainFrame.getInstance().getActionManager().getRedoAction(false));
		add(editMenu);

		JMenu graphicsMenu = new JMenu("Graphics");
		graphicsMenu.add(MainFrame.getInstance().getActionManager().getRectangleAction(false));// kvadrat
		graphicsMenu.add(MainFrame.getInstance().getActionManager().getTriangleAction(false));// trougao
		graphicsMenu.add(MainFrame.getInstance().getActionManager().getCircleAction(false));// krug
		graphicsMenu.addSeparator();
		graphicsMenu.add(MainFrame.getInstance().getActionManager().getResizeAction(false));// resize
		graphicsMenu.add(MainFrame.getInstance().getActionManager().getRotateAction(false));// rotate
		add(graphicsMenu);

		JMenu helpMenu = new JMenu("Help");
		helpMenu.add(MainFrame.getInstance().getActionManager().getHelpAboutAction());
		add(helpMenu);

	}
}
