package elements;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.geom.Point2D;

import painters.CirclePainter;
import painters.RectanglePainter;

public class RectangleElement extends PageShape {

	public RectangleElement(Point2D position, Dimension size, Stroke stroke, Paint paint, Color strokeColor) {
		super(position, size, stroke, paint, strokeColor);
		elementPainter = new RectanglePainter(this);
	}

	public RectangleElement(RectangleElement rectangle){
		super(rectangle);
		setName("kopija");
		elementPainter=new RectanglePainter(this);
	}
	
	public static PageShape createDefault(Point2D pos, int elemNo) {
		Point2D position = (Point2D) pos.clone();

		Paint fill = Color.WHITE;
		RectangleElement rectangleElement = new RectangleElement(position, new Dimension(80, 40),
				new BasicStroke((float) (2), BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL), fill, Color.BLACK);
//		rectangleElement.setName("R-" + elemNo);
		return rectangleElement;
	}

	@Override
	public PageElement clone() {
		// TODO Auto-generated method stub
		return new RectangleElement(this);
	}

}
