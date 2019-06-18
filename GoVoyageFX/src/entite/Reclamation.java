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
    private String type;
    private  String reference;
    private  int id_user;
    private  String etat;
    private String description;
    private String sujet;
    private  LocalDateTime date = LocalDateTime.now();
    private String image;

    public Reclamation(int id_reclamation,LocalDateTime date, String type, String reference, int id_user, String etat, String description, String sujet,String image) {
        this.id_reclamation = id_reclamation;
        this.date=date;
        this.type = type;
        this.reference = reference;
        this.id_user = id_user;
        this.etat = etat;
        this.description = description;
        this.sujet = sujet;
        this.image=image;
    }
    

    public Reclamation(String type, String reference, String description, int id_user,  String sujet, String image) {
        this.type = type;
        this.reference = reference;
        this.id_user=id_user;
        this.description = description;
        this.sujet = sujet;
        this.image = image;
        
    }

    public Reclamation(LocalDateTime date, String type, String reference, int id_user, String etat, String description, String sujet,String image) {
        this.date=date;
        this.type = type;
        this.reference = reference;
        this.id_user = id_user;
        this.etat = etat;
        this.description = description;
        this.sujet = sujet;
        this.image=image;
    }

    public Reclamation(String text, String text0, int id_user, String text1, String text2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_reclamation() {
        return id_reclamation;
    }

    public void setId_reclamation(int id_reclamation) {
        this.id_reclamation = id_reclamation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
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

    public Reclamation(int id_reclamation, String type, String reference, int id_user, String etat, String description, String sujet,String image) {
        this.id_reclamation = id_reclamation;
        this.type = type;
        this.reference = reference;
        this.id_user = id_user;
        this.etat = etat;
        this.description = description;
        this.sujet = sujet;
        this.image=image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "id_reclamation=" + id_reclamation + ", type=" + type + ", reference=" + reference + ", id_user=" + id_user + ", etat=" + etat + ", description=" + description + ", sujet=" + sujet + ", date=" + date +", image=" + image + '}';
    }

    public Reclamation() {
    }
    
}
