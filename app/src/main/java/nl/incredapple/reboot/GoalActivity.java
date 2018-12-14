package nl.incredapple.reboot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class GoalActivity extends AppCompatActivity {

    GoalDatabaseHelper goalDatabaseHelper;
    Button nextToBtn;
    EditText goalEditText, whereEditText, whenEditText, howEditText, preciseEditText,moreEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal);

        goalDatabaseHelper = new GoalDatabaseHelper(this);

        nextToBtn = findViewById(R.id.nextToBtn);

        goalEditText = findViewById(R.id.goalEditText);
        whereEditText = findViewById(R.id.whereEditText);
        whenEditText = findViewById(R.id.whenEditText);
        howEditText = findViewById(R.id.howEditText);
        preciseEditText = findViewById(R.id.preciseEditText);
        moreEditText = findViewById(R.id.moreEditText);

        nextToBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String goal = goalEditText.getText().toString();
                String where = whereEditText.getText().toString();
                String when = whenEditText.getText().toString();
                String how = howEditText.getText().toString();
                String precise = preciseEditText.getText().toString();
                String more = moreEditText.getText().toString();

                long goalId = goalDatabaseHelper.insertData(goal, where, when, how, precise, more);
                if (goalId > 0) {
                    Toast.makeText(GoalActivity.this, "DataSaved", Toast.LENGTH_LONG).show();
                    Intent nextToIntent = new Intent(GoalActivity.this, PositiveThoughtsActivity.class);
                    nextToIntent.putExtra("goalId", goalId);
                    startActivity(nextToIntent);
                }
            }
        });
    }







//        secondGoalBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent secondGoalIntent = new Intent(GoalActivity.this, GoalActivity.class);
//                startActivity(secondGoalIntent);
//                opslaan
//                        clear strings
//                                counter variable
//                                        eerst counter gelijk aan 5.
//                        if statement
//                        anders nutton weghalen
//
//                        database helper is datbase van telefoon
//                        json zijn berichte van de server
//                        geen json
//                                edittext opslaan in data base van de telefoon
//                        goalsdatabase handeler
//                                goals model savegoals
//            }
//        });


}
