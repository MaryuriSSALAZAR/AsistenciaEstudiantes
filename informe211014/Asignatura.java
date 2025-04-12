package Modelo;
import java.util.ArrayList;
public class Asignatura {
    private String codigo = "";
    private String grupo = "";
    private String semestre = "";
    private String nombre = "";
    private int creditos = 0;
    private ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();
    private static Asignatura instancia = null;
    private int Creditos;
    public static Asignatura singleton() {
        if (instancia == null) {
            instancia = new Asignatura();
        }
        return instancia;
    }

    private ArrayList<Asistencia> asistencias = new ArrayList<Asistencia>();

    public Asignatura(String codigo, String grupo, String semestre, String nombre, int creditos){
        this.codigo = codigo;
        this.grupo = grupo;
        this.semestre = semestre;
        this.nombre = nombre;
        this.creditos = creditos;
        this.estudiantes = new ArrayList<Estudiante>();
        this.asistencias =new ArrayList<Asistencia>();

    }
    public Asignatura(){
        //creditos = 0;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getGrupo() {
        return grupo;
    }
    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
    public String getSemestre() {
        return semestre;
    }
    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getCreditos() {
        return creditos;
    }
    public void setCreditos(int creditos) {
        this.Creditos = creditos;
    }
    @Override
    public String toString(){
        return "----------------------\nInformación de la asignatura: \nCódigo "+codigo+"\nGrupo: "+grupo+"\nSemestre: "+semestre+"\nNombre: "+nombre+"\nCréditos: "+creditos;
    }
    public boolean adicionarAsistencia(String fecha, String hora_de_incio, String hora_final, ArrayList<String> codigos, ArrayList<String> estados){
        Asistencia asistencia = new Asistencia(fecha, hora_de_incio, hora_final);
        for(int vc = 0; vc<codigos.size();vc++){
            String codigo = codigos.get(vc);
            String estado = estados.get(vc);
            asistencia.adicionarAsistencia(codigo,estado);
        }
        asistencias.add(asistencia);
        return true;
    }
    public boolean registrarEstudiante(Estudiante e) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getIdentificacion().equalsIgnoreCase(e.getIdentificacion())) {
                return false;
            }
        }
        estudiantes.add(e);
        return true;
    }

    public Asistencia consultarAsistencia(String fecha, String hora_de_inicio, String hora_final){
        for(int vc = 0; vc<asistencias.size();vc++){
            if(asistencias.get(vc).getFecha().equalsIgnoreCase(fecha) && asistencias.get(vc).getHora_de_inicio().equalsIgnoreCase(hora_de_inicio) && asistencias.get(vc).getHora_final().equalsIgnoreCase(hora_final)){
                return asistencias.get(vc);
            }
        }return null;
    }
    public Estudiante consultarEstudiante(String tipo, String id) {
        for (int i = 0; i < estudiantes.size(); i++) {
            Estudiante e = estudiantes.get(i);
            if (e.getTipoID().equalsIgnoreCase(tipo) && e.getIdentificacion().equalsIgnoreCase(id)) {
                return e;
            }
        }
        return null;
    }
    public boolean modificarEstudiante(String tipo, String id, String nombre) {
        Estudiante estudiante = consultarEstudiante(tipo, id);
        if (estudiante != null) {
            estudiante.setNombres(nombre);
            return true;
        }
        return false;
    }

    public boolean modificarAsistencia(String fecha, String horaInicio, String horaFinal, String tipoID, String identificacion, String nuevoEstado) {
        Asistencia asistencia = this.consultarAsistencia(fecha, horaInicio, horaFinal);
        if (asistencia != null) {
            asistencia.modificarEstado(tipoID, identificacion);
        }
        return false;
    }

    public boolean registrarEstudiante(String estudiante) {
        Estudiante e = new Estudiante();
        e.setIdentificacion(estudiante); // suponiendo que el string es el ID
        estudiantes.add(e);
        return true;
    }

    public void consultarEstudiantes() {
        for (int i = 0; i < estudiantes.size(); i++) {
            Estudiante e = estudiantes.get(i);
            System.out.println("Nombre: " + e.getNombres() + " - ID: " + e.getIdentificacion() + " - Tipo ID: " + e.getTipoID());
        }
    }

    public boolean crearListaAsistenciaVacia(String fecha, String horaInicio, String horaFinal) {
        Asistencia nueva = new Asistencia(fecha, horaInicio, horaFinal);
        for (int i = 0; i < estudiantes.size(); i++) {
            Estudiante est = estudiantes.get(i);
            nueva.adicionarRegistro(est.getIdentificacion(), "Ausente");
        }
        asistencias.add(nueva);
        return true;
    }

    public boolean llenarAsistencia(String fecha, String horaInicio, String horaFinal) {
        Asistencia asistencia = consultarAsistencia(fecha, horaInicio, horaFinal);
        if (asistencia != null) {
            for (int i = 0; i < estudiantes.size(); i++) {
                Estudiante est = estudiantes.get(i);
                asistencia.modificarRegistro(est.getIdentificacion(), "Presente");
            }
            return true;
        }
        return false;
    }
    public void crearListaAsistencia(String fecha, String horaInicio, String horaFinal){
        Asistencia asistencia = new Asistencia(fecha, horaInicio, horaFinal);
        for(Estudiante estudiante : estudiantes){
            asistencia.registrarEstado(estudiante.getNumDoc(), "No Registrado");
        }
        asistencias.add(asistencia);
    }
    public boolean listarAsistencias(String fecha, String horaInicio) {
        for (int i = 0; i < asistencias.size(); i++) {
            Asistencia asistencia = asistencias.get(i);
            if (asistencia.getFecha().equalsIgnoreCase(fecha) && asistencia.getHora_de_inicio().equalsIgnoreCase(horaInicio)) {
                System.out.println("Asistencia de fecha: " + fecha + ", Hora inicio: " + horaInicio);
                asistencia.listarRegistros();
                return true;
            }
        }
        return false;
    }

}
