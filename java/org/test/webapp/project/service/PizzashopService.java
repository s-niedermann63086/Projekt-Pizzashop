package org.test.webapp.project.service;

import org.test.webapp.project.dto.Pizza;
import org.test.webapp.project.persistence.PizzaDAO;

public class PizzashopService {


    private PizzaDAO pizzaDAO;

    public int idToInt(String z) {
        int id = Integer.parseInt(z);
        return id;
    }


    public String getPizzaId(int x) {
        Pizza pizza = pizzaDAO.getPizzaById(x);
        return pizza.toString();
    }


}
