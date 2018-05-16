/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigbossclub.DbClass.ClassAttendance;

public class Classes {
   
    private int c_id;
    private String c_level;
    private String c_day;
    private String c_time;

    public Classes(){
        
    }
    public Classes( int c_id, String c_level, String c_day, String c_time) {
        this.c_id = c_id;
        this.c_level = c_level;
        this.c_day = c_day;
        this.c_time = c_time;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }
    
    public String getC_level() {
        return c_level;
    }

    public void setC_level(String c_level) {
        this.c_level = c_level;
    }

    public String getC_day() {
        return c_day;
    }

    public void setC_day(String c_day) {
        this.c_day = c_day;
    }

    public String getC_time() {
        return c_time;
    }

    public void setC_time(String c_time) {
        this.c_time = c_time;
    }
    
    
}
