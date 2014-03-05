package com.github.swtmock.api;

import org.eclipse.swt.graphics.Color;

/**
 * Interface to JFaceColors that can be mocked.
 * 
 * JFaceColors has static methods that require an SWT Display object.
 * An SWT Display is not available when using mock controls, so instead
 * use this method to get an interface that has methods that can be
 * used instead of the JFaceColors static methods.
 * 
 * @author Nigel Westbury
 */
public interface IJFaceColors {

	Color getBannerBackground(IDisplay display);

	Color getBannerForeground(IDisplay display);

}
