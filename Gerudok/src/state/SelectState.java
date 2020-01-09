package state;

import java.awt.Point;
import java.awt.event.MouseEvent;

import elements.PageElement;
import elements.PageShape;
import gui.MainFrame;
import page.Page;

public class SelectState extends State {

	private Page mediator;

	public SelectState(Page mediator) {
		this.mediator = mediator;
	}

	public void mousePressed(MouseEvent e) {
		if (e.isControlDown()) {
			MainFrame.getInstance().setSelectedPage(mediator);
			Point position = e.getPoint();
			if (e.getButton() == MouseEvent.BUTTON1) {
				if (mediator.getElementAtPosition(position) != -1) {
					PageElement element = mediator.getElementAt(mediator.getElementAtPosition(position));
					MainFrame.getInstance().addSelectedPageElement(element);
					mediator.getSelectionModel().addToSelectionList(element);
					mediator.doNothing();
				}
			}
		} else {
			MainFrame.getInstance().setSelectedPage(mediator);
			Point position = e.getPoint();
			if (e.getButton() == MouseEvent.BUTTON1) {
				MainFrame.getInstance().removeSelectedPageElements();
				mediator.getSelectionModel().removeAllFromSelectionList();
				if (mediator.getElementAtPosition(position) != -1) {
					PageElement element = mediator.getElementAt(mediator.getElementAtPosition(position));
					MainFrame.getInstance().addSelectedPageElement(element);
					mediator.getSelectionModel().addToSelectionList(element);
				}
				mediator.doNothing();
			}
		}
	}
}
