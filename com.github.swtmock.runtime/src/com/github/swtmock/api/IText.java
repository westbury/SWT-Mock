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

import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Font;

public interface IText extends IControl {

	void setText(String text);

	String getText();

	void addModifyListener(ModifyListener listener);

	void removeModifyListener(ModifyListener listener);
	
	void setFont(Font font);

	void setCursor(Cursor cursor);

}
