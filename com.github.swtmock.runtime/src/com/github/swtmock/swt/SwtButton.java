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

import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;

import com.github.swtmock.api.IButton;

public class SwtButton extends SwtControl implements IButton {

	private Button button;
	
	public SwtButton(Button button) {
		super(button);
		this.button = button;
	}

	@Override
	public void setText(String text) {
		button.setText(text);
	}

	@Override
	public String getText() {
		return button.getText();
	}

	@Override
	public void addSelectionListener(SelectionListener listener) {
		button.addSelectionListener(listener);
	}

	@Override
	public void removeSelectionListener(SelectionListener listener) {
		button.removeSelectionListener(listener);
	}

}
