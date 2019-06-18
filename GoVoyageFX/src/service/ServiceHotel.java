/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entite.Hotel;
import entite.HotelOffer;
import entite.RepondReclamation;

import utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/**
 *
 * @author ASUS
 */
public class ServiceHotel {

    private List<Hotel> listHotel;
    Connection con = DataSource.getInstance().getConnection();
    Statement ste;

    public List<Hotel> readAll() {
        List<Hotel> list = new ArrayList<>();
        try {
            ste = con.createStatement();
            ResultSet reseSet = ste.executeQuery("select * from hotel ");

            while (reseSet.next()) {
                int id_hotel = reseSet.getInt("id_hotel");
                String nom_hotel = reseSet.getString("nom_hotel");
                int disponibilite = reseSet.getInt("is_available_hotel");
                int id_user = reseSet.getInt("id_user");
                String img = reseSet.getString("img_hotel");
                String Adresse_hotel = reseSet.getString("Adresse_hotel");
                String stars_hotel = reseSet.getString("stars_hotel");
                int chambre_hotel = reseSet.getInt("chambre_hotel");
                String prix_hotel = reseSet.getString("prix_hotel");
//              int id_hotel, String nom_hotel, int id_user, int is_available_hotel, String Adresse_hotel, String stars_hotel, int chambre_hotel, String prix_hotel, String img_hotel)

                list.add(new Hotel(id_hotel, nom_hotel, id_user, disponibilite, Adresse_hotel, stars_hotel, chambre_hotel, prix_hotel, img));

            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return list;
    }

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
     public boolean deleteReservationHotel(int reservationId) {
        try {
            String deleteSQL = "DELETE FROM hotel_reservation WHERE id_hotel_reservation = ?";
            PreparedStatement pstmt = con.prepareStatement(deleteSQL);
            pstmt.setInt(1, reservationId);
            // execute delete SQL stetement
            pstmt.executeUpdate();
            System.out.println("Record is deleted!");
        } catch (SQLException e) {

            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }


    public List<HotelOffer> readAllOffersByHotelId(String hotelId) {
        List<HotelOffer> list = new ArrayList<>();
        try {
            ste = con.createStatement();
            ResultSet reseSet = ste.executeQuery("select * from hotel_offre Where id_hotel =" + hotelId);
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

    public int getHotelCount() {
        String req = "SELECT COUNT(*) AS count FROM hotel_offre";
        int nombreLignes = 0;
        try {
            ste = con.prepareStatement(req);
            ResultSet resultSet = ste.executeQuery(req);
            while (resultSet.next()) {
                nombreLignes = resultSet.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nombreLignes;
    }

        public int getHotelReservationCount() {
        String req = "SELECT COUNT(*) AS count FROM hotel_reservation";
        int nombreLignes = 0;
        try {
            ste = con.prepareStatement(req);
            ResultSet resultSet = ste.executeQuery(req);
            while (resultSet.next()) {
                nombreLignes = resultSet.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nombreLignes;
    }
    
}
