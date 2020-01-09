package painters;

import java.awt.geom.GeneralPath;

import elements.PageElement;
import elements.RectangleElement;

public class RectanglePainter extends ShapePainter {

	public RectanglePainter(PageElement element) {
		super(element);
		RectangleElement rectangle = (RectangleElement) element;

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(rectangle.getPosition().getX(), rectangle.getPosition().getY());

		((GeneralPath) shape).lineTo(rectangle.getPosition().getX() + rectangle.getSize().width,
				rectangle.getPosition().getY());

		((GeneralPath) shape).lineTo(rectangle.getPosition().getX() + rectangle.getSize().width,
				rectangle.getPosition().getY() + rectangle.getSize().height);

		((GeneralPath) shape).lineTo(rectangle.getPosition().getX(),
				rectangle.getPosition().getY() + rectangle.getSize().height);

		((GeneralPath) shape).closePath();

	}

}
