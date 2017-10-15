package com.example.udt.ulist.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.udt.ulist.model.ListItem;
import com.example.udt.ulist.model.MyLists;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.version;

/**
 * Created by UDT on 9/22/2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "shoppinglists";

    private static final String TABLE_LISTS = "lists";
    private static final String KEY_ID = "id";
    private static final String KEY_LIST_NAME = "list_name";
    private static final String KEY_TOTAL = "list_name";

    private static final String TABLE_LIST_ELEMENT = "list_element";
    private static final String KEY_ITEM_ID = "item_id";
    private static final String KEY_ITEM_NAME = "item_name";
    private static final String KEY_PRICE = "price";
    private static final String KEY_PROMO_PRICE = "promo_price";
    private static final String KEY_QTY = "qty";
    private static final String KEY_ITEM_TOTAL = "item_total";


    private static final String CREATE_LISTS_TABLE = "CREATE TABLE " + TABLE_LISTS + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_LIST_NAME + " TEXT" + KEY_TOTAL+" INTEGER" +")";
    private static final String CREATE_LIST_ELEMENT_TABLE = "CREATE TABLE " + TABLE_LIST_ELEMENT + "(" + KEY_ITEM_ID + " INTEGER PRIMARY KEY," + KEY_ITEM_NAME + " TEXT" +
            KEY_PRICE+"INTEGER"+ KEY_PROMO_PRICE+"INTEGER"+KEY_QTY+"INTEGER"+KEY_ITEM_TOTAL+"INTEGER"+")";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, version);
        //3rd argument to be passed is CursorFactory instance
    }

    public DatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_LISTS_TABLE);
        sqLiteDatabase.execSQL(CREATE_LIST_ELEMENT_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // Drop older table if existed
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_LISTS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_LIST_ELEMENT);

        // Create tables again
        onCreate(sqLiteDatabase);
    }

    // add the new myLists
    public void addList(MyLists myLists) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_LIST_NAME, myLists.getListName()); // myLists Name

        // Inserting Row
        db.insert(TABLE_LISTS, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }



    // get the single list
    public MyLists getlist(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_LISTS, new String[]{KEY_ID,
                        KEY_LIST_NAME,KEY_TOTAL}, KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        MyLists myLists = new MyLists(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),cursor.getInt(2));
        // return contact
        return myLists;
    }

    // code to get all contacts in a list view
    public List<MyLists> getAlllists() {
        List<MyLists> myList = new ArrayList<MyLists>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_LISTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                MyLists list = new MyLists();
                list.setId(Integer.parseInt(cursor.getString(0)));
                list.setListName(cursor.getString(1));

                // Adding contact to list
                myList.add(list);
            } while (cursor.moveToNext());
        }
        return myList;
    }


    // update the single lists
    public int updatelist(MyLists myLists) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_LIST_NAME, myLists.getListName());

        // updating row
        return db.update(TABLE_LISTS, values, KEY_ID + " = ?",
                new String[]{String.valueOf(myLists.getId())});
    }


    // Deleting single myLists
    public void deleteList(MyLists myLists) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_LISTS, KEY_ID + " = ?",
                new String[]{String.valueOf(myLists.getId())});
        db.close();
    }


    // Getting contacts Count
    public int getListCount() {
        String countQuery = "SELECT  * FROM " + TABLE_LISTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();

        // return count
        return count;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
// add the new element
    public void addElement(ListItem listItem) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ITEM_NAME, listItem.getItemName()); // myLists Name

        // Inserting Row
        db.insert(TABLE_LIST_ELEMENT, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }


    // get the single element
    public ListItem getelemet(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_LIST_ELEMENT, new String[]{KEY_ITEM_ID,
                        KEY_ITEM_NAME}, KEY_ITEM_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        ListItem listItem = new ListItem(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),cursor.getInt(2),cursor.getInt(3),cursor.getInt(4),cursor.getInt(5));
        // return contact
        return listItem;
    }


}
