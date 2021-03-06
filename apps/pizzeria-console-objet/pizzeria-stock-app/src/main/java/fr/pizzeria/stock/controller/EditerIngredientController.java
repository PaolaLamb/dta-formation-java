package fr.pizzeria.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.pizzeria.model.Ingredient;
import fr.pizzeria.stock.repository.IngredientRepository;

@Controller
@RequestMapping("/ingredient/id")
public class EditerIngredientController {

	@Autowired
	private IngredientRepository ingreRep;

	@RequestMapping(value = "/ingredient/{id}", method = RequestMethod.GET)
	public String post(@PathVariable String id) {
				
		return "editerIngredient";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(@ModelAttribute("ingredient") Ingredient newIngredient, @PathVariable("id") Integer id) {
		Ingredient oldIngredient = ingreRep.findIngredientById(id) ;
		newIngredient.setId(oldIngredient.getId());
		ingreRep.save(newIngredient);
		
		return "redirect:/mvc/ingredient";

	}

}