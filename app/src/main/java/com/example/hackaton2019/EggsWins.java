package com.example.hackaton2019;

public class EggsWins {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private String name;
    private String url;

    public EggsWins(String name, String url) {
        this.name = name;
        this.url = url;
    }
}
