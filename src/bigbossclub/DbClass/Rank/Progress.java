/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigbossclub.DbClass.Rank;

import java.sql.Date;

public class Progress {
    
    private Date pr_date;
    private int progfk_sid;
    private int progfk_rid;
    private int id;
    
    public Progress (){
        
    }
    public Progress(Date pr_date, int progfk_sid, int progfk_rid) {
        this.pr_date = pr_date;
        this.progfk_sid = progfk_sid;
        this.progfk_rid = progfk_rid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public Date getPr_date() {
        return pr_date;
    }

    public void setPr_date(Date pr_date) {
        this.pr_date = pr_date;
    }

    public int getProgfk_sid() {
        return progfk_sid;
    }

    public void setProgfk_sid(int progfk_sid) {
        this.progfk_sid = progfk_sid;
    }

    public int getProgfk_rid() {
        return progfk_rid;
    }

    public void setProgfk_rid(int progfk_rid) {
        this.progfk_rid = progfk_rid;
    }
    
    
    
}