/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entite.HotelOffer;
import entite.HotelReservation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DataSource;

/**
 *
 * @author Lenovo
 */
public class ReservationHotelService {

    Connection con = DataSource.getInstance().getConnection();
    Statement ste;

    public boolean addReservation(HotelReservation h) {
        boolean test = false;
        try {
            String query = "INSERT INTO hotel_reservation"
                    + " VALUES(NULL,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, h.getDate_debut_hotel_reservation());
            preparedStatement.setString(2, h.getDate_fin_hotel_reservation());
            preparedStatement.setInt(3, h.getEnfant_hotel_reservation());
            preparedStatement.setInt(4, h.getAdulte_hotel_reservation());
            preparedStatement.setString(5, String.valueOf(h.getNuit_hotel_reservation()));
            preparedStatement.setInt(6, h.getId_user());
            preparedStatement.setInt(7, h.getId_hotel_offre());
            int va = preparedStatement.executeUpdate();
            if (va > 0) {
                test = true;
                return test;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return test;
    }

    public boolean deleteRservation(int id) {
        try {
            String query = "DELETE FROM hotel_reservation WHERE id_hotel_reservation=?";
            PreparedStatement preparedStatement = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, id);
            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
