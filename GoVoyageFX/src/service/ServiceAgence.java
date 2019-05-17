/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entite.Agence;
import entite.AgenceOffer;
import entite.Hotel;
import entite.HotelOffer;
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
public class ServiceAgence {

    Connection con = DataSource.getInstance().getConnection();

    public int addAgence(Agence agence) {
        int test = -1;
        try {

            String query = "INSERT INTO agence"
                    + "(nom_agence,id_user,adresse_agence)"
                    + " VALUES(?,?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, agence.getNom_agence());
            preparedStatement.setInt(2, agence.getId_user());
            preparedStatement.setString(3, agence.getAdresse_agence());

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

    public boolean addOfferToHotel(AgenceOffer h) {
        boolean test = false;
        try {

            String query = "INSERT INTO offre_agence"
                    + "(titre_offre_agence,photo_offre_agence,description_offre_agence ,date_debut_dispo ,date_fin_dispo,prix,id_agence)"
                    + " VALUES(?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, h.getTitre_offre_agence());
            preparedStatement.setString(2, h.getPhoto_offre_agence());
            preparedStatement.setString(3, h.getDescription_offre_agence());
            preparedStatement.setString(4, h.getDate_debut_dispo());
            preparedStatement.setString(5, h.getDate_fin_dispo());
            preparedStatement.setString(6, h.getPrix());
            preparedStatement.setInt(7, h.getId_agence());
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

}
