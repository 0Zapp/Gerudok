package elements;

import java.awt.Color;
import java.awt.Paint;
import java.awt.Stroke;
import java.io.Serializable;

import painters.ElementPainter;

public abstract class PageElement implements Serializable {

	protected Paint paint;
	protected SerializableStrokeAdapter stroke;
	protected Color strokeColor;

	protected String name;
	protected String description;

	protected ElementPainter elementPainter;

	abstract public PageElement clone();

	public PageElement(Stroke stroke, Paint paint, Color strokeColor) {
		this.stroke = new SerializableStrokeAdapter(stroke);
		this.paint = paint;
		this.strokeColor = strokeColor;
		this.name = "";
	}

	public PageElement(PageElement element) {
		this.stroke = element.stroke;
		this.paint = element.paint;
		this.strokeColor = element.strokeColor;
		this.name = element.name;
		this.description = element.description;
		this.elementPainter = element.elementPainter;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setElementPainter(ElementPainter elementPainter) {
		this.elementPainter = elementPainter;
	}

	public ElementPainter getPainter() {
		return elementPainter;
	}

	public Paint getPaint() {
		return paint;
	}

	public void setPaint(Paint paint) {
		this.paint = paint;
	}

	public Stroke getStroke() {
		return (Stroke) stroke;
	}

	public void setStroke(Stroke stroke) {
		this.stroke = (SerializableStrokeAdapter) stroke;
	}

	public String toString() {
		return name;
	}

	public Color getStrokeColor() {
		return strokeColor;
	}

	public void setStrokeColor(Color strokeColor) {
		this.strokeColor = strokeColor;
	}

}
