package Modelo;

public class Estudiante {

    private String nombres;
    private String identificacion;
    private String tipoID;
    private String grupo;
    private String semestre;

    public Estudiante(String tipoDoc, String numDoc, String nombre, String semestre, String grupo) {

    }

    public Estudiante() {

    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getTipoID() {
        return tipoID;
    }

    public void setTipoID(String tipoID) {
        this.tipoID = tipoID;
    }

    // Alias para compatibilidad con otras clases

    public String getNumDoc() {
        return identificacion;
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

}