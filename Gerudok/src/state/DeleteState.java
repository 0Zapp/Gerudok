package state;

import java.awt.Point;
import java.awt.event.MouseEvent;

import elements.PageElement;
import gui.MainFrame;
import page.Page;

public class DeleteState extends State {

	private Page mediator;

	public DeleteState(Page mediator) {
		this.mediator = mediator;
	}

	public void mousePressed(MouseEvent e) {

		MainFrame.getInstance().setSelectedPage(mediator);
		Point position = e.getPoint();
		if (e.getButton() == MouseEvent.BUTTON1) {
			if (mediator.getElementAtPosition(position) != -1) {
				PageElement element = mediator.getElementAt(mediator.getElementAtPosition(position));
				mediator.removeElement(element);
				for (PageElement pe : MainFrame.getInstance().getSelectedPageElements()) {
					mediator.removeElement(pe);
				}
				MainFrame.getInstance().removeSelectedPageElements();

			}
			mediator.startSelectState();
			mediator.doNothing();
		}
	}
}
