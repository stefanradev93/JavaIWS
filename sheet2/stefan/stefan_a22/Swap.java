import java.util.Date;

public class Swap {
 
    private Date date = new Date();
    private Trainer[] trainers = new Trainer[2];
    private Pokemon[] pokemons = new Pokemon[2];
    private String id;


    /* Setters */ 
    private void setId() {
        id = Long.toString(getDate().getTime());
    }

    public void setTrainers(Trainer t1, Trainer t2) {
        trainers[0] = t1;
        trainers[1] = t2;
    }

    public void setPokemons(Pokemon p1, Pokemon p2) {
        pokemons[0] = p1;
        pokemons[1] = p2;
    }

    /* Getters */
    public String getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public Trainer[] getTrainers() {
        return trainers;
    }

    public Pokemon[] getPokemons() {
        return pokemons;
    }

    // Execute swapping
    public boolean execute(Pokemon p1, Pokemon p2) {
    	// Returns true if the swap was executed and false if not
    	
    	// Make sure trainers are not the same
    	if (p1.getTrainer().equals(p2.getTrainer())) {
    		System.out.println("Warning! Cannot swap pokemons of the same trainer! Swap not executed.");
    		return false;
    	}
    	
    	// Make sure pokemon 1 can be swapped
    	if (!p1.getSwapAllowed()) {
    		System.out.println("Warning! Pokemon " + p1 + " cannot be swapped. Make sure swapAllowed is true.");
    		return false;
    	}
    	
    	// Make sure pokemon 2 can be swapped
    	if (!p2.getSwapAllowed()) {
    		System.out.println("Warning! Pokemon " + p2 + " cannot be swapped. Make sure swapAllowed is true.");
    		return false;
    	}
    	
    	// Execute swap
    	pokemons[0] = p1;
    	pokemons[1] = p2;
    	trainers[0] = p1.getTrainer();
    	trainers[1] = p2.getTrainer();
    	p1.setTrainer(trainers[1]);
    	p2.setTrainer(trainers[0]);
    	p1.addSwap(this);
    	p2.addSwap(this);
    	setId();
    	return true;
    }
    
    @Override 
	public String toString() {
		return "Swap#" + id + "[" + pokemons[0].getName() + " for " + pokemons[1].getName() + " between " + 
						 trainers[0].getFirstName() + " and " + trainers[1].getFirstName() +  "]";
	}

}