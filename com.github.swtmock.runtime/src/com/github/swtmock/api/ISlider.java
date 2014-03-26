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

package com.github.swtmock.api;

import org.eclipse.swt.events.SelectionListener;

public interface ISlider extends IControl {

	void addSelectionListener(SelectionListener listener);

	void removeSelectionListener(SelectionListener listener);

	int getMinimum();

	void setMinimum(int value);
	
	int getMaximum();

	void setMaximum(int value);
	
	int getThumb();

	void setThumb(int value);

	int getSelection();

	void setSelection(int value);

}
