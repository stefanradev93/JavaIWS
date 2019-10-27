
public class Pokemon {
	
	public static int nextNumber = 1;
	private int number;
	private String name;
	private Type type;
	
	// Main method
	public static void main(String[] args) {
		
		// Declare object
		Pokemon myPokemon;
		
		// Define object
		myPokemon = new Pokemon("Charizard", Type.FIRE);
		
		// String representation
		System.out.println(myPokemon.toString());
	}
	
	public Pokemon(String newName, Type newType) {
		name = newName;
		type = newType;
		number = nextNumber;
		nextNumber++;
	}
	
	/* Getters */
	public String getName() {
		return name;
	}
	
	public Type getType() {
		return type;
	}
	
	public int getNumber() {
		return number;
	}
	
	/* Setters */
	public void setName(String newName) {
		name = newName;
		// this is a reference to the current class instance 
		// calling this() invokes current class constructor
		// we do not need it in case there are no name conflicts
		// but we could have done this.name = newName;
	}
	
	public void setType(Type newType) {
		type = newType;
	}
	
	@Override 
	public String toString() {
		return "Pokemon[Name: " + name + ", Type: " + type + ", Number: " + number + "]";
	}
	
	
}
