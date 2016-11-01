package app.com.example.mahmoudshahen.timer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.io.Serializable;

public class FirstPeople extends AppCompatActivity implements Serializable{

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_people);
    }
}
