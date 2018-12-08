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
    private ArrayList<String> urls;
    private Long goalId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood_board);

        urls = new ArrayList<>();

        Button nextToMainBtn = findViewById(R.id.nextBtn);
        Button nextGoalBtn = findViewById(R.id.nextGoalBtn);
//        Button galleryBtn = findViewById(R.id.galleryBtn);
        Intent intent = getIntent();
        goalId = intent.getLongExtra("goalId" , 0 );
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
                saveImages();
                Intent nextGoalIntent = new Intent(MoodBoardActivity.this, GoalActivity.class);
                startActivity(nextGoalIntent);

            }
        });

        nextToMainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveImages();
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

    private void saveImages() {
        moodBoardDatabaseHelper = new MoodBoardDatabaseHelper(getApplicationContext());
        for (int image = 0 ; image < urls.size() ; image++) {
            moodBoardDatabaseHelper.insertDestinationURL(urls.get(image),goalId);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == RESULT_LOAD_IMG ){
            Uri selectedImage = data.getData();
//            String[] filePathColumn = {MediaStore.Images.Media.DATA};
//
//            Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
//
//            assert cursor != null;
//            cursor.moveToFirst();
//
//            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
//            picturePath = cursor.getString(columnIndex);
//            cursor.close();
//            Bitmap bm = BitmapFactory.decodeFile(picturePath);
//            Log.i("Hii...", "After Cursor..");
//            moodBoardDatabaseHelper = new MoodBoardDatabaseHelper(this);
//            int id = (int) moodBoardDatabaseHelper.insertBitmap(bm);
            urls.add(String.valueOf(selectedImage));
            moodBoardImage.setImageURI(selectedImage);

        }else if (requestCode == RESULT_LOAD_IMG2){
            Uri selectedImage = data.getData();
//            String[] filePathColumn = {MediaStore.Images.Media.DATA};
//
//            Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
//
//            assert cursor != null;
//            cursor.moveToFirst();
//
//            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
//            picturePath = cursor.getString(columnIndex);
//            cursor.close();
//            Bitmap bm = BitmapFactory.decodeFile(picturePath);
//            Log.i("Hii...", "After Cursor..");
//            moodBoardDatabaseHelper = new MoodBoardDatabaseHelper(this);
//            int id = (int) moodBoardDatabaseHelper.insertBitmap(bm);
            urls.add(String.valueOf(selectedImage));
            moodBoardImage2.setImageURI(selectedImage);

        }else if (requestCode == RESULT_LOAD_IMG3){
            Uri selectedImage3 = data.getData();
            urls.add(String.valueOf(selectedImage3));
            moodBoardImage3.setImageURI(selectedImage3);

        }else if (requestCode == RESULT_LOAD_IMG4){
            Uri selectedImage3 = data.getData();
            urls.add(String.valueOf(selectedImage3));
            moodBoardImage4.setImageURI(selectedImage3);

        }else if (requestCode == RESULT_LOAD_IMG5){
            Uri selectedImage3 = data.getData();
            urls.add(String.valueOf(selectedImage3));
            moodBoardImage5.setImageURI(selectedImage3);

        }else if (requestCode == RESULT_LOAD_IMG6){
            Uri selectedImage3 = data.getData();
            urls.add(String.valueOf(selectedImage3));
            moodBoardImage6.setImageURI(selectedImage3);

        }else if (requestCode == RESULT_LOAD_IMG7){
            Uri selectedImage3 = data.getData();
            urls.add(String.valueOf(selectedImage3));
            moodBoardImage7.setImageURI(selectedImage3);

        }else if (requestCode == RESULT_LOAD_IMG8){
            Uri selectedImage3 = data.getData();
            urls.add(String.valueOf(selectedImage3));
            moodBoardImage8.setImageURI(selectedImage3);

        }else if (requestCode == RESULT_LOAD_IMG9){
            Uri selectedImage3 = data.getData();
            urls.add(String.valueOf(selectedImage3));
            moodBoardImage9.setImageURI(selectedImage3);

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
