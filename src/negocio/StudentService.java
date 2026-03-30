/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import dominio.Student;
import infraestructura.StudentRepository;
import java.util.List;

/**
 *
 * @author HP
 */
public class StudentService {
    
    private StudentRepository repository 
            = new StudentRepository();
    
    public String registerStudent(Student student){
        if(student.getName().isEmpty())
            return "ERROR: El nombre es obligatorio";
        
        repository.save(student);
        return "El estudiante ha sido "
                + "agregado exitosamente";
    }
    
    public List<Student> getAllStudents(){
        return repository.findAll();
    }
    
    public String removeStudent(String code){
        if(code.isBlank())
            return "ERROR: No es un código válido";
        
        repository.delete(code);
        return "El estudiante fue removido exitosamente";
    }    
    
}
