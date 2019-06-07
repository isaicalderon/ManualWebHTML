import java.io.Serializable;
import java.util.List;

/**
 * Interfaz que declara los metodos genericos para los diferentes Dao
 *
 * @author
 *
 * @param <T>
 *            - Tipo de dato que se va a manejar en la clase que implemente la
 *            interfaz
 * @param <ID>
 *            - Tipo de la llave primaria
 */
public interface GenericDao<T, ID extends Serializable> {

	/**
	 * Guarda un registro solicitado
	 *
	 * @param instancia
	 *            - La instancia del objeto por guardar
	 * @throws Excepcion
	 *             cuando el metodo no esta implementado
	 */
	public void guardar(T instancia) throws Exception;

	/**
	 * Modifica un registro solicitado
	 *
	 * @param instancia
	 *            - La instancia del objeto por guardar
	 * @throws Excepcion
	 *             cuando el metodo no esta implementado
	 */
	public void modificar(T instancia) throws Exception;

	/**
	 *
	 * @param instancia
	 *            - La instancia del objeto por eliminar
	 * @throws Excepcian
	 *             cuando el metodo no esta implementado
	 */
	public void eliminar(T instancia) throws Exception;

	/**
	 * Obtiene una lista con todos los registros solicitados
	 *
	 * @return Lista con todos los registros solicitados
	 * @throws Excepcion
	 *             cuando el metodo no esta implementado
	 */
	public List<T> obtenerTodos() throws Exception;

	/**
	 * Obtiene un registro solicitado
	 *
	 * @return Registro solicitado
	 * @throws Excepcion
	 *             cuando el metodo no esta implementado
	 */
	public T obtenerPorId(ID id) throws Exception;

}