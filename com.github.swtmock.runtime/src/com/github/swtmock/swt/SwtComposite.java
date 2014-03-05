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

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.Text;

import com.github.swtmock.api.IButton;
import com.github.swtmock.api.IComposite;
import com.github.swtmock.api.IDialog;
import com.github.swtmock.api.IDisplay;
import com.github.swtmock.api.IGC;
import com.github.swtmock.api.IJFaceColors;
import com.github.swtmock.api.ILabel;
import com.github.swtmock.api.IScrolledComposite;
import com.github.swtmock.api.IShell;
import com.github.swtmock.api.IStyledText;
import com.github.swtmock.api.ITabFolder;
import com.github.swtmock.api.ITableViewer;
import com.github.swtmock.api.IText;

public class SwtComposite extends SwtControl implements IComposite {

	private Composite composite;

	/**
	 * This constructor is public so that testable components
	 * can be created from code that calls SWT directly.
	 * <P>
	 * If a testable component is created within another testable
	 * component then there is no need to use this constructor from
	 * the code being tested because IComposite is returned when
	 * the child component is created.
	 * 
	 * @param composite
	 */
	public SwtComposite(Composite composite) {
		super(composite);
		this.composite = composite;
	}

	@Override
	public void setLayoutData(Object layoutData) {
		composite.setLayoutData(layoutData);
	}

	@Override
	public IComposite createComposite(int style) {
		return new SwtComposite(new Composite(composite, style));
	}

	@Override
	public void setLayout(Layout layout) {
		composite.setLayout(layout);
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
	public IButton createButton(int style) {
		return new SwtButton(new Button(composite, style));
	}

	@Override
	public ILabel createLabel(int style) {
		return new SwtLabel(new Label(composite, style));
	}

	@Override
	public ITableViewer createTableViewer(int style) {
		return new SwtTableViewer(new TableViewer(composite, style));
	}

	@Override
	public IText createText(int style) {
		return new SwtText(new Text(composite, style));
	}

	@Override
	public ITabFolder createTabFolder(int style) {
		return new SwtTabFolder(new TabFolder(composite, style));
	}

	@Override
	public ITabFolder createCTabFolder(int style) {
		return new SwtTabFolder(new CTabFolder(composite, style));
	}

	@Override
	public int openTrayDialog(IDialog dialog) {
		SwtTrayDialog swtDialog = new SwtTrayDialog(composite.getShell(), dialog);
		return swtDialog.open();
	}

	@Override
	public IDisplay getDisplay() {
		return new SwtDisplay(composite.getDisplay());
	}

	@Override
	public Layout getLayout() {
		return composite.getLayout();
	}

	@Override
	public IStyledText createStyledText(int style) {
		return new SwtStyledText(new StyledText(composite, style));
	}

	@Override
	public IScrolledComposite createScrolledComposite(int style) {
		
		return new SwtScrolledComposite(new ScrolledComposite(composite, style));
	}

	@Override
	public IGC createGC() {
		GC gc = new GC(composite);
		return new SwtGC(gc);
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
	public IShell getShell() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IJFaceColors getJFaceColors() {
		return new SwtJFaceColors();
	}

}
