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
    int position;


    TextView thought1Text, thought2Text, thought3Text, thought4Text;
    TextView goalText, whereText, whenText, howText, preciseText, moreText;

    String goal, mWhere, when, how, precise, mMore;

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

        goalText.setText(String.valueOf(mainModel.getGoals()));
        whereText.setText(String.valueOf(mainModel.getRightWhere()));
        whenText.setText(String.valueOf(mainModel.getRightWhen()));
        howText.setText(String.valueOf(mainModel.getRightHow()));
        preciseText.setText(String.valueOf(mainModel.getRightPrecise()));
        moreText.setText(String.valueOf(mainModel.getRightMore()));


        moodBoardImage = findViewById(R.id.imageView2);
        moodBoardImage1 = findViewById(R.id.imageView3);
        moodBoardImage2 = findViewById(R.id.imageView4);
        moodBoardImage3 = findViewById(R.id.imageView5);
        moodBoardImage4 = findViewById(R.id.imageView6);
        moodBoardImage5 = findViewById(R.id.imageView7);
        moodBoardImage6 = findViewById(R.id.imageView8);
        moodBoardImage7 = findViewById(R.id.imageView9);

        Intent intent = getIntent();
        intent.putExtra("goalId" , String.valueOf(mGetGoalIds));


            moodBoardImage.setImageURI(Uri.parse(String.valueOf(moodBoardDatabaseHelper.getImageUrlsFor(mGetGoalIds.get(0)))));
            moodBoardImage1.setImageURI(Uri.parse(String.valueOf(moodBoardDatabaseHelper.getImageUrlsFor(mGetGoalIds.get(0)))));
            moodBoardImage2.setImageURI(Uri.parse(String.valueOf(moodBoardDatabaseHelper.getImageUrlsFor(mGetGoalIds.get(0)))));
            moodBoardImage3.setImageURI(Uri.parse(String.valueOf(moodBoardDatabaseHelper.getImageUrlsFor(mGetGoalIds.get(0)))));
            moodBoardImage4.setImageURI(Uri.parse(String.valueOf(moodBoardDatabaseHelper.getImageUrlsFor(mGetGoalIds.get(0)))));
            moodBoardImage5.setImageURI(Uri.parse(String.valueOf(moodBoardDatabaseHelper.getImageUrlsFor(mGetGoalIds.get(0)))));
            moodBoardImage6.setImageURI(Uri.parse(String.valueOf(moodBoardDatabaseHelper.getImageUrlsFor(mGetGoalIds.get(0)))));
            moodBoardImage7.setImageURI(Uri.parse(String.valueOf(moodBoardDatabaseHelper.getImageUrlsFor(mGetGoalIds.get(0)))));


        thought1Text = findViewById(R.id.textViewPositiveThought1);
        thought2Text = findViewById(R.id.textViewPositiveThought2);
        thought3Text = findViewById(R.id.textViewPositiveThought3);
        thought4Text = findViewById(R.id.textViewPositiveThought4);


        thought1Text.setText(setPositiveThoughtFor(goalId).get(position));

//
//            thought1Text.setText(String.valueOf(positiveThoughtsDatabaseHelper.getPositiveThoughtsFor(goalId)));
//            thought2Text.setText(String.valueOf(positiveThoughtsDatabaseHelper.getPositiveThoughtsFor(goalId)));
//            thought3Text.setText(String.valueOf(positiveThoughtsDatabaseHelper.getPositiveThoughtsFor(goalId)));
//            thought4Text.setText(String.valueOf(positiveThoughtsDatabaseHelper.getPositiveThoughtsFor(goalId)));


    }

    public ArrayList<String> setPositiveThoughtFor(long goalId) {
        ArrayList<String> positiveThoughts = new ArrayList<>();
        for (int rij = 0; rij < positiveThoughts.size(); rij++) {
            positiveThoughts.add(String.valueOf(positiveThoughtsDatabaseHelper.getPositiveThoughtsFor(goalId).get(rij)));
        }
        return positiveThoughts;
    }

}
//            thought1Text.setText(String.valueOf(positiveThoughtsDatabaseHelper.getPositiveThoughtsFor(goalId).get(position)));
//            thought2Text.setText(String.valueOf(positiveThoughtsDatabaseHelper.getPositiveThoughtsFor(goalId).get(position)));
//            thought3Text.setText(String.valueOf(positiveThoughtsDatabaseHelper.getPositiveThoughtsFor(goalId).get(position)));
//            thought4Text.setText(String.valueOf(positiveThoughtsDatabaseHelper.getPositiveThoughtsFor(goalId).get(position)));