/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entite;

/**
 *
 * @author admin
 */
public class Favoris {
    int id_favoris;
     int id_user;
     int id_offre;
      public Favoris(){
          
      }

    public Favoris(int id_favoris, int id_user, int id_offre) {
        this.id_favoris = id_favoris;
        this.id_user = id_user;
        this.id_offre = id_offre;
    }

    public int getId_favoris() {
        return id_favoris;
    }

    public int getId_user() {
        return id_user;
    }

    public int getId_offre() {
        return id_offre;
    }

    public void setId_favoris(int id_favoris) {
        this.id_favoris = id_favoris;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setId_offre(int id_offre) {
        this.id_offre = id_offre;
    }

    public void supprimer(Favoris f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
}

