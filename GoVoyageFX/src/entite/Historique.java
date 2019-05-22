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
public class Historique {

    private int id;
    private String action;
    private LocalDateTime date = LocalDateTime.now();
    private int id_user;

    public Historique(String action, int id_user) {
        this.action = action;
        this.id_user = id_user;
    }

    public Historique(int id, String action, LocalDateTime date, int id_user) {
        this.id = id;
        this.action = action;
        this.date = date.minusHours(2);
        this.id_user = id_user;
    }

    public Historique() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    @Override
    public String toString() {
        return "historique{" + "id=" + id + ", action=" + action + ", date=" + date + ", id_user=" + id_user + '}';
    }

}
