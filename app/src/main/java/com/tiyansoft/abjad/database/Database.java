package com.tiyansoft.abjad.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Ehsan Hasin on 12/19/2017.
 */

public class Database extends SQLiteOpenHelper{

    /**
     * The required variable for database name, table name and table fields
     */
    public static final String db_name = "Database";
    public static final String tb_name = "Data";
    public static final String field_id = "id";
    public static final String field_text = "text";
    public static final String field_number = "number";

    /**
     * The query for making the table
     */
    public static final String query = "CREATE TABLE "+tb_name+"("+field_id+" INTEGER PRIMARY KEY AUTOINCREMENT, "+field_text+" TEXT, "+field_number+" INTEGER);";

    Context context;
    SQLiteDatabase sqliteDatabase;

    /**
     * The constructor is used for making the database
     * @param context
     */
    public Database(Context context) {
        super(context, db_name, null, 1);
        this.context = context;
    }

    /**
     * This method is for creating the table
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(query);
    }

    /**
     * This method is used to open the database
     */
    public void openDatabase(){
        sqliteDatabase = getWritableDatabase();
    }

    /**
     * This method is used to close the database
     */
    public void closeDatabase(){
        close();
    }

    /**
     * This method is used to insert the data in the database
     * @param text
     * @param number
     */
    public void insertData(String text, int number){

        openDatabase();

        ContentValues cv = new ContentValues();
        cv.put(field_text,text);
        cv.put(field_number,number);
        sqliteDatabase.insert(tb_name,null,cv);

        closeDatabase();
    }

    /**
     * This method is used to get the data from database
     * @return
     */
    public ArrayList<Data> getData(){

        ArrayList<Data> list = new ArrayList<Data>();


        openDatabase();

        Cursor cursor = sqliteDatabase.query(tb_name,null,null,null,null,null,null,null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            Data data = new Data();
            data.setId(cursor.getInt(0));
            data.setText(cursor.getString(1));
            data.setNumber(cursor.getInt(2));
            cursor.moveToNext();
            list.add(data);
        }

        closeDatabase();

        return list;
    }

    /**
     * This method is used to deleted the data from database
     * @param id
     */
    public void deleteData(int id){

        openDatabase();
        sqliteDatabase.delete(tb_name,"id = "+id,null);
        closeDatabase();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}

