package com.application.practice.databinding_Sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.security.PrivateKey;

/**
 * Created by Charles Raj I on 25/07/22.
 *
 * @author Charles Raj I
 */

/* Lets start to create a sqlite helper class
* This class have the basic function of sqlite ..
* we want to extend the Sqliteopenhelper class here...
* */
public class SqliteHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "myPersonalDetails";
    private static final int DATABASE_VERSION = 1;

    private Context context;
    public SqliteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try{
            /*We have to insert the query here,
            * Lets have the Query and other things in  seperate class.*/
            sqLiteDatabase.execSQL(DbStatics.CREATE_TABLE_PERSONAL_DATA);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
