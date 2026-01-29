package qm_DataAcces.qmInterfaces;

import java.util.List;

import qm_Infrastructure.qmAppException;


public interface IqmDAO<T> {
    List<T> readAll()            throws qmAppException;
    T       readBy (Integer id)  throws qmAppException;
    boolean create (T entity)    throws qmAppException;
    boolean update (T entity)    throws qmAppException;
    boolean delete (Integer id)  throws qmAppException;
    Integer getCountReg()        throws qmAppException;
    Integer getMinReg(String tableCelName) throws qmAppException;
    Integer getMaxReg(String tableCelName) throws qmAppException;
}
