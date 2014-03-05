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

import org.eclipse.core.runtime.ListenerList;
import org.eclipse.swt.events.SelectionListener;

import com.github.swtmock.api.IButton;

public class MockButton extends MockControl implements IButton {

	private String text = "";
	
	private ListenerList listeners = new ListenerList();
	
	public MockButton(MockComposite parent, int style) {
		super(parent, style);
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
	public void addSelectionListener(SelectionListener listener) {
		listeners.add(listener);
	}

	@Override
	public void removeSelectionListener(SelectionListener listener) {
		listeners.remove(listener);
	}

	public void click() {
		for (Object listener : listeners.getListeners()) {
			((SelectionListener)listener).widgetSelected(null);
		}
	}

}
