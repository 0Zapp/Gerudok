package gui;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

public class MyPalette extends JToolBar {
	public MyPalette() {
		super(JToolBar.VERTICAL);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		ButtonGroup group = new ButtonGroup();

		JToggleButton btn1 = new JToggleButton(MainFrame.getInstance().getActionManager().getSelectAction(true));
		group.add(btn1);
		add(btn1);

		JToggleButton btn2 = new JToggleButton(MainFrame.getInstance().getActionManager().getRectangleAction(true));
		group.add(btn2);
		add(btn2);

		JToggleButton btn3 = new JToggleButton(MainFrame.getInstance().getActionManager().getCircleAction(true));
		group.add(btn3);
		add(btn3);

		JToggleButton btn4 = new JToggleButton(MainFrame.getInstance().getActionManager().getTriangleAction(true));
		group.add(btn4);
		add(btn4);

		JToggleButton btn5 = new JToggleButton(MainFrame.getInstance().getActionManager().getResizeAction(true));
		group.add(btn5);
		add(btn5);

		JToggleButton btn6 = new JToggleButton(MainFrame.getInstance().getActionManager().getRotateAction(true));
		group.add(btn6);
		add(btn6);

		JToggleButton btn7 = new JToggleButton(MainFrame.getInstance().getActionManager().getDeleteAction(true));
		group.add(btn7);
		add(btn7);

		JToggleButton btn8 = new JToggleButton(MainFrame.getInstance().getActionManager().getMoveAction(true));
		group.add(btn8);
		add(btn8);

	}
}
