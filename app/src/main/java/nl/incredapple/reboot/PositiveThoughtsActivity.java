package nl.incredapple.reboot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PositiveThoughtsActivity extends AppCompatActivity {

    PositiveThoughtsDatabaseHelper positiveThoughtsDatabaseHelper;
    EditText thought1EditText, thought2EditText, thought3EditText, thought4EditText, thought5EditText;
    Button nextPageBtn, exampleBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_positive_thoughts);

        positiveThoughtsDatabaseHelper = new PositiveThoughtsDatabaseHelper(this);

        nextPageBtn = findViewById(R.id.nextPageBtn);
        exampleBtn = findViewById(R.id.exampleBtn);

        thought1EditText = findViewById(R.id.thought1EditText);
        thought2EditText = findViewById(R.id.thought2EditText);
        thought3EditText = findViewById(R.id.thought3EditText);
        thought4EditText = findViewById(R.id.thought4EditText);
        thought5EditText = findViewById(R.id.thought5EditText);

        nextPageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String thought1Text = thought1EditText.getText().toString();
                String thought2Text = thought2EditText.getText().toString();
                String thought3Text = thought3EditText.getText().toString();
                String thought4Text = thought4EditText.getText().toString();
                String thought5Text = thought5EditText.getText().toString();

                positiveThoughtsDatabaseHelper.insertData(thought1Text, thought2Text, thought3Text, thought4Text, thought5Text);
                Toast.makeText(PositiveThoughtsActivity.this, "DataSaved", Toast.LENGTH_LONG).show();

                Intent nextPageIntent = new Intent(PositiveThoughtsActivity.this, MoodBoardActivity.class);
                startActivity(nextPageIntent);
            }
        });

        exampleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent exampleIntent = new Intent(PositiveThoughtsActivity.this, ExamplePositiveThoughtsActivity.class);
                startActivity(exampleIntent);
            }
        });

    }
}
