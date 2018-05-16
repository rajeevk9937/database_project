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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class rank {
    
    private int r_id;
   // private String r_name;
    private String r_belt;
    
    public rank(){
        
    }

    public rank(int r_id, String r_belt) {
        this.r_id = r_id;
      //  this.r_name = r_name;
        this.r_belt = r_belt;
    }

    public int getR_id() {
        return r_id;
    }

    public void setR_id(int r_id) {
        this.r_id = r_id;
    }

  /*  public String getR_name() {
        return r_name;
    }

    public void setR_name(String r_name) {
        this.r_name = r_name;
    }*/

    public String getR_belt() {
        return r_belt;
    }

    public void setR_belt(String r_belt) {
        this.r_belt = r_belt;
    }
    
    
    
}

