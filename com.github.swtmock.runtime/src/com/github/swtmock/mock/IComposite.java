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

import org.eclipse.swt.widgets.Layout;

public interface IComposite {

	IComposite createComposite(int style);

	void setLayout(Layout layout);

	IButton createButton(int style);

	ILabel createLabel(int style);

	ITableViewer createTableViewer(int style);

}
