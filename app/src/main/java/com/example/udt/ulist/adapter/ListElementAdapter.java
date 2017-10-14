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
import com.example.udt.ulist.model.ListElement;

import java.util.List;

public class ListElementAdapter extends RecyclerView.Adapter<ListElementAdapter.CustomViewHolder> {

    private List<ListElement> listElements;
    private Context context;

    public ListElementAdapter(Context context, List<ListElement> listElements) {
        this.context = context;
        this.listElements = listElements;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list_element, null);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final CustomViewHolder customViewHolder, int i) {
        final ListElement feedItem = listElements.get(i);
        customViewHolder.txtElementName.setText((feedItem.getElementName()));

//        customViewHolder.rvListElements.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context, ElementDetails.class);
//                intent.putExtra("elementName", feedItem.getElementName());
//                context.startActivity(intent);
//            }
//        });


//        customViewHolder.imgPromo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return (null != listElements ? listElements.size() : 0);
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

