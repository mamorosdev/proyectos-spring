import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import saludo.SaludoService;

/**
 * Ejemplo de introducción a Spring.
 * Inyección por propiedades desde el constructor 
 * o desde métodos set. 
 * @author MiquelÀngel
 *
 */
public class TestSaludo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext contexto;
		SaludoService saludo;
		contexto = new ClassPathXmlApplicationContext("contexto1.xml");
	
		saludo = (SaludoService) contexto.getBean("saludo");
		saludo.mensaje();
		saludo.mensaje();
	}

}
