package actions;

public class ActionManager {

	private OpenProjectAction newOpenProjectToolbarAction;
	private OpenProjectAction newOpenProjectMenuAction;
	private SaveAction newSaveToolbarAction;
	private SaveAction newSaveMenuAction;
	private SaveAsAction newSaveAsToolbarAction;
	private SaveAsAction newSaveAsMenuAction;
	private ChangeWorkspaceAction newChangeWorkspaceMenuAction;
	private ChangeWorkspaceAction newChangeWorkspaceToolbarAction;

	private NewNodeAction newNodeMenuAction;

	private NewNodeAction newNodeToolbarAction;

	private DeletePageAction deletePageMenuAction;
	private DeleteProjectAction deleteProjectMenuAction;
	private DeleteDocumentAction deleteDocumentMenuAction;

	private DeletePageAction deletePageToolbarAction;
	private DeleteProjectAction deleteProjectToolbarAction;
	private DeleteDocumentAction deleteDocumentToolbarAction;

	private CloseTabAction closeTabMenuAction;
	private CloseAllTabsAction closeAllTabsMenuAction;

	private RenameAction renameMenuAction;

	private CloseTabAction closeTabToolbarAction;
	private CloseAllTabsAction closeAllTabsToolbarAction;

	private RenameAction renameToolbarAction;

	private HelpAboutAction helpAboutAction;

	private SelectAction selectMenuAction;
	private RectangleAction rectangleMenuAction;
	private CircleAction circleMenuAction;
	private TriangleAction triangleMenuACtion;
	private ResizeAction resizeMenuAction;
	private RotateAction rotateMenuAction;
	private DeleteAction deleteMenuAction;
	private MoveAction moveMenuAction;

	private SelectAction selectToolbarAction;
	private RectangleAction rectangleToolbarAction;
	private CircleAction circleToolbarAction;
	private TriangleAction triangleToolbarACtion;
	private ResizeAction resizeToolbarAction;
	private RotateAction rotateToolbarAction;
	private DeleteAction deleteToolbarAction;
	private MoveAction moveToolbarAction;

	private CopyAction copyMenuAction;
	private CutAction cutMenuAction;
	private PasteAction pasteMenuAction;

	private CopyAction copyToolbarAction;
	private CutAction cutToolbarAction;
	private PasteAction pasteToolbarAction;

	private UndoAction undoMenuAction;
	private RedoAction redoMenuAction;

	private UndoAction undoToolbarAction;
	private RedoAction redoToolbarAction;

	public ActionManager() {
		initialiseActions();
	}

	private void initialiseActions() {

		newOpenProjectToolbarAction = new OpenProjectAction(true);
		newSaveToolbarAction = new SaveAction(true);
		newSaveAsToolbarAction = new SaveAsAction(true);
		newChangeWorkspaceToolbarAction = new ChangeWorkspaceAction(true);

		newOpenProjectMenuAction = new OpenProjectAction(false);
		newSaveMenuAction = new SaveAction(false);
		newSaveAsMenuAction = new SaveAsAction(false);
		newChangeWorkspaceMenuAction = new ChangeWorkspaceAction(false);

		newNodeMenuAction = new NewNodeAction(false);

		newNodeToolbarAction = new NewNodeAction(true);

		deletePageMenuAction = new DeletePageAction(false);
		deleteProjectMenuAction = new DeleteProjectAction(false);
		deleteDocumentMenuAction = new DeleteDocumentAction(false);

		deletePageToolbarAction = new DeletePageAction(true);
		deleteProjectToolbarAction = new DeleteProjectAction(true);
		deleteDocumentToolbarAction = new DeleteDocumentAction(true);

		closeTabMenuAction = new CloseTabAction(false);
		closeAllTabsMenuAction = new CloseAllTabsAction(false);

		renameMenuAction = new RenameAction(false);

		closeTabToolbarAction = new CloseTabAction(true);
		closeAllTabsToolbarAction = new CloseAllTabsAction(true);

		renameToolbarAction = new RenameAction(true);

		helpAboutAction = new HelpAboutAction();

		selectMenuAction = new SelectAction(false);
		rectangleMenuAction = new RectangleAction(false);
		circleMenuAction = new CircleAction(false);
		triangleMenuACtion = new TriangleAction(false);
		resizeMenuAction = new ResizeAction(false);
		rotateMenuAction = new RotateAction(false);
		deleteMenuAction = new DeleteAction(false);
		moveToolbarAction = new MoveAction(true);

		selectToolbarAction = new SelectAction(true);
		rectangleToolbarAction = new RectangleAction(true);
		circleToolbarAction = new CircleAction(true);
		triangleToolbarACtion = new TriangleAction(true);
		resizeToolbarAction = new ResizeAction(true);
		rotateToolbarAction = new RotateAction(true);
		deleteToolbarAction = new DeleteAction(true);
		moveToolbarAction = new MoveAction(true);

		copyMenuAction = new CopyAction(false);
		cutMenuAction = new CutAction(false);
		pasteMenuAction = new PasteAction(false);

		copyToolbarAction = new CopyAction(true);
		cutToolbarAction = new CutAction(true);
		pasteToolbarAction = new PasteAction(true);

		undoMenuAction = new UndoAction(false);
		redoMenuAction = new RedoAction(false);

		undoToolbarAction = new UndoAction(true);
		redoToolbarAction = new RedoAction(true);

	}

	public CloseTabAction getCloseTabAction(boolean icon) {
		if (icon) {
			return closeTabToolbarAction;
		} else {
			return closeTabMenuAction;
		}
	}

	public CloseAllTabsAction getCloseAllTabsAction(boolean icon) {
		if (icon) {
			return closeAllTabsToolbarAction;
		} else {
			return closeAllTabsMenuAction;
		}
	}

	public RenameAction getRenameAction(boolean icon) {
		if (icon) {
			return renameToolbarAction;
		} else {
			return renameMenuAction;
		}
	}

	public NewNodeAction getNewNodeAction(boolean icon) {
		if (icon) {
			return newNodeToolbarAction;
		} else {
			return newNodeMenuAction;
		}
	}

	public DeletePageAction getDeletePageAction(boolean icon) {
		if (icon) {
			return deletePageToolbarAction;
		} else {
			return deletePageMenuAction;
		}

	}

	public DeleteProjectAction getDeleteProjectAction(boolean icon) {
		if (icon) {
			return deleteProjectToolbarAction;
		} else {
			return deleteProjectMenuAction;
		}
	}

	public DeleteDocumentAction getDeleteDocumentAction(boolean icon) {
		if (icon) {
			return deleteDocumentToolbarAction;
		} else {
			return deleteDocumentMenuAction;
		}
	}

	public HelpAboutAction getHelpAboutAction() {
		return helpAboutAction;
	}

	public void setHelpAboutAction(HelpAboutAction helpAboutAction) {
		this.helpAboutAction = helpAboutAction;
	}

	public OpenProjectAction getOpenProjectAction(boolean icon) {
		if (icon) {
			return newOpenProjectToolbarAction;
		} else {
			return newOpenProjectMenuAction;
		}
	}

	public SaveAction getSaveAction(boolean icon) {
		if (icon) {
			return newSaveToolbarAction;
		} else {
			return newSaveMenuAction;
		}
	}

	public SaveAsAction getSaveAsAction(boolean icon) {
		if (icon) {
			return newSaveAsToolbarAction;
		} else {
			return newSaveAsMenuAction;
		}
	}

	public ChangeWorkspaceAction getChangeWorkspaceAction(boolean icon) {
		if (icon) {
			return newChangeWorkspaceToolbarAction;
		} else {
			return newChangeWorkspaceMenuAction;
		}
	}

	public RectangleAction getRectangleAction(boolean icon) {
		if (icon) {
			return rectangleToolbarAction;
		} else {
			return rectangleMenuAction;
		}
	}

	public TriangleAction getTriangleAction(boolean icon) {
		if (icon) {
			return triangleToolbarACtion;
		} else {
			return triangleMenuACtion;
		}
	}

	public CircleAction getCircleAction(boolean icon) {
		if (icon) {
			return circleToolbarAction;
		} else {
			return circleMenuAction;
		}
	}

	public ResizeAction getResizeAction(boolean icon) {
		if (icon) {
			return resizeToolbarAction;
		} else {
			return resizeMenuAction;
		}
	}

	public RotateAction getRotateAction(boolean icon) {
		if (icon) {
			return rotateToolbarAction;
		} else {
			return rotateMenuAction;
		}
	}

	public SelectAction getSelectAction(boolean icon) {
		if (icon) {
			return selectToolbarAction;
		} else {
			return selectMenuAction;
		}
	}

	public DeleteAction getDeleteAction(boolean icon) {
		if (icon) {
			return deleteToolbarAction;
		} else {
			return deleteMenuAction;
		}
	}

	public MoveAction getMoveAction(boolean icon) {
		if (icon) {
			return moveToolbarAction;
		} else {
			return moveMenuAction;
		}
	}

	public CopyAction getCopyAction(boolean icon) {
		if (icon) {
			return copyToolbarAction;
		} else {
			return copyMenuAction;
		}
	}

	public CutAction getCutAction(boolean icon) {
		if (icon) {
			return cutToolbarAction;
		} else {
			return cutMenuAction;
		}
	}

	public PasteAction getPasteAction(boolean icon) {
		if (icon) {
			return pasteToolbarAction;
		} else {
			return pasteMenuAction;
		}
	}

	public UndoAction getUndoAction(boolean icon) {
		if (icon) {
			return undoToolbarAction;
		} else {
			return undoMenuAction;
		}
	}

	public RedoAction getRedoAction(boolean icon) {
		if (icon) {
			return redoToolbarAction;
		} else {
			return redoMenuAction;
		}
	}

}
