package qm_BusinessLogic.qm_Entities;

import qm_BusinessLogic.qmFactoryBL;
import qm_DataAcces.qmDAOs.qmTipoExobotDAO;
import qm_DataAcces.qmDTOs.qmTipoExobotDTO;

public class qmTipoExobotBL extends qmFactoryBL<qmTipoExobotDTO>{
    public qmTipoExobotBL(){
        super(qmTipoExobotDAO.class);
    }


}
