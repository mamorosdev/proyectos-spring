package principal;

import java.util.List;

import modelo.beans.Trabajador;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import servicios.ITrabajadorServices;

public class TestDAOSupport {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext contexto;
		contexto = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		ITrabajadorServices trabajadorServices;
		trabajadorServices = (ITrabajadorServices) contexto.getBean("trabajadorServices");
		
		Trabajador trabajador = new Trabajador(-1,"DES2","manel","desarrollo");
		
		if(trabajadorServices.ingresarEmpleado(trabajador))
			System.out.println("Trabajador insertado.");
		else
			System.out.println("Trabajador no se ha podido insertar.");
		
		List<Trabajador> lista = trabajadorServices.listarEmpleados();
		for(Trabajador t: lista)
			System.out.println(t);
	}

}
