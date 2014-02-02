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

import org.eclipse.swt.graphics.Color;

public class ControlMock implements IControl {

	private Color background;

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
		this.background = background;
	}


}
