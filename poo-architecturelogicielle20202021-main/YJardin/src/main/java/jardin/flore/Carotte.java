package jardin.flore;

import java.util.HashMap;

public class Carotte extends Vegetal implements IRacePure {

	public Carotte() {
		super();
		dessin[3] = 'c';
		dessin[4] = 'C';
	}

	@Override
	public void seReproduire(HashMap<String, Integer> panier) {
		int quantite = 3;
		if(panier.get("Carotte") != null) {
			quantite = panier.get("Carotte") + quantite;
		}
		panier.put("Carotte", quantite);		
	}

}