/*******************************************************************************
 * Copyright (c) 2014 Nigel Westbury and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Nigel Westbury - initial API and implementation
 ******************************************************************************/

package com.github.swtmock.examples.snippets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.github.swtmock.api.IComposite;
import com.github.swtmock.api.SwtFactory;
import com.github.swtmock.examples.OpeningModalDialogs;

/**
 * This snippet opens a shell with a simple composite with a few controls including
 * a table.  This snippet allows one to view the example composite.  It also demonstrates
 * how to use a testable implementation of a Composite in your SWT application.
 */
public class Snippet000OpeningModalDialogs {
	public static void main(String[] args) {
		Display display = new Display();

		// Build a UI
		Shell shell = new Shell(display);
		shell.setLayout(new RowLayout(SWT.VERTICAL));

		// create a mockable interface for the shell, and pass it as
		// the parent to the testable composite.
		IComposite composite = SwtFactory.getAccessorForComposite(shell);
		new OpeningModalDialogs(composite, SWT.NONE);
		
		shell.pack();
		shell.open();

		// The SWT event loop
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
