package scite;

public class Ecran {
    
    
    public static void afficher(Object... s) {
	for (Object o : s) {
	    System.out.print(o.toString());
	}
    }
    
    
    public static void afficherln(Object... s) {
	for (Object o : s) {
	    System.out.print(o.toString());
	}
	System.out.println();
    }
    
    
    public static void sautDeLigne() {
	System.out.println();
    }
}
