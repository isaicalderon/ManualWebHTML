public class DaoFactoryJdbc extends DaoFactory {

	private TransaccionJdbc transaccion;

	@Override
	public Transaccion getTransaccion() {
		return this.transaccion;
	}

	@Override
	public void setTransaccion(Transaccion conexion) {
		if (conexion instanceof TransaccionJdbc) {
			this.transaccion = (TransaccionJdbc) conexion;
		} else {
			throw new RuntimeException("Se esperaba un transaccion JDBC");
		}
	}

	@Override
	public AlumnosDao getAlumnosDao() {
		AlumnosDaoJdbc dao = new AlumnosDaoJdbc();
		dao.setTransaccion(this.transaccion);
		return dao;
	}

}