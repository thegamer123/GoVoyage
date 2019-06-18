/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entite.AgenceReservationFullModel;
import entite.Vol;
import entite.VolReservation;
import utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class ServiceVol {

    Connection con = DataSource.getInstance().getConnection();
    Statement ste;

    public List<Vol> readAll() {

        List<Vol> list = new ArrayList<>();
        try {
            ste = con.createStatement();
            ResultSet reseSet = ste.executeQuery("select * from vol ");

            while (reseSet.next()) {
                int id_vol = reseSet.getInt("id_vol");
                int nb_escale = reseSet.getInt("nb_escale");
                String prix = reseSet.getString("prix");
                String origine = reseSet.getString("origine");
                String destination = reseSet.getString("destination");
                String heureDepart = reseSet.getString("heureDepart");
                String heureArrive = reseSet.getString("heureArrive");
                String depart = reseSet.getString("depart");
                String arrivee = reseSet.getString("arrivee");
                int id_agence = reseSet.getInt("id_agence");

                list.add(new Vol(id_vol, nb_escale, prix, origine, destination, heureDepart, heureArrive, depart, arrivee, id_agence));

            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return list;
    }

    public List<Vol> readAllByAgenceId(String agenceID) {

        List<Vol> list = new ArrayList<>();
        try {
            ste = con.createStatement();
            ResultSet reseSet = ste.executeQuery("select * from vol where id_agence=" + agenceID);

            while (reseSet.next()) {
                int id_vol = reseSet.getInt("id_vol");
                int nb_escale = reseSet.getInt("nb_escale");
                String prix = reseSet.getString("prix");
                String origine = reseSet.getString("origine");
                String destination = reseSet.getString("destination");
                String heureDepart = reseSet.getString("heureDepart");
                String heureArrive = reseSet.getString("heureArrive");
                String depart = reseSet.getString("depart");
                String arrivee = reseSet.getString("arrivee");
                int id_agence = reseSet.getInt("id_agence");

                list.add(new Vol(id_vol, nb_escale, prix, origine, destination, heureDepart, heureArrive, depart, arrivee, id_agence));

            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return list;
    }

    public List<Vol> readOrderByPriceAsc() {

        List<Vol> list = new ArrayList<>();
        try {
            ste = con.createStatement();
            ResultSet reseSet = ste.executeQuery("select * from vol order by prix ASC ");

            while (reseSet.next()) {
                int id_vol = reseSet.getInt("id_vol");
                int nb_escale = reseSet.getInt("nb_escale");
                String prix = reseSet.getString("prix");
                String origine = reseSet.getString("origine");
                String destination = reseSet.getString("destination");
                String heureDepart = reseSet.getString("heureDepart");
                String heureArrive = reseSet.getString("heureArrive");
                String depart = reseSet.getString("depart");
                String arrivee = reseSet.getString("arrivee");
                int id_agence = reseSet.getInt("id_agence");

                list.add(new Vol(id_vol, nb_escale, prix, origine, destination, heureDepart, heureArrive, depart, arrivee, id_agence));

            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return list;
    }

    public List<Vol> readOrderByPriceDsc() {

        List<Vol> list = new ArrayList<>();
        try {
            ste = con.createStatement();
            ResultSet reseSet = ste.executeQuery("select * from vol order by prix DESC ");

            while (reseSet.next()) {
                int id_vol = reseSet.getInt("id_vol");
                int nb_escale = reseSet.getInt("nb_escale");
                String prix = reseSet.getString("prix");
                String origine = reseSet.getString("origine");
                String destination = reseSet.getString("destination");
                String heureDepart = reseSet.getString("heureDepart");
                String heureArrive = reseSet.getString("heureArrive");
                String depart = reseSet.getString("depart");
                String arrivee = reseSet.getString("arrivee");
                int id_agence = reseSet.getInt("id_agence");

                list.add(new Vol(id_vol, nb_escale, prix, origine, destination, heureDepart, heureArrive, depart, arrivee, id_agence));

            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return list;
    }

    public List<Vol> lireParCritereRecherche(String origine, String destination, String datedeprt) {

        List<Vol> list = new ArrayList<>();
        try {
            ste = con.createStatement();
            ResultSet reseSet = ste.executeQuery("select * from vol where origine='" + origine + "' and destination='" + destination + "' and depart='" + datedeprt + "'");
            //and destination='"+destination+"' and depart='"+datedeprt+"'

            while (reseSet.next()) {

                int id_vol = reseSet.getInt("id_vol");
                int nb_escale = reseSet.getInt("nb_escale");
                String prix = reseSet.getString("prix");
                String from = reseSet.getString("origine");
                String to = reseSet.getString("destination");
                String heureDepart = reseSet.getString("heureDepart");
                String heureArrive = reseSet.getString("heureArrive");
                String depart = reseSet.getString("depart");
                String arrivee = reseSet.getString("arrivee");
                int id_agence = reseSet.getInt("id_agence");

                list.add(new Vol(id_vol, nb_escale, prix, from, to, heureDepart, heureArrive, depart, arrivee, id_agence));

            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        System.out.println("list = " + list);
        return list;
    }

    public List<AgenceReservationFullModel> readAllReservationByAgenceId(String userId, String idVol) {

        List<AgenceReservationFullModel> list = new ArrayList<>();
        try {
            ste = con.createStatement();
            String query = "select id_vol_reservation ,"
                    + "vol_reservation.id_user ,"
                    + " vol_reservation.id_vol,"
                    + "date_depart_vol_reservation,"
                    + "date_arrivée_hotel_reservation,"
                    + "heure_dapart_hotel_reservation,"
                    + "heure_arrivee_hotel_reservation,"
                    + "prix,"
                    + "nb_escale,"
                    + "origine,"
                    + "destination"
                    + ",nom_user,"
                    + "prenom_user,"
                    + "tel_user"
                    + " from vol_reservation ,"
                    + "vol,"
                    + "user where  vol.id_vol =vol_reservation.id_vol and  vol.id_vol ='" + idVol + "' and user.id_user='" + userId + "'";

            System.out.println("where vol_reservation.id_vol ='" + idVol + "' and user.id_user='" + userId + "'");
            PreparedStatement preparedStatement = con.prepareStatement(query);
            // preparedStatement.setString(1, idVol);
            // preparedStatement.setString(2, userId);
            ResultSet reseSet = ste.executeQuery(query);

            while (reseSet.next()) {
                int id_vol_reservation = reseSet.getInt("id_vol_reservation");
                int id_user = reseSet.getInt("id_user");
                int id_vol = reseSet.getInt("id_vol");
                String date_depart_vol_reservation = reseSet.getString("date_depart_vol_reservation");
                String date_arrivée_hotel_reservation = reseSet.getString("date_arrivée_hotel_reservation");
                String heure_dapart_hotel_reservation = reseSet.getString("heure_dapart_hotel_reservation");
                String heure_arrivee_hotel_reservation = reseSet.getString("heure_arrivee_hotel_reservation");
                int nb_escale = reseSet.getInt("nb_escale");
                String prix = reseSet.getString("prix");
                String origine = reseSet.getString("origine");
                String destination = reseSet.getString("destination");
                String nom = reseSet.getString("nom_user");
                String prenom_user = reseSet.getString("prenom_user");
                int tel_user = reseSet.getInt("tel_user");

                list.add(new AgenceReservationFullModel(id_vol_reservation,
                        id_user,
                        id_vol,
                        date_depart_vol_reservation,
                        date_arrivée_hotel_reservation,
                        heure_dapart_hotel_reservation,
                        heure_arrivee_hotel_reservation,
                        nb_escale,
                        prix,
                        origine,
                        destination,
                        nom,
                        prenom_user,
                        String.valueOf(tel_user)));

            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return list;
    }

    public boolean deleteReservation(int idReservation) {
        try {
            String deleteSQL = "DELETE FROM vol_reservation WHERE id_vol_reservation = ?";
            PreparedStatement pstmt = con.prepareStatement(deleteSQL);
            pstmt.setInt(1, idReservation);
            // execute delete SQL stetement
            pstmt.executeUpdate();
            System.out.println("Record is deleted!");
        } catch (SQLException e) {

            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    
      public int getVolCount() {
        String req = "SELECT COUNT(*) AS count FROM vol";
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
      public int addReservationVol(VolReservation reservation) {
        int test = -1;
        try {

            String query = "INSERT INTO vol_reservation"
                    + "(id_user,id_vol,date_depart_vol_reservation ,date_arrivée_hotel_reservation ,heure_dapart_hotel_reservation,heure_arrivee_hotel_reservation)"
                    + " VALUES(?,?,?,?,?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, reservation.getId_user());
            preparedStatement.setInt(2, reservation.getId_vol());
            preparedStatement.setString(3, reservation.getDate_depart_vol_reservation());
            preparedStatement.setString(4, reservation.getDate_arrivée_hotel_reservation());
            preparedStatement.setString(5, reservation.getHeure_dapart_hotel_reservation());
            preparedStatement.setString(6, reservation.getHeure_arrivee_hotel_reservation());
            
           
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

        public int getVolReservationCount() {
        String req = "SELECT COUNT(*) AS count FROM vol_reservation";
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
