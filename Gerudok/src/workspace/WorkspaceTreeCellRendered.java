package workspace;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

import document.Document;
import page.Page;
import project.Project;

public class WorkspaceTreeCellRendered extends DefaultTreeCellRenderer {

	public WorkspaceTreeCellRendered() {

		// TODO Auto-generated constructor stub
	}

	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf,
			int row, boolean hasFocus) {
		super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

		if (value instanceof Page) {
			setIcon(new ImageIcon("images/page-icon.png"));

		} else if (value instanceof Project) {
			setIcon(new ImageIcon("images/project-icon.png"));

		} else if (value instanceof Document) {
			setIcon(new ImageIcon("images/document-icon.png"));

		} else if (value instanceof Workspace) {
			setIcon(new ImageIcon("images/workspace-icon.png"));

		}

		return this;
	}

}