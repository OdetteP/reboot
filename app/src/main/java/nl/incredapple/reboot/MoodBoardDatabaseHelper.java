package nl.incredapple.reboot;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MoodBoardDatabaseHelper  extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "MoodBoard";
    private static final String TABLE_NAME = "MoodBoardTable";
    private static final String COLUMN_IMAGE_URL = "img_url";
    private static final String COLUMN_GOAL_ID = "goal_id";
    private static final String COLUMN_ID = "id";
    private static final String CREATE_TABLE_IMAGE =
            "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COLUMN_GOAL_ID + "INTEGER,"  +
                    COLUMN_IMAGE_URL + " STRING);";

    
    public MoodBoardDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_IMAGE);
        Log.i("Table..", "Created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void insertDestinationURL(String url, long goalId) {

        SQLiteDatabase db = this.getWritableDatabase();

        db.beginTransaction();
        ContentValues values;

        try {
            values = new ContentValues();
            values.put(COLUMN_IMAGE_URL, url);
            values.put(COLUMN_GOAL_ID, goalId);
            db.insert(TABLE_NAME, null, values);
            db.setTransactionSuccessful();
            Log.i("Image..", "Inserted..");
        } catch (SQLiteException e) {
            e.printStackTrace();

        } finally {
            db.endTransaction();
            // End the transaction.
            db.close();
            // Close database
        }
    }

    public String[] getImageUrlsFor(int goalId) {
        final SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<String> arrayOfUrlsForGoal = new ArrayList<>();
        db.beginTransaction();
        try {
            String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_GOAL_ID + " = " + goalId;
            Cursor cursor = db.rawQuery(selectQuery, null);


            if (cursor.getCount() > 0) {
                while (cursor.moveToNext()) {
                    String imageURL = cursor.getColumnName(3);
                    arrayOfUrlsForGoal.add(imageURL);
                }
            }

            db.setTransactionSuccessful();
        } catch (SQLiteException e) {
            e.printStackTrace();

        } finally {
            db.endTransaction();
            // End the transaction.
            db.close();
            // Close database
        }
        return arrayOfUrlsForGoal.toArray(new String[0]);
    }
}