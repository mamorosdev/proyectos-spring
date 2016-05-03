package modelocoche;

public class MotorDiesel implements IMotor {

	private String marcaFiltro;
	
	public String getMarcaFiltro() {
		return marcaFiltro;
	}

	public void setMarcaFiltro(String marcaFiltro) {
		this.marcaFiltro = marcaFiltro;
	}

	public void puestaPunto() {
		// TODO Auto-generated method stub
		System.out.println("puesta punto diesel...");
	}

	@Override
	public String toString() {
		return "MotorDiesel [marcaFiltro=" + marcaFiltro + "]";
	}

	public void pruebas() {
		// TODO Auto-generated method stub
		System.out.println("pruebas diesel...");
	}

}
