package qm_BusinessLogic.qm_Entities;

import qm_DataAcces.qmDTOs.qmUsuarioDTO;

public class qmUsuarioBL {

    private qmUsuarioDTO data;

    public qmUsuarioBL(qmUsuarioDTO dto) {
        this.data = dto;
    }

    public boolean estaActivo() {
        return "A".equals(data.getEstado());
    }

}
