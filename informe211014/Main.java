package Vista;

import Controlador.Elcontrolador;
import Modelo.Asignatura;
import Modelo.Asistencia;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.out;

public class Main {
    private static boolean Ingrese;

    public static void main (String []args ){
        Scanner entrada = new Scanner(System.in);
        Elcontrolador control = new Elcontrolador();
        String opcion = "";
        String nombre = "";
        while (opcion.equals("15")==false){
            out.println("\nMenu Principal");
                out.println("1. Consultar Departamento");
            out.println("2. Modificar Departamento");
            out.println("3. Registrar Estudiante Departamento");
            out.println("4. Consultar Estudiante En Departamento");
            out.println("5. Modificar Estudiante");
            out.println("6. Agregar Asignatura");
            out.println("7. Consultar Asignatura");
            out.println("8. Modificar asignatura");
            out.println("9. Registrar Estudiante En Asignatura");
            out.println("10. Consultar Estudiante En Asignatura");
            out.println("11. Crear Lista De Asistencia Vacia");
            out.println("12. Llenar Asistencia");
            out.println("13. Modificar Asistencia");
            out.println("14. Listar Asistencias");
            out.println("15. Salir");

            opcion = entrada.nextLine();

            if (opcion.equals("1")) {
                out.println("Crear un nuevo departamento");
                nombre = entrada.nextLine();
                control.nombreDepartamento(nombre);
                out.println("Departamento Creado Correctamente");
            } else if (opcion.equals("2")) {
                String nombredpo = control.editarDepartamento("");
                out.println("Nombre del departamento:" + nombredpo);
            } else if (opcion.equals("3")) {
                out.println("Ingrese el tipo de documento del estudiante:");
                String tipoDoc = entrada.nextLine();
                out.println("Ingrese el número de documento del estudiante:");
                String numDoc = entrada.nextLine();
                out.println("Ingrese el nombre del estudiante:");
                String nombreEst = entrada.nextLine();
                out.println("Ingrese el semestre:");
                String semestre = entrada.nextLine();
                out.println("Ingrese el grupo:");
                String grupo = entrada.nextLine();
                control.registrarEstudianteDepartamento(tipoDoc, numDoc, nombreEst, semestre, grupo);
                out.println("Estudiante registrado correctamente en el departamento.");
            } else if (opcion.equals("4")) {
                out.println("Ingrese el tipo de documento del estudiante:");
                String tipodoc = entrada.nextLine();
                out.println("Ingrese el número de documento del estudiante:");
                String numDoc = entrada.nextLine();
                control.consultarEstudianteDepartamento(tipodoc, numDoc);
            } else if (opcion.equals("5")) {
                out.println("Ingrese el tipo de documento del estudiante:");
                String tipoDoc = entrada.nextLine();
                out.println("Ingrese el número de documento del estudiante:");
                String numDoc = entrada.nextLine();
                out.println("Ingrese el nuevo nombre del estudiante:");
                String nuevoNombre = entrada.nextLine();
                out.println("Ingrese el nuevo semestre:");
                String nuevoSemestre = entrada.nextLine();
                out.println("Ingrese el nuevo grupo:");
                String nuevoGrupo = entrada.nextLine();
                control.modificarEstudiante(tipoDoc, numDoc, nuevoNombre, nuevoSemestre, nuevoGrupo);
                out.println("Información del estudiante actualizada correctamente.");
            } else if (opcion.equals("6")) {
                out.println("Nombre");
                String name = entrada.nextLine();
                out.println("Créditos");
                String creditos = entrada.nextLine();
                out.println("Código");
                String codigo = entrada.nextLine();
                out.print("Grupo: ");
                String grupo = entrada.nextLine();
                out.print("Semestre: ");
                String semestre = entrada.nextLine();
                int cred = Integer.parseInt(creditos);
                control.agregarAsignatura(name, cred, codigo, grupo, semestre);
                out.println("Asignatura agregada con éxito");
            } else if (opcion.equals("7")) {
                out.print("Código: ");
                String codConsulta = entrada.nextLine();
                out.print("Grupo: ");
                String grupoConsulta = entrada.nextLine();
                out.print("Semestre: ");
                String semConsulta = entrada.nextLine();
                Asignatura encontrada = control.consultarAsignatura(codConsulta, grupoConsulta, semConsulta);
                if (encontrada != null) {
                    out.println("Asignatura encontrada.");
                    out.println(encontrada);
                } else {
                    out.println("Asignatura no encontrada.");
                }
            } else if (opcion.equals("8")) {
                out.print("Código: ");
                String codModi = entrada.nextLine();
                out.print("Grupo: ");
                String grupoModi = entrada.nextLine();
                out.print("Semestre: ");
                String semModi = entrada.nextLine();
                out.print("Nuevo Nombre: ");
                String nuevoNombre = entrada.nextLine();
                out.print("Nuevos Créditos: ");
                String nuevosCreditos = entrada.nextLine();
                int nuevoscred = Integer.parseInt(nuevosCreditos);
                control.modificarAsignatura(codModi, grupoModi, semModi, nuevoNombre, nuevoscred);
                out.println("La asignatura se modificó con éxito");
            } else if (opcion.equals("9")) {
                out.print("Código de la asignatura: ");
                String codAsig = entrada.nextLine();
                out.print("Grupo: ");
                String grupo = entrada.nextLine();
                out.print("Semestre: ");
                String semestre = entrada.nextLine();
                out.print("Tipo de documento del estudiante: ");
                String tipoDoc = entrada.nextLine();
                out.print("Número de documento del estudiante: ");
                String numDoc = entrada.nextLine();
                control.registrarEstudianteAsignatura(codAsig, grupo, semestre, tipoDoc, numDoc);
            } else if (opcion.equals("10")) {
                out.print("Código de la asignatura: ");
                String codAsig = entrada.nextLine();
                out.print("Grupo: ");
                String grupo = entrada.nextLine();
                out.print("Semestre: ");
                String semestre = entrada.nextLine();
                control.consultarEstudiantesAsignatura(codAsig, grupo, semestre);
            } else if (opcion.equals("11")) {
                out.print("Código de la asignatura: ");
                String codAsig = entrada.nextLine();
                out.print("Grupo: ");
                String grupo = entrada.nextLine();
                out.print("Semestre: ");
                String semestre = entrada.nextLine();
                out.print("Fecha: ");
                String fecha = entrada.nextLine();
                out.print("Hora inicio: ");
                String horaInicio = entrada.nextLine();
                out.print("Hora final: ");
                String horaFinal = entrada.nextLine();
                control.crearListaAsistencia(codAsig, grupo, semestre, fecha, horaInicio, horaFinal);
            } else if (opcion.equals("12")) {
                out.print("Código de la asignatura: ");
                String codigo = entrada.nextLine();
                out.print("Grupo: ");
                String grupo = entrada.nextLine();
                out.print("Semestre: ");
                String semestre = entrada.nextLine();
                out.print("Fecha: ");
                String fecha = entrada.nextLine();
                out.print("Hora inicio: ");
                String horaInicio = entrada.nextLine();
                out.print("Hora final: ");
                String horaFinal = entrada.nextLine();
                control.llenarAsistencia(codigo, grupo, semestre, fecha, horaInicio, horaFinal);
            } else if (opcion.equals("13")) {
                out.print("Código de la asignatura: ");
                String codigo = entrada.nextLine();
                out.print("Grupo: ");
                String grupo = entrada.nextLine();
                out.print("Semestre: ");
                String semestre = entrada.nextLine();
                out.print("Fecha: ");
                String fecha = entrada.nextLine();
                out.print("Hora inicio: ");
                String horaInicio = entrada.nextLine();
                out.print("Hora final: ");
                String horaFinal = entrada.nextLine();
                out.print("Tipo de documento del estudiante: ");
                String tipoDoc = entrada.nextLine();
                out.print("Número de documento del estudiante: ");
                String numDoc = entrada.nextLine();
                out.print("Nuevo estado: ");
                String nuevoEstado = entrada.nextLine();
                control.modificarAsistencia(codigo, grupo, semestre, fecha, horaInicio, horaFinal, tipoDoc, numDoc, nuevoEstado);
            } else if (opcion.equals("14")) {
                out.print("Código de la asignatura: ");
                String codigo = entrada.nextLine();
                out.print("Grupo: ");
                String grupo = entrada.nextLine();
                out.print("Semestre: ");
                String semestre = entrada.nextLine();
                out.print("Fecha: ");
                String fecha = entrada.nextLine();
                out.print("Hora inicio: ");
                String horaInicio = entrada.nextLine();
                control.listarAsistencias(codigo, grupo, semestre, fecha, horaInicio);
            } else if (opcion.equals("15")) {
                out.println("Saliendo del sistema. ¡Hasta pronto!");
            } else {
                out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}
