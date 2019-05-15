/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entite.Reclamation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import utils.DataSource;

/**
 *
 * @author lenovo
 */
public class Service_Go_Voyage {

    Connection con = DataSource.getInstance().getConnection();

    Statement ste;

    public boolean ajouterReclamation(Reclamation r) {
        boolean test = false;
        try {
            ste = con.createStatement();
            String query = "INSERT INTO `reclamation` (`id_reclamation`, `reference`, `id_user`, `etat`)"
                    + " VALUES (NULL, '" + r.getId_reclamation() + "', '"
                    + "" + r.getReference()+ "', '" + r.getId_user() + "', '" + r.getEtat() + "');";
            int va = ste.executeUpdate(query);
            if (va > 0) {
                test = true;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return test;
    }

    public void modifierReclamation(Reclamation r) {

        try {
            PreparedStatement update = con.prepareStatement("UPDATE reclamation SET name = ?, category = ?, price = ?, quantity = ? WHERE id = ?");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public List<Reclamation> getAllReclamation() {
        List<Reclamation> list = new ArrayList<>();
        try {
            ste = con.createStatement();
            ResultSet reseSet = ste.executeQuery("select * from reclamation");
            while (reseSet.next()) {
                int id_reclamation = reseSet.getInt("id");
                int reference = reseSet.getInt(2);
                int id_user = reseSet.getInt(3);
                int etat = reseSet.getInt(4);
                list.add(new Reclamation(id_reclamation, null, id_user, etat, null, null, LocalDateTime.MIN));
            }
        } catch (SQLException ex) {
        }

        return list;
    }
}
