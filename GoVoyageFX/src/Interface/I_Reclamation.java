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
    
    public void addRec(T t);
    public void deleteRec(int id );
    public void updateRec(int id ,T t);
    public List<T> getAll();
}
