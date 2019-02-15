package nl.incredapple.reboot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class IntroActivity extends AppCompatActivity {

    MainModel mMainModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        ImageButton nextPage = findViewById(R.id.nextToBtn);

        mMainModel = new MainModel();
        mMainModel.initialize(this);

        nextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                    if (mMainModel.getGoals().size() > 0) {
//                        Intent mainPageIntent = new Intent(IntroActivity.this, MainActivity.class);
//                        startActivity(mainPageIntent);
//                    } else {
                        Intent nextPageIntent = new Intent(IntroActivity.this, GoalActivity.class);
                        startActivity(nextPageIntent);
//                    }
//
            }
        });
    }

}
