package com.example.hackaton2019;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ListViewEggsWins extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_eggs_wins);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference studentRef = database.getReference("Eggs");
        studentRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<EggsWins> listEggsWins = new ArrayList<>();
                for (DataSnapshot eggSnapshot : dataSnapshot.getChildren()) {
                    EggsWins eggs = eggSnapshot.getValue(EggsWins.class);

                    listEggsWins.add(eggs);


                }
                ListView listEgg = findViewById(R.id.listMenu);
                EggAdapteur adapter = new EggAdapteur(ListViewEggsWins.this, listEggsWins);
                listEgg.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {}
        });
    }
}
