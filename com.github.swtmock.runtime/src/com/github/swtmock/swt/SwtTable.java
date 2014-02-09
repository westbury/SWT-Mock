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

import org.eclipse.swt.widgets.Table;

import com.github.swtmock.api.ITable;

public class SwtTable extends SwtControl implements ITable {

	private Table table;
	
	public SwtTable(Table table) {
		super(table);
		this.table = table;
	}

}
