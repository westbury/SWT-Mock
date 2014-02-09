/*******************************************************************************
 * Copyright (c) 2014 Nigel Westbury and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Nigel Westbury - initial API and implementation
 *******************************************************************************/

package com.github.swtmock.examples;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.github.swtmock.mock.MockComposite;
import com.github.swtmock.mock.SWTMockFactory;

/**
 * @author Nigel
 *
 */
public class SimpleComposite2Test {

	private static MockComposite composite;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@Before
	public void createSimpleComposite() throws Exception {
		composite = SWTMockFactory.createComposite();
		SimpleComposite2 compositeUnderTest = new SimpleComposite2(composite);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.github.swtmock.examples.SimpleComposite#SimpleComposite(com.github.swtmock.api.IComposite, int)}.
	 */
	@Test
	public void testSimpleComposite() throws Exception {
		composite.clickButton("Numbered");
	}

	/**
	 * Test method for {@link com.github.swtmock.api.CompositeImpl#setLayoutData(java.lang.Object)}.
	 */
	@Test
	public void testSetLayoutData() throws Exception {
		// TODO
		throw new RuntimeException("not yet implemented");
	}

}
