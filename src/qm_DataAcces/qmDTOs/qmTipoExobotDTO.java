package qm_DataAcces.qmDTOs;

public class qmTipoExobotDTO {
private Integer IdTipoExobo;  
private String Nombre;       
private String Estado;       
private String FechaCreacion;
private String FechaModifica;


public qmTipoExobotDTO() {
}

public qmTipoExobotDTO(String nombre) {
    IdTipoExobo = 0;
    Nombre = nombre;
}
public qmTipoExobotDTO(Integer idTipoExobo, String nombre, String estado, String fechaCreacion, String fechaModifica) {
    IdTipoExobo = idTipoExobo;
    Nombre = nombre;
    Estado = estado;
    FechaCreacion = fechaCreacion;
    FechaModifica = fechaModifica;
}

public Integer getIdTipoExobo() {
    return IdTipoExobo;
}
public void setIdTipoExobo(Integer idTipoExobo) {
    IdTipoExobo = idTipoExobo;
}
public String getNombre() {
    return Nombre;
}
public void setNombre(String nombre) {
    Nombre = nombre;
}
public String getEstado() {
    return Estado;
}
public void setEstado(String estado) {
    Estado = estado;
}
public String getFechaCreacion() {
    return FechaCreacion;
}
public void setFechaCreacion(String fechaCreacion) {
    FechaCreacion = fechaCreacion;
}
public String getFechaModifica() {
    return FechaModifica;
}
public void setFechaModifica(String fechaModifica) {
    FechaModifica = fechaModifica;
}
@Override
   public String toString(){
        return getClass().getName()
        + "\n IdTipoExobot      : "+ getIdTipoExobo      ()
        + "\n Nombre        : "+ getNombre        ()
        + "\n Estado        : "+ getEstado        ()
        + "\n FechaCreacion : "+ getFechaCreacion ()
        + "\n FechaModifica : "+ getFechaModifica ();
    }
}
