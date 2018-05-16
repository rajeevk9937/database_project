/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigbossclub.DbClass.ClassAttendance;

public class attendance {
    
    private int fk_c_id;
    private int attfk_s_id;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public attendance(){
    
    }
    public attendance(int fk_c_id, int attfk_s_id) {
        this.fk_c_id = fk_c_id;
        this.attfk_s_id = attfk_s_id;
    }

    public int getFk_c_id() {
        return fk_c_id;
    }

    public void setFk_c_id(int fk_c_id) {
        this.fk_c_id = fk_c_id;
    }

    public int getAttfk_s_id() {
        return attfk_s_id;
    }

    public void setAttfk_s_id(int attfk_s_id) {
        this.attfk_s_id = attfk_s_id;
    }    
}

