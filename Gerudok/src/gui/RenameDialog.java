package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import document.Document;
import page.Page;
import project.Project;

public class RenameDialog extends JDialog implements ActionListener {

	Object obj;
	JTextField tField;

	public RenameDialog(Frame parent, String title, boolean modal, Object o) {

		super(parent, title, modal);

		setLayout(new BorderLayout());

		setSize(250, 110);
		setLocationRelativeTo(parent);
		setResizable(false);

		JLabel lbl = new JLabel("Rename selected item:");
		tField = new JTextField("test");

		obj = o;

		if (obj instanceof Project) {
			tField.setText(((Project) obj).getName());
		} else if (obj instanceof Document) {
			tField.setText(((Document) obj).getName());
		} else if (obj instanceof Page) {
			tField.setText(((Page) obj).getName());
		}

		JPanel panCommands = new JPanel(new FlowLayout(FlowLayout.RIGHT));

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(this);

		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(this);

		panCommands.add(btnOk);
		panCommands.add(btnCancel);

		add(lbl, BorderLayout.NORTH);
		add(tField, BorderLayout.CENTER);
		add(panCommands, BorderLayout.SOUTH);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand().equals("OK")) {
			if (obj instanceof Project) {
				((Project) obj).setName(tField.getText());
			} else if (obj instanceof Document) {
				((Document) obj).setName(tField.getText());
			} else if (obj instanceof Page) {
				((Page) obj).setName(tField.getText());
			}
			setVisible(false); // you can't see me!
			dispose(); // Destroy the object
		} else {
			setVisible(false); // you can't see me!
			dispose(); // Destroy the object
		}

	}

}