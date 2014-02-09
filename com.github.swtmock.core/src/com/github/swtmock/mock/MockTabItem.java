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

import com.github.swtmock.api.IControl;
import com.github.swtmock.api.ITabItem;

public class MockTabItem implements ITabItem {

	private MockControl control;
	
	private boolean isDisposed = false;
	
	private String text;

	@Override
	public void dispose() {
		isDisposed = true;
	}

	protected void checkWidget() {
		if (isDisposed) {
			SWT.error(SWT.ERROR_WIDGET_DISPOSED);
		}
	}

	@Override
	public String getText() {
		return text;
	}

	@Override
	public void setText(String text) {
		this.text = text;
	}

	@Override
	public IControl getControl() {
		return control;
	}

	@Override
	public void setControl(IControl control) {
		control = (MockControl) control;
	}

	public MockControl getMockControl() {
		return control;
	}

}
