package com.example.udt.ulist.activities;

import android.content.Context;
import android.content.Intent;
import android.database.SQLException;
import android.speech.RecognizerIntent;
import android.support.design.widget.Snackbar;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.udt.ulist.DB.MasterDbHandler;
import com.example.udt.ulist.R;
import com.example.udt.ulist.adapter.ItemAdapter;
import com.example.udt.ulist.model.Item;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class CreateList extends BaseActivity {

    private static final String TAG = CreateList.class.getSimpleName();
    private TextView txtListName;
    private ImageView imgMicrophne, imgBarcode;
    private RecyclerView rvListElements;
    List<Item> items;
    private EditText etListElement;
    private ItemAdapter itemAdapter;
    private Button btnAdd;
    public static final int VOICE_RECOGNITION_REQUEST_CODE = 1234;
    private ImageView imgMicrophone;
    public MasterDbHandler masterDbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_list);
        initView();


        items = new ArrayList();
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rvListElements.setLayoutManager(mLayoutManager);
        rvListElements.setItemAnimator(new DefaultItemAnimator());

        masterDbHandler = new MasterDbHandler(this);

        try {

            masterDbHandler.createDataBase();

        } catch (IOException ioe) {

            throw new Error("Unable to create database");

        }

        try {

            masterDbHandler.openDataBase();

        } catch (SQLException sqle) {

            throw sqle;

        }


        items = masterDbHandler.getAllITems();
        itemAdapter = new ItemAdapter(getApplicationContext(), items);
        rvListElements.setAdapter(itemAdapter);
        itemAdapter.notifyDataSetChanged();
    }


//        Bundle extras = getIntent().getExtras();
//        if (extras != null) {
//            String listName = extras.getString("listName");
//            // txtListName.setText("listName : " + listName);
//
//        }


//        btnAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String element = etListElement.getText().toString();
//                if (!element.isEmpty()) {
//                    addElement(element);
//                } else {
//                    Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Enter a item", Snackbar.LENGTH_LONG);
//                    snackbar.show();
//                }
//                Log.d(TAG, "elemt -" + element);
//                etListElement.setText("");

//}
    //       });
//        imgMicrophne.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startVoiceRecognitionActivity();
//            }
//        });
//
//
//        imgBarcode.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                IntentIntegrator integrator = new IntentIntegrator(CreateList.this);
//                integrator.initiateScan();
//            }
//        });
    //   }


    private void initView() {
//        txtListName = (TextView) findViewById(R.id.txtListName);
//        imgMicrophne = (ImageView) findViewById(R.id.imgMicrophone);
//        imgBarcode = (ImageView) findViewById(R.id.imgBarcode);
        rvListElements = (RecyclerView) findViewById(R.id.rvListElements);
//        etListElement = (EditText) findViewById(R.id.etListElement);
//        btnAdd = (Button) findViewById(R.id.btnAdd);
//        imgMicrophone = (ImageView) findViewById(R.id.imgMicrophone);
    }

//
//    public void startVoiceRecognitionActivity() {
//        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
//        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
//                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
//        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
//                "Speech recognition demo");
//        startActivityForResult(intent, VOICE_RECOGNITION_REQUEST_CODE);
//    }

//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (requestCode == VOICE_RECOGNITION_REQUEST_CODE && resultCode == RESULT_OK) {
//            ArrayList<String> matches = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
//
////            if (matches.contains("pen")) {
////                listItems.add(new ListItem("pen"));
////            }
////            if (matches.contains("tea")) {
////                listItems.add(new ListItem("tea"));
////            }
////            if (matches.contains("book")) {
////                listItems.add(new ListItem("book"));
////            }
////
////            rvListElements.setAdapter(new ListItemAdapter(getApplicationContext(), listItems));
//        }

//
//        IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
//        if (scanResult != null) {
//            String re = scanResult.getContents();
//            Log.d(TAG, "code -" + re);
//            if (re.equals("http://www.promateworld.com/")) {
//                listItems.add(new ListItem("Promate Book"));
//            }
//            if (re.equals("4796009869132")) {
//                listItems.add(new ListItem("promate B5/100 pgs Book"));
//            }
//            rvListElements.setAdapter(new ListItemAdapter(getApplicationContext(), listItems));

//        }
//    }

//    public void addElement(String elemntName) {
//        items.add(new Item(elemntName));
//        itemAdapter = new ItemAdapter(getApplicationContext(), items);
//        rvListElements.setAdapter(itemAdapter);
//        itemAdapter.notifyDataSetChanged();
//    }


}
