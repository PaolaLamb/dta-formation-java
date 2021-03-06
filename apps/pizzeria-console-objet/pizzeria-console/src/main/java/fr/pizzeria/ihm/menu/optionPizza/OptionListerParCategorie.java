package fr.pizzeria.ihm.menu.optionPizza;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.pizzeria.dao.DaoPizza;
import fr.pizzeria.ihm.menu.OptionMenu;
import fr.pizzeria.model.Pizza;

/**
 * @author PaolaLamb
 *
 */

@Controller
public class OptionListerParCategorie extends OptionMenu {

	private DaoPizza<Pizza, String> dao;

	@Autowired
	public OptionListerParCategorie(DaoPizza<Pizza, String> dao) {
		super();
		this.dao = dao;
	}

	@Override
	public String getLibelle() {
		return "Lister les pizzas groupées par catégorie";
	}

	@Override
	public void execute() {
		this.dao.findAll().stream().collect(Collectors.groupingBy(Pizza::getCategoriePizza))
				.forEach((key, value) -> System.out.println(key + " : " + value));
	}

}
