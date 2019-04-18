package com.example.hackaton2019;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Enigme10Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enigme10);

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

                            JSONObject egg10 = list.getJSONObject(51);
                            String urlPicEgg10 = egg10.getString("image");
                            ImageView ivLogo = findViewById(R.id.imageView4);
                            Glide.with(Enigme10Activity.this).load(urlPicEgg10).into(ivLogo);



                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(Enigme10Activity.this, "error on ImportApi", Toast.LENGTH_SHORT).show();
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

                            JSONObject character10 = list.getJSONObject(1);
                            String urlPicChar10 = character10.getString("image");
                            ImageView ivCharacterShow = findViewById(R.id.imageView3);
                            Glide.with(Enigme10Activity.this).load(urlPicChar10).into(ivCharacterShow);

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(Enigme10Activity.this, "error on ImportApiCharacter", Toast.LENGTH_SHORT).show();
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
    }
}
