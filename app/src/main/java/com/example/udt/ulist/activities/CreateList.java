package com.example.udt.ulist.activities;

import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
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

import com.example.udt.ulist.R;
import com.example.udt.ulist.adapter.ListElementAdapter;
import com.example.udt.ulist.model.ListElement;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.ArrayList;
import java.util.List;

public class CreateList extends AppCompatActivity {

    private static final String TAG = CreateList.class.getSimpleName();
    private TextView txtListName;
    private ImageView imgMicrophne,imgBarcode;
    private RecyclerView rvListElements;
    List<ListElement> listElements;
    private EditText etListElement;
    ListElementAdapter listElementAdapter;
    private Button btnAdd;
    public static final int VOICE_RECOGNITION_REQUEST_CODE = 1234;
    private ImageView imgMicrophone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_list);
        initView();

        listElements = new ArrayList();
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rvListElements.setLayoutManager(mLayoutManager);
        rvListElements.setItemAnimator(new DefaultItemAnimator());

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String listName = extras.getString("listName");
            txtListName.setText("listName : " + listName);

        }


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String element = etListElement.getText().toString();
                if (!element.isEmpty()) {
                    addElement(element);
                } else {
                    Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Enter a item", Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
                Log.d(TAG, "elemt -" + element);
                etListElement.setText("");

            }
        });


        imgMicrophne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startVoiceRecognitionActivity();
            }
        });


        imgBarcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator integrator = new IntentIntegrator(CreateList.this);
                integrator.initiateScan();
            }
        });
    }



    private void initView() {
        txtListName = (TextView) findViewById(R.id.txtListName);
        imgMicrophne = (ImageView) findViewById(R.id.imgMicrophone);
        imgBarcode = (ImageView) findViewById(R.id.imgBarcode);
        rvListElements = (RecyclerView) findViewById(R.id.rvListElements);
        etListElement = (EditText) findViewById(R.id.etListElement);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        imgMicrophone = (ImageView) findViewById(R.id.imgMicrophone);
    }

    public void startVoiceRecognitionActivity() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                "Speech recognition demo");
        startActivityForResult(intent, VOICE_RECOGNITION_REQUEST_CODE);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == VOICE_RECOGNITION_REQUEST_CODE && resultCode == RESULT_OK) {
            ArrayList<String> matches = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

            if (matches.contains("pen")) {
                listElements.add(new ListElement("pen"));
            }if (matches.contains("tea")){
                listElements.add(new ListElement("tea"));
            }if (matches.contains("book")){
                listElements.add(new ListElement("book"));
            }

            rvListElements.setAdapter(new ListElementAdapter(getApplicationContext(),listElements));
        }


        IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (scanResult != null) {
            String re = scanResult.getContents();
            Log.d(TAG,"code -"+ re);
            if(re.equals("http://www.promateworld.com/")){
                listElements.add(new ListElement("Promate Book"));
            }if(re.equals("4796009869132")){
                listElements.add(new ListElement("promate B5/100 pgs Book"));
            }
            rvListElements.setAdapter(new ListElementAdapter(getApplicationContext(),listElements));

        }
    }

    public void addElement(String elemntName) {
        listElements.add(new ListElement(elemntName));
        listElementAdapter = new ListElementAdapter(getApplicationContext(), listElements);
        rvListElements.setAdapter(listElementAdapter);
        listElementAdapter.notifyDataSetChanged();
    }


}
