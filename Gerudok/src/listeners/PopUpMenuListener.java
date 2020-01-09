package listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import gui.MyPopUpMenu;

public class PopUpMenuListener extends MouseAdapter {
	public void mousePressed(MouseEvent e) {
		if (e.isPopupTrigger())
			doPop(e);
	}

	public void mouseReleased(MouseEvent e) {
		if (e.isPopupTrigger())
			doPop(e);
	}

	private void doPop(MouseEvent e) {
		MyPopUpMenu menu = new MyPopUpMenu();
		menu.show(e.getComponent(), e.getX(), e.getY());
	}
}
