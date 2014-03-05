package com.github.swtmock.mock;

public class ControlNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	protected String text;
	
	protected int style;
	
	protected MockComposite mockComposite;

	public ControlNotFoundException(String text, int style, MockComposite mockComposite) {
		this.text = text;
		this.style = style;
		this.mockComposite = mockComposite;
	}

}
