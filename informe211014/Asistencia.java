package Modelo;
import java.util.ArrayList;
public class Asistencia {
    private String fecha ="";//aaaa//mm//dd
    private String hora_de_inicio="";
    private String hora_final="";
    private static Asistencia instancia = null;

    public static Asistencia singleton(){
        if(instancia == null){
            instancia = new Asistencia();
        }
        return instancia;
    }

    private ArrayList<String> codigos = new ArrayList<String>();
    private ArrayList<String> estados= new ArrayList<String>();//0A tiempo, 1:tarde y 2:no llego

    public Asistencia(){
    }

    public Asistencia(String fecha, String hora_de_inicio, String hora_final){
        this.fecha = fecha;
        this.hora_de_inicio = hora_de_inicio;
        this.hora_final = hora_final;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setHora_de_inicio(String hora_de_inicio) {
        this.hora_de_inicio = hora_de_inicio;
    }

    public void setHora_final(String hora_final) {
        this.hora_final = hora_final;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora_de_inicio() {
        return hora_de_inicio;
    }

    public String getHora_final() {
        return hora_final;
    }

    public boolean adicionarAsistencia(String codigo, String estado){
        if (codigos.contains(codigo)) {
            return false;
        }
        codigos.add(codigo);
        estados.add(estado);
        return true;
    }

    public String consultarAsistencia (String codigo){
        for (int vc=0; vc<codigos.size();vc++){
            if (codigos.get(vc).equalsIgnoreCase(codigo) == true){
                return estados.get(vc);
            }
        }
        return null;
    }

    public boolean modificarAsistencia (String codigo, String estado){
        for (int vc=0;vc<codigos.size();vc++){
            if (codigos.get(vc).equalsIgnoreCase(codigo)==true){
                estados.set(vc, estado);
                return true;
            }
        }
        return false;
    }

    public ArrayList<String> getCodigos() {
        return codigos;
    }

    public ArrayList<String> getEstados() {
        return estados;
    }

    public boolean setCodigos (ArrayList<String> codigos){
        this.codigos = codigos;
        return true;
    }

    public boolean setEstados (ArrayList<String> estados){
        this.estados = estados;
        return true;
    }

    public void modificarEstado(String codigoEstudiante, String nuevoEstado) {
        for (int i = 0; i < codigos.size(); i++) {
            if (codigos.get(i).equals(codigoEstudiante)) {
                estados.set(i, nuevoEstado);
            }
        }
    }

    public void adicionarRegistro(String codigoEstudiante, String estado) {
        codigos.add(codigoEstudiante);
        estados.add(estado);
    }

    public void modificarRegistro(String codigoEstudiante, String nuevoEstado) {
        modificarEstado(codigoEstudiante, nuevoEstado);
    }

    public void registrarEstado(String codigoEstudiante, String estado) {
        adicionarRegistro(codigoEstudiante, estado);
    }

    public ArrayList<String> listarRegistros() {
        return estados;
    }

    public String getHorainicio() {
        return this.hora_de_inicio;
    }
}
