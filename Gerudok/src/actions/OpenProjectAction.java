package actions;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

import document.Document;
import factory.ObservableNode;
import files.ProjectFileFilter;
import gui.MainFrame;
import page.Page;
import project.Project;
import project.ProjectView;

public class OpenProjectAction extends AbstractAction {// ispravi

	public OpenProjectAction(boolean icon) {
		// putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N,
		// ActionEvent.CTRL_MASK));
		putValue(NAME, "Open project");
		if (icon) {
			putValue(SMALL_ICON, new ImageIcon("images/open-project.png"));
			putValue(SHORT_DESCRIPTION, "Open project");
		}

	}

	public void actionPerformed(ActionEvent arg0) {

		JFileChooser jfc = new JFileChooser();
		jfc.setFileFilter(new ProjectFileFilter());
		int returnVal = jfc.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = jfc.getSelectedFile();
			if (file.exists()) {
				String path = file.getPath();
				try {
					FileInputStream fis = new FileInputStream(path);
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
			} else {
				// exception
			}
		}
	}
}