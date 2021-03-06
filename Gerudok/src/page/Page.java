package page;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Observable;

import javax.swing.tree.TreeNode;

import ccp.PageSelectionModel;
import elements.PageElement;
import elements.PageShape;
import factory.ObservableNode;
import state.StateManager;

public class Page extends ObservableNode {
	private transient StateManager stateManager;

	protected ArrayList<PageElement> pageElements = new ArrayList<>();
	private PageSelectionModel selectionModel;

	public Page(String name) {
		super(name);
		stateManager = new StateManager(this);
	}

	public void initializeStateManager() {
		stateManager = new StateManager(this);
	}

	public void startCircleState() {
		stateManager.setCircleState();
	}

	public void startSelectState() {
		stateManager.setSelectState();
	}

	public void startTriangleState() {
		stateManager.setTriangleState();
	}

	public void startRotateState() {
		stateManager.setRotateState();
	}

	public void startResizeState() {
		stateManager.setResizeState();
	}

	public void startRectangleState() {
		stateManager.setRectangleState();
	}

	public void startDeleteState() {
		stateManager.setDeleteState();

	}

	public void startMoveState() {
		stateManager.setMoveState();

	}

	public StateManager getStateManager() {
		return stateManager;
	}

	@Override
	public boolean isLeaf() {
		return true;
	}

	public int getElementAtPosition(Point point) {
		for (int i = getPageElementsCount() - 1; i >= 0; i--) {
			PageElement device = getElementAt(i);
			if (device.getPainter().isElementAt(point)) {
				return i;
			}
		}
		return -1;
	}

	public int getPageElementsCount() {
		return pageElements.size();
	}

	public PageElement getElementAt(int i) {
		return pageElements.get(i);
	}

	public void addDiagramElements(PageShape shape) {
		pageElements.add(shape);
		setChanged();
		notifyObservers(shape);
	}

	public void addChild(ObservableNode node) {
		return;
	}

	public Iterator<PageElement> getElementIterator() {
		return pageElements.iterator();
	}

	public void removeElement(PageElement element) {
		pageElements.remove(element);

	}

	public PageSelectionModel getSelectionModel() {
		if (selectionModel == null)
			selectionModel = new PageSelectionModel();
		return selectionModel;
	}

	public void addPageElement(PageElement element) {
		pageElements.add(element);
		setChanged();
		notifyObservers();

	}

}
