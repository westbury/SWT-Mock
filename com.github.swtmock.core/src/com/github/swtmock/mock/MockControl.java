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
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Control;

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

	/* Default size for widgets */
	static final int DEFAULT_WIDTH	= 64;
	static final int DEFAULT_HEIGHT	= 64;

	IComposite parent;
	
	int style;
	
	private boolean isDisposed = false;
	
	private Color background = null;

	private Color foreground = null;

	private Font font = null;

	private Point size = new Point(0, 0);

	private Point location = new Point(0, 0);

	private ListenerList controlListeners = new ListenerList();

	private boolean visible = true;
	
	private Object layoutData;

	private Object data;
	
	private boolean isDataKeyed = false;

	// Object can only be constructed by MockComposite.
	// Constructing directly would not put it in the child list
	// of the parent.
	MockControl(IComposite parent, int style) {
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
	public Point getSize() {
		return size;
	}

	@Override
	public void setSize(int width, int height) {
		checkWidget();
		size.x = width;
		size.y = height;
		
		for (Object listener : controlListeners.getListeners()) {
			((ControlListener)listener).controlResized(null);
		}
	}

	@Override
	public void setSize(Point size) {
		checkWidget();
		this.size = size;
		
		for (Object listener : controlListeners.getListeners()) {
			((ControlListener)listener).controlResized(null);
		}
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(location.x, location.y, size.x, size.y);
	}

	@Override
	public void setBounds(int x, int y, int width, int height) {
		location.x = x;
		location.y = y;
		size.x = width;
		size.y = height;
		
		for (Object listener : controlListeners.getListeners()) {
			((ControlListener)listener).controlMoved(null);
			((ControlListener)listener).controlResized(null);
		}
	}

	@Override
	public Point getLocation() {
		return location;
	}

	@Override
	public void setLocation(int x, int y) {
		location.x = x;
		location.y = y;
		
		for (Object listener : controlListeners.getListeners()) {
			((ControlListener)listener).controlMoved(null);
		}
	}

	@Override
	public void setLocation(Point location) {
		this.location = location;
		
		for (Object listener : controlListeners.getListeners()) {
			((ControlListener)listener).controlMoved(null);
		}
	}

	public Point computeSize (int wHint, int hHint) {
		return computeSize (wHint, hHint, true);
	}

	public Point computeSize (int wHint, int hHint, boolean changed) {
		checkWidget ();
		int width = DEFAULT_WIDTH;
		int height = DEFAULT_HEIGHT;
		if (wHint != SWT.DEFAULT) width = wHint;
		if (hHint != SWT.DEFAULT) height = hHint;
		int border = getBorderWidth ();
		width += border * 2;
		height += border * 2;
		return new Point (width, height);
	}

	public int getBorderWidth () {
		checkWidget ();
		// Just pick a number, any will do
		return 5;
	}

	@Override
	public boolean isVisible() {
		checkWidget();
		return visible;
	}

	@Override
	public void setVisible(boolean visible) {
		checkWidget();
		this.visible = visible;
	}

	@Override
	public void addControlListener(ControlListener listener) {
		controlListeners.add(listener);
	}

	@Override
	public void removeControlListener(ControlListener listener) {
		controlListeners.remove(listener);
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

	@Override
	public void moveAbove(Control control) {
		// Implement this if you want to write a test that checks
		// that the z-order of controls is correct.
	}

	@Override
	public void moveBelow(Control control) {
		// Implement this if you want to write a test that checks
		// that the z-order of controls is correct.
	}

	public Object getData () {
		checkWidget();
		return isDataKeyed ? ((Object []) data) [0] : data;
	}

	public Object getData (String key) {
		checkWidget();
		if (key == null) SWT.error(SWT.ERROR_NULL_ARGUMENT);
		if (isDataKeyed) {
			Object [] table = (Object []) data;
			for (int i=1; i<table.length; i+=2) {
				if (key.equals (table [i])) return table [i+1];
			}
		}
		return null;
	}

	public void setData (Object data) {
		checkWidget();
		if (isDataKeyed) {
			((Object []) this.data) [0] = data;
		} else {
			this.data = data;
		}
	}
	
	public void setData (String key, Object value) {
		checkWidget();
		if (key == null) SWT.error(SWT.ERROR_NULL_ARGUMENT);
		int index = 1;
		Object [] table = null;
		if (isDataKeyed) {
			table = (Object []) data;
			while (index < table.length) {
				if (key.equals (table [index])) break;
				index += 2;
			}
		}
		if (value != null) {
			if (isDataKeyed) {
				if (index == table.length) {
					Object [] newTable = new Object [table.length + 2];
					System.arraycopy (table, 0, newTable, 0, table.length);
					data = table = newTable;
				}
			} else {
				table = new Object [3];
				table [0] = data;
				data = table;
				isDataKeyed = true;
			}
			table [index] = key;
			table [index + 1] = value;
		} else {
			if (isDataKeyed) {
				if (index != table.length) {
					int length = table.length - 2;
					if (length == 1) {
						data = table [0];
						isDataKeyed = false;
					} else {
						Object [] newTable = new Object [length];
						System.arraycopy (table, 0, newTable, 0, index);
						System.arraycopy (table, index + 2, newTable, index, length - index);
						data = newTable;
					}
				}
			}
		}
	}

}
