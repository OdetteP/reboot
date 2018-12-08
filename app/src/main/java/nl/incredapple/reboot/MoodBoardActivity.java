package nl.incredapple.reboot;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MoodBoardActivity extends AppCompatActivity {

    MoodBoardDatabaseHelper moodBoardDatabaseHelper;
    private static int RESULT_LOAD_IMG = 1;
    private static int RESULT_LOAD_IMG2 = 2;
    private static int RESULT_LOAD_IMG3 = 3;
    private static int RESULT_LOAD_IMG4 = 4;
    private static int RESULT_LOAD_IMG5 = 5;
    private static int RESULT_LOAD_IMG6 = 6;
    private static int RESULT_LOAD_IMG7 = 7;
    private static int RESULT_LOAD_IMG8 = 8;
    private static int RESULT_LOAD_IMG9 = 9;
    ImageView moodBoardImage, moodBoardImage2, moodBoardImage3, moodBoardImage4, moodBoardImage5,
            moodBoardImage6, moodBoardImage7, moodBoardImage8, moodBoardImage9;
    String picturePath;
    int id;
    public final int REQUEST_CODE_FOR_PERMISSIONS = 1001;
    Bitmap bm ;
    private ArrayList<String> imagesPathList;
    private ViewGroup lnrImages;
    int PICK_IMAGE_MULTIPLE;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood_board);

        Button nextToMainBtn = findViewById(R.id.nextBtn);
        Button nextGoalBtn = findViewById(R.id.nextGoalBtn);
//        Button galleryBtn = findViewById(R.id.galleryBtn);

        moodBoardImage = findViewById(R.id.moodBoardImageView);
        moodBoardImage2 = findViewById(R.id.moodBoardImageView2);
        moodBoardImage3 = findViewById(R.id.moodBoardImageView3);
        moodBoardImage4 = findViewById(R.id.moodBoardImageView4);
        moodBoardImage5 = findViewById(R.id.moodBoardImageView5);
        moodBoardImage6 = findViewById(R.id.moodBoardImageView6);
        moodBoardImage7 = findViewById(R.id.moodBoardImageView7);
        moodBoardImage8 = findViewById(R.id.moodBoardImageView8);
        moodBoardImage9 = findViewById(R.id.moodBoardImageView9);

        moodBoardDatabaseHelper = new MoodBoardDatabaseHelper(this);


        nextGoalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moodBoardDatabaseHelper = new MoodBoardDatabaseHelper(getApplicationContext());
                id = (int) moodBoardDatabaseHelper.insertBitmap(bm);


                Intent nextGoalIntent = new Intent(MoodBoardActivity.this, GoalActivity.class);
                startActivity(nextGoalIntent);

            }
        });

        nextToMainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moodBoardDatabaseHelper = new MoodBoardDatabaseHelper(getApplicationContext());
                id = (int) moodBoardDatabaseHelper.insertBitmap(bm);

                Intent nextToMainIntent = new Intent(MoodBoardActivity.this, MainActivity.class);
                startActivity(nextToMainIntent);




            }
        });

        moodBoardImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(Intent.createChooser(i, "Select Picture"), RESULT_LOAD_IMG);
            }
        });

        moodBoardImage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(Intent.createChooser(i, "Select Picture"), RESULT_LOAD_IMG2);
            }
        });

        moodBoardImage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(Intent.createChooser(i, "Select Picture"), RESULT_LOAD_IMG3);
            }
        });

        moodBoardImage4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(Intent.createChooser(i, "Select Picture"), RESULT_LOAD_IMG4);
            }
        });

        moodBoardImage5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(Intent.createChooser(i, "Select Picture"), RESULT_LOAD_IMG5);
            }
        });

        moodBoardImage6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(Intent.createChooser(i, "Select Picture"), RESULT_LOAD_IMG6);
            }
        });

        moodBoardImage7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(Intent.createChooser(i, "Select Picture"), RESULT_LOAD_IMG7);
            }
        });

        moodBoardImage8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(Intent.createChooser(i, "Select Picture"), RESULT_LOAD_IMG8);
            }
        });

        moodBoardImage9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(Intent.createChooser(i, "Select Picture"), RESULT_LOAD_IMG9);
            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED &&
                    ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE},
                        REQUEST_CODE_FOR_PERMISSIONS);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == RESULT_LOAD_IMG ){
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};

            Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);

            assert cursor != null;
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            picturePath = cursor.getString(columnIndex);
            cursor.close();
            Bitmap bm = BitmapFactory.decodeFile(picturePath);
            Log.i("Hii...", "After Cursor..");
            moodBoardDatabaseHelper = new MoodBoardDatabaseHelper(this);
            int id = (int) moodBoardDatabaseHelper.insertBitmap(bm);
            moodBoardImage.setImageBitmap(bm);

        }else if (requestCode == RESULT_LOAD_IMG2){
            Uri selectedImage2 = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};

            Cursor cursor = getContentResolver().query(selectedImage2, filePathColumn, null, null, null);

            assert cursor != null;
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            picturePath = cursor.getString(columnIndex);
            cursor.close();
            Bitmap bm = BitmapFactory.decodeFile(picturePath);
            Log.i("Hii...", "After Cursor..");
            moodBoardDatabaseHelper = new MoodBoardDatabaseHelper(this);
            int id = (int) moodBoardDatabaseHelper.insertBitmap(bm);
            moodBoardImage2.setImageBitmap(bm);

        }else if (requestCode == RESULT_LOAD_IMG3){
            Uri selectedImage3 = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};

            Cursor cursor = getContentResolver().query(selectedImage3, filePathColumn, null, null, null);

            assert cursor != null;
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            picturePath = cursor.getString(columnIndex);
            cursor.close();
            Bitmap bm = BitmapFactory.decodeFile(picturePath);
            Log.i("Hii...", "After Cursor..");
            moodBoardDatabaseHelper = new MoodBoardDatabaseHelper(this);
            int id = (int) moodBoardDatabaseHelper.insertBitmap(bm);
            moodBoardImage3.setImageBitmap(bm);

        }else if (requestCode == RESULT_LOAD_IMG4){
            Uri selectedImage4 = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};

            Cursor cursor = getContentResolver().query(selectedImage4, filePathColumn, null, null, null);

            assert cursor != null;
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            picturePath = cursor.getString(columnIndex);
            cursor.close();
            Bitmap bm = BitmapFactory.decodeFile(picturePath);
            Log.i("Hii...", "After Cursor..");

            moodBoardDatabaseHelper = new MoodBoardDatabaseHelper(this);
            int id = (int) moodBoardDatabaseHelper.insertBitmap(bm);
            moodBoardImage4.setImageBitmap(bm);

        }else if (requestCode == RESULT_LOAD_IMG5){
            Uri selectedImage5 = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};

            Cursor cursor = getContentResolver().query(selectedImage5, filePathColumn, null, null, null);

            assert cursor != null;
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            picturePath = cursor.getString(columnIndex);
            cursor.close();
            Bitmap bm = BitmapFactory.decodeFile(picturePath);
            Log.i("Hii...", "After Cursor..");

            moodBoardDatabaseHelper = new MoodBoardDatabaseHelper(this);
            int id = (int) moodBoardDatabaseHelper.insertBitmap(bm);
            moodBoardImage5.setImageBitmap(bm);

        }else if (requestCode == RESULT_LOAD_IMG6){
            Uri selectedImage6 = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};

            Cursor cursor = getContentResolver().query(selectedImage6, filePathColumn, null, null, null);

            assert cursor != null;
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            picturePath = cursor.getString(columnIndex);
            cursor.close();
            Bitmap bm = BitmapFactory.decodeFile(picturePath);
            Log.i("Hii...", "After Cursor..");

            moodBoardDatabaseHelper = new MoodBoardDatabaseHelper(this);
            int id = (int) moodBoardDatabaseHelper.insertBitmap(bm);
            moodBoardImage6.setImageBitmap(bm);

        }else if (requestCode == RESULT_LOAD_IMG7){
            Uri selectedImage7 = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};

            Cursor cursor = getContentResolver().query(selectedImage7, filePathColumn, null, null, null);

            assert cursor != null;
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            picturePath = cursor.getString(columnIndex);
            cursor.close();
            Bitmap bm = BitmapFactory.decodeFile(picturePath);
            Log.i("Hii...", "After Cursor..");
            moodBoardDatabaseHelper = new MoodBoardDatabaseHelper(this);
            int id = (int) moodBoardDatabaseHelper.insertBitmap(bm);
            moodBoardImage7.setImageBitmap(bm);

        }else if (requestCode == RESULT_LOAD_IMG8){
            Uri selectedImage8 = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};

            Cursor cursor = getContentResolver().query(selectedImage8, filePathColumn, null, null, null);

            assert cursor != null;
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            picturePath = cursor.getString(columnIndex);
            cursor.close();
            Bitmap bm = BitmapFactory.decodeFile(picturePath);
            Log.i("Hii...", "After Cursor..");
            moodBoardDatabaseHelper = new MoodBoardDatabaseHelper(this);
            int id = (int) moodBoardDatabaseHelper.insertBitmap(bm);
            moodBoardImage8.setImageBitmap(bm);

        }else if (requestCode == RESULT_LOAD_IMG9){
            Uri selectedImage9 = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};

            Cursor cursor = getContentResolver().query(selectedImage9, filePathColumn, null, null, null);

            assert cursor != null;
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            picturePath = cursor.getString(columnIndex);
            cursor.close();
            Bitmap bm = BitmapFactory.decodeFile(picturePath);
            Log.i("Hii...", "After Cursor..");
            moodBoardDatabaseHelper = new MoodBoardDatabaseHelper(this);
            int id = (int) moodBoardDatabaseHelper.insertBitmap(bm);
            moodBoardImage9.setImageBitmap(bm);

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == REQUEST_CODE_FOR_PERMISSIONS){
            //You need to handle permission results, if user didn't allow them.
        }
    }

//    public void getImage(Bitmap bm) {
//        Log.i("Hi..", "In getImage "+bm);
//        moodBoardDatabaseHelper = new MoodBoardDatabaseHelper(this);
//        int id = (int) moodBoardDatabaseHelper.insertBitmap(bm);
//        moodBoardImage.setImageBitmap(moodBoardDatabaseHelper.getBitmaps(id));
//    }


}
