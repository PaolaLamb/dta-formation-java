package fr.pizzeria.ihm.menu.optionClient;

import java.util.Scanner;

import fr.pizzeria.dao.DaoClient;
import fr.pizzeria.ihm.menu.OptionMenu;

/**
 * @author PaolaLamb Action du menu créditer client
 *
 */
public class OptionCrediterCompte extends OptionMenu {

	private Scanner scanner;
	private DaoClient dao;
	OptionListClient clientList;
	double montant;
	int choix;

	public OptionCrediterCompte(Scanner scanner, DaoClient dao, OptionListClient clientList) {
		super();
		this.scanner = scanner;
		this.dao = dao;
		this.clientList = clientList;
	}

	@Override
	public String getLibelle() {
		return "Créditer le compte d'un client";
	}

	@Override
	public void execute() {

		clientList.execute();
		System.out.println("Veuillez choisir le client à créditer :");
		choix = this.scanner.nextInt();

		int clientListSize = this.dao.nbClient();
		if (choix > clientListSize) {
			System.out.println("/!\\/!\\ Client introuvable /!\\/!\\ \nVeuillez saisir un client valide :");
			choix = this.scanner.nextInt();
		}

		System.out.println("Veuillez choisir le montant à créditer");
		montant = this.scanner.nextDouble();

		this.dao.crediterCompteClient(choix - 1, montant);
	}

}
