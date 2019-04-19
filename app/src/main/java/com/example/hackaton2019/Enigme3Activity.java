package com.example.hackaton2019;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
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

public class Enigme3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enigme3);


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

                            JSONObject egg3 = list.getJSONObject(8);
                            final String EggName = egg3.getString("name");
                            final String urlPicEgg3 = egg3.getString("image");
                            ImageView ivLogo = findViewById(R.id.imageView8);
                            Glide.with(Enigme3Activity.this).load(urlPicEgg3).into(ivLogo);

                            Button reponse = findViewById(R.id.button14);
                            reponse.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Toast.makeText(Enigme3Activity.this, "Bravo tu as trouvé la bonne réponse! ", Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(Enigme3Activity.this,MapsActivity.class);
                                    startActivity(intent);
                                    MediaPlayer mpVous = MediaPlayer.create(Enigme3Activity.this,R.raw.ring);
                                    mpVous.start();
                                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                                    EggsWins eggs = new EggsWins(EggName, urlPicEgg3);
                                    DatabaseReference studentRef = database.getReference("Eggs");
                                    studentRef.push().setValue(eggs);

                                }
                            });

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(Enigme3Activity.this, "error on ImportApi", Toast.LENGTH_SHORT).show();
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

                            JSONObject character3 = list.getJSONObject(10);
                            String abradolfLincler = character3.getString("name");
                            String urlPicChar3 = character3.getString("image");
                            ImageView ivCharacterShow = findViewById(R.id.imageView7);
                            Glide.with(Enigme3Activity.this).load(urlPicChar3).into(ivCharacterShow);

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(Enigme3Activity.this, "error on ImportApiCharacter", Toast.LENGTH_SHORT).show();
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

        Button button1 = findViewById(R.id.button16);
        Button button2 = findViewById(R.id.button15);
        Button button3 = findViewById(R.id.button13);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Enigme3Activity.this, "Mauvaise réponse ", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Enigme3Activity.this,MapsActivity.class);
                MediaPlayer mpVous = MediaPlayer.create(Enigme3Activity.this,R.raw.haha);
                mpVous.start();
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Enigme3Activity.this, "Mauvaise réponse ", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Enigme3Activity.this,MapsActivity.class);
                MediaPlayer mpVous = MediaPlayer.create(Enigme3Activity.this,R.raw.haha);
                mpVous.start();
                startActivity(intent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Enigme3Activity.this, "Mauvaise réponse ", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Enigme3Activity.this,MapsActivity.class);
                MediaPlayer mpVous = MediaPlayer.create(Enigme3Activity.this,R.raw.haha);
                mpVous.start();
                startActivity(intent);
            }
        });
    }

}
