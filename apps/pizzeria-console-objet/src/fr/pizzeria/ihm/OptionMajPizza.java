package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.Pizza;

public class OptionMajPizza extends OptionMenu {
	public OptionMajPizza(IPizzaDao dao, Scanner scan) {
		super(dao, scan) ;
	}

	@Override
	public String getLibelle() {
		return "Modifier une pizza" ;
	}

	@Override
	public boolean execute() {
		Pizza newPizza = new Pizza() ;
		System.out.println("Veuillez choisir le code de la pizza � modifier (99 pour quitter)");
		String pizzaPick = scan.nextLine() ;
		if (pizzaPick != "99") {
			System.out.println("Veuillez saisir le code");
			newPizza.code = scan.nextLine() ;
			
			System.out.println("Veuillez saisir le nom");
			newPizza.nom = scan.nextLine() ;
			
			System.out.println("Veuillez saisir le prix");
			newPizza.prix = scan.nextDouble() ;
			
			return dao.updatePizza(pizzaPick, newPizza) ;
		}
		return true ;
	}
	
}

