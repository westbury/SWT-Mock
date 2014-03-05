package com.github.swtmock.mock;

import java.util.LinkedList;
import java.util.List;

import com.github.swtmock.api.IDisplay;
import com.github.swtmock.api.IShell;

public class MockShell extends MockComposite implements IShell {

	List<IExpectedModalDialog> expectedModalDialogs = new LinkedList<>();
	
	private MockDisplay display;

	public MockShell(MockShell parentShell) {
		super(null);
		this.shell = this;
		
		if (parentShell == null) {
			display = new MockDisplay();
		} else {
			display = parentShell.display;
		}
		display.shells.add(this);
	}

	@Override
	public IDisplay getDisplay() {
		return display;
	}

	public IExpectedModalDialog popExpectedModal() {
		if (expectedModalDialogs.isEmpty()) {
			throw new RuntimeException("A dialog unexpectedly opened.");
		}
		IExpectedModalDialog expected = expectedModalDialogs.remove(0);
		return expected;
	}

	public void setExpectedModal(IExpectedModalDialog expectedModalDialog) {
		if (!expectedModalDialogs.isEmpty()) {
			throw new RuntimeException("Modal dialog expected but was never opened.");
		}
		expectedModalDialogs.add(expectedModalDialog);
	}

	public boolean isClosed() {
		return isDisposed();
	}

	@Override
	public void close() {
		for (MockControl child : children) {
			child.dispose();
		}
		super.dispose();
	}

}
