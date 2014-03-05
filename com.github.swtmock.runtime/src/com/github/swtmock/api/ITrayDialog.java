package com.github.swtmock.api;


/**
 * Interface to the dialog, implemented by both SwtTrayDialog and MockTrayDialog.
 * <P>
 * Some of the methods in this interface are suffixed with 'Delegated'.  The reason for
 * this is that the method in the SWT widget is protected and that prevents this interface
 * from exposing the method directly.
 * 
 * @author Nigel Westbury
 * @noimplement
 */
public interface ITrayDialog {

	/**
	 * This method is provided because the implementation of this method may want to
	 * call the super method provided by JFace.
	 * <P>
	 * The SWT implementation of this method is provided directly by the JFace Dialog class which
	 * is a base class for the class that implements this interface.  The mock version must emulate
	 * the same behavior which means it creates an empty mock composite.
	 * 
	 * @param parent
	 * @return
	 */
	IControl createDialogArea(IComposite parent);

	void createButtonsForButtonBar(IComposite parent);

	IButton createButton(IComposite parent, int id, String label,
			boolean defaultButton);

	int open();

	/*
	 * This method called buttonPressedDelegated and not buttonPressed only because
	 * Dialog.buttonPressed is protected
	 * and thus the ITrayDialog interface can't expose it for use.
	 */
	void buttonPressedDelegated(int buttonId);

	boolean close();

}
