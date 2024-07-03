package com.example.covid19app;

public class CovidData {
    private String state;
    private String city;
    private int activeCases;
    private int confirmedCases;
    private int deceased;
    private int recovered;

    public CovidData(String state, String city, int activeCases, int confirmedCases, int deceased, int recovered) {
        this.state = state;
        this.city = city;
        this.activeCases = activeCases;
        this.confirmedCases = confirmedCases;
        this.deceased = deceased;
        this.recovered = recovered;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getActiveCases() {
        return activeCases;
    }

    public void setActiveCases(int activeCases) {
        this.activeCases = activeCases;
    }

    public int getConfirmedCases() {
        return confirmedCases;
    }

    public void setConfirmedCases(int confirmedCases) {
        this.confirmedCases = confirmedCases;
    }

    public int getDeceased() {
        return deceased;
    }

    public void setDeceased(int deceased) {
        this.deceased = deceased;
    }

    public int getRecovered() {
        return recovered;
    }

    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }
}
