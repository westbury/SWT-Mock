package com.github.swtmock.api;


/**
 * This is a convenience class that may be used as the base class for
 * composite controls.  It is not compulsory to use this class.
 * 
 * @author Nigel Westbury
 */
public class CompositeImpl {

	protected final IComposite composite;
	
	public CompositeImpl(IComposite parent, int style) {
		composite = parent.createComposite(style);
	}

	public void setLayoutData(Object layoutData) {
		composite.setLayoutData(layoutData);
	}

	public void dispose() {
		composite.dispose();
	}

}
