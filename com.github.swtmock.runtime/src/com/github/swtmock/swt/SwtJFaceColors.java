package com.github.swtmock.swt;

import org.eclipse.jface.resource.JFaceColors;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

import com.github.swtmock.api.IDisplay;
import com.github.swtmock.api.IJFaceColors;

public class SwtJFaceColors implements IJFaceColors {

	@Override
	public Color getBannerBackground(IDisplay display) {
		Display swtDisplay = ((SwtDisplay)display).getSwtDisplay();
		return JFaceColors.getBannerBackground(swtDisplay);
	}

	@Override
	public Color getBannerForeground(IDisplay display) {
		Display swtDisplay = ((SwtDisplay)display).getSwtDisplay();
		return JFaceColors.getBannerForeground(swtDisplay);
	}

}
