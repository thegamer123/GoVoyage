/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

/**
 *
 * @author Lenovo
 */
public class AgenceReservationFullModel {
    
    private int id_vol_reservation;
    private int id_user;
    private int id_vol;
    private String date_depart_vol_reservation;
    private String date_arrivée_hotel_reservation;
    private String heure_dapart_hotel_reservation;
    private String heure_arrivee_hotel_reservation;
    int nb_escale;
    String prix;
    String origine;
    String destination;
    private String nom_user;
    private String prenom_user;
    private String email_user;

    public AgenceReservationFullModel(int id_vol_reservation, int id_user, int id_vol, String date_depart_vol_reservation, String date_arrivée_hotel_reservation, String heure_dapart_hotel_reservation, String heure_arrivee_hotel_reservation, int nb_escale, String prix, String origine, String destination,String nom_user, String prenom_user, String email_user) {
        this.id_vol_reservation = id_vol_reservation;
        this.id_user = id_user;
        this.id_vol = id_vol;
        this.date_depart_vol_reservation = date_depart_vol_reservation;
        this.date_arrivée_hotel_reservation = date_arrivée_hotel_reservation;
        this.heure_dapart_hotel_reservation = heure_dapart_hotel_reservation;
        this.heure_arrivee_hotel_reservation = heure_arrivee_hotel_reservation;
        this.nb_escale = nb_escale;
        this.prix = prix;
        this.origine = origine;
        this.destination = destination;
        this.nom_user = nom_user;
        this.prenom_user = prenom_user;
        this.email_user = email_user;
    }

    public int getId_vol_reservation() {
        return id_vol_reservation;
    }

    public void setId_vol_reservation(int id_vol_reservation) {
        this.id_vol_reservation = id_vol_reservation;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_vol() {
        return id_vol;
    }

    public void setId_vol(int id_vol) {
        this.id_vol = id_vol;
    }

    public String getDate_depart_vol_reservation() {
        return date_depart_vol_reservation;
    }

    public void setDate_depart_vol_reservation(String date_depart_vol_reservation) {
        this.date_depart_vol_reservation = date_depart_vol_reservation;
    }

    public String getDate_arrivée_hotel_reservation() {
        return date_arrivée_hotel_reservation;
    }

    public void setDate_arrivée_hotel_reservation(String date_arrivée_hotel_reservation) {
        this.date_arrivée_hotel_reservation = date_arrivée_hotel_reservation;
    }

    public String getHeure_dapart_hotel_reservation() {
        return heure_dapart_hotel_reservation;
    }

    public void setHeure_dapart_hotel_reservation(String heure_dapart_hotel_reservation) {
        this.heure_dapart_hotel_reservation = heure_dapart_hotel_reservation;
    }

    public String getHeure_arrivee_hotel_reservation() {
        return heure_arrivee_hotel_reservation;
    }

    public void setHeure_arrivee_hotel_reservation(String heure_arrivee_hotel_reservation) {
        this.heure_arrivee_hotel_reservation = heure_arrivee_hotel_reservation;
    }

    public int getNb_escale() {
        return nb_escale;
    }

    public void setNb_escale(int nb_escale) {
        this.nb_escale = nb_escale;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getOrigine() {
        return origine;
    }

    public void setOrigine(String origine) {
        this.origine = origine;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }



    public String getNom_user() {
        return nom_user;
    }

    public void setNom_user(String nom_user) {
        this.nom_user = nom_user;
    }

    public String getPrenom_user() {
        return prenom_user;
    }

    public void setPrenom_user(String prenom_user) {
        this.prenom_user = prenom_user;
    }

    public String getEmail_user() {
        return email_user;
    }

    public void setEmail_user(String email_user) {
        this.email_user = email_user;
    }

    
}
