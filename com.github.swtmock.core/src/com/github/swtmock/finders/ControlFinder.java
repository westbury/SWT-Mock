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
 * A control visitor that looks for a control.
 * <P>
 * This visitor will wait until it gets a control that matches the control
 * matcher.  If controlIndex is greater than zero then it waits not for the
 * first such control but for the n+1'th such control.  So, for example, if
 * controlIndex is 2 then this visitor waits until the third control that matches
 * the controlMatcher.
 */
public class ControlFinder<T> implements IWidgetVisitor<T> {
	private IMatcher<T> controlMatcher;
	private int controlCounter;

	/**
	 * 
	 * @param controlmatcher
	 *            the matcher for the control that follows the label
	 * @param controlindex
	 *            the zero-based index of the control that follows the
	 *            label, normally zero but can be more than zero if there is
	 *            more than one such control and it is not the first one
	 *            that is required
	 */
	public ControlFinder(IMatcher<T> controlMatcher, int controlIndex) {
		this.controlMatcher = controlMatcher;
		this.controlCounter = controlIndex + 1;
	}

	public boolean visit(T w) {
		if (controlMatcher.matches(w)) {
			controlCounter--;
			if (controlCounter == 0) {
				return true;
			}
		}

		return false;
	}
}
