package com.example.hackaton2019;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FinalBossActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_boss);

        MediaPlayer mpVous = MediaPlayer.create(FinalBossActivity.this,R.raw.vous);
        mpVous.start();

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        String url = "http://easteregg.wildcodeschool.fr/api/eggs";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray list) {
                        try {
                            JSONObject eggs = list.getJSONObject(28);
                            final String urlPicEgg = eggs.getString("image");
                            final String name = eggs.getString("name");
                            ImageView ivLogo = findViewById(R.id.imageView2);
                            Glide.with(FinalBossActivity.this).load(urlPicEgg).into(ivLogo);

                            Button reponse = findViewById(R.id.button2);
                            reponse.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Toast.makeText(FinalBossActivity.this, "Bravo tu as trouvé la bonne réponse! ", Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(FinalBossActivity.this,MapsActivity.class);
                                    startActivity(intent);
                                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                                    EggsWins eggs = new EggsWins(name, urlPicEgg);
                                    DatabaseReference studentRef = database.getReference("Eggs");
                                    studentRef.push().setValue(eggs);

                                }
                            });

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(FinalBossActivity.this, "error on ImportApi", Toast.LENGTH_SHORT).show();
                        }

                    }
                },
                new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Afficher l'erreur
                        Log.d("VOLLEY_ERROR", "onErrorResponse: " + error.getMessage());
                    }
                }

        );

        requestQueue.add(jsonArrayRequest);

        RequestQueue request = Volley.newRequestQueue(this);

        // TODO : URL de la requête vers l'API
        String url2 = "http://easteregg.wildcodeschool.fr/api/characters/";

        JsonArrayRequest jsonArrayRequest2 = new JsonArrayRequest(
                Request.Method.GET, url2, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray list) {
                        try {
                            JSONObject character = list.getJSONObject(55);
                            String urlPicChar = character.getString("image");
                            ImageView ivCharacterShow = findViewById(R.id.imageView);
                            Glide.with(FinalBossActivity.this).load(urlPicChar).into(ivCharacterShow);

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(FinalBossActivity.this, "error on ImportApiCharacter", Toast.LENGTH_SHORT).show();
                        }

                    }
                },
                new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Afficher l'erreur
                        Log.d("VOLLEY_ERROR", "onErrorResponse: " + error.getMessage());
                    }
                }
        );

        request.add(jsonArrayRequest2);

        Button button1 = findViewById(R.id.button3);
        Button button2 = findViewById(R.id.button);
        Button button3 = findViewById(R.id.button4);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FinalBossActivity.this, "Mauvaise réponse ", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(FinalBossActivity.this,MapsActivity.class);
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FinalBossActivity.this, "Mauvaise réponse ", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(FinalBossActivity.this,MapsActivity.class);
                startActivity(intent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FinalBossActivity.this, "Mauvaise réponse ", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(FinalBossActivity.this,MapsActivity.class);
                startActivity(intent);
            }
        });
    }
}
