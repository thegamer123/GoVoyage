/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entite.Hotel;
import entite.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import utils.DataSource;

/**
 *
 * @author Lenovo
 */
public class ServiceHotel {

    Connection con = DataSource.getInstance().getConnection();

    public int addHotel(Hotel hotel) {
        int test = -1;
        try {

            String query = "INSERT INTO hotel"
                    + "(nom_hotel,id_user,is_available_hotel ,Adresse_hotel ,stars_hotel,chambre_hotel,prix_hotel)"
                    + " VALUES(?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, hotel.getNom_hotel());
            preparedStatement.setInt(2, hotel.getId_user());
            preparedStatement.setInt(3, hotel.getIs_available_hotel());
            preparedStatement.setString(4, hotel.getAdresse_hotel());
            preparedStatement.setString(5, hotel.getStars_hotel());
            preparedStatement.setInt(6, hotel.getChambre_hotel());
            preparedStatement.setString(7, hotel.getPrix_hotel());
            int va = preparedStatement.executeUpdate();
            if (va > 0) {
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    test = generatedKeys.getInt(1);
                    System.out.println(test);
                } else {
                    throw new SQLException("Creating failed, no ID obtained.");
                }

            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return test;
    }

}
