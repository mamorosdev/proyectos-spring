package modelocoche;

public class Motor {

	private String marca;
	private double potencia;
	private int numCilindros;
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public double getPotencia() {
		return potencia;
	}
	public void setPotencia(double potencia) {
		this.potencia = potencia;
	}
	public int getNumCilindros() {
		return numCilindros;
	}
	public void setNumCilindros(int numCilindros) {
		this.numCilindros = numCilindros;
	}
	@Override
	public String toString() {
		return "Motor [marca=" + marca + ", potencia=" + potencia
				+ ", numCilindros=" + numCilindros + "]";
	}
	
	
}
