package com.tiyansoft.abjad.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.tiyansoft.abjad.R;
import com.tiyansoft.abjad.adapters.MyAdapter;
import com.tiyansoft.abjad.database.Data;
import com.tiyansoft.abjad.database.Database;

import java.util.ArrayList;

public class Favorite_Activity extends AppCompatActivity {

    /**
     * Declaring Reference Variables
     */
    private Database database;
    private ArrayList<Data> listOfData;
    private ListView listView;
    private MyAdapter myAdapter;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        //Initializing the database
        database = new Database(Favorite_Activity.this);

        //Getting the data from database and store them array list of "listOfData"
        listOfData = database.getData();

        //Finding the view of listView, making the adapter and setting the adapter in list view
        listView = (ListView) findViewById(R.id.activity_favorite_listView);
        myAdapter = new MyAdapter(this, listOfData);
        listView.setAdapter(myAdapter);

        /**
         * To set action to the list view
         */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int posi, long id) {

                /**
                 * Getting the position because we need it for deletion
                 */
                position = posi;


                /**
                 * Making the AlertDialog to ask whether the deletion should be done or not
                 */
                AlertDialog.Builder ad = new AlertDialog.Builder(Favorite_Activity.this);
                ad.setMessage("آیا مایل به حذف کردن هستید؟");
                ad.setNegativeButton("نخیر",null);
                ad.setPositiveButton("بله", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        //Deletion is done here
                        database.deleteData(listOfData.get(position).getId());

                        //This intent is for refreshing the list view
                        Intent i = new Intent(Favorite_Activity.this,Favorite_Activity.class);
                        startActivity(i);
                        finish();
                    }
                });

                ad.create();
                ad.show();

            }
        });

    }

}
