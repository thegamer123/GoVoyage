/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GoVoyage.service;

import com.GoVoyage.entite.Hotel;
import com.GoVoyage.entite.Renseignement;
import com.GoVoyage.utiles.DataSource;
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
    
     public List <Renseignement> readAll()
    {
       List <Renseignement> list=new ArrayList<>();
        try {
          ste=con.createStatement();
            ResultSet reseSet = ste.executeQuery("select * from Renseignement  ");
           
           while (reseSet.next()) {
                int id_hotel = reseSet.getInt("id_hotel");
                String nom_hotel = reseSet.getString("nom_hotel");

               int id_user=reseSet.getInt("id_user");
               String adr_hotel=reseSet.getString("adr_hotel");
                 String img_hotel= reseSet.getString("img_hotel");
               
                int nbr_etoile_class = reseSet.getInt("nbr_etoile_class");
                int id_chambre = reseSet.getInt("id_chambre");
                int num_chambre = reseSet.getInt("num_chambre");
                int tel_chambre = reseSet.getInt("tel_chambre");
                int id_reservation = reseSet.getInt("id_reservation");
                int id_offre = reseSet.getInt("id_offre");
                int date_debut = reseSet.getInt("date_debut");
                int date_fin = reseSet.getInt("date_fin");
                int id_categorie = reseSet.getInt("id_categorie");
                String descrip_categorie = reseSet.getString("descrip_categorie");
                 Float prix = reseSet.getFloat("prix");
   
               list.add(new Renseignement( id_hotel,  nom_hotel,  id_user,  adr_hotel, 
                        img_hotel,  nbr_etoile_class,  id_chambre, 
                        num_chambre,  tel_chambre,  id_reservation,  id_offre,  date_debut,
                        date_fin,  id_categorie,  descrip_categorie,  prix));

           }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    
    return list;
    }
           public List <Renseignement> lireParCritereRecherche( String destination, int datedebut,int datefin)
    {
        
       List<Renseignement> list=new ArrayList<>();
        try {
          ste=con.createStatement();
            ResultSet reseSet = ste.executeQuery("select * from renseignement where adr_hotel='"+destination+"' and date_debut='"+datedebut+"' and date_fin='"+datefin+"'");
            //and destination='"+destination+"' and depart='"+datedeprt+"'
           
           while (reseSet.next()) {
                       int id_hotel = reseSet.getInt("id_hotel");
                String nom_hotel = reseSet.getString("nom_hotel");

               int id_user=reseSet.getInt("id_user");
               String adr_hotel=reseSet.getString("adr_hotel");
                 String img_hotel= reseSet.getString("img_hotel");
               
                int nbr_etoile_class = reseSet.getInt("nbr_etoile_class");
                int id_chambre = reseSet.getInt("id_chambre");
                int num_chambre = reseSet.getInt("num_chambre");
                int tel_chambre = reseSet.getInt("tel_chambre");
                int id_reservation = reseSet.getInt("id_reservation");
                int id_offre = reseSet.getInt("id_offre");
                int date_debut = reseSet.getInt("date_debut");
                int date_fin = reseSet.getInt("date_fin");
                int id_categorie = reseSet.getInt("id_categorie");
                String descrip_categorie = reseSet.getString("descrip_categorie");
                 Float prix = reseSet.getFloat("prix");
   
               list.add(new Renseignement( id_hotel,  nom_hotel,  id_user,  adr_hotel, 
                        img_hotel,  nbr_etoile_class,  id_chambre, 
                        num_chambre,  tel_chambre,  id_reservation,  id_offre,  date_debut,
                        date_fin,  id_categorie,  descrip_categorie,  prix));

           }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
     System.out.println("list = "+list);
    return list;
    }
        public List <Renseignement> lireParNbStars( int nbr_etoile)
    {
        
       List<Renseignement> list=new ArrayList<>();
        try {
          ste=con.createStatement();
            ResultSet reseSet = ste.executeQuery("select * from renseignement where nbr_etoile_class='"+nbr_etoile+"' ");
            //and destination='"+destination+"' and depart='"+datedeprt+"'
           
           while (reseSet.next()) {
                       int id_hotel = reseSet.getInt("id_hotel");
                String nom_hotel = reseSet.getString("nom_hotel");

               int id_user=reseSet.getInt("id_user");
               String adr_hotel=reseSet.getString("adr_hotel");
                 String img_hotel= reseSet.getString("img_hotel");
               
                int nbr_etoile_class = reseSet.getInt("nbr_etoile_class");
                int id_chambre = reseSet.getInt("id_chambre");
                int num_chambre = reseSet.getInt("num_chambre");
                int tel_chambre = reseSet.getInt("tel_chambre");
                int id_reservation = reseSet.getInt("id_reservation");
                int id_offre = reseSet.getInt("id_offre");
                int date_debut = reseSet.getInt("date_debut");
                int date_fin = reseSet.getInt("date_fin");
                int id_categorie = reseSet.getInt("id_categorie");
                String descrip_categorie = reseSet.getString("descrip_categorie");
                 Float prix = reseSet.getFloat("prix");
   
               list.add(new Renseignement( id_hotel,  nom_hotel,  id_user,  adr_hotel, 
                        img_hotel,  nbr_etoile_class,  id_chambre, 
                        num_chambre,  tel_chambre,  id_reservation,  id_offre,  date_debut,
                        date_fin,  id_categorie,  descrip_categorie,  prix));

           }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
     System.out.println("list = "+list);
    return list;
    }
    
}
