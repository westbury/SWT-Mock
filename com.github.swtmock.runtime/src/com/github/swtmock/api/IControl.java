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

import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Point;

public interface IControl {

	int getStyle();

	Object getLayoutData();

	void setLayoutData(Object layoutData);

	Color getBackground();

	void setBackground(Color color);

	Color getForeground();

	void setForeground(Color color);

	Font getFont();

	void setFont(Font font);
	
	Point getSize();

	void setSize(int width, int height);
	
	void setSize(Point size);
	
	boolean isVisible();
	
	void setVisible(boolean visible);
	
	void addControlListener(ControlListener listener);

	void setFocus();
	
	void dispose();

	boolean isDisposed();
	
	IShell getShell();

	IDisplay getDisplay();
}
