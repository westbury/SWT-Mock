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

import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;

import com.github.swtmock.api.IControl;
import com.github.swtmock.api.IMockableStructuredContentProvider;
import com.github.swtmock.api.ITable;
import com.github.swtmock.api.ITableViewer;

public class MockTableViewer implements ITableViewer {

//	private Viewer realViewer;
	private MockTable table;
	private IBaseLabelProvider labelProvider;
	private IMockableStructuredContentProvider contentProvider;
	private Object input = null;
	
	// Current set of elements as shown in table
	private Object[] elements;
	
	public MockTableViewer(MockTable table) {
		this.table = table;
	}

	@Override
	public void setLabelProvider(IBaseLabelProvider labelProvider) {
		this.labelProvider = labelProvider;
	}

	@Override
	public void setContentProvider(IMockableStructuredContentProvider contentProvider) {
		this.contentProvider = contentProvider;
	}

	@Override
	public IControl getControl() {
		return table;
	}

	@Override
	public ITable getTable() {
		return table;
	}

	@Override
	public void setInput(Object input) {

		this.contentProvider.inputChanged(this, this.input, input);
		this.input = input;
	
		elements = contentProvider.getElements(input);
		
		List<String[]> rows = new ArrayList<String[]>();
		for (Object element : elements) {
			String label = ((LabelProvider)labelProvider).getText(element);
			rows.add(new String [] { label });
		}
		
		table.setRows(rows);
	}

	@Override
	public IStructuredSelection getSelection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSelection(IStructuredSelection selection) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Object[] elements, String[] properties) {
		// TODO Auto-generated method stub

	}

}
