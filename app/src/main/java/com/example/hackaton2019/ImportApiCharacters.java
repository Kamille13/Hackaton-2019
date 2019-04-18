package com.example.hackaton2019;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ImportApiCharacters extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_import_api_characters);


        // Crée une file d'attente pour les requêtes vers l'API
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        // TODO : URL de la requête vers l'API
        String url = "http://easteregg.wildcodeschool.fr/api/characters/";

        // Création de la requête vers l'API, ajout des écouteurs pour les réponses et erreurs possibles
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray list) {
                        TextView tvName = findViewById(R.id.tvCharacter);
                        try {
                            JSONObject character = list.getJSONObject(0);
                            String rickSanchez = character.getString("name");
                            String urlPicChar = character.getString("image");
                            tvName.append(rickSanchez);
                            ImageView ivCharacterShow = findViewById(R.id.ivImageCharacters);
                            Glide.with(ImportApiCharacters.this).load(urlPicChar).into(ivCharacterShow);


                            JSONObject character2 = list.getJSONObject(2);
                            String mortySmith = character2.getString("name");
                            String urlPicChar2 = character2.getString("image");
                            tvName.append(mortySmith);

                            JSONObject character3 = list.getJSONObject(10);
                            String abradolfLincler = character3.getString("name");
                            String urlPicChar3 = character3.getString("image");
                            tvName.append(abradolfLincler);

                            JSONObject character4 = list.getJSONObject(19);
                            String alienMorty = character4.getString("name");
                            String urlPicChar4 = character4.getString("image");
                            tvName.append(alienMorty);

                            JSONObject character5 = list.getJSONObject(20);
                            String alienRick = character5.getString("name");
                            String urlPicChar5 = character5.getString("image");
                            tvName.append(alienRick);

                            JSONObject character6 = list.getJSONObject(22);
                            String amishCyborg = character6.getString("name");
                            String urlPicChar6 = character6.getString("image");
                            tvName.append(amishCyborg);

                            JSONObject character7 = list.getJSONObject(51);
                            String hepatitisA = character7.getString("name");
                            String urlPicChar7 = character7.getString("image");
                            tvName.append(hepatitisA);

                            JSONObject character8 = list.getJSONObject(50);
                            String gonorrhea = character8.getString("name");
                            String urlPicChar8 = character8.getString("image");
                            tvName.append(gonorrhea);

                            JSONObject character9 = list.getJSONObject(53);
                            String hepatitisC = character9.getString("name");
                            String urlPicChar9 = character9.getString("image");
                            tvName.append(hepatitisC);

                            JSONObject character10 = list.getJSONObject(55);
                            String gandalf = character10.getString("name");
                            String urlPicChar10 = character10.getString("image");
                            tvName.append(gandalf);

                            String[][] characterArray = new String [][]{
                                    {rickSanchez , urlPicChar },
                                    {mortySmith , urlPicChar2},
                                    {abradolfLincler , urlPicChar3},
                                    {alienMorty,urlPicChar4},
                                    {alienRick,urlPicChar5},
                                    {amishCyborg,urlPicChar6},
                                    {hepatitisA,urlPicChar7},
                                    {gonorrhea,urlPicChar8},
                                    {hepatitisC,urlPicChar9},
                                    {gandalf,urlPicChar10},

                            };


                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(ImportApiCharacters.this, "error on ImportApiCharacter", Toast.LENGTH_SHORT).show();
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


    }
}

