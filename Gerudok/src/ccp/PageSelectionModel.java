package ccp;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.DefaultSingleSelectionModel;
import javax.swing.event.EventListenerList;

import elements.PageElement;
import elements.PageShape;

public class PageSelectionModel extends DefaultSingleSelectionModel {

	/**
	 * Lista sa elementima koji su selektovani.
	 */
	private ArrayList<PageElement> selectionList = new ArrayList<PageElement>();

	transient EventListenerList listenerList = new EventListenerList();
//	UpdateEvent updateEvent = null;	

	/**
	 * Metoda dodaje element u listu selekcije.
	 * 
	 */
	public void addToSelectionList(PageElement element) {
		selectionList.add(element);
		fireUpdatePerformed();
	}

	/**
	 * Metoda dodaje listu elemenata u selekcionu listu.
	 */
	public void addToSelectionList(ArrayList<PageElement> list) {
		selectionList.addAll(list);
		fireUpdatePerformed();
	}

	/**
	 * Vraca broj elemenata u selekcionoj listi.
	 */
	public int getSelectionListSize() {
		return selectionList.size();
	}

	/**
	 * Vraca element iz selekcione liste koji se nalazi na indeksu koji se navodi
	 * kao argument.
	 */
	public PageElement getElementFromSelectionListAt(int index) {
		return (PageElement) selectionList.get(index);
	}

	/**
	 * Vraca indeks zadatog elementa u selekcionoj listi.
	 * 
	 * @param element - element za koji se trazi indeks u listi
	 * @return - indeks elementa u listi ili -1
	 * 
	 */
	public int getIndexByObject(PageElement element) {
		return selectionList.indexOf(element);
	}

	/**
	 * Uklanja element iz selekcione liste na datom indeksu.
	 * 
	 * @param index - indeks elementa koji se uklanja iz selekcione liste.
	 */
	public void removeFromSelectionList(PageElement element) {
		selectionList.remove(element);
		fireUpdatePerformed();
	}

	/**
	 * Uklanja sve elemente iz selekcione liste.
	 */
	public void removeAllFromSelectionList() {
		selectionList.clear();
		fireUpdatePerformed();
	}

	/**
	 * Vraca objekat selekcione liste.
	 * 
	 * @return - objekat selekcione liste
	 * 
	 */
	public ArrayList<PageElement> getSelectionList() {
		return selectionList;
	}

	public Iterator<PageElement> getSelectionListIterator() {
		return selectionList.iterator();
	}

	public boolean isElementSelected(PageElement element) {
		return selectionList.contains(element);

	}

	/**
	 * Metoda selektuje sve elemente koji se seku ili su obuhvaceni pravougaonikom
	 * 
	 * @param rec      - selekcioni pravougaonik
	 * @param elements - niz elemenata iz modela
	 * 
	 */
	public void selectElements(Rectangle2D rec, ArrayList<PageElement> elements) {
		Iterator<PageElement> it = elements.iterator();
		while (it.hasNext()) {
			PageElement element = it.next();
			if (element instanceof PageShape) {
				PageShape device = (PageShape) element;
				if (rec.intersects(device.getPosition().getX(), device.getPosition().getY(),
						device.getSize().getWidth(), device.getSize().getHeight())) {
					if (!isElementSelected(device))
						selectionList.add(device);
				}
			}
		}
	}

	public ArrayList<PageElement> getSelected() {
		ArrayList<PageElement> selected = new ArrayList<PageElement>();
		selected.addAll(selectionList);

		return selected;
	}

//	 public void addUpdateListener(UpdateListener l) {
//	     listenerList.add(UpdateListener.class, l);
//	 }
//
//	 public void removeUpdateListener(UpdateListener l) {
//	     listenerList.remove(UpdateListener.class, l);
//	 }
//	 
	/**
	 * Javljamo svim listenerima da se dogaðaj desio
	 */
	public void fireUpdatePerformed() {
//		     Object[] listeners = listenerList.getListenerList();
//		     for (int i = listeners.length-2; i>=0; i-=2) {
//		         if (listeners[i]==UpdateListener.class) {
//		             if (updateEvent == null)
//		                 updateEvent = new UpdateEvent(this);
//		             ((UpdateListener)listeners[i+1]).updatePerformed(updateEvent);
//		         }
//		     }
	}

}
