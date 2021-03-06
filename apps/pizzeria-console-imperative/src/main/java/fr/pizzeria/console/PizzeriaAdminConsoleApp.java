package fr.pizzeria.console;

import java.util.Scanner;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		/*
		 * deux possibilit�s : cr�er un tableau plus grand et cacher les lignes
		 * vides ou recr�er le tableau � chaque fois en ajoutant une ligne en
		 * plus
		 */
		String tabInfoPizza[][] = { { "Code de la pizza", "Nom", "Prix" }, { "PEP", "P�p�roni", "12.50" },
				{ "MAR", "Margherita", "14.00" }, { "REI", "La Reine", "11.50" }, { "FRO", "La 4 fromages", "12.00" },
				{ "CAN", "La cannibale", "12.50" }, { "SAV", "La savoyarde", "13.00" },
				{ "ORI", "L'orientale", "13.50" }, { "IND", "L'indienne", "14.00" }, { "", "", "" } };

		System.out.println("***** Pizzeria Administration *****");
		System.out.println("1. Lister les pizzas");
		System.out.println("2. Ajouter une nouvelle pizza");
		System.out.println("3. Mettre � jour une pizza");
		System.out.println("4. Supprimer une pizza");
		System.out.println("99. Sortir");

		String code = "";
		String nom = "";
		String prix = "";

		int choix = scan.nextInt();
		while (choix != 99) {

			// utiliser switch plutot que if
			if (choix == 1) {
				for (int i = 1; i < tabInfoPizza.length; i++) {
					System.out.println(
							tabInfoPizza[i][0] + " -> " + tabInfoPizza[i][1] + " (" + tabInfoPizza[i][2] + ") ");
				}

				System.out.println("***** Pizzeria Administration *****");
				System.out.println("1. Lister les pizzas");
				System.out.println("2. Ajouter une nouvelle pizza");
				System.out.println("3. Mettre � jour une pizza");
				System.out.println("4. Supprimer une pizza");
				System.out.println("99. Sortir");
				choix = scan.nextInt();
			}

			else if (choix == 2) {
				System.out.println("Veuillez saisir le code");
				code = scan.next();
				tabInfoPizza[9][0] = code;

				System.out.println("Veuillez saisir le nom (sans espace)");
				nom = scan.next();
				tabInfoPizza[9][1] = nom;

				System.out.println("Veuillez saisir le prix");
				prix = scan.next();
				tabInfoPizza[9][2] = prix;

				System.out.println("***** Pizzeria Administration *****");
				System.out.println("1. Lister les pizzas");
				System.out.println("2. Ajouter une nouvelle pizza");
				System.out.println("3. Mettre � jour une pizza");
				System.out.println("4. Supprimer une pizza");
				System.out.println("99. Sortir");
				choix = scan.nextInt();

			}

			else if (choix == 3) {
				for (int i = 1; i < tabInfoPizza.length; i++) {
					System.out.println(
							tabInfoPizza[i][0] + " -> " + tabInfoPizza[i][1] + " (" + tabInfoPizza[i][2] + ") ");
				}
				System.out.println("Veuillez choisir la pizza � modifier");
				System.out.println("(99 pour abandonner)");
				String pizzaModif = scan.next();

				if (!pizzaModif.equals("99")) {
					for (int ip = 0; ip < tabInfoPizza.length; ip++) {
						if (pizzaModif.equals(tabInfoPizza[ip][0])) {
							System.out.println("Veuillez saisir le code");
							code = scan.next();
							tabInfoPizza[ip][0] = code;

							System.out.println("Veuillez saisir le nom (sans espace)");
							nom = scan.next();
							tabInfoPizza[ip][1] = nom;

							System.out.println("Veuillez saisir le prix");
							prix = scan.next();
							tabInfoPizza[ip][2] = prix;
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
				for (int i = 1; i < tabInfoPizza.length; i++) {
					System.out.println(
							tabInfoPizza[i][0] + " -> " + tabInfoPizza[i][1] + " (" + tabInfoPizza[i][2] + ") ");
				}
				System.out.println("Veuillez choisir la pizza � supprimer");
				System.out.println("(99 pour abandonner)");
				String pizzaSupp = scan.next();

				if (!pizzaSupp.equals("99")) {
					for (int jp = 0; jp < tabInfoPizza.length; jp++) {
						if (pizzaSupp.equals(tabInfoPizza[jp][0])) {
							tabInfoPizza[jp][0] = "";
							tabInfoPizza[jp][1] = "";
							tabInfoPizza[jp][2] = "";
						}
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
		scan.close() ;

	}

}
