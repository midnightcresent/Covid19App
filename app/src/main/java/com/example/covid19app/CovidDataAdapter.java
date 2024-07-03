package com.example.covid19app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CovidDataAdapter extends RecyclerView.Adapter<CovidDataAdapter.ViewHolder> {
    private final List<CovidData> covidDataList;

    public CovidDataAdapter(List<CovidData> covidDataList) {
        this.covidDataList = covidDataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CovidData data = covidDataList.get(position);
        holder.stateName.setText(data.getState());
        holder.cityName.setText(data.getCity());
        holder.activeCases.setText("Active cases: " + data.getActiveCases());
        holder.confirmedCases.setText("Confirmed cases: " + data.getConfirmedCases());
        holder.deceasedCases.setText("Deceased: " + data.getDeceased());
        holder.recoveredCases.setText("Recovered: " + data.getRecovered());
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView stateName;
        public TextView cityName;
        public TextView activeCases;
        public TextView confirmedCases;
        public TextView deceasedCases;
        public TextView recoveredCases;

        public ViewHolder(View itemView) {
            super(itemView);
            stateName = itemView.findViewById(R.id.state);
            cityName = itemView.findViewById(R.id.city);
            activeCases = itemView.findViewById(R.id.active_text);
            confirmedCases = itemView.findViewById(R.id.confirmed_text);
            deceasedCases = itemView.findViewById(R.id.deceased_text);
            recoveredCases = itemView.findViewById(R.id.recovered_text);
        }
    }

    @Override
    public int getItemCount() {
        return covidDataList.size();
    }
}
