package com.example.schmitt_a13;
import com.example.schmitt_a13.*;


public class PokemonTest {

    public static void main(String[] args){

        Pokemon p1 = new Pokemon("Glumanda", Type.FIRE);
        Pokemon p2 = new Pokemon("Schiggy", Type.WATER);

        // Test of Constructor and number
        System.out.println("Testing constructor and number");
        System.out.println("Number of Pokemon p1: " + p1.getNumber());
        System.out.println("Number of Pokemon p2: " + p2.getNumber());

        // Test of getters (name and type)
        System.out.println("\n\nTesting getter of name");
        System.out.println("Name of Pokemon p1: " + p1.getName());
        System.out.println("Type of Pokemon p1: " + p1.getType());

        // Test of setters (name and type)
        System.out.println("\n\nTesting setter of name");
        System.out.println("Changing Name to Glurak");
        p1.setName("Glurak");
        System.out.println("Name of Pokemon p1: " + p1.getName());
        System.out.println("Type of Pokemon p1: " + p1.getType());
        System.out.println("Changing Type to Type.WATER");
        p1.setType(Type.WATER);
        System.out.println("Name of Pokemon p1: " + p1.getName());
        System.out.println("Type of Pokemon p1: " + p1.getType());

        // Test of toString
        System.out.println("\n\nTesting of toString()");
        System.out.println("toString output of p1: " + p1.toString());
        System.out.println("toString output of p2: " + p2.toString());

    }
}
