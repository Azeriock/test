package jardin;

import java.util.Scanner;

public class Terre {

	public static void main(String[] args) {

		Jardin j = new Jardin(3, 5);
		
		j.ajouterPanier("Ail", 1);
		j.ajouterPanier("Betterave", 7);
		j.ajouterPanier("Carotte", 2);
		j.ajouterPanier("Tomate", 9);
				
		int choice = 0;
		
		do {			
			System.out.println(j);
			
			System.out.println("1. Semer une graine");
			System.out.println("2. Recolter toutes les plantes");
			System.out.println("3. Passer à la saison suivante");
			System.out.println("4. Quitter l'application");
			
			Scanner sc = new Scanner(System.in);
			choice = sc.nextInt();
			
			switch (choice) {
			case 1:
				j.semer();
				break;
			case 2:
				j.recolter();
				break;
			case 3:
				j.saisonSuivante();
				break;
			default :
				System.out.println("Merci de saisir une valeur entre 1 et 4.");
				break;
			}
			
		} while(choice != 4);
		
		System.out.println("Fin du programme");
		
	}

}
