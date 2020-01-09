package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.Transferable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyVetoException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.tree.TreePath;

import actions.ActionManager;
import document.Document;
import document.DocumentView;
import elements.PageElement;
import elements.PageShape;
import factory.ObservableNode;
import listeners.PopUpMenuListener;
import page.Page;
import page.PageView;
import project.Project;
import project.ProjectView;
import workspace.Workspace;
import workspace.WorkspaceModel;

public class MainFrame extends JFrame implements ClipboardOwner {

	private MainFrame() {

	}

	private ArrayList<PageElement> selectedPageElements = new ArrayList<>();;
	private static MainFrame instance = null;
	private ActionManager actionManager;
	private WorkspaceModel workspaceModel;
	private WorkspaceTree workspaceTree;

	private ProjectView projectDisplay;
	private ProjectView supportProjectView;
	private TreePath pathToParentOfSelectedNode;

	private JScrollPane scroll;

	private Toolkit kit;
	private Dimension screenSize;
	private int screenWidth;
	private int screenHeight;
	private Image img;
	private JSplitPane split;
	private MyMenuBar menu;
	private MyToolbar toolbar;
	private MyPalette palette;
	private PageView SelectedPageView;

	private Clipboard clipboard = new Clipboard("GeRuDok clipboard");

	private void initialise() {
		actionManager = new ActionManager();
		initialiseWorkspaceTree();
		initialiseGUI();

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void initialiseGUI() {

		SelectedPageView = null;

		menu = new MyMenuBar(this);
		this.setJMenuBar(menu);

		toolbar = new MyToolbar();
		add(toolbar, BorderLayout.NORTH);

		palette = new MyPalette();
		add(palette, BorderLayout.EAST);

		projectDisplay = new ProjectView();
		supportProjectView = new ProjectView();

		kit = Toolkit.getDefaultToolkit();
		screenSize = kit.getScreenSize();
		screenHeight = screenSize.height;
		screenWidth = screenSize.width;

		setSize(screenWidth / 2, screenHeight / 2);

		img = kit.getImage("images/bulletin-board.png");
		setIconImage(img);

		setTitle("Rukovalac Dokumentima");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent we) {
				File f = new File("config.txt");
				FileWriter fw = null;
				BufferedWriter bw = null;
				try {
					fw = new FileWriter(f);
					bw = new BufferedWriter(fw);
					bw.write(((Workspace) getWorkspaceModel().getRoot()).getPath());
					System.out.println(((Workspace) getWorkspaceModel().getRoot()).getPath());
					bw.close();
					fw.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {

				}

				String ObjButtons[] = { "Yes", "No", "Cancel" };
				int PromptResult = JOptionPane.showOptionDialog(null, "Do you want to save the changes you made?",
						"Rukovalac Dokumentima", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null,
						ObjButtons, ObjButtons[0]);
				if (PromptResult == 0) {// yes
					Workspace w = (Workspace) workspaceModel.getRoot();
					try {
						f = new File(w.getPath());
						fw = new FileWriter(f);
						bw = new BufferedWriter(fw);
						for (ObservableNode p : w.getChildren()) {
							if (((Project) p).getPath() != null) {
								bw.write(((Project) p).getPath());
								bw.newLine();
							}
						}
						bw.close();
						fw.close();
					} catch (IOException e) {

					}
					System.exit(0);
				} else if (PromptResult == 1) {// no
					System.exit(0);
				} else if (PromptResult == 2) {// cancel

				}

			}
		});

		setLocationRelativeTo(null);

		scroll = new JScrollPane(workspaceTree);
		scroll.setPreferredSize(new Dimension(250, 250));
		scroll.setMinimumSize((new Dimension(200, 200)));
		scroll.setMaximumSize(new Dimension(300, 300));

		split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scroll, projectDisplay);
		add(split, BorderLayout.CENTER);
		split.setDividerLocation(250);
		split.setOneTouchExpandable(true);

	}

	private void initialiseWorkspaceTree() {
		workspaceTree = new WorkspaceTree();
		workspaceModel = new WorkspaceModel();
		workspaceTree.setModel(workspaceModel);
		workspaceTree.addMouseListener(new PopUpMenuListener());

	}

	public ActionManager getActionManager() {
		return actionManager;
	}

	public static MainFrame getInstance() {
		if (instance == null) {
			instance = new MainFrame();
			instance.initialise();

		}
		return instance;
	}

	public JPanel getProjectDisplay() {
		return projectDisplay;
	}

	public WorkspaceTree getWorkspaceTree() {
		return workspaceTree;
	}

	public WorkspaceModel getWorkspaceModel() {
		return workspaceModel;
	}

	public void changeProjectView(ProjectView pView) {

		if (pView.getProject() != null) {
			projectDisplay.getTitle().setText(pView.getProject().getName());
			supportProjectView = pView;
		} else {
			projectDisplay.getTitle().setText(pView.getTitle().getText());
		}

		Component selected = null;

		try {
			selected = projectDisplay.getTpane().getSelectedComponent();
		} catch (Exception e) {
		}

		projectDisplay.getTpane().removeAll();
		for (DocumentView dView : pView.getDocumentViews()) {
			if (dView.isOpen()) {
				projectDisplay.getTpane().addTab(pView.getProject().getName() + dView.getDocument().getName(), dView);
				dView.removeAll();
				for (PageView paView : dView.getPageViews()) {
					paView.setTitle(
							pView.getProject().getName() + dView.getDocument().getName() + paView.getPage().getName());
					dView.add(paView);
				}
			}
		}
		try {
			projectDisplay.getTpane().setSelectedComponent(selected);
		} catch (Exception e) {
		}

	}

	public TreePath getPathToParentOfSelectedNode() {
		return pathToParentOfSelectedNode;
	}

	public void changeProjectView(TreePath treePath, Project project, Document document, Page page, int mode) {
		pathToParentOfSelectedNode = treePath;
		if (mode > 0) {
			project.doNothing();
		}
		DocumentView selectedDocumentView = null;
		if (mode > 1) {

			selectedDocumentView = setTab(document);
		}
		if (mode > 2) {
			setPage(selectedDocumentView, page);
		}

	}

	public DocumentView setTab(Document document) {

		for (DocumentView dView : supportProjectView.getDocumentViews()) {
			if (dView.getDocument().equals(document)) {
				dView.setOpen(true);
				projectDisplay.getTpane().setSelectedComponent(dView);
				return dView;
			}

		}
		return null;

	}

	public ProjectView getSupportProjectView() {
		return supportProjectView;
	}

	private void setPage(DocumentView selectedDocumentView, Page page) {
		for (PageView pView : selectedDocumentView.getPageViews()) {
			if (pView.getPage().equals(page)) {
				try {
					SelectedPageView = pView;
					pView.setSelected(true);
				} catch (PropertyVetoException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public PageView getSelectedPageView() {
		// TODO Auto-generated method stub
		return SelectedPageView;
	}

	public ArrayList<PageElement> getSelectedPageElements() {
		return selectedPageElements;
	}

	public void addSelectedPageElement(PageElement selectedPageElement) {
		this.selectedPageElements.add(selectedPageElement);
	}

	public void setSelectedPage(Page page) {
		Workspace w = (Workspace) getWorkspaceModel().getRoot();
		Project p = supportProjectView.getProject();
		Object[] objects = new Object[4];
		objects[0] = w;
		objects[1] = p;
		ArrayList<ObservableNode> documents = p.getChildren();
		for (ObservableNode d : documents) {
			for (ObservableNode pa : d.getChildren()) {
				if (page.equals(pa)) {
					objects[2] = d;
					objects[3] = pa;
					TreePath path = new TreePath(objects);
					getWorkspaceTree().setSelectionPath(path);
				}
			}
		}

	}

	public boolean isElementSelected(PageElement element) {
		for (PageElement e : selectedPageElements) {
			if (element.equals(e)) {
				return true;
			}
		}
		return false;
	}

	public void removeSelectedPageElements() {
		selectedPageElements.clear();

	}

	public Clipboard getClipboard() {
		return clipboard;
	}

	@Override
	public void lostOwnership(Clipboard clipboard, Transferable contents) {
		// TODO Auto-generated method stub
		System.out.println("lostOwnership");

	}
}
