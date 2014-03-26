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

package com.github.swtmock.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Layout;

import com.github.swtmock.api.IButton;
import com.github.swtmock.api.IComposite;
import com.github.swtmock.api.IDialog;
import com.github.swtmock.api.IGC;
import com.github.swtmock.api.IJFaceColors;
import com.github.swtmock.api.ILabel;
import com.github.swtmock.api.IScrolledComposite;
import com.github.swtmock.api.IShell;
import com.github.swtmock.api.ISlider;
import com.github.swtmock.api.IStyledText;
import com.github.swtmock.api.ITabFolder;
import com.github.swtmock.api.ITableViewer;
import com.github.swtmock.api.IText;
import com.github.swtmock.finders.ControlFinder;
import com.github.swtmock.finders.ControlWithLabelVistitor;
import com.github.swtmock.finders.IMatcher;
import com.github.swtmock.finders.IWidgetVisitor;
import com.github.swtmock.finders.WidgetOfType;
import com.github.swtmock.finders.WidgetOfTypeAndMatch;

public class MockComposite extends MockControl implements IComposite {

	protected List<MockControl> children = new ArrayList<>();

	private Layout layout = null;

	/**
	 * This shell that contains this composite.
	 */
	protected MockShell shell;
	
	/**
	 * This constructor is used internally.
	 * 
	 * @param parent
	 * @param style
	 */
	protected MockComposite(MockComposite parent, int style) {
		super(parent, style);
		this.shell = parent.shell;
	}

	/**
	 * This constructor is used to create the top-level mock
	 * composite.
	 */
	public MockComposite(MockShell shell) {
		super(null, SWT.NONE);
		this.shell = shell;
	}

	@Override
	public IComposite createComposite(int style) {
		MockComposite childComposite = new MockComposite(this, style);
		children.add(childComposite);
		return childComposite;
	}

	@Override
	public Layout getLayout() {
		return layout;
	}

	@Override
	public void setLayout(Layout layout) {
		this.layout = layout;
	}

	@Override
	public IButton createButton(int style) {
		MockButton button = new MockButton(this, style);
		children.add(button);
		return button;
	}

	@Override
	public ILabel createLabel(int style) {
		MockLabel label = new MockLabel(this, style);
		children.add(label);
		return label;
	}

	@Override
	public IText createText(int style) {
		MockText text = new MockText(this, style);
		children.add(text);
		return text;
	}

	@Override
	public ITableViewer createTableViewer(int style) {
		// Create the table first
		MockTable table = new MockTable(this, style);
		children.add(table);
		
		// then the viewer
		MockTableViewer viewer = new MockTableViewer(table);
		return viewer;
	}

	@Override
	public ITabFolder createTabFolder(int style) {
		MockTabFolder folder = new MockTabFolder(this, style, false);
		children.add(folder);
		return folder;
	}

	@Override
	public ITabFolder createCTabFolder(int style) {
		MockTabFolder folder = new MockTabFolder(this, style, true);
		children.add(folder);
		return folder;
	}

	/**
	 * Clicks the button with the given text.
	 * 
	 * @param text
	 */
	public void clickButton(final String text) {
		button(text).click();
	}

	public void clickButton(String text,
			IExpectedModalDialog expectedModalDialog) {
		
		shell.setExpectedModal(expectedModalDialog);
		
		button(text).click();
		
	}


//	private <C extends ControlMock> C findControl(Class<C> classOfControl,
//			ControlFinder<C> controlFinder) {
//		C result = null;
//		for (ControlMock control : children) {
//			if (classOfControl.isAssignableFrom(control.getClass())) {
//				C control2 = classOfControl.cast(control);
//				if (controlFinder.matches(control2)) {
//					if (result == null) {
//						result = control2;
//					} else {
//						throw new RuntimeException("Multiple controls match");
//					}
//				}
//			} else if (control instanceof CompositeMock) {
//				C match = ((CompositeMock)control).findControl(classOfControl, controlFinder);
//				if (match != null) {
//					if (result == null) {
//						result = match;
//					} else {
//						throw new RuntimeException("Multiple controls match");
//					}
//				}
//			}
//		}
//		return result;
//	}

	public void setTextWithLabel(String label, String text) {
		MockText textBot = textWithLabel(label);
	    textBot.setText(text);
		
	}

	public void setComboBoxWithLabel(String label, String text) {
		MockCombo comboBot = comboWithLabel(label);
	    comboBot.setSelection(text);
	}

	/**
	 * Finds the first Text control that follows the first Label that contains the given text.
	 * Only the given part is searched.
	 * 
	 * @param labelText
	 * @return
	 */
	public MockText textWithLabel(final String labelText) {
		MockText foundText = (MockText)searchControls(new ControlWithLabelVistitor(
				new WidgetOfTypeAndMatch<MockLabel>(MockLabel.class, new IMatcher<MockLabel>() {
					public boolean matches(MockLabel control) {
						return control.getText().equals(labelText);
					}
				}),
				new WidgetOfType(MockText.class),
				0, 
				0
		));
		return foundText;
	}

	/**
	 * Finds the first Combo control that follows the first Label that contains the given text.
	 * Only the given part is searched.
	 * 
	 * @param labelText
	 * @return
	 */
	public MockCombo comboWithLabel(final String labelText) {
		MockCombo foundCombo = (MockCombo)searchControls(new ControlWithLabelVistitor(
				new WidgetOfTypeAndMatch<MockLabel>(MockLabel.class, new IMatcher<MockLabel>() {
					public boolean matches(MockLabel control) {
						return control.getText().equals(labelText);
					}
				}),
				new IMatcher<MockControl>() {
					public boolean matches(MockControl control) {
						return control instanceof MockCombo;
					}
				},
				0, 
				0
		));

		return foundCombo;
	}

	public MockTable table() {
		MockTable foundTable = (MockTable)searchControls(new ControlFinder<MockControl>(
				new IMatcher<MockControl>() {
					public boolean matches(MockControl control) {
						System.out.println("control: " + control.getClass().getName());
						return control instanceof MockTable;
					}
				},
				0
		));

		return foundTable;
	}
	
	/**
	 * Returns a table that followed a <code>Label</code> with the
	 * given text.
	 * 
	 * @param label
	 * @return
	 */
	public MockTable table(final String labelText) {
		MockTable foundTable = (MockTable)searchControls(new ControlWithLabelVistitor(
				new WidgetOfTypeAndMatch<MockLabel>(MockLabel.class, new IMatcher<MockLabel>() {
					public boolean matches(MockLabel control) {
						return control.getText().equals(labelText);
					}
				}),
				new WidgetOfTypeAndMatch<MockTable>(MockTable.class, new IMatcher<MockTable>() {
					public boolean matches(MockTable table) {
						return true;
					}
				}),
				0,
				0
			)
		);

		return foundTable;
	}

	/**
	 * Check boxes and radios are not returned by this method.  Use <code>checkBox</code>
	 * or <code>radio</code> to find check boxes and radio buttons.
	 * 
	 * @param text
	 * @return the button, never null
	 */
	public MockButton button(final String text) {
		MockButton foundButton = (MockButton)searchControls(new ControlFinder<MockControl>(
				new WidgetOfTypeAndMatch<MockButton>(MockButton.class, new IMatcher<MockButton>() {
					public boolean matches(MockButton control) {
						return (control.getStyle() & (SWT.CHECK | SWT.RADIO)) == 0
								&& control.getText().equals(text);
					}
				}),
				0
			)
		);

		if (foundButton == null) {
			throw new ButtonNotFoundException(text, SWT.PUSH, this);
		}
		return foundButton;
	}

	public MockCheckBox checkBox(final String text) {
		MockCheckBox foundButton = (MockCheckBox)searchControls(new ControlFinder<MockControl>(
				new IMatcher<MockControl>() {
					public boolean matches(MockControl control) {
						return control instanceof MockCheckBox
								&& (((MockCheckBox)control).getStyle() & SWT.CHECK) != 0
								&& ((MockCheckBox)control).getText().equals(text);
					}
				},
				0
		));

		return foundButton;
	}

	/**
	 * @param mnemonicText the mnemonicText on the widget.
	 * @return a {@link MockTabItem} with the specified <code>mnemonicText</code>.
	 * @throws WidgetNotFoundException if the widget is not found or is disposed.
	 */
	public MockTabItem tabItem(final String text) {
		MockTabItem foundItem = (MockTabItem)searchTabItems(new ControlFinder<MockTabItem>(
				new IMatcher<MockTabItem>() {
					public boolean matches(MockTabItem item) {
						return item.getText().equals(text);
					}
				},
				0
		));

		return foundItem;
	}

	/**
	 * Finds the first label that matches the given matcher.
	 * 
	 * @param labelMatcher
	 * @return
	 */
//	public TextMock label(final IMatcher<Label> labelMatcher) {
//		Label foundText = (Label)search(new ControlFinder<ControlMock>(
//				new WidgetOfTypeAndMatch<Label>(Label.class, labelMatcher),
//				0
//		));
//		return new TextMock(foundText);
//	}

	MockControl searchControls(IWidgetVisitor<MockControl> visitor) {
		return visitControls(visitor);
	}

	private MockTabItem searchTabItems(final IWidgetVisitor<MockTabItem> visitor) {
		return visitTabItems(visitor);
	}

	/**
	 * Visit all controls in the given parent widget. For each control, pass it
	 * to the given visitor. Processing stops if the visitor returns true.
	 * <P>
	 * This method is not thread safe and must be invoked from the UI thread.
	 * </p>
	 * Even though TabFolder is a Composite, we don't want to process all its
	 * children.  We want to process controls only in the active tab.  That makes
	 * it easier for test writers to find controls as this is the intuitive approach,
	 * avoids the need for test writers to look through every tab to ensure their
	 * control finder will find the control on the active tab, and also makes the
	 * tests more robust because changes on one tab won't break tests only interested
	 * in another tab.
	 * 
	 * @return if we reached a control for which the visitor returned true then
	 *         the widget, or null if we went through all the controls and the
	 *         visitor returned false for all of them
	 */
	MockControl visitControls(IWidgetVisitor<MockControl> visitor) {
		for (MockControl child : children) {
			if (visitor.visit(child)) {
				return child;
			}

			if (child instanceof MockTabFolder) {
				MockControl match = ((MockTabFolder)child).visitControls(visitor);
				if (match != null) {
					return match;
				}
			} else if (child instanceof MockComposite) {
				MockControl match = ((MockComposite)child).visitControls(visitor);
				if (match != null) {
					return match;
				}
			}
		}

		return null;
	}
	
	/**
	 * Visit all folder tab items in the given parent widget. For each control, pass it
	 * to the given visitor. Processing stops if the visitor returns true.
	 * <P>
	 * This method is not thread safe and must be invoked from the UI thread.
	 * </p>
	 * Even though TabFolder is a Composite, we don't want to process all its
	 * children.  We want to process controls only in the active tab.  That makes
	 * it easier for test writers to find controls as this is the intuitive approach,
	 * avoids the need for test writers to look through every tab to ensure their
	 * control finder will find the control on the active tab, and also makes the
	 * tests more robust because changes on one tab won't break tests only interested
	 * in another tab.
	 * 
	 * @return if we reached a control for which the visitor returned true then
	 *         the widget, or null if we went through all the controls and the
	 *         visitor returned false for all of them
	 */
	MockTabItem visitTabItems(IWidgetVisitor<MockTabItem> visitor) {
		for (MockControl child : children) {
			if (child instanceof MockTabFolder) {
				MockTabItem match = ((MockTabFolder)child).visitTabItems(visitor);
				if (match != null) {
					return match;
				}
			}
			if (child instanceof MockComposite) {
				MockTabItem match = ((MockComposite)child).visitTabItems(visitor);
				if (match != null) {
					return match;
				}
			}
		}
		
		return null;
	}
	
	public MockLabel label(final String text) {
		MockLabel foundLabel = (MockLabel)searchControls(new ControlFinder<MockControl>(
				new IMatcher<MockControl>() {
					public boolean matches(MockControl control) {
						return control instanceof MockLabel
								&& ((MockLabel)control).getText().equals(text);
					}
				},
				0
				));

		if (foundLabel == null) {
			// TODO check if this is correct				
			throw new IllegalArgumentException("Label matching " + text + " not found.");
		}

		return foundLabel;
	}

	/**
	 * Scans the column with the given column name looking for a value that
	 * matches the given regular expression.
	 * 
	 * @param columnName
	 *            the label used in the column header which is assumed to be
	 *            unique amongst the column header names
	 * @param textRegex
	 *            the value for which we are searching in the cells
	 * @return the first row where the given column contains a value that
	 *         matches the given regex
	 */
	public MockLabel labelWithRegex(String textRegex) {
		try {
			final Pattern compiledPattern = Pattern.compile(textRegex);

			MockLabel foundLabel = (MockLabel)searchControls(new ControlFinder<MockControl>(
					new IMatcher<MockControl>() {
						public boolean matches(MockControl control) {
							if (control instanceof MockLabel) {
								String thisValue = ((MockLabel)control).getText();
								java.util.regex.Matcher m = compiledPattern.matcher(thisValue);
								if (m.matches()) {
									return true;
								}
							}
							return false;
						}
					},
					0
			));

			if (foundLabel == null) {
				// TODO check if this is correct				
				throw new IllegalArgumentException("Value matching " + textRegex + " not found.");
			}
			
			return foundLabel;
		} catch (PatternSyntaxException e) {
			throw new IllegalArgumentException("'" + textRegex + " is not a valid regex expression.");
		}
	}

	@Override
	public IStyledText createStyledText(int style) {
		MockStyledText styledText = new MockStyledText(this, style);
		children.add(styledText);
		return styledText;
	}

	@Override
	public IScrolledComposite createScrolledComposite(int style) {
		MockScrolledComposite scrolledComposite = new MockScrolledComposite(this, style);
		children.add(scrolledComposite);
		return scrolledComposite;
	}

	@Override
	public IGC createGC() {
		return new MockGC();
	}

	@Override
	public int openTrayDialog(IDialog dialog) {
		/*
		 * A modal dialog is being opened.  This dialog must be processed and
		 * closed before this method returns.  To do this, we must be expecting
		 * a modal dialog and we must know how to manipulate the modal dialog.
		 */
		IExpectedModalDialog expected = shell.popExpectedModal();
		
		MockShell dialogShell = new MockShell(shell);
		MockTrayDialog modalDialog = new MockTrayDialog(dialogShell, dialog);
		dialog.setDelegateDialog(modalDialog);
		
		dialog.createDialogArea(dialogShell);
		dialog.createButtonsForButtonBar(dialogShell);
		
		expected.performModalActions(dialogShell);
		
		// fail the test if the shell is not closed
		if (!dialogShell.isClosed()) {
			throw new RuntimeException("Modal dialog was not closed");
		}
		
		return modalDialog.getReturnCode();
	}

	@Override
	public Rectangle getClientArea() {
		// TODO Auto-generated method stub
		return new Rectangle(0, 0, 200, 200);
	}

	@Override
	public Point computeSize(int width, int height) {
		// TODO Auto-generated method stub
		return new Point(300, 300);
	}

	@Override
	public void layout(boolean changed) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IShell getShell() {
		return shell;
	}

	@Override
	public void dispose() {
		for (MockControl child : children) {
			child.dispose();
		}
		super.dispose();
	}

	@Override
	public IJFaceColors getJFaceColors() {
		return new MockJFaceColors();
	}

	@Override
	public ISlider createSlider(int style) {
		return new MockSlider(this, style);
	}
}
