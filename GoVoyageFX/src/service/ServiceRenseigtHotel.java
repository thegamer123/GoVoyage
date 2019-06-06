/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entite.Hotel;
import entite.Renseignement;
import utils.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class ServiceRenseigtHotel {

    private List<Renseignement> listRensHotel;
    Connection con = DataSource.getInstance().getConnection();
    Statement ste;

    public List<Hotel> readAll() {
        List<Hotel> list = new ArrayList<>();
        try {
            ste = con.createStatement();
            ResultSet reseSet = ste.executeQuery("select * from Renseignement  ");

            while (reseSet.next()) {
                int id_hotel = reseSet.getInt("id_hotel");
                String nom_hotel = reseSet.getString("nom_hotel");

                int id_user = reseSet.getInt("id_user");
                String adr_hotel = reseSet.getString("adr_hotel");
                String img_hotel = reseSet.getString("img_hotel");

                String nbr_etoile_class = reseSet.getString("nbr_etoile_class");
                int id_chambre = reseSet.getInt("id_chambre");
                int num_chambre = reseSet.getInt("num_chambre");
                int tel_chambre = reseSet.getInt("tel_chambre");
                int id_reservation = reseSet.getInt("id_reservation");
                int id_offre = reseSet.getInt("id_offre");
                int date_debut = reseSet.getInt("date_debut");
                int date_fin = reseSet.getInt("date_fin");
                int id_categorie = reseSet.getInt("id_categorie");
                String descrip_categorie = reseSet.getString("descrip_categorie");
                String prix = reseSet.getString("prix");
                int id_availabe = reseSet.getInt("is_available_hotel");

                list.add(new Hotel(id_hotel,
                        nom_hotel,
                        id_user,
                        id_availabe,
                        adr_hotel,
                        nbr_etoile_class,
                        num_chambre,
                        prix,
                        img_hotel
                ));

            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        System.out.println("list = " + list);
        return list;
    }

    public List<Hotel> lireParNbStars(int nbr_etoile) {

        List<Hotel> list = new ArrayList<>();
        try {
            ste = con.createStatement();
            ResultSet reseSet = ste.executeQuery("select * from renseignement where nbr_etoile_class='" + nbr_etoile + "' ");
            //and destination='"+destination+"' and depart='"+datedeprt+"'

            while (reseSet.next()) {
                int id_hotel = reseSet.getInt("id_hotel");
                String nom_hotel = reseSet.getString("nom_hotel");

                int id_user = reseSet.getInt("id_user");
                String adr_hotel = reseSet.getString("adr_hotel");
                String img_hotel = reseSet.getString("img_hotel");

                String nbr_etoile_class = reseSet.getString("nbr_etoile_class");
                int id_chambre = reseSet.getInt("id_chambre");
                int num_chambre = reseSet.getInt("num_chambre");
                int tel_chambre = reseSet.getInt("tel_chambre");
                int id_reservation = reseSet.getInt("id_reservation");
                int id_offre = reseSet.getInt("id_offre");
                int date_debut = reseSet.getInt("date_debut");
                int date_fin = reseSet.getInt("date_fin");
                int id_categorie = reseSet.getInt("id_categorie");
                String descrip_categorie = reseSet.getString("descrip_categorie");
                String prix = reseSet.getString("prix");
                int id_availabe = reseSet.getInt("is_available_hotel");

                list.add(new Hotel(id_hotel,
                        nom_hotel,
                        id_user,
                        id_availabe,
                        adr_hotel,
                        nbr_etoile_class,
                        num_chambre,
                        prix,
                        img_hotel
                ));

            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        System.out.println("list = " + list);
        return list;
    }

}
