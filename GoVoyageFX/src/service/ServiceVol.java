/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entite.Vol;
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
                String type_vol = reseSet.getString("type_vol");
                int nb_escale = reseSet.getInt("nb_escale");
                float prix = reseSet.getInt("prix");
                int nb_pax_max = reseSet.getInt("nb_pax_max");
                String origine = reseSet.getString("origine");
                String destination = reseSet.getString("destination");
                String heureDepart = reseSet.getString("heureDepart");
                String heureArrive = reseSet.getString("heureArrive");

                list.add(new Vol(id_vol, type_vol, nb_escale, prix, nb_pax_max, origine, destination, heureDepart, heureArrive));

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

                String type_vol = reseSet.getString("type_vol");

                int nb_escale = reseSet.getInt("nb_escale");
                float prix = reseSet.getInt("prix");
                int nb_pax_max = reseSet.getInt("nb_pax_max");
                String origine = reseSet.getString("origine");
                String destination = reseSet.getString("destination");
                String heureDepart = reseSet.getString("heureDepart");
                String heureArrive = reseSet.getString("heureArrive");

                list.add(new Vol(id_vol, type_vol, nb_escale, prix, nb_pax_max, origine, destination, heureDepart, heureArrive));

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

                String type_vol = reseSet.getString("type_vol");

                int nb_escale = reseSet.getInt("nb_escale");
                float prix = reseSet.getInt("prix");
                int nb_pax_max = reseSet.getInt("nb_pax_max");
                String origine = reseSet.getString("origine");
                String destination = reseSet.getString("destination");
                String heureDepart = reseSet.getString("heureDepart");
                String heureArrive = reseSet.getString("heureArrive");

                list.add(new Vol(id_vol, type_vol, nb_escale, prix, nb_pax_max, origine, destination, heureDepart, heureArrive));

            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return list;
    }

    public List<Vol> lireParCritereRecherche(String origine, String destination, int datedeprt) {

        List<Vol> list = new ArrayList<>();
        try {
            ste = con.createStatement();
            ResultSet reseSet = ste.executeQuery("select * from vol where origine='" + origine + "' and destination='" + destination + "' and depart='" + datedeprt + "'");
            //and destination='"+destination+"' and depart='"+datedeprt+"'

            while (reseSet.next()) {
                int id_vol = reseSet.getInt("id_vol");

                String type_vol = reseSet.getString("type_vol");

                int nb_escale = reseSet.getInt("nb_escale");
                float prix = reseSet.getInt("prix");
                int nb_pax_max = reseSet.getInt("nb_pax_max");
                String origine1 = reseSet.getString("origine");
                String destination1 = reseSet.getString("destination");
                String heureDepart = reseSet.getString("heureDepart");
                String heureArrive = reseSet.getString("heureArrive");
                String dateDepart = reseSet.getString("depart");
                list.add(new Vol(id_vol, type_vol, nb_escale, prix, nb_pax_max, origine1, destination1, heureDepart, heureArrive, dateDepart));

            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        System.out.println("list = " + list);
        return list;
    }
}
