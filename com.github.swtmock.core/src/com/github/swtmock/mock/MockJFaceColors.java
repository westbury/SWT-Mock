package com.github.swtmock.mock;

import org.eclipse.swt.graphics.Color;

import com.github.swtmock.api.IDisplay;
import com.github.swtmock.api.IJFaceColors;

public class MockJFaceColors implements IJFaceColors {

	@Override
	public Color getBannerBackground(IDisplay display) {
		return new Color(null, 1,1,2);
	}

	@Override
	public Color getBannerForeground(IDisplay display) {
		return new Color(null, 1,1,3);
	}

}
