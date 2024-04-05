package com.example.planetapp;

public class Planet {
    private String planetName;
    private String moonCount;
    private int planetImage;

    public Planet(String planetName, String moonCount, int planetImage) {
        this.planetName = planetName;
        this.moonCount = moonCount;
        this.planetImage = planetImage;
    }

    public String getPlanetName() {
        return planetName;
    }

    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }

    public String getMoonCount() {
        return moonCount;
    }

    public void setMoonCount(String moonCount) {
        this.moonCount = moonCount;
    }

    public int getPlanetImage() {
        return planetImage;
    }

    public void setPlanetImage(int planetImage) {
        this.planetImage = planetImage;
    }
}
