package com.github.swtmock.api;

import org.eclipse.swt.graphics.Point;

public interface IScrolledComposite extends IComposite {

	IScrollBar getHorizontalBar();

	IScrollBar getVerticalBar();

	void setMinSize(int width, int height);
	
	void setMinSize(Point size);

	boolean getExpandHorizontal();

	void setExpandHorizontal(boolean expand);
	
	boolean getExpandVertical();

	void setExpandVertical(boolean expand);

	void setMinHeight(int height);
	
	void setMinWidth(int width);

	void setContent(IControl content);

}
