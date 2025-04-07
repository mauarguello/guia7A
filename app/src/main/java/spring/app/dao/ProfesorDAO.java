package spring.app.dao;

import java.util.List;

import spring.app.model.Profesor;

public interface ProfesorDAO {
    void save(Profesor profesor);
    Profesor findById(String id);
    List<Profesor> findAll();
    void update(Profesor profesor);
    void delete(String id);
}
