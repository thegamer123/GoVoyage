/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entite.Favoris;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.DataSource;

/**
 *
 * @author admin
 */
public class FavorisService {

    Connection con = DataSource.getInstance().getConnection();
    Statement ste;

    public boolean ajouterFavoris(Favoris f) {
        boolean test = false;
        try {
            ste = con.createStatement();
            String query = "INSERT INTO `favoris` (`id_favoris`, `id_user`, `id_offre`)"
                    + " VALUES (NULL, " + f.getId_user() + " , " + f.getId_offre() + ")";
            int va = ste.executeUpdate(query);
            if (va > 0) {
                test = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return test;
    }

    public boolean supprimerFavoris(Favoris f) {
        try {
            ste = con.createStatement();
            String query = "DELETE FROM favoris WHERE id_favoris=" + f.getId_favoris();
            int va = ste.executeUpdate(query);
            if (va > 0) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public List<Favoris> readAll() {
        List<Favoris> list = new ArrayList<>();
        try {
            ste = con.createStatement();
            ResultSet reseSet = ste.executeQuery("select * from favoris");
            while (reseSet.next()) {
                int favoris = reseSet.getInt("id_favoris");
                int user = reseSet.getInt("id_user");
                int offre = reseSet.getInt("id_offre");
                list.add(new Favoris(favoris, user, offre));
            }
        } catch (SQLException ex) {
        }
        return list;
    }

    public List<Favoris> findMyFavourites(int idUser) {
        List<Favoris> list = new ArrayList<>();
        try {
            ste = con.createStatement();
            ResultSet reseSet = ste.executeQuery("select * from favoris where id_user=" + idUser);
            while (reseSet.next()) {
                int favoris = reseSet.getInt("id_favoris");
                int user = reseSet.getInt("id_user");
                int offre = reseSet.getInt("id_offre");
                list.add(new Favoris(favoris, user, offre));
            }
        } catch (SQLException ex) {
        }
        return list;
    }
    
    public boolean checkIfOffreIsInMyFavorited(int idOffre,int idUser) {
        try {
            ste = con.createStatement();
            ResultSet resulSet = ste.executeQuery("select * from favoris where id_offre=" + idOffre + " and id_user=" + idUser);
            return resulSet.next();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
