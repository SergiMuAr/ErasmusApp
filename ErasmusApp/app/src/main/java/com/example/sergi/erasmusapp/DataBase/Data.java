//package com.example.sergi.erasmusapp.DataBase;
//
///**
// * Created by Sergi on 06/02/2018.
// */
//import java.util.ArrayList;
//import java.util.List;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.SQLException;
//import android.database.sqlite.SQLiteDatabase;
//import android.util.Log;
//
//public class Data {
//    // Database fields
//    private static SQLiteDatabase database;
//
//    // Helper to manipulate table
//    private static MySQLiteHelper dbHelper;
//
//    // Here we only select Title and Author, must select the appropriate columns
//    private String[] allColumns = { MySQLiteHelper.COLUMN_ID,
//            MySQLiteHelper.COLUMN_TITLE, MySQLiteHelper.COLUMN_AUTHOR,
//            MySQLiteHelper.COLUMN_YEAR, MySQLiteHelper.COLUMN_PUBLISHER,
//            MySQLiteHelper.COLUMN_CATEGORY, MySQLiteHelper.COLUMN_PERSONAL_EVALUATION};
//
//    public Data(Context context) {
//        dbHelper = new MySQLiteHelper(context);
//    }
//
//    public void open() throws SQLException {
//        database = dbHelper.getWritableDatabase();
//    }
//
//    public void close() {
//        dbHelper.close();
//    }
//}
