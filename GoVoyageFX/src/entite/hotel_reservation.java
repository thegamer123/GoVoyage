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
public class hotel_reservation {

    private int id_hotel_reservation;
    private String date_debut_hotel_reservation;
    private String date_fin_hotel_reservation;
    private int enfant_hotel_reservation;
    private int adulte_hotel_reservation;
    private int nuit_hotel_reservation;
    private int id_user;
    private int id_hotel_offre;

    public int getId_hotel_reservation() {
        return id_hotel_reservation;
    }

    public void setId_hotel_reservation(int id_hotel_reservation) {
        this.id_hotel_reservation = id_hotel_reservation;
    }

    public String getDate_debut_hotel_reservation() {
        return date_debut_hotel_reservation;
    }

    public void setDate_debut_hotel_reservation(String date_debut_hotel_reservation) {
        this.date_debut_hotel_reservation = date_debut_hotel_reservation;
    }

    public String getDate_fin_hotel_reservation() {
        return date_fin_hotel_reservation;
    }

    public void setDate_fin_hotel_reservation(String date_fin_hotel_reservation) {
        this.date_fin_hotel_reservation = date_fin_hotel_reservation;
    }

    public int getEnfant_hotel_reservation() {
        return enfant_hotel_reservation;
    }

    public void setEnfant_hotel_reservation(int enfant_hotel_reservation) {
        this.enfant_hotel_reservation = enfant_hotel_reservation;
    }

    public int getAdulte_hotel_reservation() {
        return adulte_hotel_reservation;
    }

    public void setAdulte_hotel_reservation(int adulte_hotel_reservation) {
        this.adulte_hotel_reservation = adulte_hotel_reservation;
    }

    public int getNuit_hotel_reservation() {
        return nuit_hotel_reservation;
    }

    public void setNuit_hotel_reservation(int nuit_hotel_reservation) {
        this.nuit_hotel_reservation = nuit_hotel_reservation;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_hotel_offre() {
        return id_hotel_offre;
    }

    public void setId_hotel_offre(int id_hotel_offre) {
        this.id_hotel_offre = id_hotel_offre;
    }

    public hotel_reservation(int id_hotel_reservation, String date_debut_hotel_reservation, String date_fin_hotel_reservation, int enfant_hotel_reservation, int adulte_hotel_reservation, int nuit_hotel_reservation, int id_user, int id_hotel_offre) {
        this.id_hotel_reservation = id_hotel_reservation;
        this.date_debut_hotel_reservation = date_debut_hotel_reservation;
        this.date_fin_hotel_reservation = date_fin_hotel_reservation;
        this.enfant_hotel_reservation = enfant_hotel_reservation;
        this.adulte_hotel_reservation = adulte_hotel_reservation;
        this.nuit_hotel_reservation = nuit_hotel_reservation;
        this.id_user = id_user;
        this.id_hotel_offre = id_hotel_offre;
    }

}
