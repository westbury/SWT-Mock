package com.github.swtmock.swt;

import org.eclipse.swt.widgets.Display;

import com.github.swtmock.api.IDisplay;

public class SwtDisplay implements IDisplay {

	private Display display;

	public SwtDisplay(Display display) {
		this.display = display;
	}

	public Display getSwtDisplay() {
		return display;
	}

}
