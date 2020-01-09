package state;

import java.awt.Point;
import java.awt.event.MouseEvent;

import elements.CircleElement;
import elements.PageShape;
import gui.MainFrame;
import page.Page;

public class CircleState extends State {

	private Page mediator;

	public CircleState(Page mediator) {
		this.mediator = mediator;
	}

	public void mousePressed(MouseEvent e) {
		MainFrame.getInstance().setSelectedPage(mediator);
		Point position = e.getPoint();
		if (e.getButton() == MouseEvent.BUTTON1) {
			if (mediator.getElementAtPosition(position) == -1) {
				PageShape shape = CircleElement.createDefault(position, mediator.getPageElementsCount());
				mediator.addDiagramElements(shape);
			}
		}
	}
}
