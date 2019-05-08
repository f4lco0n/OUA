package pl.sokol;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "db";
    private static final int DB_VERSION = 2;


    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
     updateMyDatabase(db,0,DB_VERSION);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private static void insertLanguage(SQLiteDatabase db, String name, String description){
        ContentValues languageValues = new ContentValues();
        languageValues.put("NAME",name);
        languageValues.put("DESCRIPTION",description);
        db.insert("LANGUAGE",null,languageValues);
    }

    private void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion){
        if (oldVersion < 1){
            db.execSQL("CREATE TABLE LANGUAGE (_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "NAME TEXT," +
                    "DESCRIPTION TEXT);");
            insertLanguage(db,"Java","Java nie jest taka zla do pewnego momentu");
            insertLanguage(db,"Python","Python jest calkiem przyjemny");
        }
        if (oldVersion < 2){
            db.execSQL("ALTER TABLE LANGUAGE ADD COLUMN TYPE;");
        }
    }
}
