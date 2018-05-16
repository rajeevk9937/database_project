/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigbossclub.DbClass.Student;

import java.util.List;


public interface student_infoDao {
    
    public List<student_info> getAllStudents();
    
    public void addStudent(student_info student);
    
    public student_info getStudent(int s_id);
    
    public void updateStudent(student_info student);
    
    public void deleteStudent(int s_id);
}
