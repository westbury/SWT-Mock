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

package com.github.swtmock.api;



/**
 * This is a convenience class that may be used as the base class for
 * composite controls.  It is not compulsory to use this class.
 * 
 * @author Nigel Westbury
 */
public class CompositeImpl {

	protected final IComposite composite;
	
	public CompositeImpl(IComposite parent, int style) {
		composite = parent.createComposite(style);
	}

	public void setLayoutData(Object layoutData) {
		composite.setLayoutData(layoutData);
	}

	public void dispose() {
		composite.dispose();
	}

	/**
	 * Gets the composite interface wrapper.
	 * 
	 * @return
	 */
	public IComposite getComposite() {
		return composite;
	}
}
