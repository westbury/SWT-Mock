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

import org.eclipse.swt.SWT;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.github.swtmock.api.IComposite;
import com.github.swtmock.mock.MockComposite;
import com.github.swtmock.mock.MockTable;
import com.github.swtmock.mock.SWTMockFactory;

/**
 * @author Nigel
 *
 */
public class SimpleCompositeTest {
	private static IComposite parent;

	private MockComposite composite;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		parent = SWTMockFactory.createComposite();

	}

	@Before
	public void createSimpleComposite() throws Exception {
		SimpleComposite compositeUnderTest = new SimpleComposite(parent, SWT.NONE);
		composite = (MockComposite)compositeUnderTest.getComposite(); 
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

	@Test
	public void testNumbersButton() throws Exception {
		composite.clickButton("Numbered");
		
		MockTable table = composite.table("Values:");
		Assert.assertTrue(table.containsExactly(new String [] { "value 1", "value 2" }));
	}

	@Test
	public void testLettersButton() throws Exception {
		composite.clickButton("Lettered");
		
		MockTable table = composite.table("Values:");
		Assert.assertTrue(table.containsExactly(new String [] { "value A", "value B" }));
	}

}
