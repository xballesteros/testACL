package cl.xballesteros.testrest.services;

import cl.xballesteros.testrest.mappers.TareaMapper;
import cl.xballesteros.testrest.model.Tarea;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    TareaMapper tareaMapper;

    public Tarea getTarea(Integer id_tarea) {
        return tareaMapper.tarea(id_tarea);
    }

    public ArrayList<Tarea> getTareas() {
        return tareaMapper.tareas();
    }

    public void insert(String descripcion) {
        tareaMapper.insert(descripcion);
    }

    public void desactivar(Integer id) {
        tareaMapper.desactivar(id);
    }

    public void delete(Integer id) {
        tareaMapper.delete(id);
    }

    public void editar(Integer id, String descripcion) {
        System.out.println(id + " " + descripcion);
        tareaMapper.editar(id, descripcion);
    }

}
