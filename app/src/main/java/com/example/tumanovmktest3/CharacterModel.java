package com.example.tumanovmktest3;

public class CharacterModel {
    private String name;
    private String path;
    private int color;

    public CharacterModel(String name, String path, int color) {
        this.name = name;
        this.path = path;
        this.color = color;
    }

    public String getName() { return name; }
    public String getPath() { return path; }
    public int getColor() { return color; }
}
