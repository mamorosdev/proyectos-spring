import modelocoche.Coche;
import modelocoche.MotorDiesel;
import modelocoche.Radio;

/**
 * Ejemplo de como se pierde la ventaja del débil acoplamiento
 * entre objetos, cuando no se usa Spring Framework.
 * @author MiquelÀngel
 *
 */
public class TestCocheNoSpring {

	public static void main(String[] args) {

		Radio r = new Radio();
		r.setMarca("Sony");
		r.setMarca("Vayo");
		
		MotorDiesel m = new MotorDiesel();
		m.setMarcaFiltro("marca");
		
		Coche coche = new Coche(m,r);
		System.out.println(coche);
		
	}

}
