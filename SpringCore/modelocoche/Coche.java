package modelocoche;

public class Coche {

	private IMotor motor;
	private Radio radio;
	
	// No se deberia hacer:
	// Que la clase coche se proporcione sus piezas.
	public Coche() {
//		motor = new IMotor();
//		radio = new Radio();
	}
	
	public Coche(IMotor motor, Radio radio) {
		super();
		this.motor = motor;
		this.radio = radio;
	}

	public IMotor getMotor() {
		return motor;
	}
	public void setMotor(IMotor motor) {
		this.motor = motor;
	}
	public Radio getRadio() {
		return radio;
	}
	public void setRadio(Radio radio) {
		this.radio = radio;
	}
	@Override
	public String toString() {
		return "Coche [motor=" + motor + ", radio=" + radio + "]";
	}
	
	
}
