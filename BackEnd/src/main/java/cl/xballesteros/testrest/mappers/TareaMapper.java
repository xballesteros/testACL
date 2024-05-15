package cl.xballesteros.testrest.mappers;

import cl.xballesteros.testrest.model.Tarea;
import java.util.ArrayList;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

@Service
public interface TareaMapper {

    @Select("SELECT * FROM tarea WHERE id = #{id} AND vigente;")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "descripcion", column = "descripcion"),
        @Result(property = "fechaCreacion", column = "fechaCreacion")
    })
    public Tarea tarea(@Param("id") Integer id);

    @Select("SELECT * FROM tarea WHERE vigente;")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "descripcion", column = "descripcion"),
        @Result(property = "fechaCreacion", column = "fechaCreacion")
    })
    public ArrayList<Tarea> tareas();

    @Insert("INSERT INTO tarea (descripcion) VALUES (#{descripcion})")
    @Options(flushCache = Options.FlushCachePolicy.TRUE)
    public void insert(String descripcion);

    @Update("UPDATE tarea SET vigente = false WHERE id = #{id}")
    @Options(flushCache = Options.FlushCachePolicy.TRUE)
    public void desactivar(@Param("id") Integer id);

    @Delete("DELETE FROM tarea WHERE id = #{id}")
    @Options(flushCache = Options.FlushCachePolicy.TRUE)
    public void delete(Integer id);

    @Update("UPDATE tarea SET descripcion = #{descripcion} WHERE id = #{id}")
    @Options(flushCache = Options.FlushCachePolicy.TRUE)
    public void editar(@Param("id") Integer id, @Param("descripcion") String descripcion);

}
