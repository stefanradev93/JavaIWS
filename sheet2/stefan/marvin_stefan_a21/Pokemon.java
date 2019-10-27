public class Pokemon {
	
	public static int nextNumber = 1;
	private int number;
	private String name;
	private Type type;
	private Trainer trainer;
	
	/* C-tor */
	public Pokemon(String name, Type type) {
		setName(name);
		setType(type);
		incrementNumber();
	}
	
	private void incrementNumber() {
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
	
	public Trainer getTrainer() {
		return trainer;
	}
	
	/* Setters */
	public void setName(String name) {
		this.name = name;
	}
	
	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}
	
	public void setType(Type type) {
		this.type = type;
	}
	
	@Override 
	public String toString() {
		return "Pokemon[Name: " + name + ", Type: " + type + ", Number: " + number + "]";
	}
	
	
}
