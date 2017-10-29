package com.example.udt.ulist.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.udt.ulist.DB.DatabaseHandler;
import com.example.udt.ulist.R;
import com.example.udt.ulist.activities.CreateList;
import com.example.udt.ulist.activities.ShowList;
import com.example.udt.ulist.model.MyLists;

import java.util.List;


public class MainListAdapter extends RecyclerView.Adapter<MainListAdapter.CustomViewHolder> {

    private List<MyLists> myLists;
    private Context context;


    public MainListAdapter(Context context, List<MyLists> myLists) {
        this.context = context;
        this.myLists = myLists;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_name, parent,false);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final CustomViewHolder customViewHolder, final int i) {
        final MyLists feedItem = myLists.get(i);
        customViewHolder.txtItemListName.setText((feedItem.getListName()));

        customViewHolder.rlItemList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ShowList.class);
                intent.putExtra("listName", feedItem.getListName());
                context.startActivity(intent);
            }
        });


        customViewHolder.ImgItemOptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //creating a popup menu
                PopupMenu popup = new PopupMenu(context, customViewHolder.ImgItemOptions);
                //inflating menu from xml resource
                popup.inflate(R.menu.item_options_menu);
                //adding click listener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.menu1:
                                myLists.remove(customViewHolder.getAdapterPosition());
                                notifyDataSetChanged();
                               // deleteList(myLists.get());
                                break;
                            case R.id.menu2:
                                //handle menu2 click
                                break;
                        }
                        return false;
                    }
                });
                //displaying the popup
                popup.show();

            }
        });
    }


    private void deleteList(int id){
        final DatabaseHandler db=new DatabaseHandler(context);
      //  db.deleteList(new MyLists(myLists.get()));
    }

    @Override
    public long getItemId(int position) {
        return myLists.get(position).getId();
    }

    @Override
    public int getItemCount() {
        return (null != myLists ? myLists.size() : 0);
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        private final TextView txtItemListName;
        private final ImageView ImgItemOptions;
        protected LinearLayout rlItemList;

        public CustomViewHolder(View view) {
            super(view);
            this.txtItemListName = (TextView) view.findViewById(R.id.txtItemListName);
            this.ImgItemOptions = (ImageView) view.findViewById(R.id.btnItemOptions);
            this.rlItemList = (LinearLayout) view.findViewById(R.id.rlItemList);
        }
    }


}

