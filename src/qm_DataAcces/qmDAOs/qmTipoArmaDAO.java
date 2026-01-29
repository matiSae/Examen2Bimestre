package qm_DataAcces.qmDAOs;

import qm_DataAcces.qmDTOs.qmTipoArmaDTO;
import qm_DataAcces.qmHelpers.qmSQLiteDataHelper;
import qm_Infrastructure.qmAppException;

public class qmTipoArmaDAO extends qmSQLiteDataHelper<qmTipoArmaDTO>{

    public qmTipoArmaDAO() throws qmAppException {
        super(qmTipoArmaDTO.class,"TipoArma","IdTipoArma");
    }

}