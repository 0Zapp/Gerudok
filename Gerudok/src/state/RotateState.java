package state;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import elements.PageElement;
import elements.PageShape;
import gui.MainFrame;
import page.Page;
import page.PageView;
import page.PageView.Handle;

public class RotateState extends State {

	private Point startingPosition;
	private Page mediator;
	private Handle h;
	private ArrayList<PageElement> elements;

	public RotateState(Page mediator) {
		this.mediator = mediator;
	}

	public void mousePressed(MouseEvent e) {
		MainFrame.getInstance().setSelectedPage(mediator);
		Point position = e.getPoint();
		startingPosition = position;
		PageView selectedPageView = MainFrame.getInstance().getSelectedPageView();
		h = selectedPageView.getDeviceAndHandleForPoint(position);
		elements = MainFrame.getInstance().getSelectedPageElements();

	}

	public void mouseDragged(MouseEvent e) {
		Point position = e.getPoint();

		if (!elements.isEmpty() || h == null) {

		} else {
//			element.setAngle(startingAngle + 1);
//			element.setAngle(element.getAngle() + 1);

		}
		mediator.doNothing();
	}

}
