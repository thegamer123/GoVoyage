/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.time.LocalDateTime;

/**
 *
 * @author omar
 */
public class RepondReclamation {
    private int id;  
    private String description;
    private String sujet;
    private String emailD;
    private LocalDateTime date=LocalDateTime.now();
    private String etat;

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public RepondReclamation(String description, String sujet, String emailD, String etat) {
        this.description = description;
        this.sujet = sujet;
        this.emailD = emailD;
        this.etat = etat;
    }

    public RepondReclamation(int id, String description, String sujet, String emailD, LocalDateTime date, String etat) {
        this.id = id;
        this.description = description;
        this.sujet = sujet;
        this.emailD = emailD;
        this.date = date;
        this.etat = etat;
    }

    public RepondReclamation(String description, String sujet, String emailD) {
        this.description = description;
        this.sujet = sujet;
        this.emailD = emailD;
    }

    public RepondReclamation(int id, String description, String sujet, String emailD, LocalDateTime date) {
        this.id = id;
        this.description = description;
        this.sujet = sujet;
        this.emailD = emailD;
        this.date = date;
    }

    public RepondReclamation(String description, String sujet, String emailD, LocalDateTime date) {
        this.description = description;
        this.sujet = sujet;
        this.emailD = emailD;
        this.date = date;
    }

    public RepondReclamation(String description, String sujet, String emailD, LocalDateTime date, String etat) {
        this.description = description;
        this.sujet = sujet;
        this.emailD = emailD;
        this.date = date;
        this.etat = etat;
    }

    public RepondReclamation(int id, String description, String sujet, String emailD) {
        this.id = id;
        this.description = description;
        this.sujet = sujet;
        this.emailD = emailD;
    }

    public RepondReclamation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEmailD() {
        return emailD;
    }

    public void setEmailD(String emailD) {
        this.emailD = emailD;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "RepondReclamation{" + "id=" + id + ", description=" + description + ", sujet=" + sujet + ", emailD=" + emailD + ", date=" + date + ", etat=" + etat + '}';
    }

    

   
}
