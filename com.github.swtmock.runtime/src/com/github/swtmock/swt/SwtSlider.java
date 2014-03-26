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
import org.eclipse.swt.widgets.Slider;

import com.github.swtmock.api.ISlider;

public class SwtSlider extends SwtControl implements ISlider {

	private Slider slider;
	
	public SwtSlider(Slider slider) {
		super(slider);
		this.slider = slider;
	}

	@Override
	public void addSelectionListener(SelectionListener listener) {
		slider.addSelectionListener(listener);
	}

	@Override
	public void removeSelectionListener(SelectionListener listener) {
		slider.removeSelectionListener(listener);
	}

	@Override
	public int getMinimum() {
		return slider.getMinimum();
	}

	@Override
	public void setMinimum(int value) {
		slider.setMinimum(value);
	}

	@Override
	public int getMaximum() {
		return slider.getMaximum();
	}

	@Override
	public void setMaximum(int value) {
		slider.setMaximum(value);
	}

	@Override
	public int getThumb() {
		return slider.getThumb();
	}

	@Override
	public void setThumb(int value) {
		slider.setThumb(value);
	}

	@Override
	public int getSelection() {
		return slider.getSelection();
	}

	@Override
	public void setSelection(int value) {
		slider.setSelection(value);
	}

}
