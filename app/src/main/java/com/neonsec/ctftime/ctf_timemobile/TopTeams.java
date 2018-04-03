package com.neonsec.ctftime.ctf_timemobile;

/**
 * Created by psn on 3/4/18.
 */

public class TopTeams {
    private String name,color;



    private int pos;



    private float points;

    public TopTeams() {
    }

    public TopTeams(String name, float points,String color,int pos) {
        this.name = name;
        this.points = points;
        this.color = color;
        this.pos = pos;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPoints() {
        return points;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPoints(float points){
        this.points = points;

    }

    public String getColor() {
        return color;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }
}