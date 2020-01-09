package commands;

import java.awt.geom.Point2D;

import ccp.PageSelectionModel;
import elements.CircleElement;
import elements.PageElement;
import elements.RectangleElement;
import elements.TriangleElement;
import page.Page;
import page.PageView;

public class AddDeviceCommand extends AbstractCommand {

	Page model;
	Point2D lastPosition;
	PageElement device = null;
	PageSelectionModel selectionModel;
	int deviceType;

	public AddDeviceCommand(Page model, PageSelectionModel selectionModel, Point2D lastPosition, int deviceType) {
		this.model = model;
		this.lastPosition = lastPosition;
		this.selectionModel = selectionModel;
		this.deviceType = deviceType;

	}

	@Override
	public void doCommand() {
		if (device == null)
			if (deviceType == PageView.CIRCLE) {
				device = CircleElement.createDefault(lastPosition, model.getPageElementsCount());
			} else if (deviceType == PageView.RECTANGLE) {
				device = RectangleElement.createDefault(lastPosition, model.getPageElementsCount());
			} else if (deviceType == PageView.TRIANGLE) {
				device = TriangleElement.createDefault(lastPosition, model.getPageElementsCount());
			}

		selectionModel.removeAllFromSelectionList();
		model.addPageElement(device);
		selectionModel.addToSelectionList(device);

	}

	@Override
	public void undoCommand() {
		selectionModel.removeAllFromSelectionList();
		model.removeElement(device);

	}

}
