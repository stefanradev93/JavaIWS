public class Competition extends Swap {
	
	@Override
	public boolean execute(Pokemon p1, Pokemon p2) {
		
		// Make sure trainers are not the same
    	if (p1.getTrainer().equals(p2.getTrainer())) {
    		System.out.println("Warning! Pokemons from same trainer cannot compete! Competition not executed.");
    		return false;
    	}
    	
    	// Add pokemons to list
    	pokemons[0] = p1;
    	pokemons[1] = p2;
    	int winner;
    	
    	// Execute competition
    	// If types are the same, make outcome random, else determine by POISON > WATER > FIRE
    	
    	// Equals types
    	if (p1.getType().equals(p2.getType())) {
    		winner = (java.lang.Math.random() > 0.5) ? 1 : 0;
    	}
    	
    	// p1 POSION wind directly
    	else if (p1.getType().equals(Type.POISON)) {
    		winner = 0;
    	}
    	
    	// p1 WATER and p2 FIRE
    	else if ( (p1.getType().equals(Type.WATER)) && (p2.getType().equals(Type.FIRE)) ) {
    		winner = 0;
    	}
    	
    	// For all other cases p2 wins
    	else {
    		winner = 1;
    	}
    	
    	// Add pokemons and trainers
    	initExec(p1, p2);
    	
    	// Trainer of winner becomes trainer of defeated
    	int defeated = (winner == 1) ? 0 : 1; 
    	trainers[defeated].removePokemon(pokemons[defeated]);
    	trainers[winner].addPokemon(pokemons[defeated]);
    	
    	// Add competitions to pokemon
    	p1.addCompetition(this);
    	p2.addCompetition(this);
    	
    	return true;
	}
	
	@Override 
	public String toString() {
		return "Competition#" + id + "[" + pokemons[0].getName() + " vs " + pokemons[1].getName() + " between " + 
						 trainers[0].getFirstName() + " and " + trainers[1].getFirstName() +  "]";
	}
}
