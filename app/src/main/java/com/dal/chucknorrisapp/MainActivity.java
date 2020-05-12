/* Reference:
HathibelagalHathibelagal, A.(2015, March 23).Getting Started With RecyclerView and CardView on Android.
    Retrieved December 1, 2019, from
    https://code.tutsplus.com/tutorials/getting-started-with-recyclerview-and-cardview-on-android--cms-23465.
*/

package com.dal.chucknorrisapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    boolean errorFlag = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String url = "http://api.icndb.com/jokes/random/10";

        recyclerView = findViewById(R.id.recycleView);
        final ArrayList<card> cardsList = new ArrayList<>();

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("value");
                    for (int i=0; i< jsonArray.length(); i++){
                        String joke = jsonArray.getJSONObject(i).optString("joke");
                        cardsList.add(new card(R.drawable.chuck_norris_icon, joke));
                    }
                } catch (Exception e) {
                    recyclerView.setVisibility(View.GONE);
                    Toast.makeText(getApplicationContext(),"Unknown Error Occured",Toast.LENGTH_SHORT);
                }
                recyclerView.setHasFixedSize(true);
                layoutManager = new LinearLayoutManager(getApplicationContext());
                adapter = new myViewAdaptor(cardsList);

                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                recyclerView.setVisibility(View.GONE);
                Toast.makeText(getApplicationContext(),"Unknown Error Occured", Toast.LENGTH_SHORT);
            }
        });
        RequestQueueSingleton.getInstance(getApplicationContext()).addToRequestQueue(request);
    }
}
