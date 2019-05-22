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
public class Hotel {

    private int id_hotel;
    private String nom_hotel;
    private int id_user;
    private int is_available_hotel;
    private String Adresse_hotel;
    private String stars_hotel;
    private int chambre_hotel;
    private String prix_hotel;
    private String img_hotel;

    public Hotel(int id_hotel, String nom_hotel, int id_user, int is_available_hotel, String Adresse_hotel, String stars_hotel, int chambre_hotel, String prix_hotel, String img_hotel) {
        this.id_hotel = id_hotel;
        this.nom_hotel = nom_hotel;
        this.id_user = id_user;
        this.is_available_hotel = is_available_hotel;
        this.Adresse_hotel = Adresse_hotel;
        this.stars_hotel = stars_hotel;
        this.chambre_hotel = chambre_hotel;
        this.prix_hotel = prix_hotel;
        this.img_hotel = img_hotel;
    }

    public String getImg_hotel() {
        return img_hotel;
    }

    public void setImg_hotel(String img_hotel) {
        this.img_hotel = img_hotel;
    }

    
    
    public int getId_hotel() {
        return id_hotel;
    }

    public void setId_hotel(int id_hotel) {
        this.id_hotel = id_hotel;
    }

    public String getNom_hotel() {
        return nom_hotel;
    }

    public void setNom_hotel(String nom_hotel) {
        this.nom_hotel = nom_hotel;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getIs_available_hotel() {
        return is_available_hotel;
    }

    public void setIs_available_hotel(int is_available_hotel) {
        this.is_available_hotel = is_available_hotel;
    }

    public String getAdresse_hotel() {
        return Adresse_hotel;
    }

    public void setAdresse_hotel(String Adresse_hotel) {
        this.Adresse_hotel = Adresse_hotel;
    }

    public String getStars_hotel() {
        return stars_hotel;
    }

    public void setStars_hotel(String stars_hotel) {
        this.stars_hotel = stars_hotel;
    }

    public int getChambre_hotel() {
        return chambre_hotel;
    }

    public void setChambre_hotel(int chambre_hotel) {
        this.chambre_hotel = chambre_hotel;
    }

    public String getPrix_hotel() {
        return prix_hotel;
    }

    public void setPrix_hotel(String prix_hotel) {
        this.prix_hotel = prix_hotel;
    }

}
