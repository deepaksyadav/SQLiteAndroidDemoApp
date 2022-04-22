package org.professord.sqlitedemoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;


import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            SqliteDemoHelper helper = new SqliteDemoHelper(this);
            int drinkNo = 2;

            SQLiteDatabase db = helper.getReadableDatabase();
            Cursor cursor = db.query("DRINK",
                    new String[]{"NAME", "DESCRIPTION"},
                    "_id = ?",
                    new String[]{Integer.toString(drinkNo)},
                    null, null, null);
            //Move to the first record in the Cursor
            if (cursor.moveToFirst()) {
//Get the drink details from the cursor
                String nameText = cursor.getString(0);
                String descriptionText = cursor.getString(1);
                //int photoId = cursor.getInt(2);
//Populate the drink name
                TextView name = (TextView) findViewById(R.id.name);
                name.setText(nameText);
//Populate the drink description
                TextView description = (TextView) findViewById(R.id.description);
                description.setText(descriptionText);
            }
            cursor.close();
            db.close();
        } catch (SQLiteException e) {
            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();

        }
    }

    public void insertData(View view) {
        SqliteDemoHelper helper = new SqliteDemoHelper(this);

        //SQLiteDatabase db = helper.getWritableDatabase();
        SQLiteDatabase db = helper.getWritableDatabase();
        TextView name = (TextView) findViewById(R.id.name);
        TextView description = (TextView) findViewById(R.id.description);
        //TextView t3 = (TextView)findViewById(R.id.textView);
        ContentValues cv = new ContentValues();

        cv.put("Name",name.getText().toString());
        cv.put("DESCRIPTION", description.getText().toString());
        db.insert("DRINK", null, cv);
        //insertDrink(db, name.toString(), description.toString());
        db.close();
        name.setText("");

       // String name1=name.toString();
        //t3.setText(name1);

    }
    private static void insertDrink(SQLiteDatabase db, String name, String description) {
        ContentValues drinkValues = new ContentValues();

        db.insert("DRINK", null, drinkValues);
    }
}