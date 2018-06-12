package com.ms.square.android.expandabletextview.sample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ms.square.android.expandabletextview.ExpandableTextView;
import com.ms.square.android.mymodule.app.R;

public class SampleRecyclerViewAdapter extends RecyclerView.Adapter<SampleRecyclerViewAdapter.TextViewHolder> {

    private final SparseBooleanArray mCollapsedStatus;
    private final String[] sampleStrings;

    public SampleRecyclerViewAdapter(Context context) {
        mCollapsedStatus = new SparseBooleanArray();
        sampleStrings = context.getResources().getStringArray(R.array.sampleStrings);
    }

    @Override
    public TextViewHolder onCreateViewHolder(
            final ViewGroup parent,
            final int viewType) {
        return new TextViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(
            final TextViewHolder holder,
            final int position) {
        holder.bind(sampleStrings[position], position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getItemCount() {
        return sampleStrings.length;
    }

    class TextViewHolder extends RecyclerView.ViewHolder {

        ExpandableTextView expandableTextView;

        TextViewHolder(final View itemView) {
            super(itemView);
            expandableTextView = itemView.findViewById(R.id.expand_text_view);
        }

        void bind(
                final String text,
                final int position) {
            expandableTextView.setText(text, mCollapsedStatus, position);
        }
    }
}
