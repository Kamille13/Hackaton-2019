package com.example.hackaton2019;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Enigme1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enigme1);

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        String url = "http://easteregg.wildcodeschool.fr/api/eggs";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray list) {
                        try {
                            JSONObject eggs = list.getJSONObject(0);
                            String urlPicEgg = eggs.getString("image");
                            ImageView ivLogo = findViewById(R.id.imageView2);
                            Glide.with(Enigme1Activity.this).load(urlPicEgg).into(ivLogo);

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(Enigme1Activity.this, "error on ImportApi", Toast.LENGTH_SHORT).show();
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
                            JSONObject character = list.getJSONObject(0);
                            String urlPicChar = character.getString("image");
                            ImageView ivCharacterShow = findViewById(R.id.imageView);
                            Glide.with(Enigme1Activity.this).load(urlPicChar).into(ivCharacterShow);


                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(Enigme1Activity.this, "error on ImportApiCharacter", Toast.LENGTH_SHORT).show();
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

        Button reponsejuste = findViewById(R.id.button3);
        reponsejuste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Enigme1Activity.this, "Bonne réponse, bravo!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Enigme1Activity.this,MapsActivity.class);
                startActivity(intent);



            }
        });
    }
}
