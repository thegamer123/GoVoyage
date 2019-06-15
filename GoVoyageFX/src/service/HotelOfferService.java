/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entite.HotelOffer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import utils.DataSource;

/**
 *
 * @author admin
 */
public class HotelOfferService {

    Connection cnx;

    public HotelOfferService() {
        cnx = DataSource.getInstance().getConnection();
    }

    public HotelOffer findHotelOffer(int id) {
        try {
            Statement statement = cnx.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM hotel_offre WHERE id_offre_hotel=" + id);
            if (rs.next()) {
                HotelOffer offre = new HotelOffer();
                offre.setId_offre_hotel(rs.getInt(1));
                offre.setTitre_offre_hotel(rs.getString(2));
                offre.setPhoto_offre_hotel(rs.getString(3));
                offre.setDescription_offre_hotel(rs.getString(4));
                return offre;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        return null;
    }
}
