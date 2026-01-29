package qm_DataAcces.qmDAOs;

import qm_DataAcces.qmDTOs.qmTipoExobotDTO;
import qm_DataAcces.qmHelpers.qmSQLiteDataHelper;
import qm_Infrastructure.qmAppException;

public class qmTipoExobotDAO extends qmSQLiteDataHelper<qmTipoExobotDTO>{

    public qmTipoExobotDAO() throws qmAppException {
        super(qmTipoExobotDTO.class,"TipoExobot","IdTipoExobot");
    }

}
