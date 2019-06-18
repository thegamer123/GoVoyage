/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import GUI.HotelOfferDetailScreenController;
import GUI.LoginController;
import GUI.Reclamation.HelloReclamationController;
import entite.RepondReclamation;
import Interface.I_Reclamation;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DataSource;

/**
 *
 * @author omar
 */
public class RepondReclamationService implements I_Reclamation<RepondReclamation> {

    DataSource ds;
    PreparedStatement ste;

    public RepondReclamationService() {
        ds = DataSource.getInstance();
    }

    public void addRec(RepondReclamation t) {
        try {

            String req = "INSERT INTO repondreclamation(emailD,description,sujet,date,etat) VALUES(?,?,?,?,?)";
            
            
            ste = ds.getConnection().prepareStatement(req);
            ste.setString(1, LoginController.result.getEmail_user());

            ste.setString(2, t.getDescription());

       ste.setString(3, t.getSujet());
            ste.setTimestamp(4, Timestamp.from(t.getDate().toInstant(ZoneOffset.ofHours(0))));
            ste.setString(5, t.getEtat());
            ste.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteRec(int id) {
        try {
            String req = "DELETE FROM repondreclamation WHERE id_repondre=?";
            ste = ds.getConnection().prepareStatement(req);
            ste.setInt(1, id);
            ste.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateRec(int id, RepondReclamation t) {
    }

    @Override
    public List<RepondReclamation> getAll() {
        List<RepondReclamation> list = new ArrayList<RepondReclamation>();
        try {
            String req = "SELECT * FROM repondreclamation ";
            ste = ds.getConnection().prepareStatement(req);

            ResultSet rs = ste.executeQuery();
            while (rs.next()) {

                list.add(new RepondReclamation(rs.getInt("id_repondre"), rs.getString("description"), rs.getString("sujet"), rs.getString("emailD"), rs.getTimestamp("date").toLocalDateTime(), rs.getString("etat")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);

        }
        return list;
    }

    public List<RepondReclamation> getSome(String txtSearch) {
        List<RepondReclamation> list = new ArrayList<>();
        try {
            String req = "SELECT *"
                    + " FROM repondreclamation where sujet like '%" + txtSearch + "%' order by date desc";
            ste = ds.getConnection().prepareStatement(req);

            ResultSet rs = ste.executeQuery();
            while (rs.next()) {

                list.add(new RepondReclamation(rs.getInt("id_repondre"), rs.getString("description"), rs.getString("sujet"), rs.getString("emailD"), rs.getTimestamp("date").toLocalDateTime(), rs.getString("etat")));

            }

        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);

        }

        return list;
    }

//   -------------------------------------------Statitstique-------- 
    public int Calculertotal() {
        String req = "SELECT COUNT(*) FROM repondreclamation ";
        RepondReclamation etat = null;
        int nombreLignes = 0;
        try {
            ste = ds.getConnection().prepareStatement(req);
            // ps = connection.prepareStatement(req);
            ResultSet resultSet = ste.executeQuery();
            while (resultSet.next()) {
                nombreLignes = resultSet.getInt(1);
            }

            // resultSet.last();
            //on récupère le numéro de la ligne 
            // nombreLignes = resultSet.getRow();
            //on replace le curseur avant la première ligne 
            // resultSet.beforeFirst();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nombreLignes;
    }

    public int Calculer(String etat) {
        String req = "SELECT COUNT(*) AS count FROM repondreclamation where etat =?";
        RepondReclamation u = null;
        int nombreLignes = 0;
        try {
            ste = ds.getConnection().prepareStatement(req);;
            ste.setString(1, etat);
            ResultSet resultSet = ste.executeQuery();
            while (resultSet.next()) {
                nombreLignes = resultSet.getInt(1);
            }
            //  resultSet.last(); 
//            //on récupère le numéro de la ligne 
            // nombreLignes = resultSet.getRow(); 
//            //on replace le curseur avant la première ligne 
            // resultSet.beforeFirst(); 

        } catch (Exception e) {
            e.printStackTrace();
        }
        return nombreLignes;
    }

    public int Calculertotal2() {
        String req = "SELECT COUNT(*) FROM reclamation ";
        RepondReclamation etat = null;
        int nombreLignes = 0;
        try {
            ste = ds.getConnection().prepareStatement(req);
            // ps = connection.prepareStatement(req);
            ResultSet resultSet = ste.executeQuery();
            while (resultSet.next()) {
                nombreLignes = resultSet.getInt(1);
            }

            // resultSet.last();
            //on récupère le numéro de la ligne 
            // nombreLignes = resultSet.getRow();
            //on replace le curseur avant la première ligne 
            // resultSet.beforeFirst();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nombreLignes;
    }

    public int Calculer2(String etat) {
        String req = "SELECT COUNT(*) AS count FROM reclamation where type =?";
        RepondReclamation u = null;
        int nombreLignes = 0;
        try {
            ste = ds.getConnection().prepareStatement(req);;
            ste.setString(1, etat);
            ResultSet resultSet = ste.executeQuery();
            while (resultSet.next()) {
                nombreLignes = resultSet.getInt(1);
            }
            //  resultSet.last(); 
//            //on récupère le numéro de la ligne 
            // nombreLignes = resultSet.getRow(); 
//            //on replace le curseur avant la première ligne 
            // resultSet.beforeFirst(); 

        } catch (Exception e) {
            e.printStackTrace();
        }
        return nombreLignes;
    }

}
