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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DataSource;


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

    

    public List<HotelReservation> readAllOffersByHotelId(String id_hotel_offre) {
        List<HotelReservation> list = new ArrayList<>();
        try {
            ste = con.createStatement();
            ResultSet reseSet = ste.executeQuery("select * from hotel_reservation where id_hotel_offre =" + id_hotel_offre);
            while (reseSet.next()) {
                int id_hotel_reservation = reseSet.getInt("id_hotel_reservation");
                String date_debut_hotel_reservation = reseSet.getString("date_debut_hotel_reservation");
                String date_fin_hotel_reservation = reseSet.getString("date_fin_hotel_reservation");
                int enfant_hotel_reservation = reseSet.getInt("enfant_hotel_reservation");
                int adulte_hotel_reservation = reseSet.getInt("adulte_hotel_reservation");
                int nuit_hotel_reservation = reseSet.getInt("nuit_hotel_reservation");
                int id_user = reseSet.getInt("id_user");
                int id_hotel_offre_reservation = reseSet.getInt("id_hotel_offre");
                list.add(new HotelReservation(id_hotel_reservation,
                        date_debut_hotel_reservation,
                        date_fin_hotel_reservation,
                        enfant_hotel_reservation,
                        adulte_hotel_reservation,
                        nuit_hotel_reservation,
                        id_user,
                        id_hotel_offre_reservation));

            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return list;
    }

}
