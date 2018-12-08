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
    private static final String COLUMN_GOAL_ID = "goalId";

    PositiveThoughtsDatabaseHelper(Context context) {super(context, DATABASE_NAME, null, 1);}

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_PT1 + " STRING, " +
                COLUMN_GOAL_ID + " INTEGER);";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    public long insertData (String positiveThought, Long goalId) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_PT1, positiveThought);
        contentValues.put(COLUMN_GOAL_ID, goalId);

        long id = db.insert(TABLE_NAME, null, contentValues);

        return id;
    }

    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data  = db.rawQuery(query, null);
        return data;
    }


}