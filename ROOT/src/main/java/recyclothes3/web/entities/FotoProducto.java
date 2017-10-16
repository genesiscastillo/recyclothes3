package recyclothes3.web.entities;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FotoProducto {

  private Long id_foto_producto;

  private Long id_producto;


  private byte[] foto;

  public Long getId_foto_producto() {
    return id_foto_producto;
  }

  public void setId_foto_producto(Long id_foto_producto) {
    this.id_foto_producto = id_foto_producto;
  }

  public Long getId_producto() {
    return id_producto;
  }

  public void setId_producto(Long id_producto) {
    this.id_producto = id_producto;
  }

  public byte[] getFoto() {
    return foto;
  }

  public void setFoto(byte[] foto) {
    this.foto = foto;
  }

  public static FotoProducto fromResultSet(ResultSet resultSet) throws SQLException {
    FotoProducto fotoProducto = null;
    if(resultSet.next()) {
      fotoProducto = new FotoProducto();
      fotoProducto.setFoto(resultSet.getBytes("foto"));
      fotoProducto.setId_foto_producto(resultSet.getLong("id_foto_producto"));
      fotoProducto.setId_producto(resultSet.getLong("id_producto"));
    }
    return fotoProducto;
  }
  @Override
  public String toString() {
    return "FotoProducto{id_producto=" + id_producto +", id_foto_producto=" + id_foto_producto +'}';
  }
}
