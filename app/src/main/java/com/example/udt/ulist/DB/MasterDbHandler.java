package com.example.udt.ulist.DB;

import android.content.ClipData;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.udt.ulist.model.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by UDT on 10/15/2017.
 */

public class MasterDbHandler extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "master.db";
    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_LOCATION = "/data/data/com.example.udt.ulist.databases/";
    private Context context;
    private SQLiteDatabase sqLiteDatabase;


    public MasterDbHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void openDatabse() {
        String dbPath = context.getDatabasePath(DATABASE_NAME).getPath();
        if (sqLiteDatabase != null && sqLiteDatabase.isOpen()) {
            return;
        }

        sqLiteDatabase = SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READWRITE);
    }

    public void closeDatabase() {
        if (sqLiteDatabase != null) {
            sqLiteDatabase.close();
        }

    }

    public List<Item> getAllITems() {
        Item item = null;
        List<Item> itemList = new ArrayList<>();
        openDatabse();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM ITEM", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            item = new Item(cursor.getInt(0), cursor.getString(1));
            itemList.add(item);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return itemList;
    }
}
