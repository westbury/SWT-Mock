package com.github.swtmock.examples;

import org.eclipse.swt.SWT;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.github.swtmock.api.IComposite;
import com.github.swtmock.mock.IExpectedModalDialog;
import com.github.swtmock.mock.MockComposite;
import com.github.swtmock.mock.MockShell;
import com.github.swtmock.mock.SWTMockFactory;

public class OpeningModalDialogsTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

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
		OpeningModalDialogs compositeUnderTest = new OpeningModalDialogs(parent, SWT.NONE);
		composite = (MockComposite)compositeUnderTest.getComposite(); 
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDialogOpens() throws Exception {
		composite.clickButton(
				"Open Dialog 1", 
				new IExpectedModalDialog() {
					@Override
					public void performModalActions(MockShell mockDialog) {
						mockDialog.clickButton("OK");
					}
				});
	}

	@Test
	public void testDialogNotClosed() throws Exception {
		thrown.expect(RuntimeException.class);
	    thrown.expectMessage("Modal dialog was not closed");
	    
	    composite.clickButton(
				"Open Dialog 1", 
				new IExpectedModalDialog() {
					@Override
					public void performModalActions(MockShell mockDialog) {
						mockDialog.clickButton("Details");
					}
				});
	}

}
