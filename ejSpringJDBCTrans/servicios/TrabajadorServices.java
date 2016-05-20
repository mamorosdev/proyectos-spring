package servicios;

import java.util.List;

import modelo.beans.Trabajador;
import modelo.dao.TrabajadorDAO2;

import org.springframework.jdbc.datasource.IsolationLevelDataSourceAdapter;
import org.springframework.jdbc.datasource.lookup.IsolationLevelDataSourceRouter;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

public class TrabajadorServices implements ITrabajadorServices {

	private TrabajadorDAO2 dao;
	private TransactionTemplate txTemplate;
	
	public TrabajadorServices(TrabajadorDAO2 dao, TransactionTemplate txTemplate) {
		super();
		this.setDao(dao);
		this.txTemplate = txTemplate;
	}
	
	@Override
	public boolean ingresarEmpleado(final Trabajador t) {
		return txTemplate.execute(new TransactionCallback<Boolean>() {
			@Override
			public Boolean doInTransaction(TransactionStatus txStatus) {
				boolean valor = false;
				try {
					valor = dao.ingresarEmpleado(t);
				} catch(RuntimeException e) {
					txStatus.setRollbackOnly();
					throw e;
				}
				return valor;
			}	
		});
	}

	@Override
	public boolean eliminarEmpleado(final String nombre_trabajador) {
		return txTemplate.execute(new TransactionCallback<Boolean>() {
			@Override
			public Boolean doInTransaction(TransactionStatus txStatus) {
				boolean valor = false;
				try {
					valor = dao.eliminarEmpleado(nombre_trabajador);
				} catch(RuntimeException e) {
					txStatus.setRollbackOnly();
					throw e;
				}
				return valor;
			}	
		});
	}

	@Override
	public boolean actualizarEmpleado(final Trabajador t) {
		txTemplate.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		return txTemplate.execute(new TransactionCallback<Boolean>() {
			@Override
			public Boolean doInTransaction(TransactionStatus txStatus) {
				boolean valor = false;
				try {
					valor = dao.actualizarEmpleado(t);
				} catch(RuntimeException e) {
					txStatus.setRollbackOnly();
					throw e;
				}
				return valor;
			}	
		});
	}
	
	public List<Trabajador> listarEmpleados() {
		return dao.listarEmpleados();
	}

	public TrabajadorDAO2 getDao() {
		return dao;
	}

	public void setDao(TrabajadorDAO2 dao) {
		this.dao = dao;
	}
	
	

}
