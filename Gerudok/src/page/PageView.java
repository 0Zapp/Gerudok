package page;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.datatransfer.Transferable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;

import ccp.PageElementsSelection;
import commands.CommandManager;
import document.DocumentView;
import elements.CircleElement;
import elements.PageElement;
import elements.PageShape;
import elements.RectangleElement;
import elements.TriangleElement;
import gui.MainFrame;
import painters.CirclePainter;
import painters.ElementPainter;
import painters.RectanglePainter;
import painters.TrianglePainter;
import project.ProjectView;

public class PageView extends JInternalFrame implements Observer {

	static int openFrameCount = 0;
	private ProjectView projectView;
	private DocumentView documentView;
	private Page page;

	static final int xOffset = 3, yOffset = 3;

	private JPanel framework;

	private CommandManager commandManager = new CommandManager();
	
//	public static final int OR=1;
//	public static final int AND=2;
//	public static final int INPUT=3;
	public static final int CIRCLE=4;
	public static final int RECTANGLE=5;
	public static final int TRIANGLE=6;

	public PageView() {

		super("", true, // resizable
				false, // closable
				true, // maximizable
				true);// iconifiable

		setLocation(xOffset * openFrameCount, yOffset * openFrameCount);
		++openFrameCount;
		setSize(400, 400);
		setVisible(true);

		framework = new Framework();
		framework.setBackground(Color.WHITE);
		getContentPane().add(framework, BorderLayout.CENTER);
		PageController c = new PageController();
		framework.addMouseListener(c);
		framework.addMouseMotionListener(c);

	}

	private class PageController extends MouseAdapter implements MouseMotionListener {

		public void mousePressed(MouseEvent e) {
			page.getStateManager().getCurrentState().mousePressed(e);
		}

		public void mouseReleased(MouseEvent e) {
			page.getStateManager().getCurrentState().mouseReleased(e);
		}

		public void mouseDragged(MouseEvent e) {
			page.getStateManager().getCurrentState().mouseDragged(e);
		}

	}

	public void setProjectView(ProjectView pv) {
		this.projectView = pv;
	}

	public ProjectView getProjectView() {
		return projectView;
	}

	public void setDocumentView(DocumentView dv) {
		this.documentView = dv;
	}

	public DocumentView getDocumentVIew() {
		return documentView;
	}

	public void setPage(Page page) {
		this.page = page;
		this.page.addObserver(this);
	}

	public Page getPage() {
		return page;
	}

	@Override
	public void update(Observable o, Object arg) {

		Page temp = (Page) o;
		if (!temp.isVisible()) {
			this.documentView.removePageView(this);
		}
		MainFrame.getInstance().changeProjectView(projectView);
	}

	private class Framework extends JPanel {
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			Graphics2D g2 = (Graphics2D) g;
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f));

			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			AffineTransform old = g2.getTransform();
			Iterator<PageElement> it = page.getElementIterator();
			while (it.hasNext()) {
				PageShape element = (PageShape) it.next();
				ElementPainter painter = null;
				g2.rotate(Math.toRadians(element.getAngle()));
				if (MainFrame.getInstance().isElementSelected(element)) {
					paintSelectionHandles(g2);
				}
				if (element instanceof RectangleElement) {
					painter = new RectanglePainter(element);

				} else if (element instanceof CircleElement) {
					painter = new CirclePainter(element);

				} else if (element instanceof TriangleElement) {
					painter = new TrianglePainter(element);
				}
				painter.paint(g2, element);
//				g2.setTransform(old);
			}
//			}

		}

	}

	/**
	 * Handlovi za selekciju su identifikovani stranama sveta.
	 *
	 *
	 */
	public enum Handle {
		North, South, East, West, SouthEast, SouthWest, NorthEast, NorthWest
	}

	static final int handleSize = 10;

	/**
	 * Iscrtavanje selekcionih hendlova oko selektovanog elementa Velicina hendlova
	 * ne sme da zavisi od tekuceg skaliranja
	 */
	public void paintSelectionHandles(Graphics2D g2) {

		ArrayList<PageElement> selectedElements = MainFrame.getInstance().getSelectedPageElements();
		for (PageElement selectedElement : selectedElements) {
			if (selectedElement != null && selectedElement instanceof PageShape) {
				PageShape device = (PageShape) selectedElement;
				// Iscrtavanje pravougaonika sa isprekidanom linijom
				g2.setStroke(new BasicStroke((float) 1, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL, 1f,
						new float[] { 3f, 6f }, 0));
				g2.setPaint(Color.BLACK);

				g2.drawRect((int) device.getPosition().getX(), (int) device.getPosition().getY(),
						(int) device.getSize().getWidth(), (int) device.getSize().getHeight());

				// Iscrtavanje hendlova
				for (Handle e : Handle.values()) {
					paintSelectionHandle(g2, getHandlePoint(device.getPosition(), device.getSize(), e));
				}

			}
		}
	}

	private void paintSelectionHandle(Graphics2D g2, Point2D position) {
		double size = handleSize;
		g2.fill(new Rectangle2D.Double(position.getX() - size / 2, position.getY() - size / 2, size, size));
	}

	private Point2D getHandlePoint(Point2D topLeft, Dimension2D size, Handle handlePosition) {
		double x = 0, y = 0;

		// Doreivanje y koordinate

		// Ako su gornji hendlovi
		if (handlePosition == Handle.NorthWest || handlePosition == Handle.North
				|| handlePosition == Handle.NorthEast) {
			y = topLeft.getY();
		}
		// Ako su centralni po y osi
		if (handlePosition == Handle.East || handlePosition == Handle.West) {
			y = topLeft.getY() + size.getHeight() / 2;
		}
		// Ako su donji
		if (handlePosition == Handle.SouthWest || handlePosition == Handle.South
				|| handlePosition == Handle.SouthEast) {
			y = topLeft.getY() + size.getHeight();
		}

		// Odreivanje x koordinate

		// Ako su levi
		if (handlePosition == Handle.NorthWest || handlePosition == Handle.West || handlePosition == Handle.SouthWest) {
			x = topLeft.getX();
		}
		// ako su centralni po x osi
		if (handlePosition == Handle.North || handlePosition == Handle.South) {
			x = topLeft.getX() + size.getWidth() / 2;
		}
		// ako su desni
		if (handlePosition == Handle.NorthEast || handlePosition == Handle.East || handlePosition == Handle.SouthEast) {
			x = topLeft.getX() + size.getWidth();
		}

		return new Point2D.Double(x, y);

	}

	/**
	 * Na osnovu hendla iznad koga se nalazi postavlja kursor
	 */
	public void setMouseCursor(Point2D point) {

		Handle handle = getDeviceAndHandleForPoint(point);

		if (handle != null) {
			Cursor cursor = null;

			switch (handle) {
			case North:
				cursor = Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR);
				break;
			case South:
				cursor = Cursor.getPredefinedCursor(Cursor.S_RESIZE_CURSOR);
				break;
			case East:
				cursor = Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR);
				break;
			case West:
				cursor = Cursor.getPredefinedCursor(Cursor.W_RESIZE_CURSOR);
				break;
			case SouthEast:
				cursor = Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR);
				break;
			case NorthWest:
				cursor = Cursor.getPredefinedCursor(Cursor.NW_RESIZE_CURSOR);
				break;
			case SouthWest:
				cursor = Cursor.getPredefinedCursor(Cursor.SW_RESIZE_CURSOR);
				break;
			case NorthEast:
				cursor = Cursor.getPredefinedCursor(Cursor.NE_RESIZE_CURSOR);
				break;
			}
			framework.setCursor(cursor);
		} else
			framework.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	/**
	 * Odreuje handl i ureaj koji se nalazi na zadatoj lokaciji
	 * 
	 * @param point Ulazni parametar koji odruje lokaciju
	 * @return Hendl za zadatu poziciju. Ukoliko je null tada je device nedefinisan.
	 */
	public Handle getDeviceAndHandleForPoint(Point2D point) {

		ArrayList<PageElement> selectedElements = MainFrame.getInstance().getSelectedPageElements();
		if (!selectedElements.isEmpty()) {
			return getHandleForPoint(selectedElements, point);
		}
		return null;
	}

	/**
	 * Za zadatu taku i ureaj vra hendl.
	 * 
	 * @param device
	 * @param point
	 * @return Hendl ukoliko je "pogoen", u suprotnom vra null
	 */
	private Handle getHandleForPoint(ArrayList<PageElement> selectedElements, Point2D point) {

		for (PageElement selectedElement : selectedElements) {
			for (Handle h : Handle.values()) {
				if (isPointInHandle(selectedElement, point, h)) {
					return h;
				}
			}

		}
		return null;
	}

	/**
	 * Za zadati ureaj, taku i hendl odreuje da li je taka unutar hendla
	 * 
	 * @param device
	 * @param point
	 * @param handle
	 * @return
	 */
	private boolean isPointInHandle(PageElement element, Point2D point, Handle handle) {
		if (element instanceof PageElement) {
			PageElement device = (PageElement) element;
			Point2D handleCenter = getHandlePoint(((PageShape) device).getPosition(), ((PageShape) device).getSize(),
					handle);
			return ((Math.abs(point.getX() - handleCenter.getX()) <= (double) handleSize / 2)
					&& (Math.abs(point.getY() - handleCenter.getY()) <= (double) handleSize / 2));
		} else
			return false;
	}

	public void paste() {
		Transferable clipboardContent = MainFrame.getInstance().getClipboard().getContents(MainFrame.getInstance());
		if ((clipboardContent != null)
				&& (clipboardContent.isDataFlavorSupported(PageElementsSelection.elementFlavor))) {
			try {
				PageShape device = null;
				ArrayList<PageElement> tempElements = (ArrayList<PageElement>) clipboardContent
						.getTransferData(PageElementsSelection.elementFlavor);
				for (int i = 0; i < tempElements.size(); i++) {

					if (tempElements.get(i) instanceof PageShape) {
						device = (PageShape) tempElements.get(i).clone();
						Point2D newLocation = (Point2D) device.getPosition().clone();
						newLocation.setLocation(device.getPosition().getX() + 40, device.getPosition().getY() + 40);
						device.setPosition(newLocation);

						if (device instanceof CircleElement) {
							device.setElementPainter(new CirclePainter(device));
						} else if (device instanceof RectangleElement) {
							device.setElementPainter(new RectanglePainter(device));
						} else if (device instanceof TriangleElement) {
							device.setElementPainter(new TrianglePainter(device));

							page.addDiagramElements(device);

						}
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();

			}

		}

	}

	public CommandManager getCommandManager() {
		return commandManager;
	}
}