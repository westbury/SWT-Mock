package com.github.swtmock.mock;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;

import com.github.swtmock.api.IControl;
import com.github.swtmock.api.IScrollBar;
import com.github.swtmock.api.IScrolledComposite;

public class MockScrolledComposite extends MockComposite implements
		IScrolledComposite {

	private Point minSize = new Point(100, 100);
	private boolean expandHorizontal = false;
	private boolean expandVertical = false;
	private IScrollBar horizontalBar = null;
	private IScrollBar verticalBar = null;

// Used for initial top test composite only, so always just a composite???
//	public MockScrolledComposite(MockShell shell) {
//		super(shell);
//	}

	public MockScrolledComposite(MockComposite mockComposite, int style) {
		super(mockComposite, style);
		
		if ((style & SWT.H_SCROLL) != 0) {
			horizontalBar = new MockScrollBar();
		} 
		if ((style & SWT.V_SCROLL) != 0) {
			verticalBar = new MockScrollBar();
		}
	}

	@Override
	public IScrollBar getHorizontalBar() {
		return horizontalBar;
	}

	@Override
	public IScrollBar getVerticalBar() {
		return verticalBar;
	}

	@Override
	public void setMinSize(int width, int height) {
		minSize = new Point(width, height);
	}

	@Override
	public void setMinSize(Point size) {
		minSize = size;
	}

	@Override
	public boolean getExpandHorizontal() {
		return expandHorizontal;
	}

	@Override
	public void setExpandHorizontal(boolean expand) {
		this.expandHorizontal = expand;
	}

	@Override
	public boolean getExpandVertical() {
		return expandVertical;
	}

	@Override
	public void setExpandVertical(boolean expand) {
		this.expandVertical = expand;
	}

	@Override
	public void setMinHeight(int height) {
		minSize.y = height;
	}

	@Override
	public void setMinWidth(int width) {
		minSize.x = width;
	}

	@Override
	public void setContent(IControl content) {
		// TODO Auto-generated method stub

	}

}
