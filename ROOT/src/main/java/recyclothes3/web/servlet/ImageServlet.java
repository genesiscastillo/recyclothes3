package recyclothes3.web.servlet;

import org.apache.log4j.Logger;
import recyclothes3.web.dao.FotoProductoDAO;
import recyclothes3.web.entities.FotoProducto;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

@WebServlet("/imageServlet")
public class ImageServlet extends HttpServlet {

    static final Logger LOGGER = Logger.getLogger(ImageServlet.class);
    private static final long serialVersionUID = 1L;

    @Inject
    FotoProductoDAO fotoProductoDAO;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Long idFotoProducto = Long.valueOf(request.getParameter("id"));
            LOGGER.info("\n\t\tidFotoProducto = " + idFotoProducto + " " + new Date().getTime());

            FotoProducto fotoProducto = fotoProductoDAO.obtenerFotoProducto(idFotoProducto);
            LOGGER.info("\tobtenerFotoProducto=" + fotoProducto);
            ByteArrayInputStream iStream = null;
            if (fotoProducto != null) {
                iStream = new ByteArrayInputStream(fotoProducto.getFoto());
                response.setContentType("image/jpg");
            } else {
                InputStream in = getClass().getClassLoader().getResourceAsStream("imagen-no-disponible.png");
                response.setContentType("image/png");

                byte[] buff = new byte[8000];
                int bytesRead = 0;

                ByteArrayOutputStream bao = new ByteArrayOutputStream();

                while ((bytesRead = in.read(buff)) != -1) {
                    bao.write(buff, 0, bytesRead);
                }

                byte[] data = bao.toByteArray();

                iStream = new ByteArrayInputStream(data);
            }
            int length = iStream.available();

            response.setContentLength(length);

            ServletOutputStream oStream = response.getOutputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = iStream.read(buffer)) != -1) {
                oStream.write(buffer, 0, len);
            }
            iStream.close();

            oStream.flush();
            oStream.close();
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw e;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        doGet(request, response);
    }
}