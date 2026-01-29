package qm_DataAcces.qmDAOs;

import qm_DataAcces.qmDTOs.qmExobotDTO;
import qm_DataAcces.qmHelpers.qmSQLiteDataHelper;
import qm_Infrastructure.qmAppException;

public class qmExobotDAO extends qmSQLiteDataHelper<qmExobotDTO>{

    public qmExobotDAO() throws qmAppException {
        super(qmExobotDTO.class,"Exobot","IdExobot");
    }

}