package com.example.udt.ulist.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.View;

import com.example.udt.ulist.R;

/**
 * Created by UDT on 10/15/2017.
 */

public class ShowList extends BaseActivity implements View.OnClickListener {

    private FloatingActionButton fab;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_list);
        fab = (FloatingActionButton) findViewById(R.id.showListFab);
        fab.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.showListFab:
                Intent intent = new Intent(this, CreateList.class);
                startActivity(intent);
                finish();

                break;

        }
    }
}
