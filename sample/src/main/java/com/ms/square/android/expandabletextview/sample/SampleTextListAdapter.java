package com.ms.square.android.expandabletextview.sample;

import android.content.Context;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.ms.square.android.expandabletextview.ExpandableTextView;
import com.ms.square.android.mymodule.app.R;

public class SampleTextListAdapter extends BaseAdapter {

    private final Context mContext;
    private final SparseBooleanArray mCollapsedStatus;
    private final String[] sampleStrings;

    public SampleTextListAdapter(Context context) {
        mContext  = context;
        mCollapsedStatus = new SparseBooleanArray();
        sampleStrings = mContext.getResources().getStringArray(R.array.sampleStrings);
    }

    @Override
    public int getCount() {
        return sampleStrings.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.expandableTextView = (ExpandableTextView) convertView.findViewById(R.id.expand_text_view);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.expandableTextView.setText(sampleStrings[position], mCollapsedStatus, position);

        return convertView;
    }


    private static class ViewHolder{
        ExpandableTextView expandableTextView;
    }
}