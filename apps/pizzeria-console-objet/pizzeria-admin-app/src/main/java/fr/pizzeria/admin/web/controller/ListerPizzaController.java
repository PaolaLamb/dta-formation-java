package fr.pizzeria.admin.web.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.metier.PizzaService;

@WebServlet("/pizzas/list")
public class ListerPizzaController extends HttpServlet {
	@Inject
	private PizzaService pizzaService;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("listPizzas", pizzaService.findAll());

		RequestDispatcher dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/pizzas/listerPizzas.jsp");
		dispatcher.forward(request, response);

	}

}
