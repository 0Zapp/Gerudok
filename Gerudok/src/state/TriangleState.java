package state;

import java.awt.Point;
import java.awt.event.MouseEvent;

import elements.PageShape;
import elements.RectangleElement;
import elements.TriangleElement;
import page.Page;

public class TriangleState extends State {

	private Page mediator;

	public TriangleState(Page mediator) {
		this.mediator = mediator;
	}

	public void mousePressed(MouseEvent e) {

		Point position = e.getPoint();
		if (e.getButton() == MouseEvent.BUTTON1) {
			if (mediator.getElementAtPosition(position) == -1) {
				PageShape shape = TriangleElement.createDefault(position, mediator.getPageElementsCount());
				mediator.addDiagramElements(shape);
			}

		}
	}

}
