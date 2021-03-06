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

import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Control;

import com.github.swtmock.api.IControl;
import com.github.swtmock.api.IDisplay;
import com.github.swtmock.api.IShell;

public class SwtControl implements IControl {

	private Control control;
	
	public SwtControl(Control control) {
		this.control = control;
	}

	@Override
	public int getStyle() {
		return control.getStyle();
	}

	@Override
	public void setLayoutData(Object layoutData) {
		control.setLayoutData(layoutData);
	}

	@Override
	public void setBackground(Color color) {
		control.setBackground(color);
	}

	@Override
	public Color getBackground() {
		return control.getBackground();
	}

	@Override
	public void dispose() {
		control.dispose();
	}

	@Override
	public boolean isDisposed() {
		return control.isDisposed();
	}

	public Control getControl() {
		return control;
	}

	@Override
	public Object getLayoutData() {
		return control.getLayoutData();
	}

	@Override
	public Color getForeground() {
		return control.getForeground();
	}

	@Override
	public void setForeground(Color color) {
		control.setForeground(color);
	}

	@Override
	public Font getFont() {
		return control.getFont();
	}

	@Override
	public void setFont(Font font) {
		control.setFont(font);
	}

	@Override
	public Point getSize() {
		return control.getSize();
	}

	@Override
	public void setSize(int width, int height) {
		control.setSize(width, height);
	}

	@Override
	public void setSize(Point size) {
		control.setSize(size);
	}

	@Override
	public Rectangle getBounds() {
		return control.getBounds();
	}

	@Override
	public void setBounds(int x, int y, int width, int height) {
		control.setBounds(x, y, width, height);
	}

	@Override
	public Point getLocation() {
		return control.getLocation();
	}

	@Override
	public void setLocation(int x, int y) {
		control.setLocation(x, y);
	}

	@Override
	public void setLocation(Point location) {
		control.setLocation(location);
	}

	@Override
	public Point computeSize(int wHint, int hHint) {
		return control.computeSize(wHint, hHint);
	}

	@Override
	public void addControlListener(ControlListener listener) {
		control.addControlListener(listener);
	}

	@Override
	public void removeControlListener(ControlListener listener) {
		control.removeControlListener(listener);
	}

	@Override
	public void setFocus() {
		control.setFocus();
	}

	@Override
	public IShell getShell() {
		return new SwtShell(control.getShell());
	}

	@Override
	public IDisplay getDisplay() {
		return new SwtDisplay(control.getDisplay());
	}

	@Override
	public boolean isVisible() {
		return control.isVisible();
	}

	@Override
	public void setVisible(boolean visible) {
		control.setVisible(visible);
	}

	@Override
	public void moveAbove(Control control) {
		control.moveAbove(control);
	}

	@Override
	public void moveBelow(Control control) {
		control.moveBelow(control);
	}

	@Override
	public Object getData() {
		return control.getData();
	}

	@Override
	public void setData(Object value) {
		control.setData(value);
	}

	@Override
	public Object getData(String key) {
		return control.getData(key);
	}

	@Override
	public void setData(String key, Object value) {
		control.setData(key, value);
	}

}
