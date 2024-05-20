package com.example.tutorial;

public class Planet {
    private String PlanetName;
    private String Desc;
    private int PlanetImage;

    public Planet(String planetName, String desc, int planetImage) {
        PlanetName = planetName;
        Desc = desc;
        PlanetImage = planetImage;
    }

    public String getPlanetName() {
        return PlanetName;
    }

    public void setPlanetName(String planetName) {
        PlanetName = planetName;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public int getPlanetImage() {
        return PlanetImage;
    }

    public void setPlanetImage(int planetImage) {
        PlanetImage = planetImage;
    }
}
