package jardin.flore;

import java.util.AbstractMap.SimpleEntry;
import java.util.Random;

public class Betterave extends Vegetal implements IOgm {

	public Betterave() {
		super();
		dessin[3] = 'b';
		dessin[4] = 'B';
	}

	@Override
	public SimpleEntry<Integer, Integer> seDupliquer(int longueur, int largeur) {
		
		etat = Etat.GRAINE;
		
		Random r = new Random();
		int newX = r.nextInt(longueur);
		int newY = r.nextInt(largeur);
		
		return new SimpleEntry<Integer, Integer>(newX, newY);
	}
	
}