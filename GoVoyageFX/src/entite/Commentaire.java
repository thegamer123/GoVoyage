/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

/**
 *
 * @author aessegh
 */
public class Commentaire {

    private int id_commentaire;
    private String corps;
    private int id_offre;
    private int id_user;

    public Commentaire() {
    }

    public Commentaire(int id_commentaire, String corps, int id_offre, int id_user) {
        this.id_commentaire = id_commentaire;
        this.corps = corps;
        this.id_offre = id_offre;
        this.id_user = id_user;
    }

    public int getId_commentaire() {
        return id_commentaire;
    }

    public void setId_commentaire(int id_commentaire) {
        this.id_commentaire = id_commentaire;
    }

    public String getCorps() {
        return corps;
    }

    public void setCorps(String corps) {
        this.corps = corps;
    }

    public int getId_offre() {
        return id_offre;
    }

    public void setId_offre(int id_offre) {
        this.id_offre = id_offre;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

}
