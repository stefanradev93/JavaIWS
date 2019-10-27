import java.util.ArrayList;
import java.util.List;

public class Pokemon {
	
	public static int nextNumber = 1;
	private boolean swapAllowed;
	private int number;
	private String name;
	private Type type;
	private List<Swap> swaps = new ArrayList<Swap>();
	private Trainer trainer;
	
	/* C-tors */
	public Pokemon(String name, Type type) {
		// Swap allowed defaults to true
		this(name, type, true);

	}
	
	public Pokemon(String name, Type type, boolean swapAllowed) {
		setName(name);
		setType(type);
		setSwapAllowed(swapAllowed);
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
	
	public boolean getSwapAllowed() {
		return swapAllowed;
	}
	
	public List<Swap> getSwaps() {
		return swaps;
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
	
	public void setSwapAllowed(boolean swapAllowed) {
		this.swapAllowed = swapAllowed;
	}
	
	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}
	
	public void setType(Type type) {
		this.type = type;
	}
	
	public void addSwap(Swap swap) {
		swaps.add(swap);
	}
	
	@Override 
	public String toString() {
		return "Pokemon[Name: " + name + ", Type: " + type + ", Number: " + number + "]";
	}
	
	
}
