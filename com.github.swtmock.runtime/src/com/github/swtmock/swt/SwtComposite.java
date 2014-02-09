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
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.Text;

import com.github.swtmock.api.IButton;
import com.github.swtmock.api.IComposite;
import com.github.swtmock.api.ILabel;
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

}
