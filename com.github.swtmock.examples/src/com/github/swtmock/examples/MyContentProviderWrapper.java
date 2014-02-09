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

import org.eclipse.jface.viewers.IStructuredContentProvider;

import com.github.swtmock.api.IMockableStructuredContentProvider;
import com.github.swtmock.api.IViewer;


/**
 * This wrapper converts a standard JFace content provider to a content
 * provider that can be used with the mocked SWT classes.  It only works
 * when the content provider makes no attempt to access the viewer, i.e.
 * the content does not update, or at least the content provider does not
 * update the viewer.
 * 
 * @author Nigel Westbury
 *
 */
public class MyContentProviderWrapper implements IMockableStructuredContentProvider {

	IStructuredContentProvider wrapped;
	
	public MyContentProviderWrapper(IStructuredContentProvider wrapped) {
		this.wrapped = wrapped;
	}

	@Override
	public void dispose() {
		wrapped.dispose();
	}

	@Override
	public void inputChanged(IViewer viewer, Object oldInput, Object newInput) {
		// If you get an NPE because the wrapped class attempts to access the
		// viewer then you can't use this class.
		wrapped.inputChanged(null, oldInput, newInput);
	}

	@Override
	public Object[] getElements(Object inputElement) {
		return wrapped.getElements(inputElement);
	}

}
