package modelo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import modelo.beans.Trabajador;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class TrabajadorDAO2 extends JdbcDaoSupport implements ITrabajadorDAO {
	
	@Override
	public Trabajador getTrabajador(String numero_trabajador) {
		Trabajador t;
		t = getJdbcTemplate().queryForObject(
				"select * from trabajadores where id=?",
				new Object[]{numero_trabajador},
				new RowMapper<Trabajador>() { // Lo podemos crear mediante una clase anónima.
					// de la misma forma que los eventos en Swing.
					public Trabajador mapRow(ResultSet rst, int rowNum) throws SQLException {
						System.out.println("Buscando producto " + rowNum);
						Trabajador trab = new Trabajador();
						trab.setNumero_trabajador(rst.getLong("numero_trabajador"));
						trab.setId(rst.getString("id"));
						trab.setNombre(rst.getString("nombre"));
						trab.setDepartamento(rst.getString("departamento"));
						return trab;
					}
				});
		return t;
	}

	@Override
	public boolean ingresarEmpleado(Trabajador t) {
		int filas = getJdbcTemplate().update("insert into trabajadores(id,nombre,departamento) values(?,?,?)",
				new Object[]{t.getId(),t.getNombre(),t.getDepartamento()});
		return filas == 1;
	}

	@Override
	public boolean eliminarEmpleado(String numero_trabajador) {
		int filas = getJdbcTemplate().update("delete from trabajadores where numero_trabajador=?",
				new Object[]{numero_trabajador});
		return filas == 1;
	}

	@Override
	public boolean actualizarEmpleado(Trabajador t) {
		int filas = getJdbcTemplate().update("update trabajadores set id=?, nombre=?, departamento=? where numero_trabajador=?",
				new Object[]{t.getId(),t.getNombre(),t.getDepartamento(),t.getNumero_trabajador()});
		return filas == 1;
	}

	@Override
	public List<Trabajador> listarEmpleados() {
		List<Trabajador> trabajadores =
				getJdbcTemplate().query("select * from trabajadores",
				new RowMapper<Trabajador>() {
					public Trabajador mapRow(ResultSet rst, int rowNum)
						throws SQLException {
						Trabajador trab = new Trabajador();
						trab.setNumero_trabajador(rst.getLong("numero_trabajador"));
						trab.setId(rst.getString("id"));
						trab.setNombre(rst.getString("nombre"));
						trab.setDepartamento(rst.getString("departamento"));
						return trab;
					}
				});
		return trabajadores;
	}

	@Override
	public int numeroTrabajadores() {
		int numeroTrabajadores = getJdbcTemplate().queryForInt("select count(0) from trabajadores");
		return numeroTrabajadores;
	}

	@Override
	public int numeroTrabajadoresPorDpo(String departamento) {
		int numeroTrabDpto = getJdbcTemplate().queryForInt("select count(0) from trabajadores where departamento=?"
				, new Object[]{departamento});
		return numeroTrabDpto;
	}

}
