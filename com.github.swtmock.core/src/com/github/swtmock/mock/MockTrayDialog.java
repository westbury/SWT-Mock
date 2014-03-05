package com.github.swtmock.mock;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

import com.github.swtmock.api.IButton;
import com.github.swtmock.api.IComposite;
import com.github.swtmock.api.IControl;
import com.github.swtmock.api.IDialog;
import com.github.swtmock.api.ITrayDialog;

public class MockTrayDialog implements ITrayDialog {

	MockShell shell;
	
	IDialog dialog;

	/**
	 * Window return code; initially <code>OK</code>.
	 */
	private int returnCode = Window.OK;

	/**
	 * 
	 * @param shell the shell that is this dialog
	 * @param dialog the actual implementation
	 */
	MockTrayDialog(MockShell shell, IDialog dialog) {
		this.shell = shell;
		this.dialog = dialog;
	}

	@Override
	public IControl createDialogArea(IComposite parent) {
		// Emulate the default JFace implementation
		return parent.createComposite(SWT.NONE);
	}

	@Override
	public void createButtonsForButtonBar(IComposite parent) {
		// Is there anything we need to do in the default implementation here?
	}

	@Override
	public IButton createButton(IComposite parent, final int buttonId,
			String label, boolean defaultButton) {
		IButton button = parent.createButton(SWT.PUSH);
		button.setText(label);

		/*
		 * If the button is 'pressed' by the test then we do what
		 * JFace would do, we pass the request to the user implementation
		 * of buttonPressed.
		 */
		button.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				dialog.buttonPressed(buttonId);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				dialog.buttonPressed(buttonId);
			}
		});

		return button;
	}

	@Override
	public int open() {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * This method called buttonPressedDelegated and not buttonPressed only because
	 * Dialog.buttonPressed is protected
	 * and thus the ITrayDialog interface can't expose it for use.
	 */
	@Override
	public void buttonPressedDelegated(int buttonId) {
		/*
		 * This method is called when the user implementation of buttonPressed
		 * in the delegate calls the super method.
		 */
		if (IDialogConstants.OK_ID == buttonId) {
			okPressed();
		} else if (IDialogConstants.CANCEL_ID == buttonId) {
			cancelPressed();
		}
	}


	/**
	 * Notifies that the ok button of this dialog has been pressed.
	 * <p>
	 * The <code>Dialog</code> implementation of this framework method sets
	 * this dialog's return code to <code>Window.OK</code> and closes the
	 * dialog. Subclasses may override.
	 * </p>
	 */
	protected void okPressed() {
		// TODO because the user can override this, we should really defer to an implementation
		// in IDialog.
		setReturnCode(Window.OK);
		close();
	}

	/**
	 * Notifies that the cancel button of this dialog has been pressed.
	 * <p>
	 * The <code>Dialog</code> implementation of this framework method sets
	 * this dialog's return code to <code>Window.CANCEL</code> and closes the
	 * dialog. Subclasses may override if desired.
	 * </p>
	 */
	protected void cancelPressed() {
		// TODO because the user can override this, we should really defer to an implementation
		// in IDialog.
		setReturnCode(Window.CANCEL);
		close();
	}

	/**
	 * Sets this window's return code. The return code is automatically returned
	 * by <code>open</code> if block on open is enabled. For non-blocking
	 * opens, the return code needs to be retrieved manually using
	 * <code>getReturnCode</code>.
	 * 
	 * @param code
	 *            the return code
	 */
	// Copied from Window
	protected void setReturnCode(int code) {
		returnCode = code;
	}

	@Override
	public boolean close() {
		shell.dispose();
		
		return true;
	}

	int getReturnCode() {
		return returnCode;
	}
}