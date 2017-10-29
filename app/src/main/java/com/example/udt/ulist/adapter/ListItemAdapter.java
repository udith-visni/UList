package com.example.udt.ulist.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.udt.ulist.R;
import com.example.udt.ulist.model.ListItem;

import java.util.List;

public class ListItemAdapter extends RecyclerView.Adapter<ListItemAdapter.CustomViewHolder> {

    private List<ListItem> listItems;
    private Context context;

    public ListItemAdapter(Context context, List<ListItem> listItems) {
        this.context = context;
        this.listItems = listItems;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_element, parent,false);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final CustomViewHolder customViewHolder, int i) {
        final ListItem feedItem = listItems.get(i);
        customViewHolder.txtElementName.setText((feedItem.getItemName()));

    }

    @Override
    public long getItemId(int position) {
        return listItems.get(position).getItemId();
    }

    @Override
    public int getItemCount() {
        return (null != listItems ? listItems.size() : 0);
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        private final TextView txtElementName;
        private final ImageView imgPromo;
        protected RelativeLayout rvListElements;

        public CustomViewHolder(View view) {
            super(view);
            this.txtElementName = (TextView) view.findViewById(R.id.txtElementName);
            this.imgPromo = (ImageView) view.findViewById(R.id.imgPromo);
            this.rvListElements = (RelativeLayout) view.findViewById(R.id.rvListElements);
        }
    }
}

