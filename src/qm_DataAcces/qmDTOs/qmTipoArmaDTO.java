package qm_DataAcces.qmDTOs;

public class qmTipoArmaDTO {
private Integer IdTipoArma;   
private String Nombre;       
private String Estado;       
private String FechaCreacion;
private String FechaModifica;


public qmTipoArmaDTO() {
}
public qmTipoArmaDTO(String nombre) {
    IdTipoArma = 0;
    Nombre = nombre;
}
public qmTipoArmaDTO(Integer idTipoArma, String nombre, String estado, String fechaCreacion, String fechaModifica) {
    IdTipoArma = idTipoArma;
    Nombre = nombre;
    Estado = estado;
    FechaCreacion = fechaCreacion;
    FechaModifica = fechaModifica;
}
public Integer getIdTipoArma() {
    return IdTipoArma;
}
public void setIdTipoArma(Integer idTipoArma) {
    IdTipoArma = idTipoArma;
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
        + "\n IdTipoArma      : "+ getIdTipoArma      ()
        + "\n Nombre        : "+ getNombre        ()
        + "\n Estado        : "+ getEstado        ()
        + "\n FechaCreacion : "+ getFechaCreacion ()
        + "\n FechaModifica : "+ getFechaModifica ();
    }

}
