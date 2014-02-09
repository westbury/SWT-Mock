/*******************************************************************************
 * Copyright (c) 2014 Nigel Westbury and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Nigel Westbury - initial API and implementation
 *******************************************************************************/

package com.github.swtmock.mock;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;

import com.github.swtmock.api.IControl;

/**
 * This class extends Widget because that allows it to be set in an
 * Event.  If that were not the case then we would not be able to use
 * 
 * @author Nigel
 *
 */
public class MockControl implements IControl {

	int style;
	
	private boolean isDisposed = false;
	
	private Color background;

	@Override
	public int getStyle() {
		return style;
	}

	@Override
	public void setLayoutData(Object layoutData) {
		// TODO Auto-generated method stub

	}

	@Override
	public Color getBackground() {
		return background;
	}

	@Override
	public void setBackground(Color background) {
		checkWidget ();
		this.background = background;
	}

	@Override
	public void dispose() {
		isDisposed = true;
	}

	protected void checkWidget() {
		if (isDisposed) {
			SWT.error(SWT.ERROR_WIDGET_DISPOSED);
		}
	}

}
