import java.util.List;

import org.apache.log4j.PropertyConfigurator;

import com.matco.manual.entity.Alumno;
import com.matco.manual.facade.AlumnoFacade;

public class Main {
	private static final String log4j = "log4j_csa.properties";

	public static void main(String[] args) throws Exception {
		PropertyConfigurator.configure(log4j);
		String archivoConfiguracion = "admintx_csa_aplicacion.properties";
		
		//Código para listarlos todos
		AlumnoFacade alumnoFacade = new AlumnoFacade(archivoConfiguracion);
		List<Alumno> alumnos = alumnoFacade.obtenerTodosAlumnos();
		int contador = 0;
		for (Alumno alumnoo : alumnos) {
			contador++;
			System.out.println(alumnoo.getMatricula() + " - " + alumnoo.getNombres() + " " + alumnoo.getApellidoPaterno()
					+ " " + alumnoo.getApellidoMaterno());
		}
		System.out.println("Hay "+contador+" alumnos");
		
		//Código para agregar un alumno
		Alumno alumno = new Alumno();
		alumno.setNombres("Estemen");
		alumno.setApellidoPaterno("No tiene");
		alumno.setApellidoMaterno("Si tiene");
		alumno.setCreadoPor("DESARROLLO");
		int matricula = alumnoFacade.guardarAlumno(alumno);
		System.out.println("Se guardó el alumno con la matricula: "+matricula);
		
		alumnos = alumnoFacade.obtenerTodosAlumnos();
		contador = 0;
		for (Alumno alumnoo : alumnos) {
			contador++;
			System.out.println(alumnoo.getMatricula() + " - " + alumnoo.getNombres() + " " + alumnoo.getApellidoPaterno()
					+ " " + alumnoo.getApellidoMaterno());
		}
		System.out.println("Hay "+contador+" alumnos");
		
		//Código para consultar un alumno
		
		alumno = alumnoFacade.obtenerAlumnoPorMatricula(matricula);
		System.out.println(alumno.getMatricula() + " - " + alumno.getNombres() + " " + alumno.getApellidoPaterno()
		+ " " + alumno.getApellidoMaterno());
		
		//Código para modificar un alumno
		alumno.setNombres("Ahorano");
		alumno.setApellidoPaterno("parfavar");
		alumno.setApellidoMaterno("noooo");
		alumnoFacade.modificarAlumno(alumno);
		alumno = alumnoFacade.obtenerAlumnoPorMatricula(matricula);
		System.out.println(alumno.getMatricula() + " - " + alumno.getNombres() + " " + alumno.getApellidoPaterno()
		+ " " + alumno.getApellidoMaterno());
		
		//Código para eliminar un alumno
		alumnoFacade.eliminarAlumno(alumno);
		System.out.println("Se ha eliminado a "+alumno.getMatricula() + " - " + alumno.getNombres() + " " + alumno.getApellidoPaterno()
		+ " " + alumno.getApellidoMaterno());
		alumnos = alumnoFacade.obtenerTodosAlumnos();
		contador = 0;
		for (Alumno alumnoo : alumnos) {
			contador++;
			System.out.println(alumnoo.getMatricula() + " - " + alumnoo.getNombres() + " " + alumnoo.getApellidoPaterno()
					+ " " + alumnoo.getApellidoMaterno());
		}
		System.out.println("Hay "+contador+" alumnos");
	}

}