package painters;

import java.awt.Graphics2D;
import java.awt.Point;
import java.io.Serializable;

import elements.PageElement;

public abstract class ElementPainter implements Serializable {

	public ElementPainter(PageElement element) {

	}

	public abstract void paint(Graphics2D g, PageElement element);

	public abstract boolean isElementAt(Point pos);

}
