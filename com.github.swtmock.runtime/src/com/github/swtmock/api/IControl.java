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
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Control;

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
	
	Rectangle getBounds();

	void setBounds(int x, int y, int width, int height);

	Point getLocation();
	
	void setLocation(int x, int y);

	void setLocation(Point location);

	boolean isVisible();
	
	void setVisible(boolean visible);
	
	void addControlListener(ControlListener listener);

	void setFocus();
	
	void dispose();

	boolean isDisposed();
	
	IShell getShell();

	IDisplay getDisplay();

	Point computeSize(int width, int height);

	void moveAbove(Control control);

	void moveBelow(Control control);
}
