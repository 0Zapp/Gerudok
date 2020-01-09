package document;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JDesktopPane;

import gui.MainFrame;
import page.Page;
import page.PageView;
import project.ProjectView;

public class DocumentView extends JDesktopPane implements Observer {

	private Document document;
	private ProjectView projectView;
	private ArrayList<PageView> pageViews = new ArrayList<>();
	private boolean open;

	public DocumentView() {
		super();
		open = true;
	}

	public ArrayList<PageView> getPageViews() {
		return pageViews;
	}

	public void setDocument(Document document) {
		this.document = document;
		this.document.addObserver(this);
	}

	public Document getDocument() {
		return document;
	}

	public void setProjectView(ProjectView pv) {
		this.projectView = pv;
	}

	public ProjectView getProjectView() {
		return projectView;
	}

	public void setOpen(boolean open) {
		this.open = open;
		MainFrame.getInstance().changeProjectView(projectView);
	}

	public boolean isOpen() {
		return open;
	}

	public void removePageView(PageView pv) {
		pageViews.remove(pv);
	}

	@Override
	public void update(Observable o, Object arg) {

		if (arg instanceof Page) {
			PageView paView = new PageView();
			paView.setProjectView(projectView);
			paView.setDocumentView(this);
			paView.setPage((Page) arg);
			pageViews.add(paView);
		} else {
			Document temp = (Document) o;
			if (!temp.isVisible()) {
				this.projectView.removeDocumentView(this);
			}
		}
		MainFrame.getInstance().changeProjectView(projectView);
	}

}