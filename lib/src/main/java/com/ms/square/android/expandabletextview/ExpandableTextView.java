/*
 * Copyright (C) 2011 The Android Open Source Project
 * Copyright 2014 Manabu Shimobe
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ms.square.android.expandabletextview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;


public class ExpandableTextView extends BaseExpandableTextView {

    protected ImageButton mButtonIcon; // Button to expand/collapse

    private Drawable mExpandDrawable;
    private Drawable mCollapseDrawable;

    public ExpandableTextView(Context context) {
        super(context);
    }

    public ExpandableTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public ExpandableTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ExpandableTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }


    private void init(AttributeSet attrs) {
        if(attrs != null){
            TypedArray a = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.ExpandableTextView, 0, 0);
            try {
                mExpandDrawable = a.getDrawable(R.styleable.ExpandableTextView_expandDrawable);
                mCollapseDrawable = a.getDrawable(R.styleable.ExpandableTextView_collapseDrawable);

            } finally {
                a.recycle();
            }
        }

        if (mExpandDrawable == null) {
            mExpandDrawable = getDrawable(getContext(), R.drawable.ic_expand_more_black_12dp);
        }
        if (mCollapseDrawable == null) {
            mCollapseDrawable = getDrawable(getContext(), R.drawable.ic_expand_less_black_12dp);
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private static Drawable getDrawable(@NonNull Context context, @DrawableRes int resId) {
        Resources resources = context.getResources();
        if (isLollipop()) {
            return resources.getDrawable(resId, context.getTheme());
        } else {
            return resources.getDrawable(resId);
        }

    }

    @Override
    public void initButtonView() {
        mButtonIcon = (ImageButton) findViewById(R.id.expand_collapse);
        mButtonIcon.setImageDrawable(isCollapsed() ? mExpandDrawable : mCollapseDrawable);
        mButtonIcon.setOnClickListener(this);
    }

    @Override
    public void makeButtonCollapse() {
        mButtonIcon.setImageDrawable(mCollapseDrawable);
    }

    @Override
    public void makeButtonExpand() {
        mButtonIcon.setImageDrawable(mExpandDrawable);
    }

    @Override
    public View getButtonView() {
        return mButtonIcon;
    }

}
