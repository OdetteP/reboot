package nl.incredapple.reboot;

import android.content.Intent;
import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    ListView goalListView;
    MainModel mainModel;

    List <String> mGoals;
// array list met alle doelen

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goalListView = findViewById(R.id.goalListView);

        DatabaseAdapter databaseAdapter = new DatabaseAdapter();
        goalListView.setAdapter(databaseAdapter);

        mainModel = new MainModel();
        mainModel.initialize(this);

        mGoals = mainModel.getGoals();

        Button todayBtn = findViewById(R.id.todayBtn);
        Button programBtn = findViewById(R.id.programBtn);
        Button moreBtn = findViewById(R.id.moreInfoBtn);
        Button settingsBtn = findViewById(R.id.settingBtn);



        todayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        programBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

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
//                Intent showSpecificActivity = new Intent(getApplicationContext(), GoalOverView.class);
//                showSpecificActivity.putExtra("COLUMN_ID", i);
//                showSpecificActivity.putExtra("START_TIME", mDate.get(i));
//                startActivity(showSpecificActivity);
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
            return 5;
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

        goalTextView.setText(String.valueOf(mGoals));


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
