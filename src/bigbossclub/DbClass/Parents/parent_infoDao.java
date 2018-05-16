/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigbossclub.DbClass.Parents;
import java.util.List;

/**
 *
 * @author Mithi
 */
public interface parent_infoDao {
 
    public List<parent_info> getAllparents();
    
    public List<parent_info> getUserparents(int s_id);
    
    public void addParent(parent_info parent);
    
    public parent_info getParent(int p_id);
    
    public void updateParent(parent_info parent);
    
    public void deleteParent(int s_id);
    
}

