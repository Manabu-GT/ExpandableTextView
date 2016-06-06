package com.ms.square.android.expandabletextview.sample;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.ms.square.android.expandabletextview.BaseExpandableTextView;


public class CustomExpandableTextView extends BaseExpandableTextView {

    protected TextView mButtonText; // Button to expand/collapse

    public CustomExpandableTextView(Context context) {
        super(context);
    }

    public CustomExpandableTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public CustomExpandableTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CustomExpandableTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void initButtonView() {
        mButtonText = (TextView) findViewById(com.ms.square.android.expandabletextview.R.id.expand_collapse);
        mButtonText.setVisibility(isCollapsed() ? View.VISIBLE : View.INVISIBLE);
        mButtonText.setOnClickListener(this);
    }

    @Override
    public void makeButtonCollapse() {
        mButtonText.setVisibility(View.INVISIBLE);
    }

    @Override
    public void makeButtonExpand() {
        mButtonText.setVisibility(View.VISIBLE);
    }

    @Override
    public View getButtonView() {
        return mButtonText;
    }


}
