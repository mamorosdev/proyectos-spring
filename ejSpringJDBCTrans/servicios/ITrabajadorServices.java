package servicios;

import java.util.List;

import modelo.beans.Trabajador;

public interface ITrabajadorServices {
	
	public boolean ingresarEmpleado(final Trabajador t);
	public boolean eliminarEmpleado(final String nombre_trabajador);
	public boolean actualizarEmpleado(final Trabajador t);
	public List<Trabajador> listarEmpleados();
	
}
