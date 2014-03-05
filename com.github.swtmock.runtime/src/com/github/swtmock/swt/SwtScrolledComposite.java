package com.github.swtmock.swt;

import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.graphics.Point;

import com.github.swtmock.api.IControl;
import com.github.swtmock.api.IScrollBar;
import com.github.swtmock.api.IScrolledComposite;

public class SwtScrolledComposite extends SwtComposite implements
		IScrolledComposite {

	private ScrolledComposite scrolledComposite;

	public SwtScrolledComposite(ScrolledComposite scrolledComposite) {
		super(scrolledComposite);
		this.scrolledComposite = scrolledComposite;
	}

	@Override
	public IScrollBar getHorizontalBar() {
		return new SwtScrollBar(scrolledComposite.getHorizontalBar());
	}

	@Override
	public IScrollBar getVerticalBar() {
		return new SwtScrollBar(scrolledComposite.getVerticalBar());
	}

	@Override
	public void setMinSize(int width, int height) {
		scrolledComposite.setMinSize(width, height);
	}

	@Override
	public void setMinSize(Point size) {
		scrolledComposite.setMinSize(size);
	}

	@Override
	public void setExpandHorizontal(boolean expand) {
		scrolledComposite.setExpandHorizontal(expand);
	}

	@Override
	public void setExpandVertical(boolean expand) {
		scrolledComposite.setExpandVertical(expand);
	}

	@Override
	public void setMinHeight(int height) {
		scrolledComposite.setMinHeight(height);
	}

	@Override
	public void setMinWidth(int width) {
		scrolledComposite.setMinWidth(width);
	}

	@Override
	public void setContent(IControl content) {
		SwtControl swtContent = (SwtControl)content;
		scrolledComposite.setContent(swtContent.getControl());
	}

	@Override
	public boolean getExpandHorizontal() {
		return scrolledComposite.getExpandHorizontal();
	}

	@Override
	public boolean getExpandVertical() {
		return scrolledComposite.getExpandVertical();
	}

}
