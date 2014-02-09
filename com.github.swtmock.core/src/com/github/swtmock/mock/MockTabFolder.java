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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.ListenerList;
import org.eclipse.swt.events.SelectionListener;

import com.github.swtmock.api.ITabFolder;
import com.github.swtmock.api.ITabItem;
import com.github.swtmock.finders.IWidgetVisitor;

public class MockTabFolder extends MockControl implements ITabFolder {

	private ListenerList listeners = new ListenerList();

	private List<MockTabItem> tabs = new ArrayList<MockTabItem>();

	private List<MockTabItem> selection = new ArrayList<MockTabItem>();
	
	/**
	 * 
	 * @param style
	 * @param isCustom true if this is a custom tab folder, false
	 * 		if this is a native tab folder
	 */
	public MockTabFolder(int style, boolean isCustom) {
	}

	@Override
	public void addSelectionListener(SelectionListener listener) {
		listeners.add(listener);
	}

	@Override
	public void removeSelectionListener(SelectionListener listener) {
		listeners.remove(listener);
	}

	public void click() {
		for (Object listener : listeners.getListeners()) {
			((SelectionListener)listener).widgetSelected(null);
		}
	}

	@Override
	public ITabItem createTabItem(int style) {
		MockTabItem item = new MockTabItem();
		tabs.add(item);
		return item;
	}

	@Override
	public ITabItem createTabItem(int style, int index) {
		MockTabItem item = new MockTabItem();
		tabs.add(index, item);
		return item;
	}

	public List<MockTabItem> getTabItems() {
		return Collections.unmodifiableList(tabs);
	}

	public MockTabItem[] getMockSelection() {
		return selection.toArray(new MockTabItem[0]);
	}

	public MockTabItem visitTabItems(IWidgetVisitor<MockTabItem> visitor) {
		for (MockTabItem tabItem : tabs) {
			if (visitor.visit(tabItem)) {
				return tabItem;
			}
		}
		
		// Now look in the selected tab for nested tab folders
		
		MockTabItem[] selection = getMockSelection();
//		Assert.assertEquals(1, selection.length);
		MockControl topControlInTab = selection[0].getMockControl();

		if (topControlInTab instanceof MockTabFolder) {
			MockTabItem match = ((MockTabFolder)topControlInTab).visitTabItems(visitor);
			if (match != null) {
				return match;
			}
		} else if (topControlInTab instanceof MockComposite) {
			MockTabItem match = ((MockComposite)topControlInTab).visitTabItems(visitor);
			if (match != null) {
				return match;
			}
		}

		return null;
	}

	public MockControl visitControls(IWidgetVisitor<MockControl> visitor) {
		MockTabItem[] selection = getMockSelection();
//		Assert.assertEquals(1, selection.length);
		MockControl topControlInTab = selection[0].getMockControl();
		if (visitor.visit(topControlInTab)) {
			return topControlInTab;
		}
		if (topControlInTab instanceof MockTabFolder) {
			MockControl match = ((MockTabFolder)topControlInTab).visitControls(visitor);
			if (match != null) {
				return match;
			}
		} else if (topControlInTab instanceof MockComposite) {
			MockControl match = ((MockComposite)topControlInTab).visitControls(visitor);
			if (match != null) {
				return match;
			}
		}
		
		return null;
	}
}
