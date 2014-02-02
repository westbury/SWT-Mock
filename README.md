SWTMock provides mock objects that can be used for unit testing code that uses SWT controls.  This differs from SWTBot because when testing using SWTBot, the target code executes using the real SWT classes, while SWTBot inspects and manipulates the SWT controls from another thread.

SWTMock, on the other hand, does not use the real SWT control classes.  Mock classes are used instead.  This approach means the tests are no longer dependent on the host OS and other environmental factors that affect SWT and will cause tests to be fragile.

The approach taken with the current code provides a different API for creating SWT controls.  Instead on calling the constructors directly, controls are created by calling methods on the parent composite.  This does involve changing all your UI code to use the wrapper interfaces instead of using the SWT API directly.  There is a one-to-one mapping of methods, so really all you will need to do is to change the control constuctors.  For example, instead of new Button(parent, SWT.PUSH) you would instead use parent.createButton(SWT.PUSH).

An alternative approach would be to use the real org.eclipse.ui.swt jar but with a fake fragment.

Development has just been started, so there is not much to this project at this time.  However the mock objects could potentially become quite sophisticated.  For example, they could fail a test if a control would be partially obscured in a fixed-size dialog, the error being given even if the problem would only show in Linux and the test is running on Windows.

If you are interested in mock objects for SWT, please do fork this project and commit your changes back into Github, filling it out or changing it in the direction you want it to go.
