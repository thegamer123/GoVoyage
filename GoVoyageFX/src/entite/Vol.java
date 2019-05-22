/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.GoVoyage.entite;



/**
 *
 * @author admin
 */
public class Vol {
    int id_vol ;
    String type_vol;
   int nb_escale;
   float prix;
   int nb_pax_max;
   String origine;
   String destination;
   String heureDepart;
   String heureArrive;
   String depart;
   public Vol(){
       
   }

    public Vol(int id_vol, String type_vol, int nb_escale, float prix, int nb_pax_max, String origine, String destination, String heureDepart, String heureArrive, String depart) {
        this.id_vol = id_vol;
        this.type_vol = type_vol;
        this.nb_escale = nb_escale;
        this.prix = prix;
        this.nb_pax_max = nb_pax_max;
        this.origine = origine;
        this.destination = destination;
        this.heureDepart = heureDepart;
        this.heureArrive = heureArrive;
        this.depart = depart;
    }

    public Vol(int id_vol, String type_vol, int nb_escale, float prix, int nb_pax_max, String origine, String destination, String heureDepart, String heureArrive) {
        this.id_vol = id_vol;
        this.type_vol = type_vol;
        this.nb_escale = nb_escale;
        this.prix = prix;
        this.nb_pax_max = nb_pax_max;
        this.origine = origine;
        this.destination = destination;
        this.heureDepart = heureDepart;
        this.heureArrive = heureArrive;
    }

    public Vol(int id_vol, String type_vol, int nb_escale, float prix, int nb_pax_max, String origine, String destination) {
        this.id_vol = id_vol;
        this.type_vol = type_vol;
        this.nb_escale = nb_escale;
        this.prix = prix;
        this.nb_pax_max = nb_pax_max;
        this.origine = origine;
        this.destination = destination;
    }

 
   
    public Vol(int id_vol, String type_vol, int nb_escale, float prix, int nb_pax_max) {
        this.id_vol = id_vol;
        this.type_vol = type_vol;
        this.nb_escale = nb_escale;
        this.prix = prix;
        this.nb_pax_max = nb_pax_max;
       
    }

    public int getId_vol() {
        return id_vol;
    }

    public String getType_vol() {
        return type_vol;
    }

    public int getNb_escale() {
        return nb_escale;
    }

    public float getPrix() {
        return prix;
    }

    public int getNb_pax_max() {
        return nb_pax_max;
    }

    public void setId_vol(int id_vol) {
        this.id_vol = id_vol;
    }

    public void setType_vol(String type_vol) {
        this.type_vol = type_vol;
    }

    public void setNb_escale(int nb_escale) {
        this.nb_escale = nb_escale;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setNb_pax_max(int nb_pax_max) {
        this.nb_pax_max = nb_pax_max;
    }

    public String getOrigine() {
        return origine;
    }

    public String getDestination() {
        return destination;
    }

    public void setOrigine(String origine) {
        this.origine = origine;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getHeureDepart() {
        return heureDepart;
    }

    public String getHeureArrive() {
        return heureArrive;
    }

    public void setHeureDepart(String heureDepart) {
        this.heureDepart = heureDepart;
    }

    public void setHeureArrive(String heureArrive) {
        this.heureArrive = heureArrive;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

 
  
}
