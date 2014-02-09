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

public interface IMockableStructuredContentProvider extends IMockableContentProvider {
    /**
     * Returns the elements to display in the viewer 
     * when its input is set to the given element. 
     * These elements can be presented as rows in a table, items in a list, etc.
     * The result is not modified by the viewer.
     * 
     * @param inputElement the input element
     * @return the array of elements to display in the viewer
     */
    public Object[] getElements(Object inputElement);
}
