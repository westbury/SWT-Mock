package com.github.swtmock.swt;

import org.eclipse.swt.widgets.Shell;

import com.github.swtmock.api.IDisplay;
import com.github.swtmock.api.IShell;

public class SwtShell implements IShell {

	private Shell shell;

	public SwtShell(Shell shell) {
		this.shell = shell;
	}

	@Override
	public IDisplay getDisplay() {
		return new SwtDisplay(shell.getDisplay());
	}

	@Override
	public void close() {
		shell.close();
	}

}
