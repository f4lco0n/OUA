package pl.sokol;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class MainActivity extends Activity {

    private SQLiteDatabase db;
    private Cursor favoritesCursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AdapterView.OnItemClickListener itemClickListener =
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        if(position == 0){
                            Intent intent = new Intent(MainActivity.this,LanguageCategoryActivity.class);
                            startActivity(intent);
                        }
                    }
                };
        ListView listView = (ListView) findViewById(R.id.list_options);
        listView.setOnItemClickListener(itemClickListener);

        ListView listFavorites = (ListView)findViewById(R.id.list_favorites);
        try {
            SQLiteOpenHelper databaseHelper = new DatabaseHelper(this);
            db = databaseHelper.getReadableDatabase();
            favoritesCursor = db.query("LANGUAGE",
                                new String[]{"_id","NAME"}, "FAVORITE = 1",
                     null,null,null,null);
            CursorAdapter favoriteAdapter =
                    new SimpleCursorAdapter(MainActivity.this,
                                            android.R.layout.simple_list_item_1,
                                            favoritesCursor,
                                            new String[]{"NAME"},
                                            new int[] {android.R.id.text1},0);
            listFavorites.setAdapter(favoriteAdapter);
        } catch (SQLiteException e) {
            Toast toast = Toast.makeText(this,"Baza jest niedostepna (Main Activity)",Toast.LENGTH_SHORT);
            toast.show();
        }

        listFavorites.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,LanguageActivity.class);
                intent.putExtra(LanguageActivity.EXTRA_LANGUAGENO,(int) id);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        favoritesCursor.close();
        db.close();
    }

    public void onRestart(){
        super.onRestart();
        try {
            DatabaseHelper databaseHelper = new DatabaseHelper(this);
            db = databaseHelper.getReadableDatabase();
            Cursor newCursor = db.query("LANGUAGE",
                                new String[]{"_id","NAME"},
                        "FAVORITE = 1",
                    null,null,null,null);
            ListView listFavorites = (ListView)findViewById(R.id.list_favorites);
            CursorAdapter adapter = (CursorAdapter) listFavorites.getAdapter();
            adapter.changeCursor(newCursor);
            favoritesCursor = newCursor;
        } catch (SQLiteException e){
            Toast toast = Toast.makeText(this,"Baza danych niedostepna (Main Activity 2)",Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
