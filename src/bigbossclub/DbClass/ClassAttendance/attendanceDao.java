/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigbossclub.DbClass.ClassAttendance;

import java.util.List;


public interface attendanceDao {
    
    public List<attendance> getAllattendance();
    
    public void addAttendance(attendance value);
  
    public attendance getAttendance(int id);
    
    public List<attendance> getAttendanceClass(int c_id);
    
    public List<attendance> getAttendanceStudent(int s_id);
    
    public void updateAttendance(attendance value);
    
    public void deleteAttendance(int id);
    
}
