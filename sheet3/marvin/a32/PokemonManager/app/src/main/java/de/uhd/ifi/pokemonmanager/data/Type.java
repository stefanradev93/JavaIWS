package de.uhd.ifi.pokemonmanager.data;

public enum Type {
    FIRE, WATER, POISON;

    public double toScore(){
        switch(this){
            case FIRE:
                return 0.2;
            case WATER:
                return 0.4;
            case POISON:
                return 0.6;
            default:
                return 0.0;
        }
    }
}
