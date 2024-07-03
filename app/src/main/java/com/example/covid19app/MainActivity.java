package com.example.covid19app;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    ArrayList<CovidData> covidDataList = new ArrayList<>();
    CovidDataAdapter adapter = new CovidDataAdapter(covidDataList);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Covid19 App");
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        fetchCovidData();
    }

    private void fetchCovidData() {
        String url = "https://data.covid19india.org/state_district_wise.json";
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                response -> {
                    try {
                        Iterator<String> states = response.keys();
                        while (states.hasNext()) {
                            String state = states.next();
                            JSONObject stateData = response.getJSONObject(state);
                            JSONObject districtData = stateData.getJSONObject("districtData");

                            Iterator<String> districts = districtData.keys();
                            while (districts.hasNext()) {
                                String district = districts.next();
                                JSONObject districtDetails = districtData.getJSONObject(district);

                                int active = districtDetails.getInt("active");
                                int confirmed = districtDetails.getInt("confirmed");
                                int deceased = districtDetails.getInt("deceased");
                                int recovered = districtDetails.getInt("recovered");

                                covidDataList.add(new CovidData(state, district, active, confirmed, deceased, recovered));
                            }
                        }
                        adapter.notifyDataSetChanged();
                    } catch (JSONException e) {
                        Log.d("Error", e.toString());
                        Toast.makeText(MainActivity.this, "Error parsing data", Toast.LENGTH_SHORT).show();
                    }
                },
                error -> {
                    Log.d("Error", error.toString());
                    Toast.makeText(MainActivity.this, "Error fetching data", Toast.LENGTH_SHORT).show();
                });

        queue.add(request);
    }
}