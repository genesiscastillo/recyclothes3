package recyclothes3.web.dao;

import org.apache.log4j.Logger;
import recyclothes3.web.entities.FotoProducto;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import java.sql.*;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class FotoProductoDAOImpl implements FotoProductoDAO {

    static final Logger LOGGER = Logger.getLogger(FotoProductoDAOImpl.class);

    @Override
    public FotoProducto obtenerFotoProducto(Long idFotoProducto) {
        LOGGER.info("obtenerFotoProducto....."+idFotoProducto);
        String sql = "select id_foto_producto , id_producto , foto from tb_foto_producto where id_foto_producto = ?";
        FotoProducto fotoProducto = null;
        try(Connection connection = AccesoBD.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);){
            preparedStatement.setLong(1,idFotoProducto);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                fotoProducto = new FotoProducto();
                fotoProducto.setFoto(resultSet.getBytes("foto"));
                fotoProducto.setId_foto_producto(resultSet.getLong("id_foto_producto"));
                fotoProducto.setId_producto(resultSet.getLong("id_producto"));
            }
        }catch(SQLException e)  {
            LOGGER.error(e.getMessage());
        }
        return fotoProducto;
    }

}
