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
import com.example.udt.ulist.model.Item;
import com.example.udt.ulist.model.ListItem;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.CustomViewHolder> {

    private List<Item> items;
    private Context context;

    public ItemAdapter(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list_element, null);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final CustomViewHolder customViewHolder, int i) {
        final Item feedItem = items.get(i);
        customViewHolder.txtElementName.setText((feedItem.getItemName()));

    }

    @Override
    public int getItemCount() {
        return (null != items ? items.size() : 0);
    }

    @Override
    public long getItemId(int position) {
        return items.get(position).getItemId();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        private final TextView txtElementName;
        protected RelativeLayout rvListElements;

        public CustomViewHolder(View view) {
            super(view);
            this.txtElementName = (TextView) view.findViewById(R.id.txtElementName);
            this.rvListElements = (RelativeLayout) view.findViewById(R.id.rvListElements);
        }
    }
}

