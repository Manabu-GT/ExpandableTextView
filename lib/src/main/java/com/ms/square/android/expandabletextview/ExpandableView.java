package com.ms.square.android.expandabletextview;

import android.view.View;
import android.widget.TextView;

/**
 * For customization of the ExpandableTextView.
 *
 * @author 4xes
 */
public interface ExpandableView {

    View getButtonView();

    TextView getTextView();

    void initButtonView();

    void initTextView();

    void makeButtonExpand();

    void makeButtonCollapse();

    boolean isCollapsed();
}
