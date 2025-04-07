package spring.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import spring.app.model.Profesor;
import spring.app.dao.ProfesorDAO;
@Service
public class ProfesorService {
    
    private final ProfesorDAO profesorDAO;


    public ProfesorService(ProfesorDAO profesorDAO) {
        this.profesorDAO = profesorDAO;
    }

    public void add(Profesor profesor){
        profesorDAO.save(profesor);
    }

    public List<Profesor> listar(){
        return profesorDAO.findAll();
    }

    public Profesor consultar(String id){
        return profesorDAO.findById(id);
    }

    public void eliminar(String id){
        profesorDAO.delete(id);
    }

    public void actualizar(Profesor profesor){
        profesorDAO.update(profesor);
    }
}