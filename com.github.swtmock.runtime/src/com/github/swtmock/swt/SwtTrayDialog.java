package com.github.swtmock.swt;

import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import com.github.swtmock.api.IButton;
import com.github.swtmock.api.IComposite;
import com.github.swtmock.api.IControl;
import com.github.swtmock.api.IDialog;
import com.github.swtmock.api.ITrayDialog;

public class SwtTrayDialog extends TrayDialog implements ITrayDialog {

	IDialog dialog;

	protected SwtTrayDialog(Shell shell, IDialog dialog) {
		super(shell);
		this.dialog = dialog;
		dialog.setDelegateDialog(this);
	}

	protected void createButtonsForButtonBar(Composite parent) {
		IComposite buttonArea = new SwtComposite(parent);    	
		dialog.createButtonsForButtonBar(buttonArea);
	}

	protected Control createDialogArea(Composite parent) {
		IComposite dialogArea = new SwtComposite(parent);    	
		IControl control = dialog.createDialogArea(dialogArea);
		return ((SwtControl)control).getControl();
	}

	@Override
	public void buttonPressed(int buttonId) {
		/*
		 * JFace is processing a 'buttonPressed' and is passing the request to us.
		 * We in turn pass it on to the delegate.
		 */
		dialog.buttonPressed(buttonId);
	}

	@Override
	public void buttonPressedDelegated(int buttonId) {
		/*
		 * This method is only needed because Dialog.buttonPressed is protected
		 * and thus the ITrayDialog interface can't expose it for use.
		 * 
		 * It's really important this goes to the super method.  This is called when
		 * the user's buttonPressed implementation makes a call to the super method
		 * and we don't want to recurse back!
		 */
		super.buttonPressed(buttonId);
	}

	/**
	 * This method is called only if the user's implementation of
	 * this method in IDialog calls the super method.
	 * <P>
	 * So the flow would be 1) the above implementation of createDialogArea(Composite)
	 * is called by the JFace framework, 2) this calls into the user's implementation
	 * code, 3) the user's implementation code calls the super implementation in the
	 * user implementation class which 4) calls this method, 5) the base implementation
	 * in the JFace class is called.
	 * 
	 */
	@Override
	public IControl createDialogArea(IComposite parent) {
		SwtComposite swtParent = (SwtComposite)parent;
		Control control = super.createDialogArea((Composite)swtParent.getControl());
		return new SwtComposite((Composite)control);
	}

	@Override
	public void createButtonsForButtonBar(IComposite parent) {
		SwtComposite swtParent = (SwtComposite)parent;
		super.createButtonsForButtonBar((Composite)swtParent.getControl());
	}

	@Override
	public IButton createButton(IComposite parent, int id, String label,
			boolean defaultButton) {
		SwtComposite swtParent = (SwtComposite)parent;
		Button button = super.createButton((Composite)swtParent.getControl(), id, label, defaultButton);
		return new SwtButton(button);
	}

}
