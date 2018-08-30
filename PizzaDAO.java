package org.test.webapp.project.persistence;

import org.test.webapp.project.dto.Pizza;

import java.util.List;

public interface PizzaDAO {
    List<Pizza> getPizzas();

    Pizza getPizzaById(int id);

    void create(Pizza pizza);

    void update(Pizza pizza, int id);

    void delete(int id);
}
