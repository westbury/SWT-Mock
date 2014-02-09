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
import java.util.List;

import org.eclipse.core.runtime.ListenerList;

import com.github.swtmock.api.ITable;

public class MockTable extends MockControl implements ITable {

	private ListenerList listeners = new ListenerList();
	
	private List<String[]> rows = new ArrayList<String[]>();
	
	public MockTable(int style) {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param labels
	 * @return true if the table contains exactly the given labels
	 * 		in the given order in the first column, false otherwise
	 */
	public boolean containsExactly(String[] labels) {
		if (labels.length != rows.size()) {
			return false;
		}
		
		for (int i = 0; i < labels.length; i++) {
			if (!labels[i].equals(rows.get(i)[0])) {
				return false;
			}
		}
		
		return true;
	}

	public void setRows(List<String[]> rows) {
		this.rows = rows;
	}

}
