package com.github.swtmock.api;


public class BaseDialog implements IDialog {

	private ITrayDialog delegateDialog;
	
	/**
	 * This method is used internally by the real and the mocked packages.
	 */
	public void setDelegateDialog(ITrayDialog delegateDialog) {
		this.delegateDialog = delegateDialog;
	}
	
	@Override
	public void createButtonsForButtonBar(IComposite parent) {
		/*
		 * We're trying to keep the API as close as possible to the SWT API, so
		 * we provide this base method implementation.
		 * 
		 * We want to call into the method of the same name in JFace Dialog if
		 * this is running with real SWT.
		 */
		delegateDialog.createButtonsForButtonBar(parent);
	}

	protected IButton createButton(IComposite parent, int id, String label,
			boolean defaultButton) {
		/*
		 * We're trying to keep the API as close as possible to the SWT API, so
		 * we provide this base method implementation.
		 * 
		 * We want to call into the method of the same name in JFace Dialog if
		 * this is running with real SWT.
		 */
		return delegateDialog.createButton(parent, id, label, defaultButton);
	}

	@Override
	public IControl createDialogArea(IComposite parent) {
		/*
		 * We're trying to keep the API as close as possible to the SWT API, so
		 * we provide this base method implementation.
		 * 
		 * We want to call into the method of the same name in JFace Dialog if
		 * this is running with real SWT.
		 */
		return delegateDialog.createDialogArea(parent);
	}

	@Override
	public void buttonPressed(int buttonId) {
		delegateDialog.buttonPressedDelegated(buttonId);
	}

	public void open() {
		delegateDialog.open();
	}

	@Override
	public boolean close() {
		return delegateDialog.close();
	}

}
