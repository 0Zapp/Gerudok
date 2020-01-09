package elements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.geom.Point2D;

public abstract class PageShape extends PageElement {

	protected Dimension size;
	protected Point2D position;
	protected int angle;

	public int getAngle() {
		return angle;
	}

	public void setAngle(int angle) {
		this.angle = angle;
	}

	public PageShape(Point2D position, Dimension size, Stroke stroke, Paint paint, Color strokeColor) {
		super(stroke, paint, strokeColor);
		this.size = size;
		position.setLocation(position.getX() - size.getWidth() / 2, position.getY() - size.getHeight() / 2);
		this.position = position;
		angle = 0;
	}

	public PageShape(PageShape shape) {
		super(shape);
		this.size=shape.size;
		this.angle=shape.angle;
		this.position=shape.position;
	}

	public Point2D getPosition() {
		return position;
	}

	public void setPosition(Point2D position) {
		this.position = position;
	}

	public Dimension getSize() {
		return size;
	}

	public void setSize(Dimension size) {
		this.size = size;
	}

}
