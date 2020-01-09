package actions;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;

import document.Document;
import factory.ObservableNode;
import files.ProjectFileFilter;
import files.WorkspaceFileFilter;
import gui.MainFrame;
import page.Page;
import project.Project;
import project.ProjectView;
import workspace.Workspace;

public class ChangeWorkspaceAction extends AbstractAction {// ispravi

	public ChangeWorkspaceAction(boolean icon) {
		// putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N,
		// ActionEvent.CTRL_MASK));
		putValue(NAME, "Change Workspace");
		if (icon) {
			putValue(SMALL_ICON, new ImageIcon("images/change-workspace.png"));
			putValue(SHORT_DESCRIPTION, "Change Workspace");
		}

	}

	public void actionPerformed(ActionEvent arg0) {

		JFileChooser jfc = new JFileChooser();
		jfc.setFileFilter(new WorkspaceFileFilter());
		int returnVal = jfc.showOpenDialog(MainFrame.getInstance());
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = jfc.getSelectedFile();
			if (file.exists()) {
				String path = file.getPath();
				MainFrame mf = MainFrame.getInstance();
				try {
					Workspace ws = (Workspace) mf.getWorkspaceModel().getRoot();
					ws.setPath(path);
					ws.removeAllProjects();
					FileReader fr = new FileReader(path);
					BufferedReader br = new BufferedReader(fr);
					String line = null;
					MainFrame.getInstance().changeProjectView(new ProjectView());
					SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getWorkspaceTree());
					while ((line = br.readLine()) != null) {

						try {
							FileInputStream fis = new FileInputStream(line);
							ObjectInputStream ois = new ObjectInputStream(fis);
							Object o = ois.readObject();
							Project p = (Project) o;
							MainFrame.getInstance().getWorkspaceTree().addProject(p);
							ProjectView pView = new ProjectView();
							pView.setProject(p);
							for (ObservableNode d : p.getChildren()) {
								p.doNothing(d);
								for (ObservableNode pa : d.getChildren()) {
									((Page) pa).initializeStateManager();
									d.doNothing(pa);
								}
							}
							ois.close();
							fis.close();
						} catch (Exception ex) {
							ex.printStackTrace();
						}

					}

					br.close();
					fr.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			} else {
				// exception
			}

		}

	}
}