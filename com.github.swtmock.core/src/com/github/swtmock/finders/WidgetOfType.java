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

package com.github.swtmock.finders;

import com.github.swtmock.mock.MockControl;

public class WidgetOfType implements IMatcher<MockControl> {

	private Class<? extends MockControl> classOfControl;
	
	public WidgetOfType(Class<? extends MockControl> classOfControl) {
		this.classOfControl = classOfControl;
	}

	public boolean matches(MockControl control) {
		return classOfControl.isAssignableFrom(control.getClass());
	}

}
