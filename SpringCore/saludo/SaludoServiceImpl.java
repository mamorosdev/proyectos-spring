package saludo;

public class SaludoServiceImpl implements SaludoService {
	
	@Override
	public void mensaje() {
		System.out.println("Mensaje prueba");
	}
	
	public void primerMetodo() {
		System.out.println("Salta primer método ...");
	}
	
	public void ultimoMetodo() {
		System.out.println("Salta ultimo método ...");
	}

}
