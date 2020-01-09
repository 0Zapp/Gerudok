package state;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import elements.PageElement;
import elements.PageShape;
import gui.MainFrame;
import page.Page;

public class MoveState extends State {

	private Page mediator;
	private Point startingPosition;
	private ArrayList<PageElement> originalElements;

	public MoveState(Page mediator) {
		this.mediator = mediator;
	}

	public void mousePressed(MouseEvent e) {
		MainFrame.getInstance().setSelectedPage(mediator);

		Point position = e.getPoint();
		startingPosition = position;
		System.out.println(startingPosition);
		originalElements = MainFrame.getInstance().getSelectedPageElements();
	}

	public void mouseDragged(MouseEvent e) {

		ArrayList<PageElement> elements = MainFrame.getInstance().getSelectedPageElements();
		Point position = e.getPoint();
		int deltaY = (int) (position.y - startingPosition.y);
		int deltaX = (int) (position.x - startingPosition.x);
		System.out.println(deltaX + ", " + deltaY);
		for (PageElement el : elements) {

			Point newPosition = new Point();
			PageShape element = (PageShape) el;
			newPosition.setLocation(element.getPosition().getX() + deltaX, element.getPosition().getY() + deltaY);
			element.setPosition(newPosition);

		}
		mediator.doNothing();
		startingPosition = position;
	}
}
