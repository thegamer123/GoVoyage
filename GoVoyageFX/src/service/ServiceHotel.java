/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GoVoyage.service;

import com.GoVoyage.entite.Hotel;

import com.GoVoyage.utiles.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/**
 *
 * @author ASUS
 */
public class ServiceHotel {
     private List<Hotel> listHotel;
    Connection con = DataSource.getInstance().getConnection();
    Statement ste;

    
    public List <Hotel> readAll()
    {
       List <Hotel> list=new ArrayList<>();
        try {
          ste=con.createStatement();
            ResultSet reseSet = ste.executeQuery("select * from hotel ");
           
           while (reseSet.next()) {
                int id_hotel = reseSet.getInt("id_hotel");

                
                String nom_hotel = reseSet.getString("nom_hotel");
              
               int disponibilite= reseSet.getInt("is_available_hotel");
               int id_user=reseSet.getInt("id_user");
                int id_chambre = reseSet.getInt("id_chambre");
                String ville = reseSet.getString("adr_hotel");
                String img= reseSet.getString("img_hotel");
//              
                  
               list.add(new Hotel(id_hotel, nom_hotel ,disponibilite,id_user,id_chambre,ville,img));

           }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    
    return list;
    }
//     public List<Reservation> read() throws SQLException{
//         List<Reservation> list=new ArrayList<>();
//         ste=con.createStatement();
////   String Requete = "SELECT Demande_Intervention.ID_Demande, Demande_Intervention.DateDemande, Criticite.Libelle_Criticite, Etat.Libelle_Etat " +
////					"FROM Demande_Intervention, Criticite, Etat " +
////					"WHERE Demande_Intervention.ID_Utilisateur = '1' AND Demande_Intervention.ID_Criticite=Criticite.ID_Criticite AND Demande_Intervention.ID_Etat=Etat.ID_Etat" +
////					"ORDER BY Demande_Intervention.ID_Demande DESC LIMIT 20";
//           
//			// Execution et recupération du résultat
//                        String Requete="SELECT hotel.id_hotel, hotel.nom_hotel,hotel.adr_hotel,hotel.img_hotel,";
//			ResultSet mon_resultat = ste.executeQuery("Requete");
//                        int i=0;
//			// Traitemant du résultat
//			//if(!mon_resultat.wasNull()){
//				while (mon_resultat.next()) {
//					list.get(i)[1] = mon_resultat.getInt("id_hotel");
//					list.get(i)[2] = "";
//					list.get(i)[3] = mon_resultat.getString(1);
// 
//					list.get(i)[4] = mon_resultat.getString(3);
// 
//					list.get(i)[5] = mon_resultat.getString(4);
//					i++;
//				}
//			//}
//        return list;
//     }
     
}
