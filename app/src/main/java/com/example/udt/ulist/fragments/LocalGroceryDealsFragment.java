package com.example.udt.ulist.fragments;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.udt.ulist.R;
import com.example.udt.ulist.adapter.ProductRecyclerAdapter;
import com.example.udt.ulist.model.Product;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by UDT on 8/20/2017.
 */

public class LocalGroceryDealsFragment extends BaseFragment {
    View myview;
    private static final String TAG = LocalGroceryDealsFragment.class.getSimpleName();
    private RecyclerView recyclerView;
    private ProductRecyclerAdapter mAdapter;
    private final String url = "https://arpicosupercentre.com/big-deal-offer.html";
    List<Product> productList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myview=inflater.inflate(R.layout.fragment_local_grocery_deals,container,false);

        recyclerView = (RecyclerView) myview.findViewById(R.id.promotionRv);
        new WebCrawler().execute(url);
        productList =new ArrayList<>();

        return myview;


    }

    private class WebCrawler extends AsyncTask<String, Integer, ArrayList<Product>> {

        public ArrayList<Product> productList;

        @Override
        public ArrayList<Product> doInBackground(String... strings) {
            try {
                Log.d(TAG, "inside crawler");
                Document doc = Jsoup.connect("https://arpicosupercentre.com/big-deal-offer.html").get();
                Elements products = doc.select("ul li");
                productList = new ArrayList<Product>();

                for (Element raw : products) {

                    Log.d(TAG, "inside elemtnt for");

                    String title = raw.select(".product-name").text();
                    String oldPrice = raw.select(".old-price .price").text().replace("LKR", "").trim();
                    String specialPrice = raw.select(".special-price .price").text().replace("LKR", "").trim();
                    String promo = raw.select(".offer-txt").text();
                    String src = raw.select("img").attr("src").toString();

                    //System.out.println(title + " " + oldPrice + " " + specialPrice + " " + promo+" "+src);
                    if (title != null && title != "") {
                        productList.add(new Product(title, oldPrice, specialPrice, promo, src));
                    }

                }


                //System.out.println(Arrays.toString(productList.toArray()));
                for (Product item : productList) {

                    Log.d(TAG + " index -", productList.indexOf(item) + " Titles- " + item.getTitle());

                }


                //System.out.println(productList.get(i).getTitle());
                Log.d(TAG, "size " + productList.size());

            } catch (Exception e) {

                Log.d(TAG, "exception-" + e.getMessage());
                e.printStackTrace();
            }

            setData(productList);
            return productList;


        }

        @Override
        protected void onPostExecute(ArrayList<Product> products) {
            super.onPostExecute(products);
        }
    }


    private void setData(final List<Product> productList) {

        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {

                Log.d(TAG, "productList size inside set data--" + productList.size());

                mAdapter = new ProductRecyclerAdapter(productList);
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(mAdapter);
            }
        });


    }


}
