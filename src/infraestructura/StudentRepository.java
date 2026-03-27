/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package infraestructura;

import dominio.Student;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class StudentRepository {
    private static List<Student> dataSource = new ArrayList<>();
    
    public void save(Student student){
        dataSource.add(student);
    }
    
    public List<Student> findAll(){
        return dataSource;
    }
    
    public void delete(String code){
        dataSource.removeIf(student ->
        student.getCode().equals(code));
    }
    
    public void update(Student updatedStudent){
        for(int i = 0; i<dataSource.size();i++){
            if(dataSource.get(i).getCode()
                    .equals(updatedStudent.getCode())){
               dataSource.set(i,updatedStudent);
               break;
            }
        }
    }
}
