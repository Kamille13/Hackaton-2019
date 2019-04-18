package com.example.hackaton2019;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListViewEggsWins extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_eggs_wins);

        EggsWins egg1 = new EggsWins("salut" ,"");

        List<EggsWins> listEggsWins = new ArrayList<>();
        listEggsWins.add(egg1);

        ListView listEgg = findViewById(R.id.listMenu);
        EggAdapteur adapter = new EggAdapteur(ListViewEggsWins.this, listEggsWins);
        listEgg.setAdapter(adapter);

    }
}
