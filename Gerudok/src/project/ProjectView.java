package project;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import document.Document;
import document.DocumentView;
import gui.MainFrame;

public class ProjectView extends JPanel implements Observer {

	private Project project;
	private JTabbedPane tpane;
	private JLabel title;
	private ArrayList<DocumentView> documentViews = new ArrayList<>();

	public ProjectView() {
		super(new BorderLayout());

		title = new JLabel("Chose or create a project");
		add(title, BorderLayout.NORTH);

		tpane = new JTabbedPane(JTabbedPane.TOP);
		add(tpane, BorderLayout.CENTER);

	}

	public ArrayList<DocumentView> getDocumentViews() {
		return documentViews;
	}

	public JTabbedPane getTpane() {
		return tpane;
	}

	public void setProject(Project project) {
		this.project = project;
		this.project.addObserver(this);
	}

	public Project getProject() {
		return project;
	}

	public JLabel getTitle() {
		return title;
	}

	public void removeDocumentView(DocumentView dv) {
		documentViews.remove(dv);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (arg instanceof Document) {
			DocumentView dView = new DocumentView();
			dView.setProjectView(this);
			dView.setDocument((Document) arg);
			documentViews.add(dView);
		}
		MainFrame.getInstance().changeProjectView(this);
	}

}
