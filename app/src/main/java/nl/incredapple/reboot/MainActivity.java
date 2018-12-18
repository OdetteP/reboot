package nl.incredapple.reboot;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    ListView goalListView;
    MainModel mainModel;

    List <String> mGoals;

    long goalId;
    List<Long> mGetGoalIds;
    String[] mGetGoal;
    String[] mGetWhere;
    String[] mGetWhen;
    String[] mGetHow;
    String[] mGetPrecise;
    String[] mGetMore;

    String [] mGetPositiveThought;

    String [] getImages;

    PositiveThoughtsDatabaseHelper positiveThoughtsDatabaseHelper;
    MoodBoardDatabaseHelper moodBoardDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goalListView = findViewById(R.id.goalListView);


        positiveThoughtsDatabaseHelper = new PositiveThoughtsDatabaseHelper(this);
        moodBoardDatabaseHelper = new MoodBoardDatabaseHelper(this);
        mainModel = new MainModel();
        mainModel.initialize(this);

        mGoals = mainModel.getGoals();

        mGetGoal= mainModel.getGoal();
        mGetWhere = mainModel.getWhere();
        mGetWhen = mainModel.getWhen();
        mGetHow = mainModel.getHow();
        mGetPrecise = mainModel.getPrecise();
        mGetMore = mainModel.getMore();

        mGetGoalIds = mainModel.getGoalIds();


        DatabaseAdapter databaseAdapter = new DatabaseAdapter();
        goalListView.setAdapter(databaseAdapter);


        Button moreBtn = findViewById(R.id.moreInfoBtn);
        Button settingsBtn = findViewById(R.id.settingBtn);


        moreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        settingsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        goalListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//
//                Intent intent = getIntent();
//                intent.putExtra("goalId", mGetGoalIds.get(i));

                    getImages = moodBoardDatabaseHelper.getImageUrlsFor(Long.valueOf(mGetGoalIds.get(i))).toArray(new String[0]);
                    mGetPositiveThought = positiveThoughtsDatabaseHelper.getPositiveThoughtsFor(Long.valueOf(mGetGoalIds.get(i))).toArray(new String[0]);

                Intent showSpecificActivity = new Intent(getApplicationContext(), GoalOverViewActivity.class);
                showSpecificActivity.putExtra("goalId", mGetGoalIds.get(i));
                showSpecificActivity.putExtra("COLUMN_ID", mGetGoalIds.get(i));
                showSpecificActivity.putExtra("COLUMN_GOAL", mGetGoal[i]);
                showSpecificActivity.putExtra("COLUMN_WHERE", mGetWhere[i]);
                showSpecificActivity.putExtra("COLUMN_WHEN", mGetWhen[i]);
                showSpecificActivity.putExtra("COLUMN_HOW", mGetHow[i]);
                showSpecificActivity.putExtra("COLUMN_PRECISE", mGetPrecise[i]);
                showSpecificActivity.putExtra("COLUMN_MORE", mGetMore[i]);
                showSpecificActivity.putExtra("positiveThought", mGetPositiveThought[i]);
                showSpecificActivity.putExtra("moodboard", getImages[i]);
                startActivity(showSpecificActivity);
            }
        });

    }

    public class DatabaseAdapter implements ListAdapter {

        @Override
        public boolean areAllItemsEnabled() {
            return true;
        }

        @Override
        public boolean isEnabled(int i) {
            return true;
        }

        @Override
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {

        }

        @Override
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

        }

        @Override
        public int getCount() {
            return mGoals.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            view = getLayoutInflater().inflate(R.layout.detail_listview_main, null);

            TextView goalTextView = view.findViewById(R.id.goalTextView);

            goalTextView.setText(String.valueOf(mGoals.get(i)));


            return view;
        }

        @Override
        public int getItemViewType(int i) {
            return 0;
        }

        @Override
        public int getViewTypeCount() {
            return 1;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }
    }
}
