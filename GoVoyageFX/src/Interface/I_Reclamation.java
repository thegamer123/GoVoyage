/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interface;

import java.util.List;

/**
 *
 * @author lenovo
 * @param <T>
 */
public interface I_Reclamation<T> {
    
    public void ajoutReclamation(T t);
    public void suppressionReclamation(int id );
    public void majReclamation(int id ,T t);
    public List<T> affichage();
}
