package pl.sokol;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class LanguageActivity extends Activity {

    public static final String EXTRA_LANGUAGENO = "languageNo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.language);

        int languageNo = (Integer)getIntent().getExtras().get(EXTRA_LANGUAGENO);

        try {
            SQLiteOpenHelper languageDatabaseHelper = new DatabaseHelper(this);
            SQLiteDatabase db = languageDatabaseHelper.getReadableDatabase();
            Cursor cursor = db.query("LANGUAGE",
                                            new String[]{"NAME","DESCRIPTION"},
                                    "_id = ?",
                                            new String[] {Integer.toString(languageNo)},
                                    null,null,null);

            if(cursor.moveToFirst()){

                String nameText = cursor.getString(0);
                String descriptionText = cursor.getString(1);

                TextView name = (TextView)findViewById(R.id.name);
                name.setText(nameText);

                TextView description = (TextView)findViewById(R.id.description);
                description.setText(descriptionText);
            }
            cursor.close();
            db.close();
        } catch (SQLiteException e){
            Toast toast = Toast.makeText(this,"Baza danych jest niedostepna (LanguageActivity)",Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void onFavoriteClicked(View view){
        int languageNo = (Integer)getIntent().getExtras().get("languageNo");
        new UpdateLanguageTask().execute(languageNo);
    }

    private class UpdateLanguageTask extends AsyncTask<Integer, Void, Boolean>{

        ContentValues languageValues;

        @Override
        protected void onPreExecute() {
            CheckBox favorite = (CheckBox)findViewById(R.id.favorite);
            languageValues = new ContentValues();
            languageValues.put("FAVORITE",favorite.isChecked());
        }

        @Override
        protected Boolean doInBackground(Integer... languages) {
            int languageNo = languages[0];
            SQLiteOpenHelper databaseHelper = new DatabaseHelper(LanguageActivity.this);
            try {
                SQLiteDatabase db = databaseHelper.getWritableDatabase();
                db.update("LANGUAGE",languageValues,
                                "_id = ?", new String[] {Integer.toString(languageNo)});
                db.close();
                return true;
            } catch (SQLiteException e) {
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            if(!aBoolean){
                Toast toast = Toast.makeText(LanguageActivity.this,"Baza jest niedostepna (onPostExecute)",Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }

}
