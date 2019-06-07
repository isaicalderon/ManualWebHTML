package com.nsoluciones.manual.facade;

import com.matco.administradortransacciones.dao.TipoFabrica;
import com.matco.administradortransacciones.dao.TransaccionFactory;
import com.matco.manual.dao.DaoFactory;

/**
 * Clase Singleton que crea e inicializa las Fabricas de Daos y de Transacciones
 * 
 * @author
 *
 */
public class FactorySingleton {
	private static TransaccionFactory transaccionFactory;
	private static DaoFactory daoFactory;

	/**
	 * Constructor de la Clase
	 * 
	 */
	private FactorySingleton() {

	}

	/**
	 * Obtiene una Fabrica de Transacciones
	 * 
	 * @return transaccionFactory - Fabrica de Transacciones
	 */
	public static TransaccionFactory getTransaccionFactory(String archivoConfig) {
		inicializarTransaccionFactory(archivoConfig);
		return transaccionFactory;
	}

	/**
	 * Inicializa la Fabrica de Transacciones tipo JDBC con el archivo de
	 * configuracion especificado
	 * 
	 */
	private synchronized static void inicializarTransaccionFactory(String archivoConfig) {
		if (transaccionFactory == null) {
			transaccionFactory = TransaccionFactory.crearFabrica(TipoFabrica.JDBC, archivoConfig);
		}
	}

	/**
	 * Obtiene una Fabrica de Daos
	 * 
	 * @return daoFactory - Fabrica de Daos
	 */
	public static DaoFactory getDaoFactory() {
		inicializarDaoFactory();
		return daoFactory;
	}

	/**
	 * Inicializa la Fabrica de Daos tipo JDBC
	 * 
	 */
	private synchronized static void inicializarDaoFactory() {
		if (daoFactory == null) {
			daoFactory = DaoFactory.crearFabrica(com.matco.manual.dao.TipoFabrica.JDBC);
		}
	}

}
