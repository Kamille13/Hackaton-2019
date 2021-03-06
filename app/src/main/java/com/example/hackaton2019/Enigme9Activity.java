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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Enigme9Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enigme9);

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        // TODO : URL de la requête vers l'API
        String url = "http://easteregg.wildcodeschool.fr/api/eggs";

        // Création de la requête vers l'API, ajout des écouteurs pour les réponses et erreurs possibles
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray list) {
                        try {

                            JSONObject egg9 = list.getJSONObject(48);
                            final String urlPicEgg9 = egg9.getString("image");
                            final String eggName = egg9.getString("name");
                            ImageView ivLogo = findViewById(R.id.imageView20);
                            Glide.with(Enigme9Activity.this).load(urlPicEgg9).into(ivLogo);

                            Button reponse = findViewById(R.id.button37);
                            reponse.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Toast.makeText(Enigme9Activity.this, "Bravo tu as trouvé la bonne réponse! ", Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(Enigme9Activity.this,MapsActivity.class);
                                    startActivity(intent);
                                    MediaPlayer mpVous = MediaPlayer.create(Enigme9Activity.this,R.raw.ring);
                                    mpVous.start();
                                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                                    EggsWins eggs = new EggsWins(eggName, urlPicEgg9);
                                    DatabaseReference studentRef = database.getReference("Eggs");
                                    studentRef.push().setValue(eggs);

                                }
                            });

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(Enigme9Activity.this, "error on ImportApi", Toast.LENGTH_SHORT).show();
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

        // On ajoute la requête à la file d'attente
        requestQueue.add(jsonArrayRequest);

        RequestQueue request = Volley.newRequestQueue(this);

        // TODO : URL de la requête vers l'API
        String url2 = "http://easteregg.wildcodeschool.fr/api/characters/";

        // Création de la requête vers l'API, ajout des écouteurs pour les réponses et erreurs possibles
        JsonArrayRequest jsonArrayRequest2 = new JsonArrayRequest(
                Request.Method.GET, url2, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray list) {
                        try {

                            JSONObject character9 = list.getJSONObject(53);
                            String urlPicChar9 = character9.getString("image");
                            ImageView ivCharacterShow = findViewById(R.id.imageView19);
                            Glide.with(Enigme9Activity.this).load(urlPicChar9).into(ivCharacterShow);

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(Enigme9Activity.this, "error on ImportApiCharacter", Toast.LENGTH_SHORT).show();
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

        // On ajoute la requête à la file d'attente
        request.add(jsonArrayRequest2);

        Button button1 = findViewById(R.id.button38);
        Button button2 = findViewById(R.id.button39);
        Button button3 = findViewById(R.id.button40);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Enigme9Activity.this, "Mauvaise réponse ", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Enigme9Activity.this,MapsActivity.class);
                MediaPlayer mpVous = MediaPlayer.create(Enigme9Activity.this,R.raw.haha);
                mpVous.start();
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Enigme9Activity.this, "Mauvaise réponse ", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Enigme9Activity.this,MapsActivity.class);
                MediaPlayer mpVous = MediaPlayer.create(Enigme9Activity.this,R.raw.haha);
                mpVous.start();
                startActivity(intent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Enigme9Activity.this, "Mauvaise réponse ", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Enigme9Activity.this,MapsActivity.class);
                MediaPlayer mpVous = MediaPlayer.create(Enigme9Activity.this,R.raw.haha);
                mpVous.start();
                startActivity(intent);
            }
        });
    }
}
