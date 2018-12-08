package nl.incredapple.reboot;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class PositiveThoughtsDatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Positive Thoughts";
    private static final String TABLE_NAME = "PT";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_PT1 = "positiveThought1";
    private static final String COLUMN_PT2 = "positiveThought2";
    private static final String COLUMN_PT3 = "positiveThought3";
    private static final String COLUMN_PT4 = "positiveThought4";
    private static final String COLUMN_PT5 = "positiveThought5";

    PositiveThoughtsDatabaseHelper(Context context) {super(context, DATABASE_NAME, null, 1);}

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_PT1 + " STRING, " +
                COLUMN_PT2 + " STRING, " +
                COLUMN_PT3 + " STRING, " +
                COLUMN_PT4 + " STRING, " +
                COLUMN_PT5 + " STRING);";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    public  boolean insertData (String positiveThought1, String positiveThought2, String positiveThought3,
                                String positiveThought4, String positiveThought5) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_PT1, positiveThought1);
        contentValues.put(COLUMN_PT2, positiveThought2);
        contentValues.put(COLUMN_PT3, positiveThought3);
        contentValues.put(COLUMN_PT4, positiveThought4);
        contentValues.put(COLUMN_PT5, positiveThought5);

        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        }else {
            return true;
        }
    }

    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data  = db.rawQuery(query, null);
        return data;
    }


}