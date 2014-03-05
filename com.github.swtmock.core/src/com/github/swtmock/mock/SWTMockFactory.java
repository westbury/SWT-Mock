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


public class SWTMockFactory {

	/**
	 * Create a mock composite.  Typically constructors for classes under test take
	 * as the first parameter the parent composite.  This method is will create a mock
	 * composite suitable for passing as the parent composite.  The composite returned
	 * by this method could also be used as the composite under test, being the
	 * composite that contains controls.
	 *  
	 * @return
	 */
	public static MockComposite createComposite() {
		
		return new MockShell(null);
	}

}
