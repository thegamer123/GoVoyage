/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;


import Interface.I_Reclamation;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.ZoneOffset;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DataSource;
import entite.Reclamation;
import entite.RepondReclamation;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;

/**
 *
 * @author lenovo
 */
public class ReclamationService implements I_Reclamation<Reclamation> {

    PreparedStatement ste;
    private TableColumn col;
    ObservableList<ObservableList> reclamation;
    DataSource DS;
    //private TableColumn col;
    //ObservableList<ObservableList> reclamation;

    public ReclamationService() {
        DS = DataSource.getInstance();
    }

    public void addRec(Reclamation r) {
        try {
//            String req = "INSERT INTO reclamation(id_reclamation,type,reference,etat,description,sujet,date,image) VALUES(?,?,?,?,?,?,?,?)";
        String req = "INSERT INTO reclamation(id_reclamation,type,reference,id_user,etat,description,sujet,date,image) VALUES(?,?,?,?,?,?,?,?,?)";
            ste = DS.getConnection().prepareStatement(req);

            ste.setInt(1, r.getId_reclamation());
            ste.setString(2, r.getType());
            ste.setString(3, r.getReference());
            ste.setInt(4, r.getId_user());
            ste.setString(5, r.getEtat());
            ste.setString(6, r.getDescription());
            ste.setString(7, r.getSujet());
            ste.setTimestamp(8, Timestamp.from(r.getDate().toInstant(ZoneOffset.ofHours(0))));
            ste.setString(9, r.getImage());

            ste.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }

    @Override
    public void deleteRec(int id) {
              try {
            String req ="DELETE FROM reclamation WHERE id_reclamation=?";
            ste = DS.getConnection().prepareStatement(req);
            ste.setInt(1,id);
            ste.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateRec(int id, Reclamation r) {
    }

    @Override
    public List<Reclamation> getAll() {
       
              List<Reclamation> list =new ArrayList<Reclamation>();
    try {
              String req ="SELECT * FROM reclamation ";
             ste = DS.getConnection().prepareStatement(req);
             
              ResultSet rs =ste.executeQuery();
              while(rs.next()){
                  list.add(new Reclamation(rs.getInt("id_reclamation"),rs.getTimestamp("date").toLocalDateTime(),
                          rs.getString("type"), rs.getString("reference"),rs.getInt("id_user"),
                          rs.getString("etat"),rs.getString("description"),
                            rs.getString("sujet"),rs.getString("image")));
              }
            
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
         
        }   
    return list;
    }
    
     public List<Reclamation> getSome(String txtSearch){
        List<Reclamation> list =new ArrayList<>();
    try {
              String req ="SELECT *"
                    + " FROM reclamation where reference like '%"+txtSearch+"%' order by id_reclamation desc";
             ste = DS.getConnection().prepareStatement(req);
             
              ResultSet rs =ste.executeQuery();
              while(rs.next()){
                  
                  list.add(new Reclamation(rs.getInt("id_reclamation"),rs.getTimestamp("date").toLocalDateTime(),
                          rs.getString("type"), rs.getString("reference"),rs.getInt("id_user"),
                          rs.getString("etat"),rs.getString("description"),
                            rs.getString("sujet"),rs.getString("image")));
              }
            
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
         
        }   
    
    return list;
    }
     
     
     
     
     public int Calculertotal2() {
        String req = "SELECT COUNT(*) FROM reclamation ";
        RepondReclamation etat = null;
        int nombreLignes = 0;
        try {
             ste = DS.getConnection().prepareStatement(req);
           // ps = connection.prepareStatement(req);
            ResultSet resultSet = ste.executeQuery();
            while(resultSet.next()){
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
              ste = DS.getConnection().prepareStatement(req);;
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
