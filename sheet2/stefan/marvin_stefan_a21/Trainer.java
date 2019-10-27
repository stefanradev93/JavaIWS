import java.util.ArrayList;


public class Trainer {
	
	private String firstName;
	private String lastName;
	private ArrayList<Pokemon> pokemons;
	
	
	/* Constructors */
	public Trainer() {
		this("Unnamed", "Unnamed");
	}
	
	public Trainer(String firstName, String lastName) {
		setFirstName(firstName);
		setLastName(lastName);
		pokemons = new ArrayList<Pokemon>();
	}
	
	/* Getter methods */
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	// Get all pokemons
	public ArrayList<Pokemon> getPokemons() {
		// Returns null if no pokemons exist
		if (pokemons.size() == 0) {
			return null;
		}
		return pokemons;
	}
	
	// Get all pokemons by type
	public ArrayList<Pokemon> getPokemonsByType(Type type) {
		
		ArrayList<Pokemon> pokemonsOfType = new ArrayList<Pokemon>();
		// Search for pokemons with the given type
		for (Pokemon p : pokemons) {
			if (p.getType() == type) {
				pokemonsOfType.add(p);
			}
		}
		// Returns zero if no such types forund
		if (pokemonsOfType.size() == 0) {
			return null;
		}
		return pokemonsOfType;
	}
	
	// Get a pokemon by name
	public Pokemon getPokemon(String name) {
		
		// Search for a pokemon with the given name
		for (Pokemon p : pokemons) {
			if (p.getName() == name) {
				return p;
			}
		}
		// If we are here, no pokemon with the name has been found
		return null;
		
	}
	
	/* Setter methods */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	// Create pokemon from String and Type
	public void addPokemon(String name, Type type) {
		Pokemon p = new Pokemon(name, type);
		p.setTrainer(this);
		pokemons.add(p);
	}
	
	// Create pokemon from Pokemon instance
	public void addPokemon(Pokemon p) {
		
		// Make sure p has no trainer
		if ( !(p.getTrainer() == null) ) {
			System.out.println("Could not add " + p + " because " + p.getTrainer() + " is already his trainer.");
			
		} else {
			p.setTrainer(this);
			pokemons.add(p);
		}
	}
	
	@Override 
	public String toString() {
		return "Trainer[" + firstName + " " + lastName + ", #Pokemons: " + pokemons.size() +  "]";
	}

}
