package nl.incredapple.reboot;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class GoalOverViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal_over_view);

        MainModel mMainModel = new MainModel();




        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            thought1EditText.setText(mMainModel.getPositiveThoughts(Math.toIntExact(goalId))[0]);
            thought2EditText.setText(mMainModel.getPositiveThoughts(Math.toIntExact(goalId))[1]);
            thought3EditText.setText(mMainModel.getPositiveThoughts(Math.toIntExact(goalId))[2]);
            thought4EditText.setText(mMainModel.getPositiveThoughts(Math.toIntExact(goalId))[3]);
        }

    }
}
