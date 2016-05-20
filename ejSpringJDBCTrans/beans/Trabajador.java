package modelo.beans;


public class Trabajador {
	
	private long numero_trabajador;
	private String id;
	private String nombre;
	private String departamento;
	
	public Trabajador() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Trabajador(long numero_trabajador, String id, String nombre,
			String departamento) {
		super();
		this.numero_trabajador = numero_trabajador;
		this.id = id;
		this.nombre = nombre;
		this.departamento = departamento;
	}
	
	public long getNumero_trabajador() {
		return numero_trabajador;
	}
	public void setNumero_trabajador(long numero_trabajador) {
		this.numero_trabajador = numero_trabajador;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	@Override
	public String toString() {
		return "Trabajador [numero_trabajador=" + numero_trabajador + ", id="
				+ id + ", nombre=" + nombre + ", departamento=" + departamento
				+ "]";
	}
	
}
