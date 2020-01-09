package state;

import page.Page;

public class StateManager {

	private State currentState;

	SelectState selectState;
	CircleState circleState;
	ResizeState resizeState;
	RotateState rotateState;
	TriangleState triangleState;
	RectangleState rectangleState;
	DeleteState deleteState;
	MoveState moveState;

	public StateManager(Page mediator) {

		selectState = new SelectState(mediator);
		circleState = new CircleState(mediator);
		resizeState = new ResizeState(mediator);
		rotateState = new RotateState(mediator);
		triangleState = new TriangleState(mediator);
		rectangleState = new RectangleState(mediator);
		deleteState = new DeleteState(mediator);
		moveState = new MoveState(mediator);

		currentState = selectState;
	}

	public void setCircleState() {
		currentState = circleState;
	}

	public void setSelectState() {
		currentState = selectState;
	}

	public void setResizeState() {
		currentState = resizeState;
	}

	public void setRotateState() {
		currentState = rotateState;
	}

	public void setTriangleState() {
		currentState = triangleState;
	}

	public void setRectangleState() {
		currentState = rectangleState;
	}

	public void setDeleteState() {
		currentState = deleteState;
	}

	public void setMoveState() {
		currentState = moveState;
	}

	public State getCurrentState() {
		return currentState;
	}
}
