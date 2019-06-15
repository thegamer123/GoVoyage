/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entite.Commentaire;
import entite.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import utils.DataSource;

/**
 *
 * @author aessegh
 */
public class ServiceCommentaire {

    Connection con = DataSource.getInstance().getConnection();
    Statement ste;

    public boolean ajouterCommentaire(Commentaire c) {
        boolean com = false;
        try {
            ste = con.createStatement();
            String query = "INSERT INTO `Commentaire` (`id_commentaire`, `corps`, `id_offre`, `id_user`)"
                    + " VALUES (NULL, '" + c.getCorps() + "', " + c.getId_offre() + ", " + c.getId_user() + ")";
            int va = ste.executeUpdate(query);
            if (va > 0) {
                com = true;
                System.out.println("insertion reussie");
            } else {
                System.out.println("insertion echoue");
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return com;
    }

    public boolean SuppressionCommentaire(int id_commentaire) {
        boolean sup = false;
        try {
            ste = con.createStatement();
            PreparedStatement statement = con.prepareStatement("DELETE FROM commentaire WHERE id_commentaire = ?");
            statement.setInt(1, id_commentaire);
            int va = statement.executeUpdate();

            if (va > 0) {
                sup = true;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return sup;

    }

    public boolean ModifierCommentaire(Commentaire c) {
        boolean com = false;
        try {
            ste = con.createStatement();
            String query = "update  `Commentaire` SET corps='" + c.getCorps() + "' where id_commentaire='" + c.getId_commentaire() + "'";

            int va = ste.executeUpdate(query);
            if (va > 0) {
                com = true;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return com;
    }

    public boolean afficherCommentaire(Commentaire c) {
        boolean aff = false;
        try {
            ste = con.createStatement();

            //  String query = "select *from `Commentaire` coprs)";
            ResultSet reseSet = ste.executeQuery("select * from Commentaire INNER JOIN user on Commentaire.id_user=user.id_user ");
            //ResultSet reseSet = ste.executeQuery("select * from Commentaire id_commentaire");
//  int va = ste.executeUpdate(ResultSet);
            while (reseSet.next()) {

                // int commentaire = reseSet.getInt("id_commentaire");
                String nom = reseSet.getString("nom_user");
                String prenom = reseSet.getString("prenom_user");
                String corps = reseSet.getString("corps");

            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return aff;
    }

    public List<User> SelectionnerUtilisateur(Commentaire c) {
        List<User> list = new ArrayList<>();
        boolean aff = false;
        try {
            ste = con.createStatement();

            ResultSet reseSet = ste.executeQuery("select * from user INNER JOIN user on Commentaire.id_user=user.id_user ");
            while (reseSet.next()) {

                int iduser = reseSet.getInt("id_user");;
                String nom = reseSet.getString("nom_user");
                String prenom = reseSet.getString("prenom_user");
                String corps = reseSet.getString("corps");
                list.add(new User(iduser, nom, prenom));

            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return list;
    }

    public List<Commentaire> readAll() {
        List<Commentaire> list = new ArrayList<>();

        try {
            ste = con.createStatement();
            ResultSet reseSet = ste.executeQuery("select * from Commentaire INNER JOIN user on Commentaire.id_user=user.id_user ");

            while (reseSet.next()) {
                int commentaire = reseSet.getInt("id_commentaire");
                int offre = reseSet.getInt("id_offre");
                int user = reseSet.getInt("id_user");
                String corps = reseSet.getString("corps");
                String nom = reseSet.getString("nom_user");
                String prenom = reseSet.getString("prenom_user");
                list.add(new Commentaire(commentaire, corps, offre, user));
            }
        } catch (SQLException ex) {
        }

        return list;
    }

    public List<Commentaire> findMyCommentairesByOffre(int Offre,int id_user) {
        List<Commentaire> list = new ArrayList<>();

        try {
            ste = con.createStatement();
            ResultSet reseSet = ste.executeQuery("select * from Commentaire WHERE id_offre=" + Offre+" and id_user="+ id_user);

            while (reseSet.next()) {
                int commentaire = reseSet.getInt("id_commentaire");
                int offre = reseSet.getInt("id_offre");
                int user = reseSet.getInt("id_user");
                String corps = reseSet.getString("corps");
                list.add(new Commentaire(commentaire, corps, offre, user));
            }
        } catch (SQLException ex) {
        }

        return list;
    }
}
