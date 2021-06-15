package org.professord.sqlitedemoapp;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SqliteDemoHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "menudb"; // the name of our database
    private static final int DB_VERSION = 1; // the version of the database

    SqliteDemoHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE DRINK (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "NAME TEXT, "
                + "DESCRIPTION TEXT);");


        insertDrink(db, "Coffee", "Steamed milk coffee");
        insertDrink(db, "Tea", "Fresh tea leaves, steamed in milk.");
        insertDrink(db, "Lassi", "Our best cold drink.");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    private static void insertDrink(SQLiteDatabase db, String name, String description) {
        ContentValues drinkValues = new ContentValues();
        drinkValues.put("NAME", name);
        drinkValues.put("DESCRIPTION", description);
        db.insert("DRINK", null, drinkValues);
    }
}
