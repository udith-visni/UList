package com.example.udt.ulist.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.udt.ulist.R;
import com.example.udt.ulist.model.Product;

import java.util.List;

/**
 * Created by UDT on 10/28/2017.
 */

public class ProductRecyclerAdapter extends RecyclerView.Adapter<ProductRecyclerAdapter.MyViewHolder> {

    private List<Product> productlist;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView productTv, oldPriceTv, specialPricetTv, promoPersentageTv;
        private ImageView productIv;

        public MyViewHolder(View view) {
            super(view);
            productIv = (ImageView) view.findViewById(R.id.productIv);
            productTv = (TextView) view.findViewById(R.id.productTv);
            oldPriceTv = (TextView) view.findViewById(R.id.oldPriceTv);
            specialPricetTv = (TextView) view.findViewById(R.id.specialPricetTv);
            promoPersentageTv = (TextView) view.findViewById(R.id.promoPersentageTv);
        }
    }


    public ProductRecyclerAdapter(List<Product> productlist) {
        this.productlist = productlist;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_promo, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Product product = productlist.get(position);
        holder.productTv.setText(product.getTitle());
        holder.oldPriceTv.setText(product.getOldPrice());
        holder.specialPricetTv.setText(product.getSpecialPrice());
        holder.promoPersentageTv.setText(product.getPromo());
    }

    @Override
    public int getItemCount() {
        return productlist.size();
    }
}

