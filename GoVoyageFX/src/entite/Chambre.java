/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

/**
 *
 * @author ASUS
 */
public class Chambre {
      int id_chambre;
    int num_chambre;
    int tel_chambre;
    int id_reservation;
 public Chambre(){
     
 }
    public Chambre(int id_chambre, int num_chambre, int tel_chambre, int id_reservation) {
        this.id_chambre = id_chambre;
        this.num_chambre = num_chambre;
        this.tel_chambre = tel_chambre;
        this.id_reservation = id_reservation;
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
    
    
    
}
