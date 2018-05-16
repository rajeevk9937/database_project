/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigbossclub.DbClass.Rank;

import java.util.List;

/**
 *
 * @author viswa
 */
public interface ProgressDao {
    
    public List<Progress> getAllProgress();
    
    public void addProgress(Progress value);
    
    public List<Progress> getrankProgress(int Rank_r_id);
    
    public List<Progress> getstudentProgress(int s_id);
    
    public Progress getProgress(int id);
    
    public void updateProgress(Progress value);
    
    public void deleteProg(int id);
    
}
