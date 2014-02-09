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


/**
 * 
 * @author Nigel Westbury
 *
 * @param <T> type of widget which may be passed to this matcher
 */
public interface IMatcher<T> {
	boolean matches(T control);
}
