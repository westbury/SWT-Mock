package com.github.swtmock.examples;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import com.github.swtmock.api.BaseDialog;
import com.github.swtmock.api.IComposite;
import com.github.swtmock.api.IControl;
import com.github.swtmock.api.IText;

public class Dialog2 extends BaseDialog {

	private static final int DETAILS_ID     = IDialogConstants.CLIENT_ID + 0;
	
	private IText textValue;

	private OpeningModalDialogs openingModalDialogs;
	
	public Dialog2(OpeningModalDialogs openingModalDialogs) {
		this.openingModalDialogs = openingModalDialogs;
	}

	@Override
	public void createButtonsForButtonBar(IComposite parent) {
        parent.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        createButton(parent, DETAILS_ID, "Details", false); 

        createButton(parent, IDialogConstants.OK_ID,
                IDialogConstants.OK_LABEL, true);
	}

	@Override
	public IControl createDialogArea(IComposite parent) {
       IComposite workArea = parent.createComposite(SWT.NONE);
       GridLayout workLayout = new GridLayout(2, false);
       workLayout.marginHeight = 0;
       workLayout.marginWidth = 0;
       workLayout.verticalSpacing = 0;
       workLayout.horizontalSpacing = 0;
       workArea.setLayout(workLayout);
       workArea.setLayoutData(new GridData(GridData.FILL_BOTH));

  		workArea.createLabel(SWT.NONE).setText("Value:");
   		textValue = workArea.createText(SWT.NONE);

   		textValue.setText("foo");

       return workArea;
	}

	@Override
	public void buttonPressed(int buttonId) {
        switch (buttonId) {
        case Dialog.OK:
        	openingModalDialogs.text2.setText(textValue.getText());
        	// Fall through to super class implementation which closes
        	// the dialog with Window.OK return code
        	break;
        case Dialog.CANCEL:
        	openingModalDialogs.text2.setText("cancelled");
        	// Fall through to super class implementation which closes
        	// the dialog with Window.CANCEL return code
            break;
        case DETAILS_ID:
        	// This button leaves the dialog open
            break;
        default:
            break;
        }

        super.buttonPressed(buttonId);
	}

}
