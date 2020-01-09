package actions;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import document.Document;
import gui.MainFrame;
import gui.RenameDialog;
import page.Page;
import project.Project;
public class RenameAction extends AbstractAction {
        public RenameAction(boolean icon) {
                // putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N,
                // ActionEvent.CTRL_MASK));
                if (icon) {
                        putValue(SMALL_ICON, new ImageIcon("images/rename.png"));
                        putValue(SHORT_DESCRIPTION, "Rename");
                }
                putValue(NAME, "Rename");
        }
        public void actionPerformed(ActionEvent arg0) {
                Object p = MainFrame.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
                if (p instanceof Project || p instanceof Document || p instanceof Page) {
                        RenameDialog dialog = new RenameDialog(MainFrame.getInstance(), "Rename", true, p);
                        dialog.setVisible(true);
                }
        }
}