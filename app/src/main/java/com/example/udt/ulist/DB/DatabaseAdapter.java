package com.example.udt.ulist.DB;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by UDT on 10/22/2017.
 */

public class DatabaseAdapter {
//    /**
//     * Identifier for the internal database
//     */
//    public static final int INTERNAL = 0;
//    /**
//     * Identifier for the external database
//     */
//    public static final int EXTERNAL = 1;
//
//    private final SQLiteOpenHelper[] mDatabaseManager = new SQLiteOpenHelper[2];
//    private final SQLiteDatabase[] mDatabases = new SQLiteDatabase[2];
//
//    /**
//     * Constructs the database and open it.
//     */
//    public DatabaseAdapter() {
//        // Open the internal_db
//        mDatabaseManager[INTERNAL] = new InternalDatabaseManager(MyApplication.getInstance());
//        mDatabases[INTERNAL] = mDatabaseManager[INTERNAL].getWritableDatabase();
//    }
//
//    /**
//     * Checks the database state and throws an {@link IllegalStateException} if database isn't open.
//     * Should always be used before starting to access the database.
//     *
//     * @param type Type of the database. Can be INTERNAL or EXTERNAL.
//     */
//    public void checkDbState(int type) {
//        if (mDatabases[type] == null || !mDatabases[type].isOpen()) {
//            throw new IllegalStateException("The database has not been opened");
//        }
//    }
//
//    /**
//     * Closes the database of the given type.
//     *
//     * @param type Type of the database. Can be INTERNAL or EXTERNAL.
//     */
//    public void close(int type) {
//        if (mDatabases[type].isOpen()) {
//            mDatabases[type].close();
//            mDatabases[type] = null;
//            if (mDatabaseManager[type] != null) {
//                mDatabaseManager[type].close();
//                mDatabaseManager[type] = null;
//            }
//        }
//    }
//
//    /**
//     * @param type Type of the database. Can be INTERNAL or EXTERNAL.
//     * @return true if the database is open, false otherwise.
//     */
//    public boolean isOpen(int type) {
//        return mDatabases[type] != null && mDatabases[type].isOpen();
//    }
//
//    /**
//     * Opens the default database.
//     *
//     * @param type Type of the database. Can be INTERNAL or EXTERNAL.
//     */
//    public void open(int type) {
//        switch (type) {
//            case INTERNAL:
//                mDatabaseManager[INTERNAL] = new InternalDatabaseManager(MyApplication.getInstance());
//                if (!isOpen(INTERNAL)) {
//                    mDatabases[INTERNAL] = mDatabaseManager[INTERNAL].getWritableDatabase();
//                }
//                break;
//            case EXTERNAL:
//                mDatabaseManager[EXTERNAL] = new ExternalDatabaseManager(MyApplication.getInstance(), Constants.EXTERNAL_DB_PATH, 1);
//                if (!isOpen(EXTERNAL)) {
//                    mDatabases[EXTERNAL] = mDatabaseManager[EXTERNAL].getWritableDatabase();
//                }
//                break;
//        }
//    }
}
