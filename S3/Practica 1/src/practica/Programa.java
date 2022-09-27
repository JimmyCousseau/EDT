package practica;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Programa {
	public static void main(String[] args) {
		Logger logger = Logger.getLogger(Programa.class.getName());
		if(args.length > 0) logger.log(Level.INFO, args[0]);
	}
}
