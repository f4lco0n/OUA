package pl.sokol;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class LanguageCategoryActivity extends ListActivity {
    private SQLiteDatabase db;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView listLanguages = getListView();

        try {
            SQLiteOpenHelper databaseHelper = new DatabaseHelper(this);
            db = databaseHelper.getReadableDatabase();
            cursor = db.query("LANGUAGE",
                                    new String[]{"_id","NAME"},
                                    null,null,null,null,null);
            CursorAdapter listAdapter = new SimpleCursorAdapter(this,
                                                                android.R.layout.simple_expandable_list_item_1,
                                                                cursor,
                                                                new String[]{"NAME"},
                                                                new int[]{android.R.id.text1},
                                                                0);
            listLanguages.setAdapter(listAdapter);
        } catch (SQLiteException e){
            Toast toast = Toast.makeText(this,"Baza danych jest niedostepna (Category Activity)",Toast.LENGTH_SHORT);
            toast.show();
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        cursor.close();
        db.close();
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Intent intent = new Intent(LanguageCategoryActivity.this,LanguageActivity.class);
        intent.putExtra(LanguageActivity.EXTRA_LANGUAGENO,(int) id);
        startActivity(intent);
    }
}
