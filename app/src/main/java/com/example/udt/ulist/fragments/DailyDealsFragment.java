package com.example.udt.ulist.fragments;

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
import android.widget.LinearLayout;
import android.widget.Toast;

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

public class DailyDealsFragment extends BaseFragment {
    View myview;
    private static final String TAG = DailyDealsFragment.class.getSimpleName();
    private RecyclerView recyclerView;
    private ProductRecyclerAdapter mAdapter;
    private final String url = "https://arpicosupercentre.com/big-deal-offer.html";
    List<Product> productList;
    private LinearLayout menuLl;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myview = inflater.inflate(R.layout.fragment_daily_deals, container, false);
        recyclerView = (RecyclerView) myview.findViewById(R.id.promotionRv);
        menuLl = (LinearLayout) myview.findViewById(R.id.menuLl);
        productList = new ArrayList<>();
        startCrawler();
        return myview;
    }

    private void startCrawler() {

        if (isNetworkAvailable()) {
            startProgressBar();
            new WebCrawler().execute(url);
        } else {
            //showSnackbar(menuLl, getString(R.string.no_internet), Constant.ERROR);
            Toast.makeText(getActivity(), getString(R.string.no_internet),
                    Toast.LENGTH_LONG).show();

        }

    }


    private class WebCrawler extends AsyncTask<String, Integer, ArrayList<Product>> {


        public ArrayList<Product> productList;


        @Override
        protected void onPreExecute() {
            startProgressBar();
            super.onPreExecute();

        }

        @Override
        public ArrayList<Product> doInBackground(String... strings) {
            try {
                Log.d(TAG, "inside crawler");
                Document doc = Jsoup.connect("https://arpicosupercentre.com/daily-deals.html").get();
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

                for (Product item : productList) {

                    Log.d(TAG + " index -", productList.indexOf(item) + " Titles- " + item.getTitle());

                }

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
        stopProgressBar();
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {

                Log.d(TAG, "productList size inside set data--" + productList.size());

                mAdapter = new ProductRecyclerAdapter(getActivity(),productList);
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(mAdapter);
            }
        });


    }


}
