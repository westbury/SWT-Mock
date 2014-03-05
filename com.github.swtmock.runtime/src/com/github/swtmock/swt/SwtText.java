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

import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.widgets.Text;

import com.github.swtmock.api.IText;

public class SwtText extends SwtControl implements IText {

	private Text text;

	public SwtText(Text text) {
		super(text);
		this.text = text;
	}

	@Override
	public void setText(String value) {
		text.setText(value);
	}

	@Override
	public String getText() {
		return text.getText();
	}

	@Override
	public void addModifyListener(ModifyListener listener) {
		text.addModifyListener(listener);
	}

	@Override
	public void removeModifyListener(ModifyListener listener) {
		text.removeModifyListener(listener);
	}

	@Override
	public void setCursor(Cursor cursor) {
		text.setCursor(cursor);
	}

}
