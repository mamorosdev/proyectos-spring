import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JdbcTemplate template;
		ApplicationContext contexto;
		contexto = new ClassPathXmlApplicationContext("applicationContext.xml");
		template = (JdbcTemplate) contexto.getBean("template");
		
		// Ej1: numero filas de una tabla
		int numeroClientes = template.queryForInt("select count(0) from clientes");
		System.out.println("numeroClientes = " + numeroClientes);
		
		// Ej2: numero filas de una tabla con un criterio
		int numeroContables= template.queryForInt
			("select count(0) from empleados where cargo = ?", new Object[]{"Contable"});
		System.out.println("Numero empleados contables = " + numeroContables);
		
		// Ej3: nombre de un producto
		String nombreProducto = template.queryForObject
			("select nombre from productos where id = ?", new Object[]{22}, String.class);
		System.out.println("Nombre producto 22 = " + nombreProducto);
		
		// Ej4: recuperar un objeto producto
		Producto producto =
			(Producto) template.queryForObject(
			"select * from productos where id = ?",
			new Object[]{new Long(22)}, // Los parámetros como array de Object
			new RowMapper<Producto>() { // Lo podemos crear mediante una clase anónima.
				// de la misma forma que los eventos en Swing.
				public Producto mapRow(ResultSet rst, int rowNum) throws SQLException {
					System.out.println("Buscando producto " + rowNum);
					Producto producto = new Producto();
					producto.setId(rst.getLong("id"));
					producto.setIdCategoria(rst.getLong("idCategoria"));
					producto.setNombre(rst.getString("nombre"));
					producto.setExistencias(rst.getInt("existencias"));
					producto.setPrecio(rst.getDouble("precio"));
					return producto;
				}
			});
		System.out.println(producto);
		
		// Ej5: recuperar una coleccion producto
		List<Producto> productos =
			template.query("select * from productos where idCategoria=? and precio < ?",
			new Object[]{1,22},
			new RowMapper<Producto>() {
				public Producto mapRow(ResultSet rst, int rowNum)
					throws SQLException {
					Producto producto = new Producto();
					producto.setId(rst.getLong("id"));
					producto.setIdCategoria(rst.getLong("idCategoria"));
					producto.setNombre(rst.getString("nombre"));
					producto.setExistencias(rst.getInt("existencias"));
					producto.setPrecio(rst.getDouble("precio"));
					return producto;
				}
			});
		System.out.println("Lista productos tipo 1 de precio menor a 22");
		for(Producto p: productos) {
			System.out.println(p);
		}
		
		// Ej6: insertar producto
		int filas = template.update("insert into productos(idcategoria,nombre,precio,existencias) values(?,?,?,?)",
				new Object[]{1,"Simon Life", 1.5, 40});
		System.out.println("Productos insertados " + filas);
		
		// Ej7: bajar precio productos categoria en un 10%
		int filas2 = template.update("update productos set precio = precio * 0.9 where idcategoria=?",new Object[]{1});
		System.out.println("Productos modificados " + filas2);
		
		// Ej8: eliminar registros
		int filas3 = template.update("delete from categorias where id >= ?",new Object[]{9});
		System.out.println("Filas eliminados " + filas3);
		
		int filas4 = template.update("delete from productos where nombre = ?",new Object[]{"Simon Life"});
		System.out.println("Filas eliminados " + filas4);
		
		// Ej9: DML crear tabla
		template.execute("drop table administradores");
		template.execute("create table administradores(login varchar(50), pass varchar(50), primary key(login))");
	
		// Ej 10: Llamar prodedimiento alamcenado
		template.update(
			"call NUEVA_CATEGORIA(?)",
				new Object[]{"cine"});
	}

}
