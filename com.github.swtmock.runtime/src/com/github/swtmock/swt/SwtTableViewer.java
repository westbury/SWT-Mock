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

import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;

import com.github.swtmock.api.IControl;
import com.github.swtmock.api.IMockableStructuredContentProvider;
import com.github.swtmock.api.ITable;
import com.github.swtmock.api.ITableViewer;

public class SwtTableViewer implements ITableViewer {

	private TableViewer tableViewer;
	
	public SwtTableViewer(TableViewer tableViewer) {
		this.tableViewer = tableViewer;
	}

	@Override
	public void setLabelProvider(IBaseLabelProvider labelProvider) {
		tableViewer.setLabelProvider(labelProvider);
	}

	@Override
	public void setContentProvider(final IMockableStructuredContentProvider contentProvider) {
		tableViewer.setContentProvider(new IStructuredContentProvider() {

			@Override
			public void dispose() {
				contentProvider.dispose();
			}

			@Override
			public void inputChanged(Viewer viewer, Object oldInput,
					Object newInput) {
				contentProvider.inputChanged(new SwtTableViewer(tableViewer), oldInput, newInput);
			}

			@Override
			public Object[] getElements(Object inputElement) {
				return contentProvider.getElements(inputElement);
			}
		});
	}

	@Override
	public IControl getControl() {
		return new SwtControl(tableViewer.getControl());
	}

	@Override
	public ITable getTable() {
		return new SwtTable(tableViewer.getTable());
	}

	@Override
	public void setInput(Object input) {
		tableViewer.setInput(input);
	}

	@Override
	public IStructuredSelection getSelection() {
		return (IStructuredSelection)tableViewer.getSelection();
	}

	@Override
	public void setSelection(IStructuredSelection selection) {
		tableViewer.setSelection(selection);
	}

	@Override
	public void update(Object[] elements, String[] properties) {
		tableViewer.update(elements, properties);
	}

}
