package com.example.hackaton2019;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

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
                                tvName.append(eggOfTuna);

                                JSONObject egg2 = list.getJSONObject(1);
                                String eggOfFlounderWinter = egg2.getString("name");
                                String rarityegg2 = eggs.getString("rarity");
                                tvName.append(eggOfFlounderWinter);

                                JSONObject egg3 = list.getJSONObject(8);
                                String eggOfKiwi = egg3.getString("name");
                                String rarityegg3 = eggs.getString("rarity");
                                tvName.append(eggOfKiwi);

                                JSONObject egg4 = list.getJSONObject(11);
                                String rarityegg4 = eggs.getString("rarity");
                                String eggOfChameleon = egg4.getString("name");
                                tvName.append(eggOfChameleon);

                                JSONObject egg5 = list.getJSONObject(36);
                                String rarityegg5 = eggs.getString("rarity");
                                String eggOfSturgeonAtlantic = egg5.getString("name");
                                tvName.append(eggOfSturgeonAtlantic);

                                JSONObject egg6 = list.getJSONObject(37);
                                String rarityegg6 = eggs.getString("rarity");
                                String eggOfFrogBull = egg6.getString("name");
                                tvName.append(eggOfFrogBull);

                                JSONObject egg7 = list.getJSONObject(38);
                                String rarityegg7 = eggs.getString("rarity");
                                String eggOfOstrich = egg7.getString("name");
                                tvName.append(eggOfOstrich);

                                JSONObject egg8 = list.getJSONObject(40);
                                String rarityegg8 = eggs.getString("rarity");
                                String eggOfEelAmerican = egg8.getString("name");
                                tvName.append(eggOfEelAmerican);

                                JSONObject egg9 = list.getJSONObject(48);
                                String rarityegg9 = eggs.getString("rarity");
                                String eggOfFrogleopard = egg9.getString("name");
                                tvName.append(eggOfFrogleopard);

                                JSONObject egg10 = list.getJSONObject(51);
                                String rarityegg10 = eggs.getString("rarity");
                                String eggOfPokemon = egg10.getString("name");
                                tvName.append(eggOfPokemon);

                                String[] [] eggsArray = new String [][]{
                                        {eggOfTuna , rarityegg },
                                        {eggOfFlounderWinter , rarityegg2},
                                        {eggOfKiwi , rarityegg3},
                                        {eggOfChameleon,rarityegg4},
                                        {eggOfSturgeonAtlantic,rarityegg5},
                                        {eggOfFrogBull,rarityegg6},
                                        {eggOfOstrich,rarityegg7},
                                        {eggOfEelAmerican,rarityegg8},
                                        {eggOfFrogleopard,rarityegg9},
                                        {eggOfPokemon,rarityegg10},

                                };


                        } catch (JSONException e) {
                            e.printStackTrace();
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
