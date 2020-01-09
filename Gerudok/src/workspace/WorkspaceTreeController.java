package workspace;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;

import document.Document;
import gui.MainFrame;
import page.Page;
import project.Project;

public class WorkspaceTreeController implements TreeSelectionListener {

	public void valueChanged(TreeSelectionEvent e) {
		// TODO Auto-generated method stub

		TreePath path = e.getPath();
		int mode = 0;// 0-selektovan workspace
						// 1-selektovan project
						// 2-selectovan document
						// 3-selectovan page;
		Workspace workspace = null;
		Project project = null;
		Document document = null;
		Page page = null;

		for (int i = 0; i < path.getPathCount(); i++) {
			mode = i;
			switch (mode) {
			case 0:
				workspace = (Workspace) path.getPathComponent(i);
				break;
			case 1:
				project = (Project) path.getPathComponent(i);
				break;
			case 2:
				document = (Document) path.getPathComponent(i);
				break;
			case 3:
				page = (Page) path.getPathComponent(i);
				break;

			default:
				break;
			}

		}

		MainFrame.getInstance().changeProjectView(path.getParentPath(), project, document, page, mode);

	}

}