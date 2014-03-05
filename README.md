SWTMock provides mock objects that can be used for unit testing code that uses SWT controls.  This differs from SWTBot because when testing using SWTBot, the target code executes using the real SWT classes, while SWTBot inspects and manipulates the SWT controls from another thread.

Unit tests should have the following properties:

1. Unit tests must be fast.  If unit tests are slow developers won't run them and tools such as Infinitest will grind to a halt.

2. Unit tests must be reliable and repeatable.  Tests are really not that helpful if they fail intermittently.  Unit tests must also give the same results on all platforms.  It's really not very useful running tests on your Windows machine if the build machine gets different results because it is running on Linux.

3. Unit tests must be independent of each other.  It's no good if tests fail simply because a previous test failed to close a modal dialog.

4. Test failures much include messages that make clear the root cause of the problem.  If tests failures are returned from an automated build that say "timeout waiting for control with text 'foo'" when the actual problem was a prior dialog did not close then developers need to spend extra time reproducing and debugging failures.

SWTBot is great for integration testing and is ok for regression testing but fails miserably at unit testing because it fails on the above requirements.

SWTMock provides a solution for those who like their unit tests to be fast, reliable, and independent.  SWTMock does not use the real SWT control classes.  Mock classes are used instead.  This approach means the tests are no longer dependent on the host OS and other environmental factors that affect SWT and cause tests to be fragile.

The approach taken with the current code provides a different API for creating SWT controls.  Instead of calling the constructors directly, controls are created by calling methods on the parent composite.  This does involve changing all your UI code to use the wrapper interfaces instead of using the SWT API directly.  There is a one-to-one mapping of methods, so really all you will need to do is to change the control constuctors.  For example, instead of 
```
new Button(parent, SWT.PUSH);
```
you would instead use 
```
parent.createButton(SWT.PUSH);
```
Development has just been started, so you will almost certainly find much of the SWT API is not covered.  However it is straight forward to extend SWTMock to cover more of the SWT API.

If you are interested in mock objects for SWT, please do fork this project and commit your changes back into Github, filling it out or changing it in the direction you want it to go.
