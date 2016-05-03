
import modelocoche.Coche;
import modelocoche.Radio;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Ejemplo de inyecci�n de dependencias con Spring.
 * Inyecci�n por propiedades desde el constructor 
 * o desde m�todos set. 
 * @author Miquel�ngel
 *
 */
public class TestCocheSpring {

	public static void main(String[] args) {
		
		ApplicationContext contexto;
		Coche coche;
		
		// Cargamos los datos definidos en el contexto.
		contexto = new ClassPathXmlApplicationContext("contexto2.xml");
		coche = (Coche) contexto.getBean("coche");
		
		System.out.println(coche.getMotor());
		System.out.println(coche);
		
		Radio radio = (Radio) contexto.getBean("radio");
		System.out.println(radio);
		
	}

}