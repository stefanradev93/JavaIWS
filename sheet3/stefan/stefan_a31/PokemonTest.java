public class PokemonTest {

    public static void main(String[] args){
    	
    	// Create four Pokemon instances
        Pokemon p1 = new Pokemon("Charizard", Type.FIRE);
        Pokemon p2 = new Pokemon("Bubble", Type.WATER);
        Pokemon p3 = new Pokemon("Pikatchu", Type.FIRE);
        Pokemon p4 = new Pokemon("Weirdo", Type.WATER, false);

       // Create two trainers
        Trainer t1 = new Trainer("Marvin", "Schmitt");
        Trainer t2 = new Trainer("Stefan", "Radev");
        
        // Pokemons' swap history
        System.out.println("Showing swap history of pokemons...");
        System.out.println("p1.getSwaps(): " + p1.getSwaps());
        System.out.println("p2.getSwaps(): " + p2.getSwaps());
        System.out.println("p3.getSwaps(): " + p3.getSwaps());
        System.out.println("p4.getSwaps(): " + p4.getSwaps());
        System.out.println();
        
        // Add pokemons to trainers
        System.out.println("t1 (Marvin) becomes a trainer for Charizard and Bubble...");
        t1.addPokemon(p1);
        t1.addPokemon(p2);
        System.out.println("t2 (Stefan) becomes a trainer for Pikatchu and Weirdo...");
        t2.addPokemon(p3);
        t2.addPokemon(p4);
        System.out.println("t1.getPokemons(): " + t1.getPokemons());
        System.out.println("t2.getPokemons(): " + t2.getPokemons());
        System.out.println("p1.getTrainer(): " + p1.getTrainer());
        System.out.println("p2.getTrainer(): " + p2.getTrainer());
        System.out.println("p3.getTrainer(): " + p3.getTrainer());
        System.out.println("p4.getTrainer(): " + p4.getTrainer());
        System.out.println();
        
        // Attempt to add Pikatchu to Marvin's pokemons
        System.out.println("Attempting to add Pikatchu  for Marvin's pokemons...");
        t1.addPokemon(p3);
        
        // Swap Charizard for Bubble
        System.out.println("Swapping Charizard for Pikatschu...");
        Swap s = new Swap();
        s.execute(p1, p3);
        System.out.println("Showing swap history of Charizard and Pikatschu...");
        System.out.println("p1.getSwaps(): " + p1.getSwaps());
        System.out.println("p3.getSwaps(): " + p3.getSwaps());
        System.out.println("p1.getTrainer(): " + p1.getTrainer());
        System.out.println("p3.getTrainer(): " + p3.getTrainer());
        System.out.println();
        
        // Swap Bybble back for Charizard
        System.out.println("Swapping Pikatschu back for Charizard...");
        Swap s2 = new Swap();
        s2.execute(p3, p1);
        System.out.println("Showing swap history of Charizard and Pikatschu...");
        System.out.println("p1.getSwaps(): " + p1.getSwaps());
        System.out.println("p3.getSwaps(): " + p3.getSwaps());
        System.out.println("p1.getTrainer(): " + p1.getTrainer());
        System.out.println("p3.getTrainer(): " + p3.getTrainer());
        System.out.println();
        
        // Swap unallowed 
        System.out.println("Swapping Bubble for Weirdo...");
        Swap s3 = new Swap();
        s3.execute(p2, p4);
        System.out.println("Showing swap history of Charizard and Pikatschu...");
        System.out.println("p2.getSwaps(): " + p2.getSwaps());
        System.out.println("p4.getSwaps(): " + p4.getSwaps());
        System.out.println("p2.getTrainer(): " + p2.getTrainer());
        System.out.println("p4.getTrainer(): " + p4.getTrainer());
        System.out.println();
        
        System.out.println("Allowing swap...");
        p4.setSwapAllowed(true);
        Swap s4 = new Swap();
        s4.execute(p2, p4);
        System.out.println("Showing swap history of Charizard and Pikatschu...");
        System.out.println("p2.getSwaps(): " + p2.getSwaps());
        System.out.println("p4.getSwaps(): " + p4.getSwaps());
        System.out.println("p2.getTrainer(): " + p2.getTrainer());
        System.out.println("p4.getTrainer(): " + p4.getTrainer());
        System.out.println();
        
        System.out.println("Attemping to swap both Stefan's pokemons...");
        Swap s5 = new Swap();
        s5.execute(p1, p4);
        System.out.println();
        
        // Test competitions
        System.out.println("Testing competitions...");
        Competition c1 = new Competition();
        System.out.println("Attemping to challenge both Stefan's pokemons...");
        c1.execute(p1, p4);
        System.out.println("Let Charizard (FIRE) fight Bubble (WATER)...");
        System.out.println("Trainers before competition: ");
        System.out.println("p1.getTrainer() [Charizard]: " + p1.getTrainer());
        System.out.println("p2.getTrainer() [Bubble]: " + p2.getTrainer());
        Competition c2 = new Competition();
        c2.execute(p1, p2);
        System.out.println("Trainers after competition: ");
        System.out.println("Expect Stefan to be trainer for both pokemons and have 3 pokemons");
        System.out.println("Expect Marvin to have only one pokemon left");
        System.out.println("p1.getTrainer() [Charizard]: " + p1.getTrainer());
        System.out.println("p2.getTrainer() [Bubble]: " + p2.getTrainer());
        System.out.println("t1.toString(): " + t1.toString());
        System.out.println("Check competitions list for both pokemons...");
        System.out.println("p1.getCompetitions(): " + p1.getCompetitions());
        System.out.println("p2.getCompetitions(): " + p2.getCompetitions());
    }
}

