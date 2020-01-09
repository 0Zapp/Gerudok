package state;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import elements.CircleElement;
import elements.PageElement;
import elements.PageShape;
import elements.RectangleElement;
import elements.TriangleElement;
import gui.MainFrame;
import page.Page;
import page.PageView;
import page.PageView.Handle;
import painters.ElementPainter;

public class ResizeState extends State {

	private Point startingPosition;
	private Page mediator;
	private Handle h;

	public ResizeState(Page mediator) {
		this.mediator = mediator;
	}

	public void mousePressed(MouseEvent e) {
		MainFrame.getInstance().setSelectedPage(mediator);

		Point position = e.getPoint();
		startingPosition = position;
		PageView selectedPageView = MainFrame.getInstance().getSelectedPageView();
		h = selectedPageView.getDeviceAndHandleForPoint(position);
		System.out.println(h);
	}

	public void mouseDragged(MouseEvent e) {
		Point position = e.getPoint();
		ArrayList<PageElement> elements = MainFrame.getInstance().getSelectedPageElements();
		for (PageElement el : elements) {
			PageShape element = (PageShape) el;
			if (element == null || h == null) {

			} else {
				int deltaY = (int) (position.y - element.getPosition().getY());
				int deltaX = (int) (position.x - element.getPosition().getX());
				Dimension newDim = new Dimension();
				switch (h) {
				case North:
					deltaY = (int) (-position.y + element.getPosition().getY());
					newDim.setSize(element.getSize().getWidth(), deltaY + element.getSize().height);
					element.setSize(newDim);
					position.setLocation(element.getPosition().getX(), position.y);
					element.setPosition(position);
					break;
				case South:
					newDim.setSize(element.getSize().getWidth(), deltaY);
					element.setSize(newDim);
					break;
				case East:
					newDim.setSize(deltaX, element.getSize().getHeight());
					element.setSize(newDim);
					break;
				case West:
					deltaX = (int) (-position.x + element.getPosition().getX());
					newDim.setSize(deltaX + element.getSize().width, element.getSize().height);
					element.setSize(newDim);
					position.setLocation(position.x, element.getPosition().getY());
					element.setPosition(position);
					break;
				case SouthEast:
					newDim.setSize(deltaX, deltaY);
					element.setSize(newDim);
					break;
				case SouthWest:
					deltaX = (int) (-position.x + element.getPosition().getX());
					newDim.setSize(deltaX + element.getSize().width, position.y - element.getPosition().getY());
					element.setSize(newDim);
					position.setLocation(position.x, element.getPosition().getY());
					element.setPosition(position);
					break;
				case NorthEast:
					deltaY = (int) (-position.y + element.getPosition().getY());
					newDim.setSize(position.x - element.getPosition().getX(), deltaY + element.getSize().height);
					element.setSize(newDim);
					position.setLocation(element.getPosition().getX(), position.y);
					element.setPosition(position);
					break;
				case NorthWest:
					deltaY = (int) (-position.y + element.getPosition().getY());
					deltaX = (int) (-position.x + element.getPosition().getX());
					newDim.setSize(deltaX + element.getSize().width, deltaY + element.getSize().height);
					element.setSize(newDim);
					element.setPosition(position);
					break;
				}
				mediator.doNothing();
			}
		}
	}

}
