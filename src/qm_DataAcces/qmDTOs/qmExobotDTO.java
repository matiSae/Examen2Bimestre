package qm_DataAcces.qmDTOs;

public class qmExobotDTO {

private Integer IdExobot;     
private Integer IdTipoExobot; 
private Integer IdTipoArma;   
private String Entreno;      
private Integer NoAccion;     
private String Estado;       
private String FechaCreacion;
private String FechaModifica;

public qmExobotDTO() {
    }
public qmExobotDTO(Integer idTipoExobot, Integer idTipoArma, String entreno, Integer noAccion) {
    IdExobot=0;
    IdTipoExobot = idTipoExobot;
    IdTipoArma = idTipoArma;
    Entreno = entreno;
    NoAccion = noAccion;
}
public qmExobotDTO(Integer idExobot, Integer idTipoExobot, Integer idTipoArma, String entreno, Integer noAccion,
        String estado, String fechaCreacion, String fechaModifica) {
    IdExobot = idExobot;
    IdTipoExobot = idTipoExobot;
    IdTipoArma = idTipoArma;
    Entreno = entreno;
    NoAccion = noAccion;
    Estado = estado;
    FechaCreacion = fechaCreacion;
    FechaModifica = fechaModifica;
}
public Integer getIdExobot() {
    return IdExobot;
}
public void setIdExobot(Integer idExobot) {
    IdExobot = idExobot;
}
public Integer getIdTipoExobot() {
    return IdTipoExobot;
}
public void setIdTipoExobot(Integer idTipoExobot) {
    IdTipoExobot = idTipoExobot;
}
public Integer getIdTipoArma() {
    return IdTipoArma;
}
public void setIdTipoArma(Integer idTipoArma) {
    IdTipoArma = idTipoArma;
}
public String getEntreno() {
    return Entreno;
}
public void setEntreno(String entreno) {
    Entreno = entreno;
}
public Integer getNoAccion() {
    return NoAccion;
}
public void setNoAccion(Integer noAccion) {
    NoAccion = noAccion;
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
        + "\n IdExobot      : "+ getIdExobot     ()
        + "\n IdTipoExobot     : "+ getIdTipoExobot    ()
        + "\n IdTipoArma      : "+ getIdTipoArma     ()
        + "\n Entreno      : "+ getEntreno     ()
        + "\n NoAccion      : "+ getNoAccion     ()
        + "\n Estado        : "+ getEstado        ()
        + "\n FechaCreacion : "+ getFechaCreacion ()
        + "\n FechaModifica : "+ getFechaModifica ();
    }
}
