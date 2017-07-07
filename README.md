# spring3-EJEMPLOS
Proyectos que muestran el funcionamiento y las posibilidades de Spring Framework 3; me sirvieron para aprender Spring 3 en 2012.
Ahora mismo estan todos obsoletos. Hasta nuevo aviso no preveo actualizar este repositorio.

#### Entorno: 

* Spring Framework 3.1
* Java SE 7.

#### Pendiente
* Usar Spring Boot.
* Usar Maven para facilitar instalación.
* Ejemplos de otros módulos: AOP,MVC,Security,REST-WS,Data.


EjSpringCore
-----------
Pruebas del núcleo de Spring; un contenedor que gestiona el ciclo de vida de los beans.
Para que esta mágia sea posible los beans se definen en un archivo XML o anotaciones.

Hay 3 clases Java con los ejemplos de prueba.

EjSpringJDBC
-------------
Pruebas de operaciones CRUD en una tabla de una base de datos MySQL con Spring JDBC. 
Es una forma más artesanal de mapear una BBDD relacional con las clases Java que Hibernate o IBatis; pero más elegante que JDBC a pelo.
Gracias el patrón Template Spring también aporta implementaciones para mapear datos en JPA, Hibernate, IBatis, ficheros XML, LDAP, bases de datos Nosql...
El script de la base de datos que he usado en este ejemplo y el siguiente lo puedes [obtener aquí](https://github.com/mamorosdev/ejemplos-sql/blob/master/ejemplos_springjdbc.sql).

EjSpringJDBCTrans
------------------
Una continuación del ejemplo anterior que muestra como funcionan las transacciones en Spring.



