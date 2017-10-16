package recyclothes3.web.dao;

import recyclothes3.web.entities.FotoProducto;

import javax.ejb.Local;

/**
 * Created by Cesar on 21-03-2016.
 */
@Local
public interface FotoProductoDAO {

    FotoProducto obtenerFotoProducto(Long idFotoProducto);

}
