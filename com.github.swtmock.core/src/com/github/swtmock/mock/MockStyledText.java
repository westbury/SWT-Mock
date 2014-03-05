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
import org.eclipse.swt.widgets.Caret;

import com.github.swtmock.api.IStyledText;


public class MockStyledText extends MockControl implements IStyledText {

	private String text = "";
	
	private ListenerList listenerList = new ListenerList();
	
	public MockStyledText(MockComposite parent, int style) {
		super(parent, style);
	}

	@Override
	public void setText(String text) {
		this.text = text;
		
		for (Object listener : listenerList.getListeners()) {
			((ModifyListener)listener).modifyText(null);
		}
	}

	@Override
	public String getText() {
		return text;
	}

	@Override
	public void addModifyListener(ModifyListener listener) {
		listenerList.add(listener);
	}

	@Override
	public void removeModifyListener(ModifyListener listener) {
		listenerList.remove(listener);
	}

	@Override
	public void setCursor(Cursor cursor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCaret(Caret caret) {
		// TODO Auto-generated method stub
		
	}

}
