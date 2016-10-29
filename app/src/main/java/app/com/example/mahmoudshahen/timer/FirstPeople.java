package app.com.example.mahmoudshahen.timer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FirstPeople extends AppCompatActivity implements Serializable{

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_people);
        Firebase.setAndroidContext(this);
        listView = (ListView)findViewById(R.id.listOfPeople);
        Firebase myFirebaseRef = new Firebase("https://colors-28d31.firebaseio.com/");

        myFirebaseRef.addValueEventListener(new ValueEventListener() {
            List<String> list = new ArrayList<String>();
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(FirstPeople.this,
                    android.R.layout.simple_list_item_1,list);

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot child : dataSnapshot.getChildren()) {

                    list.add(child.getValue().toString());
                    Log.v("getData",child.getValue().toString());
                }
                listView.setAdapter(arrayAdapter);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
       /* myFirebaseRef.child("mahmoud").setValue("311");
        myFirebaseRef.child("harty60@yahoo").setValue("120");
        myFirebaseRef.child("harty1557@gmail").setValue("1020");
        myFirebaseRef.child("harty60@outlook").setValue("812");
        *///myFirebaseRef.child("Player").setValue(playerMap);
    }
}
