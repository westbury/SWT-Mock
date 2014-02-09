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

package com.github.swtmock.examples;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

import com.github.swtmock.api.IButton;
import com.github.swtmock.api.IComposite;
import com.github.swtmock.api.ILabel;
import com.github.swtmock.api.ITableViewer;
import com.github.swtmock.api.IText;

public class SimpleComposite2 {

	public SimpleComposite2(IComposite composite) {
		ILabel label1 = composite.createLabel(SWT.NONE);
		label1.setText("Field 1:");
		IText text1 = composite.createText(SWT.NONE);
		
		ILabel label2 = composite.createLabel(SWT.NONE);
		label2.setText("Field 2:");
		IText text2 = composite.createText(SWT.NONE);
		
		IButton action1 = composite.createButton(SWT.PUSH);
		action1.setText("Numbered");
		
		IButton action2 = composite.createButton(SWT.PUSH);
		action2.setText("Lettered");
		
		final ITableViewer viewer = composite.createTableViewer(SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		
		viewer.setContentProvider(new MyContentProviderWrapper(ArrayContentProvider.getInstance()));
		viewer.setLabelProvider(new LabelProvider());

		action1.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				viewer.setInput(new String [] { "value 1", "value 2" });
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				viewer.setInput(new String [] { "value 1", "value 2", "value3" });
			}
		});

		action2.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				viewer.setInput(new String [] { "value A", "value B" });
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				viewer.setInput(new String [] { "value A", "value B", "value C" });
			}
		});
		
	}
}
