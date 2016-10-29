package app.com.example.mahmoudshahen.timer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Intervals extends AppCompatActivity {

    Button button;
    RadioGroup radioGroup;
    int idChecked;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intervals);
        button = (Button)findViewById(R.id.go);
        radioGroup = (RadioGroup)findViewById(R.id.group);
        radioGroup.clearCheck();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    idChecked = radioGroup.getCheckedRadioButtonId();
//                Log.v("group", v.getResources().getResourceEntryName(idChecked));
                if(idChecked!=-1)
                {
                    Bundle bundle = new Bundle();
                    switch (idChecked){
                        case R.id.two:
                            bundle.putInt("timer",2);
                            break;
                        case R.id.five:
                            bundle.putInt("timer",5);
                            break;
                        case R.id.ten:
                            bundle.putInt("timer",10);
                            break;
                        case R.id.fifteen:
                            bundle.putInt("timer",15);
                            break;
                        case R.id.twenty:
                            bundle.putInt("timer",20);
                            break;

                    }
                    Intent intent = new Intent(Intervals.this, PlayWithTimer.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(Intervals.this,"please choose timer..!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
}
