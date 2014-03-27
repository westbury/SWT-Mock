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

import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Layout;

public interface IComposite extends IControl {

	IComposite createComposite(int style);

	Layout getLayout();

	void setLayout(Layout layout);

	ILabel createLabel(int style);

	IText createText(int style);

	IStyledText createStyledText(int style);

	IButton createButton(int style);

	ITableViewer createTableViewer(int style);

	ITabFolder createTabFolder(int style);

	ITabFolder createCTabFolder(int style);

	IScrolledComposite createScrolledComposite(int style);

	IGC createGC();

	int openTrayDialog(IDialog dialog);

	Rectangle getClientArea();

	void layout(boolean changed);

	IJFaceColors getJFaceColors();

	ISlider createSlider(int style);

}
