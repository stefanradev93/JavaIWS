public class PokemonTest {

    public static void main(String[] args){
    	
    	// Create three Pokemon instances
        Pokemon p1 = new Pokemon("Charizard", Type.FIRE);
        Pokemon p2 = new Pokemon("Bubble", Type.WATER);
        Pokemon p3 = new Pokemon("BubbleGum", Type.WATER);

       // Create a trainer 
        Trainer t = new Trainer("Marvin", "Schmitt");
        
        // Test getters and toString()
        System.out.println("Testing getters...");
        System.out.println("t.getFirstName(): " + t.getFirstName());
        System.out.println("t.getLastName(): " + t.getLastName());
        System.out.println("t.getPokemons(): " + t.getPokemons());
        System.out.println("t.toString(): " + t.toString());
        System.out.println();
        
        // Test setters
        System.out.println("Setting different names...");
        t.setFirstName("Stefan");
        t.setLastName("Radev");
        System.out.println("Printing results...");
        System.out.println("t.getFirstName(): " + t.getFirstName());
        System.out.println("t.getLastName(): " + t.getLastName());
        System.out.println("t.getPokemons(): " + t.getPokemons());
        System.out.println("t.toString(): " + t.toString());
        System.out.println();
        
        
        // Test get pokemons classes
        System.out.println("Adding four pokemons...");
        t.addPokemon(p1);
        t.addPokemon(p2);
        t.addPokemon(p3);
        t.addPokemon("AddedByName", Type.FIRE);
        System.out.println("t.getPokemon(\"Bubble\"): " + t.getPokemon("Bubble"));
        System.out.println("t.getPokemon(\"AddedByName\"): " + t.getPokemon("AddedByName"));
        System.out.println("t.getPokemon(\"Inexistent\"): " + t.getPokemon("Inexistent"));
        System.out.println("t.getPokemonsByType(Type.WATER): " + t.getPokemonsByType(Type.WATER));
        System.out.println("t.getPokemonsByType(Type.POISON): " + t.getPokemonsByType(Type.POISON));
        System.out.println("t.toString(): " + t.toString());
        System.out.println("p1.getTrainer(Type.WATER): " + p1.getTrainer());
    }
}

