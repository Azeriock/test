package jardin;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import jardin.flore.Ail;
import jardin.flore.Betterave;
import jardin.flore.Carotte;
import jardin.flore.Etat;
import jardin.flore.IOgm;
import jardin.flore.IRacePure;
import jardin.flore.Tomate;

public class Jardin {

	private int longueur;
	private int largeur;
	private HashMap<String, Integer> panier;
	private Emplacement emplacement[][];

	public HashMap<String, Integer> getPanier() {
		return panier;
	}

	public Jardin(int longueur, int largeur) {
		this.longueur = longueur;
		this.largeur = largeur;
		this.panier = new HashMap<String, Integer>();
		emplacement = new Emplacement[this.longueur][this.largeur];
	}

	public void ajouterPanier(String nomDuVegetal, int quantite) {
		if (this.panier.get(nomDuVegetal) == null) {
			this.panier.put(nomDuVegetal, quantite);
		} else {
			this.panier.put(nomDuVegetal, this.panier.get(nomDuVegetal) + quantite);
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Voici notre jardin :\n");

		for (int x = 0; x < this.longueur; x++) {
			for (int y = 0; y < this.largeur; y++) {
				Emplacement e = emplacement[x][y];
				if (e == null) {
					sb.append("o");
				} else {
					sb.append(e);
				}
			}
			sb.append("\n");
		}

		sb.append("Et notre panier contient : \n");
		Iterator<String> iterator = this.panier.keySet().iterator();
		while (iterator.hasNext()) {
			String nom = iterator.next();
			int quantite = this.panier.get(nom);
			sb.append(nom).append(" : ").append(quantite).append(" graine(s)\n");
		}

		return sb.toString();
	}

	public void semer() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Indiquer la valeur X");
		int x = sc.nextInt();
		System.out.println("Indiquer la valeur Y");
		int y = sc.nextInt();
		System.out.println("Quel vegetal? 1. Ail , 2. Betterave , 3. Carotte , 4. Tomate");
		int choiceVegetal = sc.nextInt();

		switch (choiceVegetal) {
		case 1:
			if (panier.get("Ail") > 0) {
				this.emplacement[x][y] = new Emplacement(new Ail());
				this.panier.put("Ail", this.panier.get("Ail") - 1);
			}
			break;
		case 2:
			if (panier.get("Betterave") > 0) {
				this.emplacement[x][y] = new Emplacement(new Betterave());
				this.panier.put("Betterave", this.panier.get("Betterave") - 1);
			}
			break;
		case 3:
			if (panier.get("Carotte") > 0) {
				this.emplacement[x][y] = new Emplacement(new Carotte());
				this.panier.put("Carotte", this.panier.get("Carotte") - 1);
			}
			break;
		case 4:
			if (panier.get("Tomate") > 0) {
				this.emplacement[x][y] = new Emplacement(new Tomate());
				this.panier.put("Tomate", this.panier.get("Tomate") - 1);
			}
			break;
		default:
			System.out.println("Attention, vous devez saisir une valeur entre 1 et 4.");
			break;
		}

	}

	public void saisonSuivante() {

		for (int x = 0; x < this.longueur; x++) {
			for (int y = 0; y < this.largeur; y++) {
				Emplacement e = emplacement[x][y];
				if (e != null) {
					if (e.getVeg().getEtat() != Etat.MORT) {
						e.getVeg().grandir();
					} else {
						e = null;
					}
				}
			}
		}
	}

	public void recolter() {
		for (int x = 0; x < this.longueur; x++) {
			for (int y = 0; y < this.largeur; y++) {
				Emplacement e = emplacement[x][y];
				if (e != null) {
					if (e.getVeg().getEtat() == Etat.FLEUR) {
						if (e.getVeg() instanceof IRacePure) {
							IRacePure v = (IRacePure) e.getVeg();
							v.seReproduire(this.panier);
							emplacement[x][y] = null;
						} else if (e.getVeg() instanceof IOgm) {
							IOgm v = (IOgm) e.getVeg();
							SimpleEntry<Integer, Integer> newXY = v.seDupliquer(longueur, largeur);
							emplacement[x][y] = null;
							emplacement[newXY.getKey()][newXY.getValue()] = new Emplacement(e.getVeg());
						} else {
							emplacement[x][y] = null;
						}
					}
				}
			}
		}
	}

}
