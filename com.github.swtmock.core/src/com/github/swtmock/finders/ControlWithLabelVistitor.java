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

/**
 * A control visitor that looks for a control that follows a label.
 * <P>
 * This visitor will wait until it gets a control that matches the label
 * matcher.  If labelIndex is greater than zero then it waits not for the
 * first such label but for the n+1'th such label.  So, for example, if
 * labelIndex is 2 then this visitor waits until the third label that matches
 * the labelMatcher.  Then this visitor will wait until it gets a control that
 * matches the control matcher.  Again, if the control index is not zero then
 * it will get the n+1'th such control.
 * 
 */
public class ControlWithLabelVistitor implements IWidgetVisitor<MockControl> {
	private IMatcher<MockControl> labelMatcher;
	private IMatcher<MockControl> controlMatcher;
	private int labelCounter;
	private int controlCounter;

	/**
	 * 
	 * @param labelmatcher
	 *            the matcher for the label
	 * @param controlmatcher
	 *            the matcher for the control that follows the label
	 * @param labelindex
	 *            the zero-based index of the label, normally zero but can
	 *            be more than zero if there is more than one such label and
	 *            it is not the first one that is required
	 * @param controlindex
	 *            the zero-based index of the control that follows the
	 *            label, normally zero but can be more than zero if there is
	 *            more than one such control and it is not the first one
	 *            that is required
	 */
	public ControlWithLabelVistitor(IMatcher<MockControl> labelMatcher,
			IMatcher<MockControl> controlMatcher, int labelIndex, int controlIndex) {
		this.labelMatcher = labelMatcher;
		this.controlMatcher = controlMatcher;
		this.labelCounter = labelIndex + 1;
		this.controlCounter = controlIndex + 1;
	}

	public boolean visit(MockControl w) {
		if (labelCounter > 0) {
			if (labelMatcher.matches(w)) {
				labelCounter--;
			}
		} else {
			// We have already reached the required label, so
			// we are now looking for the control.
			if (controlMatcher.matches(w)) {
				controlCounter--;
				if (controlCounter == 0) {
					return true;
				}
			}
		}

		return false;
	}
}
