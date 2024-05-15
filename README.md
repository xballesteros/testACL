# testACL
Test tecnico realizado para ACL, este test consta de 3 partes:

**1.- Script de BD MySQL:** Esto hara la creacion de la estructura de la tabla "Tarea", este script debe ser ejecutado en una BD limpia, donde nos creara la tabla especificada sin datos, conteniendo los siguientes campos: identificador[numérico], descripción [cadena], fechaCreación [fecha tiempo], vigente [booleano].

**2.- BackEnd:** El proyecto backend consta de una API REST realizada bajo Spring Boot utilizando Java 8 (1.8), esta api cosnta de 5 acciones basicas:
-	Listar tareas
-	Agregar una tarea
-	Remover una tarea
-	Desactivar una tarea
-	Editar una tarea

Para la ejecucion del proyecto bastara con montarlo en el IDE de su preferencia (Personalmente recomiendo NetBeans IDE 12.4) y utilizando como servidor Jetty puesto que viene configurado para este.

Como observacion a este punto, antes que todo debera configurar los datos de conexion a BD (Previamente cargado el script adjunto), esto se realiza en la siguiente ruta ```src/main/webapp/WEB-INF/ApplicationContext.xml```, en este bloque especificamente (Por defecto esta mi BD local):   
```
<bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
    <property name="driverClassName" value="com.mysql.jdbc.Driver"/>
    <property name="url" value="jdbc:mysql://127.0.0.1:3306/test?allowMultiQueries=true&amp;useSSL=false"/>
    <property name="username" value="root"/>
    <property name="password" value=""/>
</bean>
```

**3.- FrontEnd:** El proyecto frontend consta de una interfaz grafica basica realizada en React con estructura basada en Redux, en esta interfaz podremos interactuar con las acciones listadas en el apartado de backend. Para ejecutar el proyecto bastara con usar la terminal de su preferencia y ejecutar los siguientes comando basicos de despliegue de react: ```npm install```, el cual nos cargara librerias utilizadas en el proyecto y por ultimo ```npm start```, el cual nos desplegara el proyecto. 

Adicionalmente antes de deplegar, se debera configurar el endpoint base de la API en la siguiente ruta ```src/index.js```, por defecto estara la ruta a mi LocalHost:
```
axios.defaults.baseURL = 'http://localhost:8080'; // Cambia la URL según tu configuración del backend
```
**Comentarios Adicionales**

-	Se solicito utilizar Swagger para documentar la API, sin enbargo por temas de tiempo no se logro implementarse al 100%, dentro del codigo de la API podra vizualizar comentarios del intento de implementacion.
- La implementacion de pruebas unitarias igualmente se quedo corta por temas de tiempo.

