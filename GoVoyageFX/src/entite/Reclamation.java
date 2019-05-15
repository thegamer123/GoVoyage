/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.time.LocalDateTime;

/**
 *
 * @author lenovo
 */
public class Reclamation {

    private  int id_reclamation;
    private  String reference;
    private  int id_user;
    private  int etat;
    private String description;
    private String sujet;
    private  LocalDateTime date;

    public Reclamation(int id_reclamation, String reference, int id_user, int etat, String description, String sujet, LocalDateTime date) {
        this.id_reclamation = id_reclamation;
        this.reference = reference;
        this.id_user = id_user;
        this.etat = etat;
        this.description = description;
        this.sujet = sujet;
        this.date = date;
    }

    public int getId_reclamation() {
        return id_reclamation;
    }

    public void setId_reclamation(int id_reclamation) {
        this.id_reclamation = id_reclamation;
    }

    public String getReference() {
        return reference;
    }

    public void setId_offre(String reference) {
        this.reference = reference;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

   

   

    

}
