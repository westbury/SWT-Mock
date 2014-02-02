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

import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;

import com.github.swtmock.api.IControl;
import com.github.swtmock.api.ITable;
import com.github.swtmock.api.ITableViewer;

public class TableViewerMock implements ITableViewer {

	private TableMock table;
	
	public TableViewerMock(TableMock table) {
		this.table = table;
	}

	@Override
	public void setLabelProvider(IBaseLabelProvider labelProvider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setContentProvider(IContentProvider contentProvider) {
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub

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
