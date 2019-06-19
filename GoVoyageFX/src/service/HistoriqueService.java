/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import GUI.LoginController;
import entite.Reclamation;
import entite.Historique;
import Interface.IService;
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
public class HistoriqueService implements IService<Historique>{

    DataSource ds=DataSource.getInstance();
    PreparedStatement ste;
    @Override
    public void add(Historique h) {
        try {
            String req ="INSERT INTO historique(action,date,id_user) VALUES(?,?,?)";
            ste = ds.getConnection().prepareStatement(req);
            ste.setString(1, h.getAction());            
            ste.setTimestamp(2, Timestamp.from(h.getDate().toInstant(ZoneOffset.ofHours(0))));
            ste.setInt(3, h.getId_user());
            System.out.println(LoginController.result.getId_user());
            ste.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HistoriqueService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void remove(int id) {
           try {
            String req ="DELETE FROM historique WHERE id=?";
            ste = ds.getConnection().prepareStatement(req);
            ste.setInt(1,id);
            ste.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HistoriqueService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    @Override
    public void update(int id, Historique t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Historique> getAll() {
         List<Historique> list =new ArrayList<Historique>();
    try {
              String req ="SELECT * FROM historique order by date desc";
             ste = ds.getConnection().prepareStatement(req);
             
              ResultSet rs =ste.executeQuery();
              while(rs.next()){
         list.add(new Historique(rs.getInt("id"), rs.getString("action"), rs.getTimestamp("date").toLocalDateTime(), rs.getInt("id_user")));

              }
            
        } catch (SQLException ex) {
            Logger.getLogger(HistoriqueService.class.getName()).log(Level.SEVERE, null, ex);
         
        }   
    return list;  }

        
 public List<Historique> getSome(String txtSearch){
        List<Historique> list =new ArrayList<>();
    try {
              String req ="SELECT *" + " FROM historique where action like '%"+txtSearch+"%' order by date desc";
//               "SELECT *"+ " FROM repondreclamation where sujet like '%" + txtSearch + "%' order by date desc";
             ste = ds.getConnection().prepareStatement(req);
             
              ResultSet rs =ste.executeQuery();
              while(rs.next()){
                  
         list.add(new Historique(rs.getInt("id_user"), rs.getString("action"), rs.getTimestamp("date").toLocalDateTime(), rs.getInt("id_user")));

              }
            
        } catch (SQLException ex) {
            Logger.getLogger(HistoriqueService.class.getName()).log(Level.SEVERE, null, ex);
         
        }   
    
    return list;
    }
 
    
}
