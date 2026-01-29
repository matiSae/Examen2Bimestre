
package qm_BusinessLogic;

import java.util.List;

import qm_DataAcces.qmInterfaces.IqmDAO;
import qm_Infrastructure.qmAppException;


public class qmFactoryBL<T>  {
    private final IqmDAO<T> oDAO;

    public qmFactoryBL(Class<? extends IqmDAO<T>> classDAO) {
        try {
            this.oDAO = classDAO.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            qmAppException er = new qmAppException("Error al instanciar classDAO<T>", e, getClass(), "FactoryBL(<T>)");
            throw new RuntimeException(er);
        }
    }
 
    public List<T> getAll() throws qmAppException{
         return oDAO.readAll();
    }

    public T getBy(Integer id) throws qmAppException {
        return oDAO.readBy(id);
    }

    public boolean add(T oT) throws qmAppException {
        return oDAO.create(oT);
    }

    public boolean upd(T oT) throws qmAppException {
        return oDAO.update(oT);
    }

    public boolean del(Integer id) throws qmAppException  {
        return oDAO.delete(id);
    }

    public Integer getMaxReg(String cellName) throws qmAppException{
        return oDAO.getMaxReg(cellName);
    }

    public Integer getMinReg(String cellName) throws qmAppException{
        return oDAO.getMinReg(cellName);
    }

    public Integer getCountReg() throws qmAppException{
        return oDAO.getCountReg();
    }
}
