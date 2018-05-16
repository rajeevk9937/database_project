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
public class student_info {
    
    private int s_id;
    private String s_fname;
    private String s_lname;
    private Date s_dob;
    private Date s_doj;
    private long s_mobile;
    private String s_email;
    private String s_status;
    private int isparent;
   
    
    public student_info(){
        
    }
    public student_info(int s_id,String s_fname,String s_lname,Date s_dob,Date s_doj,long s_mobile,String s_email,int isparent){
        this.s_id = s_id;
        this.s_fname = s_fname;
        this.s_lname = s_lname;
        this.s_dob = s_dob;
        this.s_doj = s_doj;
        this.s_mobile = s_mobile;
        this.s_email = s_email;
      //  this.age=age;
       // this.s_status = s_status;
        this.isparent=isparent;
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
   }
     public int getisparent() {
        return isparent;
    }

    public void setisparent(int isparent) {
        this.isparent = isparent;
   }

    public String getS_fname() {
        return s_fname;
    }

    public void setS_fname(String s_fname) {
        this.s_fname = s_fname;
    }

    public String getS_lname() {
        return s_lname;
    }

    public void setS_lname(String s_lname) {
        this.s_lname = s_lname;
    }

    public Date getS_dob() {
        return s_dob;
    }

    public void setS_dob(Date s_dob) {
        this.s_dob = s_dob;
    }

    public Date getS_doj() {
        return s_doj;
    }

    public void setS_doj(Date s_doj) {
        this.s_doj = s_doj;
    }

    public long getS_mobile() {
        return s_mobile;
    }

    public void setS_mobile(long s_mobile) {
        this.s_mobile = s_mobile;
    }

    public String getS_email() {
        return s_email;
    }

    public void setS_email(String s_email) {
        this.s_email = s_email;
    }

    public String getS_status() {
        return s_status;
    }

    public void setS_status(String s_status) {
        this.s_status = s_status;
    }
    
}


