package com.example.udt.ulist.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.udt.ulist.R;

import static android.R.attr.id;

public class CreateList extends AppCompatActivity {

    private TextView txtListName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_list);
        txtListName=(TextView)findViewById(R.id.txtListName);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String listName = extras.getString("listName");
            txtListName.setText("listName : " + listName);

        }
    }
}
