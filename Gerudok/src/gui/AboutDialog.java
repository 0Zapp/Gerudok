package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class AboutDialog extends JDialog {

	public AboutDialog(Frame parent, String title, boolean modal) {

		super(parent, title, modal);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;

		setSize((screenWidth / 10) * 4, (screenHeight / 10) * 4);
		setLocationRelativeTo(null);

		try {

			BufferedImage myPicture1;
			myPicture1 = ImageIO.read(new File("images/Mihajlo.jpeg"));

			JLabel picLabel1 = new JLabel(new ImageIcon(myPicture1));
			JLabel lbl1 = new JLabel("Mihajlo Krsmanovic RN17-2018", SwingConstants.CENTER);

			BufferedImage myPicture2;
			myPicture2 = ImageIO.read(new File("images/Marko.jpeg"));

			JLabel picLabel2 = new JLabel(new ImageIcon(myPicture2));
			JLabel lbl2 = new JLabel("Marko Nedeljkovic RN20-2018", SwingConstants.CENTER);

			JPanel leftBorder = new JPanel();
			leftBorder.setLayout(new BorderLayout());

			leftBorder.add(picLabel1, BorderLayout.CENTER);
			leftBorder.add(lbl1, BorderLayout.SOUTH);

			JPanel rightBorder = new JPanel();
			rightBorder.setLayout(new BorderLayout());

			rightBorder.add(picLabel2, BorderLayout.CENTER);
			rightBorder.add(lbl2, BorderLayout.SOUTH);

			JPanel pane = new JPanel();
			pane.setLayout(new GridLayout(1, 2));
			pane.add(leftBorder);
			pane.add(rightBorder);

			add(pane, BorderLayout.CENTER);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
