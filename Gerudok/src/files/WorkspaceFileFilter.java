package files;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class WorkspaceFileFilter extends FileFilter {

	@Override
	public boolean accept(File f) {
		return (f.isDirectory() || f.getName().toLowerCase().endsWith(".gwf"));
	}

	@Override
	public String getDescription() {
		return "GeRuDok Workspace Files (*.gwf)";
	}

}
