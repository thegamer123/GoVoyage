/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entite.Hotel;
import entite.HotelOffer;
import entite.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.DataSource;

/**
 *
 * @author Lenovo
 */
public class ServiceHotel {

    Connection con = DataSource.getInstance().getConnection();
    Statement ste;

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

    public boolean addOfferToHotel(HotelOffer h) {
        boolean test = false;
        try {

            String query = "INSERT INTO hotel_offre"
                    + "(titre_offre_hotel,photo_offre_hotel,description_offre_hotel ,date_debut_dispo ,date_fin_dispo,prix,id_hotel)"
                    + " VALUES(?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, h.getTitre_offre_hotel());
            preparedStatement.setString(2, h.getPhoto_offre_hotel());
            preparedStatement.setString(3, h.getDescription_offre_hotel());
            preparedStatement.setString(4, h.getDate_debut_dispo());
            preparedStatement.setString(5, h.getDate_fin_dispo());
            preparedStatement.setString(6, h.getPrix());
            preparedStatement.setInt(7, h.getId_hotel());
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

    public List<HotelOffer> readAllOffers() {
        List<HotelOffer> list = new ArrayList<>();
        try {
            ste = con.createStatement();
            ResultSet reseSet = ste.executeQuery("select * from hotel_offre");
            while (reseSet.next()) {
                int id_offre_hotel = reseSet.getInt("id_offre_hotel");
                String title_offer = reseSet.getString("titre_offre_hotel");
                String photo = reseSet.getString("photo_offre_hotel");
                String description = reseSet.getString("description_offre_hotel");
                String date_debut_dispo = reseSet.getString("date_debut_dispo");
                String date_fin_dispo = reseSet.getString("date_fin_dispo");
                String prix = reseSet.getString("prix");
                int id_hotel = reseSet.getInt("id_hotel");
                list.add(new HotelOffer(id_offre_hotel, title_offer, photo, description, date_debut_dispo, date_fin_dispo, prix, id_hotel));

            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return list;
    }

    public boolean deleteOffer(int offerId) {
        try {
            String deleteSQL = "DELETE FROM hotel_offre WHERE id_offre_hotel = ?";
            PreparedStatement pstmt = con.prepareStatement(deleteSQL);
            pstmt.setInt(1, offerId);
            // execute delete SQL stetement
            pstmt.executeUpdate();
            System.out.println("Record is deleted!");
        } catch (SQLException e) {

            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

}
