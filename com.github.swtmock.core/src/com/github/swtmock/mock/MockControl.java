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
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Point;

import com.github.swtmock.api.IComposite;
import com.github.swtmock.api.IControl;
import com.github.swtmock.api.IDisplay;
import com.github.swtmock.api.IShell;

/**
 * This class extends Widget because that allows it to be set in an
 * Event.  If that were not the case then we would not be able to use
 * 
 * @author Nigel
 *
 */
public class MockControl implements IControl {

	IComposite parent;
	
	int style;
	
	private boolean isDisposed = false;
	
	private Color background = null;

	private Color foreground = null;

	private Font font = null;

	private Point size = new Point(0, 0);

	private Object layoutData;

	public MockControl(IComposite parent, int style) {
		this.parent = parent;
		this.style = style;
	}
	
	@Override
	public int getStyle() {
		return style;
	}

	@Override
	public Object getLayoutData() {
		return layoutData;
	}

	@Override
	public void setLayoutData(Object layoutData) {
		this.layoutData = layoutData;
	}

	@Override
	public Color getBackground() {
		checkWidget();
		return background;
	}

	@Override
	public void setBackground(Color background) {
		checkWidget ();
		this.background = background;
	}

	@Override
	public Color getForeground() {
		checkWidget();
		return foreground;
	}

	@Override
	public void setForeground(Color foreground) {
		checkWidget ();
		this.foreground = foreground;
	}

	@Override
	public Font getFont() {
		checkWidget();
		return font;
	}

	@Override
	public void setFont(Font font) {
		checkWidget ();
		this.font = font;
	}

	@Override
	public void setSize(int width, int height) {
		checkWidget();
		size.x = width;
		size.y = height;
	}

	@Override
	public void setSize(Point size) {
		checkWidget();
		this.size = size;
	}

	@Override
	public void addControlListener(ControlListener controlListener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		isDisposed = true;
	}

	@Override
	public boolean isDisposed() {
		return isDisposed;
	}

	protected void checkWidget() {
		if (isDisposed) {
			SWT.error(SWT.ERROR_WIDGET_DISPOSED);
		}
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IShell getShell() {
		return parent.getShell();
	}

	@Override
	public IDisplay getDisplay() {
		return getShell().getDisplay();
	}

}
