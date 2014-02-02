/**
 * This package contains the public API that should be used in the production code to
 * access SWT.
 * <P>
 * The API is almost identical to the SWT API except that instead of creating controls
 * using a constructor, controls are created through methods on the parent composite.
 * This allows SWT to be mocked.
 * 
 * @author Nigel Westbury
 *
 */
package com.github.swtmock.api;