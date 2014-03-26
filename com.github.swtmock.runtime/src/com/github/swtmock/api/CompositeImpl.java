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
import org.eclipse.swt.widgets.Layout;



/**
 * This is a convenience class that may be used as the base class for
 * composite controls.  It is not compulsory to use this class.
 * 
 * @author Nigel Westbury
 */
public class CompositeImpl implements IComposite {

	protected final IComposite composite;
	
	public CompositeImpl(IComposite parent, int style) {
		composite = parent.createComposite(style);
	}

	public void setLayout(Layout layout) {
		composite.setLayout(layout);
	}

	public void setLayoutData(Object layoutData) {
		composite.setLayoutData(layoutData);
	}

	public void dispose() {
		composite.dispose();
	}

	/**
	 * Gets the composite interface wrapper.
	 * 
	 * @return
	 */
	public IComposite getComposite() {
		return composite;
	}

	@Override
	public int getStyle() {
		return composite.getStyle();
	}

	@Override
	public Object getLayoutData() {
		return composite.getLayoutData();
	}

	@Override
	public Color getBackground() {
		return composite.getBackground();
	}

	@Override
	public void setBackground(Color color) {
		composite.setBackground(color);
	}

	@Override
	public Color getForeground() {
		return composite.getForeground();
	}

	@Override
	public void setForeground(Color color) {
		composite.setForeground(color);
	}

	@Override
	public Font getFont() {
		return composite.getFont();
	}

	@Override
	public void setFont(Font font) {
		composite.setFont(font);
	}

	@Override
	public Point getSize() {
		return composite.getSize();
	}

	@Override
	public void setSize(int width, int height) {
		composite.setSize(width, height);
	}

	@Override
	public void setSize(Point size) {
		composite.setSize(size);
	}

	@Override
	public void addControlListener(ControlListener listener) {
		composite.addControlListener(listener);
	}

	@Override
	public void setFocus() {
		composite.setFocus();
	}

	@Override
	public boolean isDisposed() {
		return composite.isDisposed();
	}

	@Override
	public IShell getShell() {
		return composite.getShell();
	}

	@Override
	public IDisplay getDisplay() {
		return composite.getDisplay();
	}

	@Override
	public IComposite createComposite(int style) {
		return composite.createComposite(style);
	}

	@Override
	public Layout getLayout() {
		return composite.getLayout();
	}

	@Override
	public ILabel createLabel(int style) {
		return composite.createLabel(style);
	}

	@Override
	public IText createText(int style) {
		return composite.createText(style);
	}

	@Override
	public IStyledText createStyledText(int style) {
		return composite.createStyledText(style);
	}

	@Override
	public IButton createButton(int style) {
		return composite.createButton(style);
	}

	@Override
	public ITableViewer createTableViewer(int style) {
		return composite.createTableViewer(style);
	}

	@Override
	public ITabFolder createTabFolder(int style) {
		return composite.createTabFolder(style);
	}

	@Override
	public ITabFolder createCTabFolder(int style) {
		return composite.createCTabFolder(style);
	}

	@Override
	public IScrolledComposite createScrolledComposite(int style) {
		return composite.createScrolledComposite(style);
	}

	@Override
	public IGC createGC() {
		return composite.createGC();
	}

	@Override
	public int openTrayDialog(IDialog dialog) {
		return composite.openTrayDialog(dialog);
	}

	@Override
	public Rectangle getClientArea() {
		return composite.getClientArea();
	}

	@Override
	public Point computeSize(int width, int height) {
		return composite.computeSize(width, height);
	}

	@Override
	public void layout(boolean changed) {
		composite.layout(changed);
	}

	@Override
	public IJFaceColors getJFaceColors() {
		return composite.getJFaceColors();
	}

	@Override
	public boolean isVisible() {
		return composite.isVisible();
	}

	@Override
	public void setVisible(boolean visible) {
		composite.setVisible(visible);
	}

	@Override
	public ISlider createSlider(int style) {
		return composite.createSlider(style);
	}
}
