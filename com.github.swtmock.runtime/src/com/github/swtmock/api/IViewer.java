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

package com.github.swtmock.api;

import org.eclipse.jface.viewers.IStructuredSelection;

public interface IViewer {

	IControl getControl();

	void setInput(Object input);

	IStructuredSelection getSelection();

	void setSelection(IStructuredSelection selection);

}
