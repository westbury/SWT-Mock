package com.github.swtmock.mock;

import org.eclipse.swt.graphics.FontMetrics;

import com.github.swtmock.api.IFontMetrics;
import com.github.swtmock.api.IGC;

public class MockGC implements IGC {

	@Override
	public IFontMetrics getFontMetrics() {
		return new MockFontMetrics();
	}

	@Override
	public void dispose() {
		// TODO Fail tests that don't dispose?
	}

}
