package com.github.swtmock.mock;

/**
 * A test case may perform an action that brings up a modal dialog.  Typically
 * a button press or the selection of a context menu item might do this.  The problem
 * is that the call is blocked until the modal dialog is closed, so we need a means to
 * deal with the dialog.  This interface provides that means.
 * <P>
 * Any action performed by a test case that is expected to open a modal dialog must pass an
 * implementation of this interface.  This interface has a single method that deals with the
 * modal dialog.  If a modal dialog is opened and no implementation of this interface is provided
 * then the test will fail.
 * 
 * @author Nigel Westbury
 *
 */
public interface IExpectedModalDialog {

	void performModalActions(MockShell mockDialog);
}
