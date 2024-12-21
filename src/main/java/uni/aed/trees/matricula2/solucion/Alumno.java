package uni.aed.trees.matricula2.solucion;

class Alumno {
  private String codigo;
  private String nombres;
  private String apellidos;

  public Alumno(String codigo, String nombres, String apellidos) {
    this.codigo = codigo;
    this.nombres = nombres;
    this.apellidos = apellidos;
  }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

  @Override
  public String toString() {
    return codigo + "|" + nombres + "|" + apellidos;
  }
}

