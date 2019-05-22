/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GoVoyage.entite;

/**
 *
 * @author ASUS
 */
public class Renseignement {
    private int id_hotel ;
    private String nom_hotel;
    private int id_user;
    private String adr_hotel;
    private String img_hotel;
    int nbr_etoile_class;
    int id_chambre;
    int num_chambre;
    int tel_chambre;
    private int id_reservation;
    private int id_offre;
    private int date_debut;
    private int date_fin;
    int id_categorie ;
    String descrip_categorie;

    float prix;

    public Renseignement() {
    }

    public Renseignement(int id_hotel, String nom_hotel, int id_user, String adr_hotel, String img_hotel, int nbr_etoile_class, int id_chambre, int num_chambre, int tel_chambre, int id_reservation, int id_offre, int date_debut, int date_fin, int id_categorie, String descrip_categorie, float prix) {
        this.id_hotel = id_hotel;
        this.nom_hotel = nom_hotel;
        this.id_user = id_user;
        this.adr_hotel = adr_hotel;
        this.img_hotel = img_hotel;
        this.nbr_etoile_class = nbr_etoile_class;
        this.id_chambre = id_chambre;
        this.num_chambre = num_chambre;
        this.tel_chambre = tel_chambre;
        this.id_reservation = id_reservation;
        this.id_offre = id_offre;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.id_categorie = id_categorie;
        this.descrip_categorie = descrip_categorie;
        this.prix = prix;
    }

    public int getId_hotel() {
        return id_hotel;
    }

    public String getNom_hotel() {
        return nom_hotel;
    }

    public int getId_user() {
        return id_user;
    }

    public String getAdr_hotel() {
        return adr_hotel;
    }

    public String getImg_hotel() {
        return img_hotel;
    }

    public int getNbr_etoile_class() {
        return nbr_etoile_class;
    }

    public int getId_chambre() {
        return id_chambre;
    }

    public int getNum_chambre() {
        return num_chambre;
    }

    public int getTel_chambre() {
        return tel_chambre;
    }

    public int getId_reservation() {
        return id_reservation;
    }

    public int getId_offre() {
        return id_offre;
    }

    public int getDate_debut() {
        return date_debut;
    }

    public int getDate_fin() {
        return date_fin;
    }

    public int getId_categorie() {
        return id_categorie;
    }

    public String getDescrip_categorie() {
        return descrip_categorie;
    }

    public float getPrix() {
        return prix;
    }

    public void setId_hotel(int id_hotel) {
        this.id_hotel = id_hotel;
    }

    public void setNom_hotel(String nom_hotel) {
        this.nom_hotel = nom_hotel;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setAdr_hotel(String adr_hotel) {
        this.adr_hotel = adr_hotel;
    }

    public void setImg_hotel(String img_hotel) {
        this.img_hotel = img_hotel;
    }


    public void setNbr_etoile_class(int nbr_etoile_class) {
        this.nbr_etoile_class = nbr_etoile_class;
    }

    public void setId_chambre(int id_chambre) {
        this.id_chambre = id_chambre;
    }

    public void setNum_chambre(int num_chambre) {
        this.num_chambre = num_chambre;
    }

    public void setTel_chambre(int tel_chambre) {
        this.tel_chambre = tel_chambre;
    }

    public void setId_reservation(int id_reservation) {
        this.id_reservation = id_reservation;
    }

    public void setId_offre(int id_offre) {
        this.id_offre = id_offre;
    }

    public void setDate_debut(int date_debut) {
        this.date_debut = date_debut;
    }

    public void setDate_fin(int date_fin) {
        this.date_fin = date_fin;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

    public void setDescrip_categorie(String descrip_categorie) {
        this.descrip_categorie = descrip_categorie;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }
    
    
}
