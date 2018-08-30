package org.test.webapp.project.persistence;

import org.test.webapp.project.dto.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOjdbc implements OrderDAO {

    private Connection connection;

    public OrderDAOjdbc() {
        try {
            this.connection = ConnectionFactory.createDBConnection("localhost", 3306, "pizzashop", "root", "alqpym55skdj");
        } catch (SQLException e) {
            System.out.println("Fehler beim Erstellen der Connection: " + e.getMessage());
        }
    }

    @Override
    public List<Order> getOrders() {

        List<Order> orders = new ArrayList<>();

        String query = "select * from bestellung;";

        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            ResultSet resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                Date date = resultSet.getDate("date");
                orders.add(new Order(id, address, phone, date));
            }
        } catch (SQLException e) {
            System.out.println("Fehler, keine Informationen zu den Bestellungen erhalten: " + e.getMessage());
        }
        return orders;

        /*try (Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery("select * from bestellung;");

            while(resultSet.next()){
                Long id = resultSet.getLong("id");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                Date date = resultSet.getDate("date");
                orders.add(new Order(id, address, phone, date));
            }
        } catch (SQLException e) {
            System.out.println("Fehler beim Zurückgeben der Liste: "+e.getMessage());
        }
        return orders;*/
    }

    @Override
    public Order getOrderById(int id) {
        Order order = null;

        String query = "select * from bestellung where id = " + id + ";";

        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            ResultSet resultSet = pstmt.executeQuery();

            Long tempId = resultSet.getLong("id");
            String address = resultSet.getString("address");
            String phone = resultSet.getString("phone");
            Date date = resultSet.getDate("date");

            order = new Order(tempId, address, phone, date);
        } catch (SQLException e) {
            System.out.println("Fehler beim Erhalten von Bestellungen per Id: " + e.getMessage());
        }
        return order;

        /*try(Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery("select * from bestellung where id = "+id+";");
            Long tempId = resultSet.getLong("id");
            String address = resultSet.getString("address");
            String phone = resultSet.getString("phone");
            Date date = resultSet.getDate("date");

            order = new Order(tempId, address, phone, date);
        } catch (SQLException e) {
            System.out.println("Fehler beim Erhalten der Bestellung per Id: "+e.getMessage());
        }
        return order;*/
    }

    @Override
    public void create(Order order) {

        String query = "insert into bestellung (id, address, phone, date) values (" + order.getId() + ", " + order.getAddress() + ", " + order.getPhone() + ", " + order.getDate() + ";";

        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            ResultSet resultSet = pstmt.executeQuery();
        } catch (SQLException e) {
            System.out.println("Fehler beim Erstellen von Bestellungen: " + e.getMessage());
        }

        /*try (Statement statement = connection.createStatement()){
            statement.executeUpdate("insert into bestellung (id, address, phone, date) values ("+order.getId()+", "+order.getAddress()+", "+order.getPhone()+", "+order.getDate()+";)");
        } catch (SQLException e) {
            System.out.println("Fehler beim Erstellen von Bestellungen: "+e.getMessage());
        }*/
    }

    @Override
    public void update(Order order, int id) {

        String query = "update bestellung set id = " + order.getId() + ", address = " + order.getAddress() + ", phone = " + order.getPhone() + ", date = " + order.getDate() + " where id = " + id + ";";

        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            ResultSet resultSet = pstmt.executeQuery();
        } catch (SQLException e) {
            System.out.println("Fehler beim Update von den Bestellungen: " + e.getMessage());
        }

        /*try (Statement statement = connection.createStatement()){
            statement.executeUpdate("update bestellung set id = "+order.getId()+", address = "+order.getAddress()+", phone = "+order.getPhone()+", date = "+order.getDate()+" where id = "+id+";");
        } catch (SQLException e) {
            System.out.println("Fehler beim Update von den Bestellungen: "+e.getMessage());
        }*/
    }

    @Override
    public void delete(int id) {

        String query = "delete from bestellung where id = " + id + ";";

        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            ResultSet resultSet = pstmt.executeQuery();
        } catch (SQLException e) {
            System.out.println("Fehler beim Löschen von Inhalten: " + e.getMessage());
        }

        /*try (Statement statement = connection.createStatement()){
            statement.executeUpdate("delete from bestellung where id = "+id+";");
        } catch (SQLException e) {
            System.out.println("Fehler beim Löschen von Inhalten: "+e.getMessage());
        }*/
    }


}