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
import java.util.List;

public class MoodBoardDatabaseHelper  extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "MoodBoard";
    private static final String TABLE_NAME = "MB";
    private static final String COLUMN_IMAGE = "img";
    private static final String COLUMN_IMAGE2 = "img2";
    private static final String COLUMN_IMAGE3 = "img3";
    private static final String COLUMN_IMAGE4 = "img4";
    private static final String COLUMN_IMAGE5 = "img5";
    private static final String COLUMN_IMAGE6 = "img6";
    private static final String COLUMN_IMAGE7 = "img7";
    private static final String COLUMN_IMAGE8 = "img8";
    private static final String COLUMN_IMAGE9 = "img9";
    private static final String COLUMN_ID = "id";
    private static final String CREATE_TABLE_IMAGE =
            "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COLUMN_IMAGE + " BLOB NOT NULL," + COLUMN_IMAGE2 + " BLOB NOT NULL," +
                    COLUMN_IMAGE3 + " BLOB NOT NULL," + COLUMN_IMAGE4 + " BLOB NOT NULL, " +
                    COLUMN_IMAGE5 + " BLOB NOT NULL, " + COLUMN_IMAGE6 + " BLOB NOT NULL, " +
                    COLUMN_IMAGE7 + " BLOB NOT NULL, " + COLUMN_IMAGE8 + " BLOB NOT NULL, " + COLUMN_IMAGE9 + " BLOB NOT NULL );";

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

    public long insertBitmap(Bitmap bmp) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG, 100, out);
        byte[] buffer = out.toByteArray();

        SQLiteDatabase db = this.getWritableDatabase();

        db.beginTransaction();
        ContentValues values;

        long id = 0;

        try {
            values = new ContentValues();
            values.put("img", buffer);
            values.put("img2", buffer);
            values.put("img3", buffer);
            values.put("img4", buffer);
            values.put("img5", buffer);
            values.put("img6", buffer);
            values.put("img7", buffer);
            values.put("img8", buffer);
            values.put("img9", buffer);

            id = db.insert(TABLE_NAME, null, values);
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
        return id;
    }

    public Bitmap[] getBitmaps(int id) {
        Bitmap bitmap, bitmap2, bitmap3, bitmap4, bitmap5, bitmap6, bitmap7, bitmap8, bitmap9 = null;
        final SQLiteDatabase db = this.getReadableDatabase();
        Bitmap[] arrayOfBitmap = new Bitmap[0];
        db.beginTransaction();
        try {
            String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE id = " + id;
            Cursor cursor = db.rawQuery(selectQuery, null);


            if (cursor.getCount() > 0) {
                while (cursor.moveToNext()) {
                    byte[] blob = cursor.getBlob(cursor.getColumnIndex(COLUMN_IMAGE));
                    byte[] blob2 = cursor.getBlob(cursor.getColumnIndex(COLUMN_IMAGE2));
                    byte[] blob3 = cursor.getBlob(cursor.getColumnIndex(COLUMN_IMAGE3));
                    byte[] blob4 = cursor.getBlob(cursor.getColumnIndex(COLUMN_IMAGE4));
                    byte[] blob5 = cursor.getBlob(cursor.getColumnIndex(COLUMN_IMAGE5));
                    byte[] blob6 = cursor.getBlob(cursor.getColumnIndex(COLUMN_IMAGE6));
                    byte[] blob7 = cursor.getBlob(cursor.getColumnIndex(COLUMN_IMAGE7));
                    byte[] blob8 = cursor.getBlob(cursor.getColumnIndex(COLUMN_IMAGE8));
                    byte[] blob9 = cursor.getBlob(cursor.getColumnIndex(COLUMN_IMAGE9));

                    bitmap = BitmapFactory.decodeByteArray(blob, 0, blob.length);
                    bitmap2 = BitmapFactory.decodeByteArray(blob2, 0, blob.length);
                    bitmap3 = BitmapFactory.decodeByteArray(blob3, 0, blob.length);
                    bitmap4 = BitmapFactory.decodeByteArray(blob4, 0, blob.length);
                    bitmap5 = BitmapFactory.decodeByteArray(blob5, 0, blob.length);
                    bitmap6 = BitmapFactory.decodeByteArray(blob6, 0, blob.length);
                    bitmap7 = BitmapFactory.decodeByteArray(blob7, 0, blob.length);
                    bitmap8 = BitmapFactory.decodeByteArray(blob8, 0, blob.length);
                    bitmap9 = BitmapFactory.decodeByteArray(blob9, 0, blob.length);

                    arrayOfBitmap = new Bitmap[]{bitmap, bitmap2, bitmap3, bitmap4, bitmap5, bitmap6, bitmap7, bitmap8, bitmap9};

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
        return arrayOfBitmap;
    }
}