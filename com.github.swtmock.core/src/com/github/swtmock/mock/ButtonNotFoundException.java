package com.github.swtmock.mock;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import com.github.swtmock.api.IButton;
import com.github.swtmock.finders.IWidgetVisitor;

public class ButtonNotFoundException extends ControlNotFoundException {

	private static final long serialVersionUID = 1L;

	public ButtonNotFoundException(String text, int style, MockComposite mockComposite) {
		super(text, style, mockComposite);
	}

	@Override
	public String getMessage() {
		final StringBuffer buffer = new StringBuffer();
		buffer.append(MessageFormat.format("Button with text {0} was not found.  ", text));

		/*
		 * Look for controls with the given text but that are of any type.  This allows
		 * a useful message to be given if the test author got the text correct but got
		 * the type of control wrong.
		 */
		//			MockButton foundButton = (MockButton)mockComposite.searchControls(new ControlFinder<MockControl>(
		//					new WidgetOfTypeAndMatch<MockButton>(MockButton.class, new IMatcher<MockButton>() {
		//						public boolean matches(MockButton control) {
		//							return (control.getStyle() & (SWT.CHECK | SWT.RADIO)) == 0
		//									&& control.getText().equals(text);
		//						}
		//					}),
		//					0
		//				)
		//			);

		/*
		 * Look for controls with the given control type and style but with any text.  This allows
		 * a useful message to be given if the test author got the control type and style correct but
		 * did not get the text correct.
		 */
		final List<IButton> otherButtons = new ArrayList<IButton>();
		mockComposite.searchControls(new IWidgetVisitor<MockControl>() {
			@Override
			public boolean visit(MockControl widget) {
				if (widget instanceof IButton) {
					IButton button = (IButton)widget;
					if ((button.getStyle() & style) == style) {
						otherButtons.add(button);
					}
				}
				return false;
			}
		});

		if (!otherButtons.isEmpty()) {
			buffer.append("  Buttons found are: ");

			String separator = "";
			for (IButton otherButton : otherButtons) {
				buffer.append(separator)
				.append(otherButton.getText());
				separator = ", ";
			}
		}

		return buffer.toString();
	}
}
