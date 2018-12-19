package nl.incredapple.reboot;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GoalOverViewActivity extends AppCompatActivity {

    MainModel mainModel;
    MoodBoardDatabaseHelper moodBoardDatabaseHelper;
    PositiveThoughtsDatabaseHelper positiveThoughtsDatabaseHelper;

    List<Long> mGetGoalIds;

    long goalId;

    TextView thought1Text, thought2Text, thought3Text, thought4Text;
    TextView goalText, whereText, whenText, howText, preciseText, moreText;

    ImageView moodBoardImage, moodBoardImage1, moodBoardImage2, moodBoardImage3, moodBoardImage4, moodBoardImage5, moodBoardImage6, moodBoardImage7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal_over_view);

        mainModel = new MainModel();
        mainModel.initialize(this);

        positiveThoughtsDatabaseHelper = new PositiveThoughtsDatabaseHelper(this);
        moodBoardDatabaseHelper = new MoodBoardDatabaseHelper(this);

        mGetGoalIds = mainModel.getGoalIds();

        goalText = findViewById(R.id.textViewGoal);
        whereText = findViewById(R.id.textViewWhere);
        whenText = findViewById(R.id.textViewWhen);
        howText = findViewById(R.id.textViewHow);
        preciseText = findViewById(R.id.textViewPrecise);
        moreText = findViewById(R.id.textViewMore);

        Intent intent = getIntent();
        goalId = intent.getLongExtra("goalId" , 0);

        goalText.setText(intent.getStringExtra("COLUMN_GOAL"));
        whereText.setText(intent.getStringExtra("COLUMN_WHERE"));
        whenText.setText(intent.getStringExtra("COLUMN_WHEN" ));
        howText.setText(intent.getStringExtra("COLUMN_HOW"));
        preciseText.setText(intent.getStringExtra("COLUMN_PRECISE"));
        moreText.setText(intent.getStringExtra("COLUMN_MORE"));

        moodBoardImage = findViewById(R.id.imageView2);
        moodBoardImage1 = findViewById(R.id.imageView3);
        moodBoardImage2 = findViewById(R.id.imageView4);
        moodBoardImage3 = findViewById(R.id.imageView5);
        moodBoardImage4 = findViewById(R.id.imageView6);
        moodBoardImage5 = findViewById(R.id.imageView7);
        moodBoardImage6 = findViewById(R.id.imageView8);
        moodBoardImage7 = findViewById(R.id.imageView9);

        List<String> imageUrls = moodBoardDatabaseHelper.getImageUrlsFor(goalId);

        if (imageUrls.size() > 0) {
            moodBoardImage.setImageURI(Uri.parse(imageUrls.get(0)));
        } if (imageUrls.size() > 1) {
            moodBoardImage1.setImageURI(Uri.parse(imageUrls.get(1)));
        }if (imageUrls.size() > 2) {
            moodBoardImage2.setImageURI(Uri.parse(imageUrls.get(2)));
        }if (imageUrls.size() > 3) {
            moodBoardImage3.setImageURI(Uri.parse(imageUrls.get(3)));
        }if (imageUrls.size() > 4) {
            moodBoardImage4.setImageURI(Uri.parse(imageUrls.get(4)));
        }if (imageUrls.size() > 5) {
            moodBoardImage5.setImageURI(Uri.parse(imageUrls.get(5)));
        }if (imageUrls.size() > 6) {
            moodBoardImage6.setImageURI(Uri.parse(imageUrls.get(6)));
        }if (imageUrls.size() > 7) {
            moodBoardImage7.setImageURI(Uri.parse(imageUrls.get(7)));
        }


        thought1Text = findViewById(R.id.textViewPositiveThought1);
        thought2Text = findViewById(R.id.textViewPositiveThought2);
        thought3Text = findViewById(R.id.textViewPositiveThought3);
        thought4Text = findViewById(R.id.textViewPositiveThought4);

        List<String> positiveThoughts = positiveThoughtsDatabaseHelper.getPositiveThoughtsFor(goalId);

        if (positiveThoughts.size() > 0) {
            thought1Text.setText(positiveThoughts.get(0));
        }if (positiveThoughts.size() > 1) {
            thought2Text.setText(positiveThoughts.get(1));
        }if (positiveThoughts.size() > 2) {
            thought3Text.setText(positiveThoughts.get(2));
        }if (positiveThoughts.size() > 3) {
            thought4Text.setText(positiveThoughts.get(3));
        }

    }

}
