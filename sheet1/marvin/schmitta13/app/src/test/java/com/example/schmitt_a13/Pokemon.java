package com.example.schmitt_a13;
import com.example.schmitt_a13.*;


public class Pokemon {

    private static int nextNumber = 1;

    private Type type;
    private String name;

    public int getNumber() {
        return number;
    }

    private int number;

    public Pokemon(String new_name, Type new_type){
        this.name=new_name;
        this.type=new_type;
        this.number = nextNumber;
        nextNumber += 1;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        /*
            "this.name" ensures that the instance's attribute "name" is referred to and not the
            parameter "name" that is passed to the function setName().
         */
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String toString(){
        return("ID = " + this.number + ", type = " + this.type + ", name = " + this.name);
    }



    public static void main(String[] args){
        Pokemon pok1;
        pok1 = new Pokemon("Glumanda", Type.FIRE);
        System.out.println(pok1.toString());

        Pokemon pok2 = new Pokemon("Schiggy", Type.WATER);
        System.out.println(pok2.toString());

        Pokemon pok3 = new Pokemon("Raupy", Type.POISON);
        System.out.println(pok3.toString());
    }
}
