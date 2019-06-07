import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;

import com.matco.administradortransacciones.dao.jdbc.TransaccionJdbc;
import com.matco.manual.dao.GenericDao;

public abstract class GenericDaoJdbc<T, ID extends Serializable> implements GenericDao<T, ID> {
	private TransaccionJdbc transaccion;

	protected Connection getConexion() {
		return getTransaccion().getConexion();
	}

	public TransaccionJdbc getTransaccion() {
		return transaccion;
	}

	public void setTransaccion(TransaccionJdbc transaccion) {
		this.transaccion = transaccion;
	}

	protected void asignar(int indice, CallableStatement comando, String dato) throws SQLException {
		if (dato == null) {
			comando.setNull(indice, Types.VARCHAR);
		} else {
			comando.setString(indice, dato);
		}
	}

	protected void asignar(int indice, CallableStatement comando, BigDecimal dato) throws SQLException {
		if (dato == null) {
			comando.setNull(indice, Types.VARCHAR);
		} else {
			comando.setBigDecimal(indice, dato);
		}
	}

	protected void asignar(int indice, CallableStatement comando, java.util.Date dato) throws SQLException {
		if (dato == null) {
			comando.setNull(indice, Types.DATE);
		} else {
			Timestamp fechaHora = new Timestamp(dato.getTime());
			comando.setTimestamp(indice, fechaHora);
		}
	}

	protected void asignar(int indice, CallableStatement comando, Integer dato) throws SQLException {
		if (dato == null) {
			comando.setNull(indice, Types.NUMERIC);
		} else {
			comando.setInt(indice, dato);
		}
	}

	protected void asignar(int indice, CallableStatement comando, Boolean dato) throws SQLException {
		if (dato == null) {
			comando.setNull(indice, Types.BOOLEAN);
		} else {
			comando.setBoolean(indice, dato);
		}
	}

	protected void asignar(int indice, CallableStatement comando, Short dato) throws SQLException {
		if (dato == null) {
			comando.setNull(indice, Types.NUMERIC);
		} else {
			comando.setShort(indice, dato);
		}
	}

	protected void asignar(int indice, CallableStatement comando, Double dato) throws SQLException {
		if (dato == null) {
			comando.setNull(indice, Types.DECIMAL);
		} else {
			comando.setDouble(indice, dato);
		}
	}

	protected void registrarParametroSalida(int indice, CallableStatement comando, int tipoDato) throws SQLException {
		comando.registerOutParameter(indice, tipoDato);
	}

	protected void asignar(int indice, PreparedStatement comando, String dato) throws SQLException {
		if (dato == null) {
			comando.setNull(indice, Types.VARCHAR);
		} else {
			comando.setString(indice, dato);
		}
	}

	protected void asignar(int indice, PreparedStatement comando, java.util.Date dato) throws SQLException {
		if (dato == null) {
			comando.setNull(indice, Types.DATE);
		} else {
			Timestamp fechaHora = new Timestamp(dato.getTime());
			comando.setTimestamp(indice, fechaHora);
		}
	}

	protected void asignar(int indice, PreparedStatement comando, Integer dato) throws SQLException {
		if (dato == null) {
			comando.setNull(indice, Types.NUMERIC);
		} else {
			comando.setInt(indice, dato);
		}
	}

	protected void asignar(int indice, PreparedStatement comando, Short dato) throws SQLException {
		if (dato == null) {
			comando.setNull(indice, Types.NUMERIC);
		} else {
			comando.setShort(indice, dato);
		}
	}

	protected void asignar(int indice, CallableStatement comando, Long dato) throws SQLException {
		if (dato == null) {
			comando.setNull(indice, Types.NUMERIC);
		} else {
			comando.setLong(indice, dato);
		}
	}

	protected void asignar(int indice, PreparedStatement comando, Double dato) throws SQLException {
		if (dato == null) {
			comando.setNull(indice, Types.DECIMAL);
		} else {
			comando.setDouble(indice, dato);
		}
	}
	
	protected void asignarcalar(PreparedStatement comando, String nombre) throws SQLException {
		if (nombre == null) {
			comando.setNull(0, Types.DECIMAL);
		} else {
			comando.setString(1, nombre);
		}
	}
	
	protected void asignarcalar(PreparedStatement comando, int id) throws SQLException {
		if (id == 0) {
			comando.setNull(0, Types.DECIMAL);
		} else {
			comando.setInt(1, id);
		}
	}
	
	protected void asignarcalar(PreparedStatement comando, String nombre, String dir, int edad) throws SQLException {
		if (nombre == null) {
			comando.setNull(0, Types.DECIMAL);
		} else {
			comando.setString(1, nombre);
			comando.setString(2, dir);
			comando.setInt(3, edad);
		}
	}
	
	protected void asignarcalarE(PreparedStatement comando, String id, String nombre, String dir, String edad, String nom) throws SQLException {
		if (nombre == null) {
			comando.setNull(0, Types.DECIMAL);
		} else {
			comando.setString(1, id);
			comando.setString(2, nombre);
			comando.setString(3, dir);
			comando.setString(4, edad);
			comando.setString(5, nom);
		}
	}
}