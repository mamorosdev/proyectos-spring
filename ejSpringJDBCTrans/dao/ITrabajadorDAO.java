package modelo.dao;
import java.util.List;
import modelo.beans.Trabajador;

public interface ITrabajadorDAO {
		public Trabajador getTrabajador(final String nombre_trabajador);
		public boolean ingresarEmpleado(final Trabajador t);
		public boolean eliminarEmpleado(final String nombre_trabajador);
		public boolean actualizarEmpleado(final Trabajador t);
		public List<Trabajador> listarEmpleados();
		public int numeroTrabajadores();
		public int numeroTrabajadoresPorDpo(String departamento);
}
