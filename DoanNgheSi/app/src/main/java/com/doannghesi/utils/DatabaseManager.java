package com.doannghesi.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.doannghesi.objects.Singer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Peih Gnaoh on 7/31/2017.
 */

public enum DatabaseManager {
    INSTANCE;
    public static final String TABLE_SINGER = "TABLE_SINGER";

    public static final String SINGER_ID = "SINGER_ID";
    public static final String SINGER_FULL_NAME = "SINGER_FULL_NAME";
    public static final String SINGER_NAME_ANSWER = "SINGER_NAME_ANSWER";
    public static final String SINGER_HINT = "SINGER_HINT";
    public static final String SINGER_IMG = "SINGER_IMG";

    public static String DB_PATH = "";
    public static String DB_NAME = "Singer.db";
    public static final int DB_VERSION = 1;
    private DatabaseHelper databaseHelper;


    /**
     * khởi tạo database
     *
     * @param context
     */
    public static void init(Context context) {
        if (INSTANCE.databaseHelper == null) {
            DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
            File file = new File(DB_PATH);
            if (!file.exists()) {
                file.mkdirs();
            }
            INSTANCE.databaseHelper = new DatabaseHelper(context);
            try {
                INSTANCE.databaseHelper.createDataBase();
                INSTANCE.databaseHelper.openDataBase();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void addSingerToDB(Singer object) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        db.beginTransaction();
        ContentValues values = new ContentValues();
        values.put(SINGER_ID, UUID.randomUUID().toString());
        values.put(SINGER_HINT, object.getHint());
        values.put(SINGER_FULL_NAME, object.getFullName());
        values.put(SINGER_IMG, object.getImg());
        values.put(SINGER_NAME_ANSWER, object.getNameAnswer());
        db.insert(TABLE_SINGER, null, values);
        db.setTransactionSuccessful();
        db.endTransaction();
    }
    public ArrayList<Singer> getSingerList(Context context) {
        ArrayList<Singer> list = new ArrayList<>();
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_SINGER;
        Cursor cursor = db.rawQuery(query, null, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                Singer object = new Singer(cursor,context);
                list.add(object);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return list;
    }
    public boolean isHaveData(){
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_SINGER;
        Cursor cursor = db.rawQuery(query, null, null);
        if (cursor.getCount()>0){
            return true;
        }else {
            return false;
        }
    }
    public static class DatabaseHelper extends SQLiteOpenHelper {
        private SQLiteDatabase sqLiteDatabase;

        public DatabaseHelper(Context context) {
            super(context, DB_PATH + DB_NAME, null, DB_VERSION);
        }

        public void createDataBase() throws IOException {
            this.getReadableDatabase();
        }

        public void openDataBase() throws SQLException {
            close();
            // Open the database
            String myPath = DB_PATH + DB_NAME;
            sqLiteDatabase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try {
                db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_SINGER + "("
                        + SINGER_ID + " TEXT PRIMARY KEY, "
                        + SINGER_FULL_NAME + " TEXT, "
                        + SINGER_HINT + " TEXT, "
                        + SINGER_NAME_ANSWER + " TEXT, "
                        + SINGER_IMG+ " INTEGER)");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_SINGER);
            onCreate(sqLiteDatabase);
        }


        @Override
        public synchronized void close() {
            if (sqLiteDatabase != null) {
                sqLiteDatabase.close();
            }
            super.close();
        }
    }

}
