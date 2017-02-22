package fr.pizzeria.console;

import java.util.ArrayList;
import java.util.Scanner;

import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		Pizza p1 = new Pizza("PEP", "p�p�roni", 12.50);
		Pizza p2 = new Pizza("MAR", "Margherita", 14.00);
		Pizza p3 = new Pizza("REI", "La Reine", 11.50);
		Pizza p4 = new Pizza("FRO", "La 4 fromages", 12.00);
		Pizza p5 = new Pizza("CAN", "La Canibale", 12.50);
		Pizza p6 = new Pizza("SAV", "La savoyarde", 13.00);
		Pizza p7 = new Pizza("ORI", "L'orientale", 13.50);
		Pizza p8 = new Pizza("IND", "L'indienne", 14.00);

		ArrayList<Pizza> listPizzas = new ArrayList<Pizza>();

		listPizzas.add(p1);
		listPizzas.add(p2);
		listPizzas.add(p3);
		listPizzas.add(p4);
		listPizzas.add(p5);
		listPizzas.add(p6);
		listPizzas.add(p7);
		listPizzas.add(p8);

		System.out.println("***** Pizzeria Administration *****");
		System.out.println("1. Lister les pizzas");
		System.out.println("2. Ajouter une nouvelle pizza");
		System.out.println("3. Mettre � jour une pizza");
		System.out.println("4. Supprimer une pizza");
		System.out.println("99. Sortir");

		int choix = scan.nextInt();
		while (choix != 99) {

			int nbPizzas = listPizzas.size();

			if (choix == 1) {
				for (int i = 1; i < listPizzas.size(); i++) {
					System.out.println(listPizzas.get(i).code + " -> " + listPizzas.get(i).nom + " ("
							+ listPizzas.get(i).prix + ") ");
				}
				System.out.println("-> " + nbPizzas + " pizzas cr��es depuis l'initialisation du programme");

				System.out.println("***** Pizzeria Administration *****");
				System.out.println("1. Lister les pizzas");
				System.out.println("2. Ajouter une nouvelle pizza");
				System.out.println("3. Mettre � jour une pizza");
				System.out.println("4. Supprimer une pizza");
				System.out.println("99. Sortir");
				choix = scan.nextInt();
			} else if (choix == 2) {

				System.out.println("Veuillez saisir le code");
				String code = scan.next();

				System.out.println("Veuillez saisir le nom (sans espace)");
				String nom = scan.next();

				System.out.println("Veuillez saisir le prix");
				double prix = scan.nextDouble();

				Pizza pn = new Pizza(code, nom, prix);
				listPizzas.add(pn);
				nbPizzas+=1 ;
				
				System.out.println("***** Pizzeria Administration *****");
				System.out.println("1. Lister les pizzas");
				System.out.println("2. Ajouter une nouvelle pizza");
				System.out.println("3. Mettre � jour une pizza");
				System.out.println("4. Supprimer une pizza");
				System.out.println("99. Sortir");
				choix = scan.nextInt();

			} else if (choix == 3) {
				for (int i = 1; i < listPizzas.size(); i++) {
					System.out.println(listPizzas.get(i).code + " -> " + listPizzas.get(i).nom + " ("
							+ listPizzas.get(i).prix + ") ");
				}
				System.out.println("Veuillez choisir la pizza � modifier");
				System.out.println("(99 pour abandonner)");
				String pizzaModif = scan.next();

				if (!pizzaModif.equals("99")) {
					for (int ip = 0; ip < listPizzas.size(); ip++) {
						if (pizzaModif.equals(listPizzas.get(ip).code)) {
							System.out.println("Veuillez saisir le code");
							String code = scan.next();

							System.out.println("Veuillez saisir le nom (sans espace)");
							String nom = scan.next();

							System.out.println("Veuillez saisir le prix");
							double prix = scan.nextDouble();

							listPizzas.get(ip).code = code;
							listPizzas.get(ip).nom = nom;
							listPizzas.get(ip).prix = prix;

						}
					}
					System.out.println("***** Pizzeria Administration *****");
					System.out.println("1. Lister les pizzas");
					System.out.println("2. Ajouter une nouvelle pizza");
					System.out.println("3. Mettre � jour une pizza");
					System.out.println("4. Supprimer une pizza");
					System.out.println("99. Sortir");
					choix = scan.nextInt();

				} else {
					System.out.println("***** Pizzeria Administration *****");
					System.out.println("1. Lister les pizzas");
					System.out.println("2. Ajouter une nouvelle pizza");
					System.out.println("3. Mettre � jour une pizza");
					System.out.println("4. Supprimer une pizza");
					System.out.println("99. Sortir");
					choix = scan.nextInt();
				}
			} else if (choix == 4) {
				for (int i = 1; i < listPizzas.size(); i++) {
					System.out.println(
							listPizzas.get(i).code + " -> " + listPizzas.get(i).nom + " (" + listPizzas.get(i).prix + ") ");
				}
				System.out.println("Veuillez choisir la pizza � supprimer");
				System.out.println("(99 pour abandonner)");
				String pizzaSupp = scan.next();

				if (!pizzaSupp.equals("99")) {
					for (int jp = 0; jp < listPizzas.size(); jp++) {
						if (pizzaSupp.equals(listPizzas.get(jp).code)) {
							listPizzas.remove(jp) ;
						}
						
						nbPizzas= nbPizzas - 1 ;
						
					}

				} else {
					System.out.println("***** Pizzeria Administration *****");
					System.out.println("1. Lister les pizzas");
					System.out.println("2. Ajouter une nouvelle pizza");
					System.out.println("3. Mettre � jour une pizza");
					System.out.println("4. Supprimer une pizza");
					System.out.println("99. Sortir");
					choix = scan.nextInt();
				}

				System.out.println("***** Pizzeria Administration *****");
				System.out.println("1. Lister les pizzas");
				System.out.println("2. Ajouter une nouvelle pizza");
				System.out.println("3. Mettre � jour une pizza");
				System.out.println("4. Supprimer une pizza");
				System.out.println("99. Sortir");
				choix = scan.nextInt();
			}
		}
		System.out.println("Au revoir");
	}
}
