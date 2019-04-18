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
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ImportApi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_import_api);


        // Crée une file d'attente pour les requêtes vers l'API
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        // TODO : URL de la requête vers l'API
        String url = "http://easteregg.wildcodeschool.fr/api/eggs";

        // Création de la requête vers l'API, ajout des écouteurs pour les réponses et erreurs possibles
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray list) {
                        TextView tvName = findViewById(R.id.tvName);
                        try {
                                JSONObject eggs = list.getJSONObject(0);
                                String eggOfTuna = eggs.getString("name");
                                String rarityegg = eggs.getString("rarity");
                                String urlPicEgg = eggs.getString("image");
                                tvName.append(eggOfTuna);
                            ImageView ivLogo = findViewById(R.id.ivegg);
                            Glide.with(ImportApi.this).load(urlPicEgg).into(ivLogo);


                            JSONObject egg2 = list.getJSONObject(1);
                                String eggOfFlounderWinter = egg2.getString("name");
                                String rarityegg2 = egg2.getString("rarity");
                                String urlPicEgg2 = egg2.getString("image");
                                tvName.append(eggOfFlounderWinter);

                                JSONObject egg3 = list.getJSONObject(8);
                                String eggOfKiwi = egg3.getString("name");
                                String rarityegg3 = egg3.getString("rarity");
                                String urlPicEgg3 = egg3.getString("image");
                                tvName.append(eggOfKiwi);

                                JSONObject egg4 = list.getJSONObject(11);
                                String rarityegg4 = egg4.getString("rarity");
                                String eggOfChameleon = egg4.getString("name");
                                String urlPicEgg4 = egg4.getString("image");
                                tvName.append(eggOfChameleon);

                                JSONObject egg5 = list.getJSONObject(36);
                                String rarityegg5 = egg5.getString("rarity");
                                String eggOfSturgeonAtlantic = egg5.getString("name");
                                String urlPicEgg5 = egg5.getString("image");
                                tvName.append(eggOfSturgeonAtlantic);

                                JSONObject egg6 = list.getJSONObject(37);
                                String rarityegg6 = egg6.getString("rarity");
                                String eggOfFrogBull = egg6.getString("name");
                                String urlPicEgg6 = egg6.getString("image");
                                tvName.append(eggOfFrogBull);

                                JSONObject egg7 = list.getJSONObject(38);
                                String rarityegg7 = egg7.getString("rarity");
                                String eggOfOstrich = egg7.getString("name");
                                String urlPicEgg7 = egg7.getString("image");
                                tvName.append(eggOfOstrich);

                                JSONObject egg8 = list.getJSONObject(40);
                                String rarityegg8 = egg8.getString("rarity");
                                String eggOfEelAmerican = egg8.getString("name");
                                String urlPicEgg8 = egg8.getString("image");
                                tvName.append(eggOfEelAmerican);

                                JSONObject egg9 = list.getJSONObject(48);
                                String rarityegg9 = egg9.getString("rarity");
                                String eggOfFrogleopard = egg9.getString("name");
                                String urlPicEgg9 = egg9.getString("image");
                                tvName.append(eggOfFrogleopard);

                                JSONObject egg10 = list.getJSONObject(51);
                                String rarityegg10 = egg10.getString("rarity");
                                String eggOfPokemon = egg10.getString("name");
                                String urlPicEgg10 = egg10.getString("image");
                                tvName.append(eggOfPokemon);

                            String[][] eggsArray = new String [][]{
                                    {eggOfTuna , rarityegg , urlPicEgg},
                                    {eggOfFlounderWinter , rarityegg2, urlPicEgg2},
                                    {eggOfKiwi , rarityegg3, urlPicEgg3},
                                    {eggOfChameleon,rarityegg4, urlPicEgg4},
                                    {eggOfSturgeonAtlantic,rarityegg5, urlPicEgg5},
                                    {eggOfFrogBull,rarityegg6, urlPicEgg6},
                                    {eggOfOstrich,rarityegg7, urlPicEgg7},
                                    {eggOfEelAmerican,rarityegg8, urlPicEgg8},
                                    {eggOfFrogleopard,rarityegg9, urlPicEgg9},
                                    {eggOfPokemon,rarityegg10, urlPicEgg10},

                            };


                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(ImportApi.this, "error on ImportApi", Toast.LENGTH_SHORT).show();
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

