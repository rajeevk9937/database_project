/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigbossclub.DbClass.Parents;

/**
 *
 * @author viswa
 */
public class parent_info {
    
    private int p_id;
    private String p_fname;
    private String p_lname;
    private String p_relation;
    private Long p_mobile;
    private String p_email;
    private int parentfk_s_sid;

    public parent_info(){
    }
    public parent_info( String p_fname, String p_lname, String p_relation, Long p_mobile, String p_email, int parentfk_s_sid) {
        
        this.p_fname = p_fname;
        this.p_lname = p_lname;
        this.p_relation = p_relation;
        this.p_mobile = p_mobile;
        this.p_email = p_email;
        this.parentfk_s_sid = parentfk_s_sid;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public String getP_fname() {
        return p_fname;
    }

    public void setP_fname(String p_fname) {
        this.p_fname = p_fname;
    }

    public String getP_lname() {
        return p_lname;
    }

    public void setP_lname(String p_lname) {
        this.p_lname = p_lname;
    }

    public String getP_relation() {
        return p_relation;
    }

    public void setP_relation(String p_relation) {
        this.p_relation = p_relation;
    }

    public long getP_mobile() {
        return p_mobile;
    }

    public void setP_mobile(long p_mobile) {
        this.p_mobile = p_mobile;
    }

    public String getP_email() {
        return p_email;
    }

    public void setP_email(String p_email) {
        this.p_email = p_email;
    }

    public int getParentfk_s_sid() {
        return parentfk_s_sid;
    }

    public void setParentfk_s_sid(int parentfk_s_sid) {
        this.parentfk_s_sid = parentfk_s_sid;
    }
    
}
