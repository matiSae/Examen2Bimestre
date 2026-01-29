package qm_DataAcces.qmDTOs;

public class qmUsuarioDTO {
    private Integer IdUsuario;     
    private String Usuario;      
    private String Contrasena;   
    private String Cedula;       
    private String Estado;       
    private String FechaCreacion;
    private String FechaModifica;
    
    public qmUsuarioDTO() {
    }
    public qmUsuarioDTO(String usuario, String contrasena, String cedula) {
        IdUsuario = 0;
        Usuario = usuario;
        Contrasena = contrasena;
        Cedula = cedula;
    }
    public qmUsuarioDTO(Integer idUsuario, String usuario, String contrasena, String cedula, String estado,
            String fechaCreacion, String fechaModifica) {
        IdUsuario = idUsuario;
        Usuario = usuario;
        Contrasena = contrasena;
        Cedula = cedula;
        Estado = estado;
        FechaCreacion = fechaCreacion;
        FechaModifica = fechaModifica;
    }
    public Integer getIdUsuario() {
        return IdUsuario;
    }
    public void setIdUsuario(Integer idUsuario) {
        IdUsuario = idUsuario;
    }
    public String getUsuario() {
        return Usuario;
    }
    public void setUsuario(String usuario) {
        Usuario = usuario;
    }
    public String getContrasena() {
        return Contrasena;
    }
    public void setContrasena(String contrasena) {
        Contrasena = contrasena;
    }
    public String getCedula() {
        return Cedula;
    }
    public void setCedula(String cedula) {
        Cedula = cedula;
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

    public boolean estaActivo() {
        return "A".equals(Estado);
    }

    @Override
   public String toString(){
        return getClass().getName()
        + "\n IdUsuario      : "+ getIdUsuario     ()
        + "\n IdContrasena     : "+ getContrasena    ()
        + "\n Estado        : "+ getEstado        ()
        + "\n FechaCreacion : "+ getFechaCreacion ()
        + "\n FechaModifica : "+ getFechaModifica ();
    }
}
