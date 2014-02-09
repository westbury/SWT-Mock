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

package com.github.swtmock.swt;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Control;

import com.github.swtmock.api.IControl;

public class SwtControl implements IControl {

	private Control control;
	
	public SwtControl(Control control) {
		this.control = control;
	}

	@Override
	public int getStyle() {
		return control.getStyle();
	}

	@Override
	public void setLayoutData(Object layoutData) {
		control.setLayoutData(layoutData);
	}

	@Override
	public void setBackground(Color color) {
		control.setBackground(color);
	}

	@Override
	public Color getBackground() {
		return control.getBackground();
	}

	@Override
	public void dispose() {
		control.dispose();
	}

}
