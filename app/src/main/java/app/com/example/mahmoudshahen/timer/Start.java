package app.com.example.mahmoudshahen.timer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Start extends AppCompatActivity {

    Button start, howToPlay, intervals;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        start = (Button)findViewById(R.id.play);
        howToPlay = (Button)findViewById(R.id.howToPlay);
        intervals = (Button)findViewById(R.id.intervals);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Start.this, MainActivity.class));
            }
        });
        howToPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Start.this, HowPlaying.class));
            }
        });
        intervals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Start.this, Intervals.class));
            }
        });
    }
}
