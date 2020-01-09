package painters;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.util.Iterator;

import elements.PageElement;
import elements.PageShape;

public class ShapePainter extends ElementPainter {

	protected Shape shape;

	public ShapePainter(PageElement element) {
		super(element);
	}

	@Override
	public void paint(Graphics2D g, PageElement element) {

		if (element instanceof PageShape) {

			PageShape device = (PageShape) element;

			g.setPaint(Color.BLACK);
			g.drawString(device.getName(), (int) device.getPosition().getX() + 10,
					(int) device.getPosition().getY() + (int) device.getSize().getHeight() / 2);
		}

		// ovaj deo iscrtava element i linkove

		g.setPaint(element.getStrokeColor());
		g.setStroke(element.getStroke());
		g.draw(getShape());

		g.setPaint(element.getPaint());
		g.fill(getShape());

	}

	public boolean isElementAt(Point pos) {
		return getShape().contains(pos);
	}

	public Shape getShape() {
		return shape;
	}

	public void setShape(Shape shape) {
		this.shape = shape;
	}

}
