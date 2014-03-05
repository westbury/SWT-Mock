package com.github.swtmock.swt;

import org.eclipse.swt.graphics.FontMetrics;

import com.github.swtmock.api.IFontMetrics;

public class SwtFontMetrics implements IFontMetrics {

	private FontMetrics fontMetrics;
	
	public SwtFontMetrics(FontMetrics fontMetrics) {
		this.fontMetrics = fontMetrics;
	}

	@Override
	public int getHeight() {
		return fontMetrics.getHeight();
	}

}
