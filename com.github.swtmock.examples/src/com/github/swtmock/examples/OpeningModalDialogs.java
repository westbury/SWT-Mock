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

import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;

import com.github.swtmock.api.CompositeImpl;
import com.github.swtmock.api.IButton;
import com.github.swtmock.api.IComposite;
import com.github.swtmock.api.ILabel;
import com.github.swtmock.api.IText;

/**
 * This is an example of a composite with controls that open a modal
 * dialog.  This code for this composite is blocked until the modal dialog
 * is closed.
 * <P>
 * A design requirement of SWT-Mock is that the tests and the code being tested run on the same thread.
 * So we can't block when the modal dialog is opened.  Instead there are two approaches.
 * <OL>
 * <LI> Mock the modal dialogs, and have separate tests to test the modal dialogs.
 * This involves injecting a dialog factory into the composite.  We can then
 * mock the dialog factory.</LI>   
 * <LI> The composite opens the dialog using methods in IComposite.  If a mocked dialog
 * is to be used then a call-back must be provided that supplies the actions on the dialog.</LI>
 * </OL>
 * The first approach can be done using any standard mocking framework.  SWT-Mock
 * provides support for the second approach.
 *    
 * @author Nigel Westbury
 *
 */
public class OpeningModalDialogs extends CompositeImpl {

	IText text2;

	public OpeningModalDialogs(IComposite parent, int style) {
		super(parent, style);

		composite.setLayout(new GridLayout(2, false));
		
		ILabel label1 = composite.createLabel(SWT.NONE);
		label1.setText("Field 1:");
		final IText text1 = composite.createText(SWT.NONE);
		
		ILabel label2 = composite.createLabel(SWT.NONE);
		label2.setText("Field 2:");
		text2 = composite.createText(SWT.NONE);
		
		IButton action1 = composite.createButton(SWT.PUSH);
		action1.setText("Open Dialog 1");
		
		IButton action2 = composite.createButton(SWT.PUSH);
		action2.setText("Open Dialog 2");
		
		action1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Dialog1 dialogImpl = new Dialog1();
				int result = composite.openTrayDialog(dialogImpl);
				if (result == Window.OK) {
					text1.setText(dialogImpl.getValue());
				} else if (result == Window.CANCEL) {
					text1.setText("cancelled");
				}
			}
		});

		action2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				composite.openTrayDialog(new Dialog2(OpeningModalDialogs.this));
			}
		});
		
	}
}
