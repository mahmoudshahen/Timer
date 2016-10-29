package app.com.example.mahmoudshahen.timer;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView txtScore, txtHighScore;
    int HighScore=0, score;
    Button share, retry, firsts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txtScore = (TextView)findViewById(R.id.score);
        share = (Button)findViewById(R.id.share);
        txtHighScore = (TextView)findViewById(R.id.highScore);
        retry = (Button)findViewById(R.id.retry);
        firsts = (Button)findViewById(R.id.firsts);
        Intent intent = getIntent();
        score = intent.getExtras().getInt("score",0);
        txtScore.setText(String.valueOf(score));

        SharedPreferences preferences = getSharedPreferences("file",0);

        HighScore = preferences.getInt("HighScore", 0);
        SharedPreferences.Editor editor = preferences.edit();

        if(score > HighScore){
            editor.putInt("HighScore", score);
            txtHighScore.setText(String.valueOf(score));
            HighScore = score;
        }
        else
        txtHighScore.setText(String.valueOf(HighScore));

        editor.commit();
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "my High Score is " + HighScore + " Challenge !..");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });
        retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main2Activity.this, MainActivity.class));
            }
        });
        firsts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main2Activity.this, FirstPeople.class));
            }
        });

    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }
}
