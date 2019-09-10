package com.example.myapp;

public class wordBank {
    public terms[]bank= new terms[15];
    public terms[]update = new terms[15];


    public wordBank(){
        bank= new terms[15];
        update = new terms[15];
    }

    public void removeTerm(int index){
        terms[] shrink = new terms[update.length-1];
        for(int i =0; i < update.length-1;i++){
            if(i < index){
                shrink[i] = update[i];
            }
            else if(i >index){shrink[i]=update[i+1];
        }
            update=shrink.clone();
    }



}
    public void addTerm(terms t, int num){
        bank[num] =t;
        update[num] =t;
        num++;
    }
    public terms[] getBank(){
        return bank;
    }

    public String matchWord(String def){
        int index= 0;
        for(int j = 0; j< getBank().length; j++){
            if(getBank()[j].getDefinition().equals(def)){
                index =j;
            }
        }
        return bank[index].getWord();
    }
    public int findIndex(String def){
        int index= 0;
          for(int j = 0; j< bank.length; j++){
            if(bank[j].getDefinition().equals(def)){
                index =j;
            }
        }
        return index;
    }
    public void come(int index){

        bank[index].visit();

    }
    public void miss(int index){
         bank[index].wrong();
    }
    public terms getTerm(int index){
        return bank[index];
    }


}
