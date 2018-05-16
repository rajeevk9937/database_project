/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigbossclub.DbClass.Student;

import java.sql.Date;



/**
 *
 * @author Mithi
 */
public class history {
    
    private int id;
    private String reason;
    private float paid;
    private Date paid_date;
    private int hisfk_sid;

    public history(){
        
    }    
   
    public history(String reason, float paid, Date paid_date, int hisfk_sid) {
        this.reason = reason;
        this.paid = paid;
        this.paid_date = paid_date;
        this.hisfk_sid = hisfk_sid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public float getPaid() {
        return paid;
    }

    public void setPaid(float paid) {
        this.paid = paid;
    }

    public Date getPaid_date() {
        return paid_date;
    }

    public void setPaid_date(Date paid_date) {
        this.paid_date = paid_date;
    }

    public int getHisfk_sid() {
        return hisfk_sid;
    }

    public void setHisfk_sid(int hisfk_sid) {
        this.hisfk_sid = hisfk_sid;
    }
    
}
