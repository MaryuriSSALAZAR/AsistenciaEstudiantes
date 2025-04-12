package Modelo;
import java.util.ArrayList;
public class Departamento {
    private String nombre;
    private static ArrayList<Asignatura> asignaturas = null;
    private static Departamento instancia = null;
    private ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();

    public Departamento() {
        nombre = "";
        asignaturas = new ArrayList<Asignatura>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static Departamento singleton() {
        if (instancia == null) {
            instancia = new Departamento();
        }
        return instancia;
    }
    public boolean registrarEstudianteDepartamento(Estudiante estudiante) {
        this.estudiantes.add(estudiante);
        return true;
    }



    public boolean agregarAsignatura(String nombre, int creditos, String codigo, String grupo, String semestre) {
        Asignatura asignatura = new Asignatura(codigo, grupo, semestre, nombre, creditos);
        asignaturas.add(asignatura);
        return true;
    }

    public Asignatura consultarAsignatura(String codigo, String grupo, String semestre) {
        for (int vc = 0; vc < asignaturas.size(); vc++) {
            Asignatura copia = asignaturas.get(vc);
            if (copia.getCodigo().equalsIgnoreCase(codigo) && copia.getGrupo().equalsIgnoreCase(grupo) && copia.getSemestre().equalsIgnoreCase(semestre) == true) {
                return copia;
            }
        }
        return null;
    }

    public boolean modificarAsignatura(String codigo, String grupo, String semestre, String nombre, int creditos) {
        Asignatura asignatura = this.consultarAsignatura(codigo, grupo, semestre);
        if (asignatura != null) {
            asignatura.setNombre(nombre);
            asignatura.setCreditos(creditos);
            return true;
        }
        return false;
    }

    public boolean registrarEstudianteAsignatura(String codAsig, String grupo, String semestre, String tipoDoc, String numDoc) {
        Asignatura asignatura = this.consultarAsignatura(codAsig, grupo, semestre);
        if (asignatura != null) {
            return asignatura.registrarEstudiante(tipoDoc);
        }
        return false;
    }

    public boolean registrarEstudianteDepartamento(String tipoDoc, String numDoc, String nombre, String semestre, String grupo) {
        for (int i = 0; i < asignaturas.size(); i++) {
            Asignatura a = asignaturas.get(i);
            if (a.getSemestre().equalsIgnoreCase(semestre) && a.getGrupo().equalsIgnoreCase(grupo)) {
                a.registrarEstudiante(tipoDoc);
            }
        }
        return true;
    }

    public void consultarEstudianteDepartamento(String tipoDoc, String numDoc) {
        for (int i = 0; i < asignaturas.size(); i++) {
            Asignatura a = asignaturas.get(i);
            a.consultarEstudiante(tipoDoc, numDoc);
        }
    }
    public Estudiante consultarEstudiante(String codigo) {
        for (Estudiante e : estudiantes) {
            if (e.getIdentificacion().equalsIgnoreCase(codigo)) {
                return e;
            }
        }
        return null;
    }
    public void modificarEstudiante(String tipoDoc, String numDoc, String nuevoNombre, String nuevoSemestre, String nuevoGrupo) {
        for (int i = 0; i < asignaturas.size(); i++) {
            Asignatura a = asignaturas.get(i);
            a.modificarEstudiante(tipoDoc, numDoc, nuevoNombre);
        }
    }

    public void consultarEstudiantesAsignatura(String codAsig, String grupo, String semestre) {
        Asignatura a = this.consultarAsignatura(codAsig, grupo, semestre);
        if (a != null) {
            a.consultarEstudiantes();
        }
    }

    public boolean crearListaAsistencia(String codAsig, String grupo, String semestre, String fecha, String horaInicio, String horaFinal) {
        Asignatura a = this.consultarAsignatura(codAsig, grupo, semestre);
        if (a != null) {
            a.crearListaAsistencia(fecha, horaInicio, horaFinal);
            return true;
        }
        return false;
    }

    public boolean llenarAsistencia(String codAsig, String grupo, String semestre, String fecha, String horaInicio, String horaFinal) {
        Asignatura a = this.consultarAsignatura(codAsig, grupo, semestre);
        if (a != null) {
            return a.llenarAsistencia(fecha, horaInicio, horaFinal);
        }
        return false;
    }

    public boolean modificarAsistencia(String codAsig, String grupo, String semestre, String fecha, String horaInicio, String horaFinal, String tipoDoc, String numDoc) {
        Asignatura a = this.consultarAsignatura(codAsig, grupo, semestre);
        if (a != null) {
            return a.modificarAsistencia(fecha, horaInicio, horaFinal, tipoDoc,codAsig,numDoc);
        }
        return false;
    }

    public void listarAsistencias(String codAsig, String grupo, String semestre, String fecha, String horaInicio) {
        Asignatura a = this.consultarAsignatura(codAsig, grupo, semestre);
        if (a != null) {
            a.listarAsistencias(fecha, horaInicio);
        }
    }

    public Estudiante consultarEstudiantes(String tipoDoc, String numDoc) {
        return null;
    }
}