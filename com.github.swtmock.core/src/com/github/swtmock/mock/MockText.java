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
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Event;

import com.github.swtmock.api.IText;


public class MockText extends MockControl implements IText {

	private String text = "";
	
	private ListenerList listenerList = new ListenerList();
	
	public MockText(int style) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setText(String text) {
		this.text = text;
		
		ModifyEvent event = new ModifyEvent(new Event()); 
		for (Object listener : listenerList.getListeners()) {
			((ModifyListener)listener).modifyText(event);
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

}
