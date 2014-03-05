package com.github.swtmock.mock;

import com.github.swtmock.api.IScrollBar;

public class MockScrollBar implements IScrollBar {

	int increment = 1;

	int pageIncrement = 10;

	@Override
	public int getIncrement () {
		return increment;
	}

	@Override
	public void setIncrement(int value) {
		if (value < 1) return;
		increment = value;
	}

	@Override
	public int getPageIncrement () {
		return pageIncrement;
	}

	@Override
	public void setPageIncrement (int value) {
		if (value < 1) return;
		pageIncrement = value;
	}

}
