package app.com.example.mahmoudshahen.timer;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class PlayWithTimer extends AppCompatActivity {

    TextView timer;
    ImageButton button;
    TextView textView, yourScore;
    ImageButton button1;
    String currentColor;
    String currentText;
    String [] color = {"purple", "red", "green", "yellow", "brown", "orange", "gray", "blue", "pink", "white", "white"};
    static int score;
    boolean firstClick = true;
    Intent intent;
    int time;
    CountDownTimer countDownTimer;
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
        setContentView(R.layout.activity_play_with_timer);
        timer = (TextView) findViewById(R.id.timer);
        button = (ImageButton)findViewById(R.id.buttontrue);
        button1 = (ImageButton)findViewById(R.id.buttonfalse);
        textView = (TextView)findViewById(R.id.textView);
        yourScore = (TextView)findViewById(R.id.urScore);

        AdView mAdView = (AdView)findViewById(R.id.adView);
        AdRequest.Builder adRequestBuilder = new AdRequest.Builder();
        mAdView.loadAd(adRequestBuilder.build());

        AdView mAdView1 = (AdView)findViewById(R.id.adView1);
        AdRequest.Builder adRequestBuilder1 = new AdRequest.Builder();
        mAdView1.loadAd(adRequestBuilder1.build());
        firstClick = true;
        intent = getIntent();
        Bundle bundle = intent.getExtras();
        time = bundle.getInt("timer");
        updateTimer(time*60);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(firstClick){
                    firstClick = false;
                    startCounter(time);
                }
                if(currentColor.equals(currentText)) {

                    score++;
                    yourScore.setText(String.valueOf(score));
                    settNew();
                }
                else
                    settNew();
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(firstClick){
                    firstClick= false;
                    startCounter(time);
                }
                if(!currentColor.equals(currentText)) {

                    score++;
                    yourScore.setText(String.valueOf(score));
                    settNew();
                }
                else
                    settNew();
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
        countDownTimer.onFinish();
        countDownTimer.cancel();
        finish();
    }

    private void updateTimer(int seconds)
    {
        String min = String.valueOf((int) (seconds / 60));
        String sec = String.valueOf(seconds - (Integer.parseInt(min) * 60));

        if(min.length() ==1)
            min = "0" + min;
        if(sec.length() ==1)
            sec = "0"+sec;
        Log.v("counter", min + ":" + sec);
        timer.setText(min + ":" + sec);
    }
    private void startCounter(int time) {
    if (intent != null) {

        if (!firstClick) {
            countDownTimer = new CountDownTimer((time * 1000 * 60), 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    updateTimer((int) (millisUntilFinished / 1000));
                    Log.v("counter", String.valueOf(millisUntilFinished));
                }

                @Override
                public void onFinish() {
                    timer.setText("00:00");
                    Intent intent = new Intent(PlayWithTimer.this, Main2Activity.class);
                    intent.putExtra("score", score);
                    startActivity(intent);
                }
            };
            countDownTimer.start();
        }
    }
}
}
