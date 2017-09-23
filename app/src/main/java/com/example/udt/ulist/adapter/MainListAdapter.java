package com.example.udt.ulist.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.udt.ulist.R;
import com.example.udt.ulist.activities.CreateList;
import com.example.udt.ulist.model.MainListItem;

import java.util.List;

/**
 * Created by Visni on 7/11/2017.
 */

public class MainListAdapter extends RecyclerView.Adapter<MainListAdapter.CustomViewHolder> {

    private List<MainListItem> mainListItems;
    private Context context;

    public MainListAdapter(Context context, List<MainListItem> mainListItems) {
        this.context = context;
        this.mainListItems = mainListItems;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list_name, null);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder customViewHolder, int i) {
        final MainListItem feedItem = mainListItems.get(i);
        customViewHolder.txtItemListName.setText((feedItem.getListName()));
        customViewHolder.txtBoughtItem.setText(feedItem.getBoughtItem());
        customViewHolder.txtTotalItem.setText(feedItem.getTotalItem());
        customViewHolder.llItemList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CreateList.class);
                intent.putExtra("listName", feedItem.getListName());
                intent.putExtra("boughtItem", feedItem.getBoughtItem());
                intent.putExtra("totalItem", feedItem.getTotalItem());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return (null != mainListItems ? mainListItems.size() : 0);
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        private final TextView txtItemListName;
        private final TextView txtBoughtItem;
        private final TextView txtTotalItem;
        protected LinearLayout llItemList;

        public CustomViewHolder(View view) {
            super(view);
            this.txtItemListName = (TextView) view.findViewById(R.id.txtItemListName);
            this.txtBoughtItem = (TextView) view.findViewById(R.id.txtBoughtItem);
            this.txtTotalItem = (TextView) view.findViewById(R.id.txtTotalItem);
            this.llItemList = (LinearLayout) view.findViewById(R.id.llItemList);
        }
    }
}
