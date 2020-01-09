package errors;

import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ErrorHandler {

	public static void handle(String error, Object arg) {
		if (error.equals("startFrameInvalidName")) {
			JOptionPane.showMessageDialog((Component) arg, "Please select a valid workspace");
		}
	}

}
