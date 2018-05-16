/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigbossclub.DbClass.Rank;

/**
 *
 * @author viswa
 */
import java.util.List;


public interface rankDao {
      
    public List<rank> getAllRank();
    
    public void addRank(rank value);
    
    public rank getRank(int r_id);
    
    public void updateRank(rank value);
    
    public void deleteRank(int r_id);
    
}

