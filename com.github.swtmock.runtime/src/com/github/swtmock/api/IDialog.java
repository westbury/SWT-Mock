package com.github.swtmock.api;



public interface IDialog {

	void setDelegateDialog(ITrayDialog delegateDialog);

	void createButtonsForButtonBar(IComposite buttonArea);

	IControl createDialogArea(IComposite dialogArea);

	void buttonPressed(int buttonId);

	boolean close();

}
