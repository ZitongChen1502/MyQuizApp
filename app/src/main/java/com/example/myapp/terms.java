package com.example.myapp;

public class terms {
    private String word;
    private String definition;
    private int visits;
    private int wrongs;

    public terms(String w, String d){
        word = w;
        definition = d;
        visits = 0;
        wrongs = 0;
    }
    public String getWord(){
        return word;
    }
    public String getDefinition() {
        return definition;
    }
    public double getMissRate(){ return (double)wrongs / visits;}
    public void visit(){visits++;}
    public void wrong(){wrongs++;}
    public int getVisits(){return visits;}
}
