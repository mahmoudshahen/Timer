package app.com.example.mahmoudshahen.timer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {

    ImageButton button;
    SeekBar seekBar;
    TextView textView, yourScore;
    ImageButton button1;
    String currentColor;
    String currentText;
    String [] color = {"purple", "red", "green", "yellow", "brown", "orange", "gray", "blue", "pink", "white", "white"};
    static int score;
    boolean firstClick = true;
    int curTime = 0;
    boolean lose;
    @Override
    protected void onResume() {
        super.onResume();
        score = 0;
        currentText = color[(int)(Math.random()*10)];
        currentColor =color[(int)(Math.random()*10)];
        textView.setText(currentText);
        switchs(currentColor);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        AdView mAdView = (AdView)findViewById(R.id.adView);
        AdRequest.Builder adRequestBuilder = new AdRequest.Builder();
        mAdView.loadAd(adRequestBuilder.build());

        AdView mAdView1 = (AdView)findViewById(R.id.adView1);
        AdRequest.Builder adRequestBuilder1 = new AdRequest.Builder();
        mAdView1.loadAd(adRequestBuilder1.build());




        seekBar = (SeekBar)findViewById(R.id.seekBar);
        button = (ImageButton)findViewById(R.id.buttontrue);
        button1 = (ImageButton)findViewById(R.id.buttonfalse);
        textView = (TextView)findViewById(R.id.textView);
        yourScore = (TextView)findViewById(R.id.urScore);
        //chronometer = (Chronometer)findViewById(R.id.chronometer);
        //chronometer.setBase(SystemClock.elapsedRealtime());
        //chronometer.start();


        lose = false;
        seekBar.setMax(2000);
        seekBar.setProgress(0);
        firstClick = true;
        seekBar.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (!firstClick) {
                    seekBar.setProgress(curTime += 10);
                }
            }
        }, 0, 10);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(progress == 2000 && !lose)
                {
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    intent.putExtra("score", MainActivity.score);
                    startActivity(intent);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(firstClick){
                    firstClick = false;
                }
                if(currentColor.equals(currentText)) {

                    score++;
                    yourScore.setText(String.valueOf(score));
                    settNew();
                    curTime = 0;
                }
                else
                {
                    lose = true;
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    intent.putExtra("score", score);
                    startActivity(intent);
                }

            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(firstClick){
                    firstClick= false;
                }
                if(!currentColor.equals(currentText)) {

                    score++;
                    yourScore.setText(String.valueOf(score));
                    settNew();
                    curTime=0;
                }
                else
                {
                    lose = true;
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    intent.putExtra("score", score);
                    startActivity(intent);
                }
            }
        });



    }
    private void switchs(String currentColor)
    {
        switch (currentColor)
        {
            case "purple":
                textView.setTextColor(getResources().getColor(R.color.purple));
                break;
            case "red":
                textView.setTextColor(getResources().getColor(R.color.red));
                break;
            case "green":
                textView.setTextColor(getResources().getColor(R.color.green));
                break;
            case "yellow":
                textView.setTextColor(getResources().getColor(R.color.yellow));
                break;
            case "brown":
                textView.setTextColor(getResources().getColor(R.color.brown));
                break;
            case "orange":
                textView.setTextColor(getResources().getColor(R.color.orange));
                break;
            case "gray":
                textView.setTextColor(getResources().getColor(R.color.gray));
                break;
            case "blue":
                textView.setTextColor(getResources().getColor(R.color.blue));
                break;
            case "pink":
                textView.setTextColor(getResources().getColor(R.color.pink));
                break;
            case "white":
                textView.setTextColor(getResources().getColor(R.color.white));
                break;

        }
    }
    private void settNew()
    {
        currentText = color[((int) (Math.random() * 10))];
            float ran = (float) Math.random();
            if(ran>0.5)
            {
                currentColor = currentText;
               switchs(currentColor);
            }
        else {
                float x = (float) (Math.random() * 11);

                if (x <= 1) {
                    textView.setTextColor(getResources().getColor(R.color.purple));
                    currentColor = color[0];
                } else if (x <= 2) {
                    textView.setTextColor(getResources().getColor(R.color.red));
                    currentColor = color[1];
                } else if (x <= 3) {
                    textView.setTextColor(getResources().getColor(R.color.green));
                    currentColor = color[2];
                } else if (x <= 4) {
                    textView.setTextColor(getResources().getColor(R.color.yellow));
                    currentColor = color[3];
                } else if (x <= 5) {
                    textView.setTextColor(getResources().getColor(R.color.brown));
                    currentColor = color[4];
                } else if (x <= 6) {
                    textView.setTextColor(getResources().getColor(R.color.orange));
                    currentColor = color[5];
                } else if (x <= 7) {
                    textView.setTextColor(getResources().getColor(R.color.gray));
                    currentColor = color[6];
                } else if (x <= 8) {
                    textView.setTextColor(getResources().getColor(R.color.blue));
                    currentColor = color[7];
                }
                else if (x <= 9) {
                    textView.setTextColor(getResources().getColor(R.color.pink));
                    currentColor = color[8];
                }
                else if (x <= 11) {
                    textView.setTextColor(getResources().getColor(R.color.white));
                    currentColor = color[9];
                }
            }
            textView.setText(currentText);
        }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }
}
