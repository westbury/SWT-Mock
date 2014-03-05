package com.github.swtmock.api;

import org.eclipse.swt.widgets.Composite;

import com.github.swtmock.swt.SwtComposite;

public class SwtFactory {

	public static IComposite getAccessorForComposite(Composite composite) {
		return new SwtComposite(composite);
	}

}
