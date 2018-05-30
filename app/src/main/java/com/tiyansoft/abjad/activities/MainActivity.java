package com.tiyansoft.abjad.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.tiyansoft.abjad.R;
import com.tiyansoft.abjad.database.Database;


public class MainActivity extends AppCompatActivity {

    /**
     * Declaring the Reference Variables
     */
    private EditText text;
    private TextView number;
    private FloatingActionButton floatingActionButton;
    private Database database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

        findView();

        database = new Database(this);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database.insertData(text.getText().toString(),Integer.parseInt(number.getText().toString()));
                Toast.makeText(MainActivity.this, "به لیست مورد علاقه ها علاوه شد", Toast.LENGTH_SHORT).show();

            }
        });
        
}


    /**
     * Method name = findView();
     * It is used to find the views from the layout
     */
    public void findView(){
        number = (TextView) findViewById(R.id.txtv_Display);
        text = (EditText) findViewById(R.id.editText);
        floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);
    }

    /**
     * Method name = onAction();
     * It is used to set the action for convert button that is located in "activity_main.xml"
     * @param view
     */
    public void onAction(View view){

        /**
         * Getting the text and changing it in number by "abjad()" method
         */
        int number = abjad(text.getText().toString());

        /**
         * to set the number in number text view
         */
        this.number.setText(number+"");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.menuItem_Favorite){
            Intent intentFavorite = new Intent(MainActivity.this,Favorite_Activity.class);
            startActivity(intentFavorite);
        }else if(id == R.id.menuItem_Info){
            Intent intentInfo = new Intent(MainActivity.this,About_Activity.class);
            startActivity(intentInfo);
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Method name = abjad();
     * It is used to change the text to number
     * @param name
     * @return
     */
    public int abjad(String name) {

        int result = 0;
        for (int i = 0; i < name.length(); i++) {
            char letter = name.charAt(i);
            switch (letter) {
                case 'آ':
                    result += 1;
                    break;
                case 'ا':
                    result += 1;
                    break;
                case 'ب':
                    result += 2;
                    break;
                case 'ت':
                    result += 400;
                    break;
                case 'ث':
                    result += 500;
                    break;
                case 'ج':
                    result += 3;
                    break;
                case 'ح':
                    result += 8;
                    break;
                case 'خ':
                    result += 600;
                    break;
                case 'د':
                    result += 4;
                    break;
                case 'ذ':
                    result += 700;
                    break;
                case 'ر':
                    result += 200;
                    break;
                case 'ز':
                    result += 7;
                    break;
                case 'س':
                    result += 60;
                    break;
                case 'ش':
                    result += 300;
                    break;
                case 'ص':
                    result += 90;
                    break;
                case 'ض':
                    result += 800;
                    break;
                case 'ط':
                    result += 9;
                    break;
                case 'ظ':
                    result += 900;
                    break;
                case 'ع':
                    result += 70;
                    break;
                case 'غ':
                    result += 1000;
                    break;
                case 'ف':
                    result += 80;
                    break;
                case 'ق':
                    result += 100;
                    break;
                case 'ک':
                    result += 20;
                    break;
                case 'ل':
                    result += 30;
                    break;
                case 'م':
                    result += 40;
                    break;
                case 'ن':
                    result += 50;
                    break;
                case 'و':
                    result += 6;
                    break;
                case 'ه':
                    result += 5;
                    break;
                case 'ی':
                    result += 10;
                    break;
                case ' ':
                    result += 0;
                    break;
                case 'پ':
                    result += 0;
                    break;
                case 'چ':
                    result += 0;
                    break;
                case 'گ':
                    result += 0;
                    break;
                case 'ژ':
                    result += 0;
                    break;
            }
        }
        return result;
    }
}
