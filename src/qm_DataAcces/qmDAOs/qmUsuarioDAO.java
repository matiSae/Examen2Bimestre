package qm_DataAcces.qmDAOs;

import qm_DataAcces.qmDTOs.qmUsuarioDTO;
import qm_DataAcces.qmHelpers.qmSQLiteDataHelper;
import qm_Infrastructure.qmAppException;
import java.sql.*;

public class qmUsuarioDAO extends qmSQLiteDataHelper<qmUsuarioDTO>{

    public qmUsuarioDAO() throws qmAppException {
        super(qmUsuarioDTO.class,"Usuario","IdUsuario");
    }

    /**
     * Busca un usuario por su cédula
     */
    public qmUsuarioDTO read(String cedula) throws qmAppException {
        String sql = "SELECT * FROM Usuario WHERE Cedula = ? AND Estado = 'A'";
        try (PreparedStatement stmt = openConnection().prepareStatement(sql)) {
            stmt.setString(1, cedula);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next() ? mapResultSetToEntity(rs) : null;
            }
        } catch (SQLException e) {
            throw new qmAppException(null, e, getClass(), "read");
        }
    }
}

