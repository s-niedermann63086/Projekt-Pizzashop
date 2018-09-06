package org.test.webapp.project.persistence;

import org.test.webapp.project.dto.Pizza;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PizzaDAOjdbc implements PizzaDAO {

    private Connection connection;

    public PizzaDAOjdbc() {
        try {
            this.connection = ConnectionFactory.createDBConnection("localhost", 3306, "pizzashop", "root", "alqpym55skdj");
        } catch (SQLException e) {
            System.out.println("Fehler beim Erstellen der Connection: " + e.getMessage());
        }
    }

    @Override
    public List<Pizza> getPizzas() {

        List<Pizza> pizzas = new ArrayList<>();

        String query = "select * from pizza;";

        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            ResultSet resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                Double price = resultSet.getDouble("price");
                pizzas.add(new Pizza(id, name, price));
            }
        } catch (SQLException e) {
            System.out.println("Fehler, Keine Information zu den Pizzen bekommen: " + e.getMessage());
        }
        return pizzas;

       /* try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from pizza;");

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                Double price = resultSet.getDouble("price");
                pizzas.add(new Pizza(id, name, price));
            }
        } catch (SQLException e) {
            System.out.println("Fehler beim Zurückgeben der Liste: "+e.getMessage());
        }
        return pizzas;*/
    }

    @Override
    public Pizza getPizzaById(int id) {
        Pizza pizza = null;


        String query = "select * from pizza where id = ?;";


        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            //pstmt.setString(1, name1);
            pstmt.setInt(1, id);
            ResultSet resultSet = pstmt.executeQuery();

            Long tempId = resultSet.getLong("id");
            String name = resultSet.getString("name");
            Double price = resultSet.getDouble("price");

            pizza = new Pizza(tempId, name, price);

        } catch (SQLException e) {
            System.out.println("Fehler beim Erhalten der Pizza per Id: " + e.getMessage());
        }


        /*try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from pizza where id =" + id + ";");

            Long tempId = resultSet.getLong("id");
            String name = resultSet.getString("name");
            Double price = resultSet.getDouble("price");

            pizza = new Pizza(tempId, name, price);

        } catch (SQLException e) {
            System.out.println("Fehler beim Erhalten der Pizza per Id: "+e.getMessage());
        }*/

        return pizza;
    }

    @Override
    public void create(Pizza pizza) {

        String query = "insert into pizza (id, name, price) values (?, ?, ?);";


        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            ResultSet resultSet = pstmt.executeQuery();
        } catch (SQLException e) {
            System.out.println("Fehler beim Erstellen von Pizzas: " + e.getMessage());
        }

        /*try (Statement statement = connection.createStatement()){
            statement.executeUpdate("insert into pizza (id, name, price) values("+pizza.getId()+", "+pizza.getName()+", "+pizza.getPrice()+");");
        } catch (SQLException e) {
            System.out.println("Fehler beim Erstellen der Pizza: "+e.getMessage());
        }*/

    }

    @Override
    public void update(Pizza pizza, int id) {

        String query = "update pizza set id = ?, name = ?, price = ? where id = ?;";

        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setLong(1, id);
            ResultSet resultSet = pstmt.executeQuery();
        } catch (SQLException e) {
            System.out.println("Fehler beim Update der Pizzas: " + e.getMessage());
        }

        /*try (Statement statement = connection.createStatement()){
            statement.executeUpdate("update pizza set id = "+pizza.getId()+", name = "+pizza.getName()+", price = "+pizza.getPrice()+" where id = "+id+";");
        } catch (SQLException e) {
            System.out.println("Fehler beim Update der Tabelle: "+e.getMessage());
        }*/
    }

    @Override
    public void delete(int id) {

        String query = "delete from pizza where id = ?;";

        try {
            PreparedStatement psmtmt = connection.prepareStatement(query);
            psmtmt.setLong(1, id);
            ResultSet resultSet = psmtmt.executeQuery();
        } catch (SQLException e) {
            System.out.println("Fehler beim Löschen von Inhalten: " + e.getMessage());
        }

        /*try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("delete from pizza where id = "+id+";");
        } catch (SQLException e) {
            System.out.println("Löschen: "+e.getMessage());
        }*/
    }


}

