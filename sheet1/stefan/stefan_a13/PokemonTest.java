public class PokemonTest {

    public static void main(String[] args){
    	
    	// Create two Pokemon instances
        Pokemon p1 = new Pokemon("Charizard", Type.FIRE);
        Pokemon p2 = new Pokemon("Bubble", Type.WATER);

        // Test names, types and numbers,  numbers should be 1 and 2
        System.out.println("Testing constructors...");
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        
        // Test getters
        System.out.println("Testing getters...");
        System.out.println("Name of p1: " + p1.getName());
        System.out.println("Type of p1: " + p1.getType());
        System.out.println("Number of of p1: " + p1.getNumber());
        System.out.println("Number of of p2: " + p2.getNumber());
        
        // Test setters
        System.out.println("Testing setters...");
        System.out.println("Setting name of p1 to Zoey...");
        p1.setName("Zoey");
        System.out.println("New name of p1: " + p1.getName());
        System.out.println("Setting type of p2 to POISON...");
        p2.setType(Type.POISON);
        System.out.println("New type of p2: " + p2.getType());
    }
}

