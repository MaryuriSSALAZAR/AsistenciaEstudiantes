package Controlador;
import Modelo.Asignatura;
import Modelo.Asistencia;
import Modelo.Departamento;
import Modelo.Estudiante;
import java.io.StringReader;
import java.util.ArrayList;
public class Elcontrolador {

    private Departamento departamento = null;

    public Elcontrolador(){
        departamento = Departamento.singleton();
    }

    public void nombreDepartamento(String nombre){
        Departamento.singleton().setNombre(nombre);
    }
    public void consultarEstudianteDepartamento(String tipoDoc, String numDoc) {
        Departamento departamento = Departamento.singleton();
        Estudiante estudiante = departamento.consultarEstudiantes(tipoDoc, numDoc);
        if (estudiante != null) {
            System.out.println("Estudiante encontrado:");
            System.out.println("Nombre: " + estudiante.getNombres());
            System.out.println("Semestre: " + estudiante. getSemestre());
            System.out.println("Grupo: " + estudiante.getGrupo());
        } else {
            System.out.println("Estudiante no encontrado");
        }
    }

    public boolean modificarEstudiante(String tipoDoc, String numDoc, String nuevoNombre, String nuevoSemestre, String nuevoGrupo) {
        Departamento departamento = Departamento.singleton();
        departamento.modificarEstudiante(tipoDoc, numDoc,nuevoGrupo,nuevoSemestre,nuevoNombre);
        return false;
    }

    public boolean registrarEstudianteAsignatura(String codigo, String grupo, String semestre, String tipoDoc, String numDoc) {
        Departamento departamento = Departamento.singleton();
        Estudiante estudiante = departamento.consultarEstudiante(tipoDoc);
        Asignatura asignatura = departamento.consultarAsignatura(codigo, grupo, semestre);
        if (estudiante != null && asignatura !=null) {

            asignatura.registrarEstudiante(estudiante);
            System.out.println("Estudiante registrado en asignatura");
        }else {
            System.out.println("Error estudiante o asignatura no encontrada");
        }
        return false;
    }

    public void consultarEstudiantesAsignatura(String codigo, String grupo, String semestre) {
        Departamento departamento = Departamento.singleton();
        Asignatura asignatura = departamento.consultarAsignatura(codigo, grupo, semestre);
        if (asignatura != null) {
            asignatura.consultarEstudiantes();
        }else {
            System.out.println("Asignatura no encontrada");
        }
    }

    public boolean crearListaAsistencia(String codigo, String grupo, String semestre, String fecha, String horaInicio, String horaFinal) {
        Departamento departamento = Departamento.singleton();
        Asignatura asignatura = departamento.consultarAsignatura(codigo, grupo, semestre);
        if (asignatura != null) {
            asignatura.crearListaAsistenciaVacia(fecha, horaInicio, horaFinal);
            System.out.println("Lista de asistencia creada con exito");
        }
        return false;

    }

    public boolean llenarAsistencia(String codigo, String grupo, String semestre, String fecha, String horaInicio, String horaFinal) {
        Departamento departamento = Departamento.singleton();
        Asignatura asignatura = departamento.consultarAsignatura(codigo, grupo, semestre);
        if (asignatura != null) {
            asignatura.llenarAsistencia(fecha, horaInicio, horaFinal);
            System.out.println("Asistencia Registrada");

        } else {
            System.out.println("Asignatura no encontrada");
        }
        return false;
    }

    public boolean modificarAsistencia(String codAsig, String grupo, String semestre, String fecha, String horaInicio, String horaFinal, String tipoDoc, String numDoc, String nuevoEstado) {
        Departamento departamento = Departamento.singleton();
        Asignatura asignatura = departamento.consultarAsignatura(codAsig, grupo, semestre);
        if (asignatura != null) {
            return asignatura.modificarAsistencia(fecha, horaInicio, horaFinal, nuevoEstado, tipoDoc,numDoc);
        }
        return false;
    }

    public void listarAsistencias(String codigo, String grupo, String semestre, String fecha, String horaInicio) {
        Departamento departamento = Departamento.singleton();
        Asignatura asignatura = departamento.consultarAsignatura(codigo, grupo, semestre);
        if (asignatura != null) {
            asignatura.listarAsistencias(fecha, horaInicio);
        }else {
            System.out.println("Asignatura no encontrada");
        }
    }
    public boolean registrarEstudianteDepartamento(String tipoDoc, String numDoc, String nombre, String semestre, String grupo) {
        Estudiante estudiante = new Estudiante(tipoDoc,numDoc,nombre,semestre,grupo);
        Departamento departamento = Departamento.singleton();
        return departamento.registrarEstudianteDepartamento(estudiante);
    }

    public String editarDepartamento(String nombre) {
       Departamento.singleton().getNombre();
        return nombre;
    }

    public boolean agregarAsignatura(String nombre, int creditos, String codigo, String grupo, String semestre){
        Departamento departamento = Departamento.singleton();
        departamento.agregarAsignatura(nombre, creditos, codigo, grupo, semestre);
        return true;
    }

    public Asignatura consultarAsignatura(String codigo, String grupo, String semestre){
       Departamento departamento = Departamento.singleton();
       return departamento.consultarAsignatura(codigo, grupo, semestre);
    }
    public boolean modificarAsignatura(String codigo, String grupo, String semestre, String nombre, int creditos) {
        Departamento departamento = Departamento.singleton();
        departamento.modificarAsignatura(codigo, grupo, semestre, nombre, creditos);
        return true;
    }
}