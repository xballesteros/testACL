package cl.xballesteros.testrest.controller;

import cl.xballesteros.testrest.model.Tarea;
import cl.xballesteros.testrest.services.TestService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.text.ParseException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.springframework.validation.annotation.Validated;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@Validated
//@Api(tags = "Tareas", description = "Operaciones relacionadas con las tareas")

public class MainController {

    @Autowired
    TestService testService;

    //@ApiOperation(value = "Obtener una tarea por ID")
    @RequestMapping(value = "getTarea", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<String> getTarea(
            @RequestParam(value = "id_tarea", required = true) Integer id_tarea) throws ParseException {

        Tarea tareaData = testService.getTarea(id_tarea);

        JSONObject tareaJson = new JSONObject();
        tareaJson.put("id", tareaData.getId());
        tareaJson.put("descripcion", tareaData.getDescripcion());
        tareaJson.put("fechaCreacion", tareaData.getFechaCreacion());

        return new ResponseEntity(tareaJson.toString(), HttpStatus.OK);
    }

    //@ApiOperation(value = "Obtener todas las tareas")
    @RequestMapping(value = "getTareas", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<String> getTareas() throws ParseException {

        ArrayList<Tarea> tareaData = testService.getTareas();
        JSONArray tareasArray = new JSONArray();

        for (Tarea tarea : tareaData) {
            JSONObject tareaJson = new JSONObject();
            tareaJson.put("id", tarea.getId());
            tareaJson.put("descripcion", tarea.getDescripcion());
            tareaJson.put("fechaCreacion", tarea.getFechaCreacion());
            tareasArray.put(tareaJson);
        }

        return new ResponseEntity(tareasArray.toString(), HttpStatus.OK);
    }

    //@ApiOperation(value = "Insertar una nueva tarea")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<String> insert(@RequestParam("descripcion") String descripcion) throws ParseException {
        try {
            testService.insert(descripcion);
            return new ResponseEntity<>("Tarea insertada", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
        }
    }

    //@ApiOperation(value = "Desactivar una tarea activa")
    @RequestMapping(value = "desactivar", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<String> desactivar(@RequestParam("id") Integer id) throws ParseException {
        try {
            testService.desactivar(id);
            return new ResponseEntity<>("Tarea quitada", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
        }
    }

    //@ApiOperation(value = "Eliminar una tarea")
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<String> delete(@RequestParam("id") Integer id) throws ParseException {
        try {
            testService.delete(id);
            return new ResponseEntity<>("Tarea eliminada", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
        }
    }

    //@ApiOperation(value = "Editar una tarea")
    @RequestMapping(value = "editar", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<String> editar(@RequestParam("id") Integer id, @RequestParam("descripcion") String descripcion) throws ParseException {
        try {
            testService.editar(id, descripcion);
            return new ResponseEntity<>("Tarea editada", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
        }
    }

}
