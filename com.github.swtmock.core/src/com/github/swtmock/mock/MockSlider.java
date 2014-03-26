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

import com.github.swtmock.api.ISlider;

public class MockSlider extends MockControl implements ISlider {

	private int selection = 0;

	private int minimum = 0;
	
	private int maximum = 10;
	
	private int thumb = 10;

	private ListenerList listeners = new ListenerList();
	
	public MockSlider(MockComposite parent, int style) {
		super(parent, style);
	}

	@Override
	public void addSelectionListener(SelectionListener listener) {
		listeners.add(listener);
	}

	@Override
	public void removeSelectionListener(SelectionListener listener) {
		listeners.remove(listener);
	}

	@Override
	public int getMinimum() {
		return minimum;
	}

	@Override
	public void setMinimum(int value) {
		this.maximum = value;
	}

	@Override
	public int getMaximum() {
		return maximum;
	}

	@Override
	public void setMaximum(int value) {
		this.maximum = value;
	}

	@Override
	public int getThumb() {
		return thumb;
	}

	@Override
	public void setThumb(int value) {
		this.thumb = value;
	}

	@Override
	public int getSelection() {
		return selection;
	}

	@Override
	public void setSelection(int value) {
		this.selection = value;

		for (Object listener : listeners.getListeners()) {
			((SelectionListener)listener).widgetSelected(null);
		}
	}

}
