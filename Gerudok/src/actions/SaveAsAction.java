package actions;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;

import document.Document;
import files.ProjectFileFilter;
import files.WorkspaceFileFilter;
import gui.MainFrame;
import page.Page;
import project.Project;
import project.ProjectView;
import workspace.Workspace;

public class SaveAsAction extends AbstractAction {// ispravi

	public SaveAsAction(boolean icon) {
		// putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N,
		// ActionEvent.CTRL_MASK));
		putValue(NAME, "Save project as");
		if (icon) {
			putValue(SMALL_ICON, new ImageIcon("images/save-as.png"));
			putValue(SHORT_DESCRIPTION, "Save project as");
		}

	}

	public void actionPerformed(ActionEvent arg0) {
		Object o = MainFrame.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
		Project p;
		if (o instanceof Project) {
			p = (Project) o;
		} else
			return;
		JFileChooser jfc = new JFileChooser();
		jfc.setDialogType(JFileChooser.SAVE_DIALOG);
		jfc.setFileFilter(new ProjectFileFilter());
		int returnVal = jfc.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = jfc.getSelectedFile();
			String path = file.getPath();
			if (!path.endsWith(".gpf"))
				path += ".gpf";
			p.setPath(path);
			try {
				FileOutputStream fos = new FileOutputStream(path);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(p);
				oos.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}