package cl.xballesteros.testrest.mappers;

import cl.xballesteros.testrest.model.Producto;
import java.util.ArrayList;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

@Service
public interface ProductoMapper {

    @Select("SELECT * FROM producto WHERE id = #{id_producto};")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "descripcion", column = "descripcion"),
        @Result(property = "precio", column = "precio")
    })
    public Producto producto(@Param("id_producto") Integer id_producto);
    
        @Select("SELECT * FROM producto;")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "descripcion", column = "descripcion"),
        @Result(property = "precio", column = "precio")
    })
    public ArrayList<Producto> productos();

}
