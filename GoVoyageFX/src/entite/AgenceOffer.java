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
public class AgenceOffer {
    
    private int id_offre_agence;
    private String titre_offre_agence;
    private String photo_offre_agence;
    private String description_offre_agence;
    private String date_debut_dispo;
    private String date_fin_dispo;
    private String prix;
    private int id_agence;

    public AgenceOffer(int id_offre_agence, String titre_offre_agence, String photo_offre_agence, String description_offre_agence, String date_debut_dispo, String date_fin_dispo, String prix, int id_agence) {
        this.id_offre_agence = id_offre_agence;
        this.titre_offre_agence = titre_offre_agence;
        this.photo_offre_agence = photo_offre_agence;
        this.description_offre_agence = description_offre_agence;
        this.date_debut_dispo = date_debut_dispo;
        this.date_fin_dispo = date_fin_dispo;
        this.prix = prix;
        this.id_agence = id_agence;
    }

    public int getId_offre_agence() {
        return id_offre_agence;
    }

    public void setId_offre_agence(int id_offre_agence) {
        this.id_offre_agence = id_offre_agence;
    }

    public String getTitre_offre_agence() {
        return titre_offre_agence;
    }

    public void setTitre_offre_agence(String titre_offre_agence) {
        this.titre_offre_agence = titre_offre_agence;
    }

    public String getPhoto_offre_agence() {
        return photo_offre_agence;
    }

    public void setPhoto_offre_agence(String photo_offre_agence) {
        this.photo_offre_agence = photo_offre_agence;
    }

    public String getDescription_offre_agence() {
        return description_offre_agence;
    }

    public void setDescription_offre_agence(String description_offre_agence) {
        this.description_offre_agence = description_offre_agence;
    }

    public String getDate_debut_dispo() {
        return date_debut_dispo;
    }

    public void setDate_debut_dispo(String date_debut_dispo) {
        this.date_debut_dispo = date_debut_dispo;
    }

    public String getDate_fin_dispo() {
        return date_fin_dispo;
    }

    public void setDate_fin_dispo(String date_fin_dispo) {
        this.date_fin_dispo = date_fin_dispo;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public int getId_agence() {
        return id_agence;
    }

    public void setId_agence(int id_agence) {
        this.id_agence = id_agence;
    }
    
    
    
}
