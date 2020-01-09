package painters;

import java.awt.geom.GeneralPath;

import elements.PageElement;
import elements.TriangleElement;

public class TrianglePainter extends ShapePainter {

	public TrianglePainter(PageElement element) {
		super(element);
		TriangleElement triangle = (TriangleElement) element;

		shape = new GeneralPath();
		((GeneralPath) shape).moveTo(triangle.getPosition().getX() + triangle.getSize().width / 2,
				triangle.getPosition().getY());

//		((GeneralPath) shape).lineTo(triangle.getPosition().getX() + triangle.getSize().width,
//				triangle.getPosition().getY());

		((GeneralPath) shape).lineTo(triangle.getPosition().getX() + triangle.getSize().width,
				triangle.getPosition().getY() + triangle.getSize().height);

		((GeneralPath) shape).lineTo(triangle.getPosition().getX(),
				triangle.getPosition().getY() + triangle.getSize().height);

		((GeneralPath) shape).closePath();

	}

}
