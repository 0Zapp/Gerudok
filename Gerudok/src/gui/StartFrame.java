package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import document.Document;
import errors.ErrorHandler;
import factory.ObservableNode;
import files.WorkspaceFileFilter;
import page.Page;
import project.Project;
import project.ProjectView;
import workspace.Workspace;

public class StartFrame extends JFrame implements ActionListener {
	JTextField workspaceTxt;

	public StartFrame() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;

		setSize((screenWidth / 10) * 3, (screenHeight / 10));
		setLocationRelativeTo(null);

		setTitle("Select Workspace:");
		setResizable(false);

		JButton launchBtn = new JButton("Launch");
		launchBtn.addActionListener(this);
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(this);
		JButton browseButton = new JButton("Browse");
		browseButton.addActionListener(this);
		JButton newWorkspaceButton = new JButton("New");
		newWorkspaceButton.addActionListener(this);
		JLabel workspaceLbl = new JLabel("Workspace:");
		workspaceTxt = new JTextField();
		workspaceTxt.setPreferredSize(new Dimension(300, 20));
		initializeWorkspaceTxt();

		JPanel pan1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		pan1.add(workspaceLbl);
		pan1.add(workspaceTxt);
		pan1.add(browseButton);
		pan1.add(newWorkspaceButton);

		JPanel pan2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		pan2.add(launchBtn);
		pan2.add(cancelButton);

		add(pan1, BorderLayout.CENTER);
		add(pan2, BorderLayout.SOUTH);
	}

	private void initializeWorkspaceTxt() {
		try {
			FileReader fr = new FileReader("config.txt");
			BufferedReader br = new BufferedReader(fr);
			String wsString = br.readLine();
			workspaceTxt.setText(wsString);
			br.close();
			fr.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Launch")) {

			MainFrame mf = MainFrame.getInstance();
			try {
				Workspace ws = (Workspace) mf.getWorkspaceModel().getRoot();
				ws.setPath(workspaceTxt.getText());
				FileReader fr = new FileReader(workspaceTxt.getText());
				BufferedReader br = new BufferedReader(fr);
				String line = null;
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
				mf.setVisible(true);
				dispose();
			} catch (IOException ex) {
				ErrorHandler.handle("startFrameInvalidName", this);
			}

		} else if (e.getActionCommand().equals("Cancel")) {
			dispose();
			System.exit(0);
		} else if (e.getActionCommand().equals("Browse")) {
			JFileChooser jfc = new JFileChooser();
			jfc.setFileFilter(new WorkspaceFileFilter());
			int returnVal = jfc.showOpenDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = jfc.getSelectedFile();
				if (file.exists()) {
					String path = file.getPath();
					workspaceTxt.setText(path);
				} else {
					// exception
				}

			}
		} else if (e.getActionCommand().equals("New")) {
			JFileChooser jfc = new JFileChooser();
			jfc.setDialogType(JFileChooser.SAVE_DIALOG);
			jfc.setFileFilter(new WorkspaceFileFilter());
			int returnVal = 0;
			returnVal = jfc.showSaveDialog(this);

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = jfc.getSelectedFile();
				String path = file.getPath();
				path = path.trim();
				if (!path.endsWith(".gwf"))
					path += ".gwf";
				if (!file.exists()) {
					try {
						Files.createFile(Paths.get(path));
						workspaceTxt.setText(path);
					} catch (Exception ex) {
						ErrorHandler.handle("startFrameInvalidName", jfc);
					}
				}
			}
		}
	}

}
