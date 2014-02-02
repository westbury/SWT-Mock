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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.widgets.Layout;

import com.github.swtmock.api.IButton;
import com.github.swtmock.api.IComposite;
import com.github.swtmock.api.ILabel;
import com.github.swtmock.api.ITableViewer;
import com.github.swtmock.api.IText;

public class CompositeMock extends ControlMock implements IComposite {

	public abstract static class ControlFinder<C> {
		abstract boolean matches(C control);
	}

	private List<ControlMock> children = new ArrayList<>();

	/**
	 * This constructor is used internally.
	 * 
	 * @param parent
	 * @param style
	 */
	private CompositeMock(CompositeMock parent, int style) {
		// TODO Auto-generated constructor stub
	}

	/**
	 * This constructor is used to create the top-level mock
	 * composite.
	 */
	public CompositeMock() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public IComposite createComposite(int style) {
		CompositeMock childComposite = new CompositeMock(this, style);
		children.add(childComposite);
		return childComposite;
	}

	@Override
	public void setLayout(Layout layout) {
		// TODO Auto-generated method stub

	}

	@Override
	public IButton createButton(int style) {
		ButtonMock button = new ButtonMock(style);
		children.add(button);
		return button;
	}

	@Override
	public ILabel createLabel(int style) {
		LabelMock label = new LabelMock(style);
		children.add(label);
		return label;
	}

	@Override
	public IText createText(int style) {
		TextMock text = new TextMock(style);
		children.add(text);
		return text;
	}

	@Override
	public ITableViewer createTableViewer(int style) {
		// Create the table first
		TableMock table = new TableMock(style);
		children.add(table);
		
		// then the viewer
		TableViewerMock viewer = new TableViewerMock(table);
		return viewer;
	}

	/**
	 * Clicks the button with the given text.
	 * 
	 * @param text
	 */
	public void clickButton(final String text) {
		ButtonMock button = findControl(ButtonMock.class, new ControlFinder<ButtonMock>() {
			@Override
			boolean matches(ButtonMock control) {
				return control.getText().equals(text);
			}
		});
		button.click();
	}

	private <C extends ControlMock> C findControl(Class<C> classOfControl,
			ControlFinder<C> controlFinder) {
		C result = null;
		for (ControlMock control : children) {
			if (classOfControl.isAssignableFrom(control.getClass())) {
				C control2 = classOfControl.cast(control);
				if (controlFinder.matches(control2)) {
					if (result == null) {
						result = control2;
					} else {
						throw new RuntimeException("Multiple controls match");
					}
				}
			} else if (control instanceof CompositeMock) {
				C match = ((CompositeMock)control).findControl(classOfControl, controlFinder);
				if (match != null) {
					if (result == null) {
						result = match;
					} else {
						throw new RuntimeException("Multiple controls match");
					}
				}
			}
		}
		return result;
	}

}
