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

import org.eclipse.core.runtime.ListenerList;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Cursor;

import com.github.swtmock.api.IText;


public class MockText extends MockControl implements IText {

	private String text = "";
	
	private ListenerList listenerList = new ListenerList();
	
	public MockText(MockComposite parent, int style) {
		super(parent, style);
	}

	@Override
	public void setText(String text) {
		checkWidget();
		this.text = text;
		
		for (Object listener : listenerList.getListeners()) {
			((ModifyListener)listener).modifyText(null);
		}
	}

	@Override
	public String getText() {
		checkWidget();
		return text;
	}

	@Override
	public void addModifyListener(ModifyListener listener) {
		checkWidget();
		listenerList.add(listener);
	}

	@Override
	public void removeModifyListener(ModifyListener listener) {
		checkWidget();
		listenerList.remove(listener);
	}

	@Override
	public void setCursor(Cursor cursor) {
		checkWidget();

		// TODO Auto-generated method stub
	}

}
