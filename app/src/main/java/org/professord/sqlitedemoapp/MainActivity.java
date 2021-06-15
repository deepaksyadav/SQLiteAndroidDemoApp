package org.professord.sqlitedemoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SqliteDemoHelper helper = new SqliteDemoHelper(this);
        //SqliteDemoHelper helper = new SqliteDemoHelper(this);
        SQLiteDatabase db = helper.getReadableDatabase();

    }

}