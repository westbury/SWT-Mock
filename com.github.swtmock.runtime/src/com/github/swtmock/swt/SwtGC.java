package com.github.swtmock.swt;

import org.eclipse.swt.graphics.GC;

import com.github.swtmock.api.IFontMetrics;
import com.github.swtmock.api.IGC;

public class SwtGC implements IGC {

	private GC gc;
	
	SwtGC(GC gc) {
		this.gc = gc;
	}

	@Override
	public IFontMetrics getFontMetrics() {
		return new SwtFontMetrics(gc.getFontMetrics());
	}

	@Override
	public void dispose() {
		gc.dispose();
	}
}
