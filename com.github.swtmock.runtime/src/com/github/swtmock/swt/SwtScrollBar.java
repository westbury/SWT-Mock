package com.github.swtmock.swt;

import org.eclipse.swt.widgets.ScrollBar;

import com.github.swtmock.api.IScrollBar;

public class SwtScrollBar implements IScrollBar {

	ScrollBar scrollBar;

	public SwtScrollBar(ScrollBar scrollBar) {
		this.scrollBar = scrollBar;
	}

	@Override
	public int getIncrement() {
		return scrollBar.getIncrement();
	}

	@Override
	public void setIncrement(int value) {
		scrollBar.setIncrement(value);
	}

	@Override
	public int getPageIncrement() {
		return scrollBar.getPageIncrement();
	}

	@Override
	public void setPageIncrement(int value) {
		scrollBar.setPageIncrement(value);
	}

}
