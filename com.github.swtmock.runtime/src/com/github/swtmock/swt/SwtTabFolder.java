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

import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.TabFolder;

import com.github.swtmock.api.ITabFolder;
import com.github.swtmock.api.ITabItem;

public class SwtTabFolder extends SwtControl implements ITabFolder {

	private TabFolder nativeTabFolder = null;
	private CTabFolder customTabFolder = null;

	public SwtTabFolder(TabFolder folder) {
		super(folder);
		this.nativeTabFolder = folder;
	}

	public SwtTabFolder(CTabFolder folder) {
		super(folder);
		this.customTabFolder = folder;
	}

	@Override
	public void addSelectionListener(SelectionListener listener) {
		if (nativeTabFolder != null) {
			nativeTabFolder.addSelectionListener(listener);
		}
		if (customTabFolder != null) {
			customTabFolder.addSelectionListener(listener);
		}
	}

	@Override
	public void removeSelectionListener(SelectionListener listener) {
		if (nativeTabFolder != null) {
			nativeTabFolder.removeSelectionListener(listener);
		}
		if (customTabFolder != null) {
			customTabFolder.removeSelectionListener(listener);
		}
	}

	@Override
	public ITabItem createTabItem(int style) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ITabItem createTabItem(int style, int index) {
		// TODO Auto-generated method stub
		return null;
	}

}
