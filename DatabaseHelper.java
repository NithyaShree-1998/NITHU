package com.example.admin.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;



    public class DatabaseHelper extends SQLiteOpenHelper {


        public static final int DATABASE_VERSION = 1;
        public static final String DATABASE_NAME = "Mydatabase.db";

        public static final String TABLE_REGISTER = "register";
        public static final String FCODE = "scode";
        public static final String FPWD = "pass";
        public static final String KEY_PHONE = "Phone";
        public static final String KEY_USN = "Usn";
        public static final String KEY_SNAME = "Sname";
        public static final String KEY_ATTEND = "Attended";
        public static final String KEY_MISSED = "Missed";
        public static final String KEY_CODE = "Code";
        private static final String DATABASE_TABLE2 = "stu_info";
        public static final String KEY_ROWID = "_id";


        public DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }


        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table "
                    + TABLE_REGISTER + "(" + FCODE
                    + " INTEGER PRIMARY KEY," + FPWD
                    + " TEXT NOT NULL)");

            db.execSQL("create table "
                    + DATABASE_TABLE2 + "(" + KEY_ROWID
                    + " INTEGER PRIMARY KEY AUTO INCREMENT," + KEY_SNAME
                    + " TEXT NOT NULL," + KEY_USN
                    + " TEXT NOT NULL," + KEY_PHONE
                    + " TEXT NOT NULL," + KEY_CODE
                    + " TEXT NOT NULL)");


        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_REGISTER);
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE2);
            onCreate(db);

        }


        boolean addregister(String code, String pass)

        {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(FCODE, code);
            values.put(FPWD, pass);
            long result = db.insert(TABLE_REGISTER, null, values);
            db.close();
            return result != -1;

        }

        public String searchpass(String uname) {
            SQLiteDatabase db = this.getReadableDatabase();
            String query = "select scode, pass from " + TABLE_REGISTER;
            Cursor cursor = db.rawQuery(query, null);
            String a, b;
            b = "NOT FOUND";
            if (cursor.moveToNext()) {
                do {
                    a = cursor.getString(0);
                    if (a.equals(uname)) {
                        b = cursor.getString(1);
                        break;
                    }

                }
                while (cursor.moveToNext());
            }

            return b;


        }

    boolean addstudents(String name,String USN,String phone,String code)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        {
            ContentValues values=new ContentValues();
            values.put(KEY_SNAME,name);
            values.put(KEY_USN,USN);
            values.put(KEY_PHONE,phone);
            values.put(KEY_CODE,code);
            long result=db.insert(DATABASE_TABLE2,null,values);
            db.close();
            return result!=-1;
        }
    }

    }