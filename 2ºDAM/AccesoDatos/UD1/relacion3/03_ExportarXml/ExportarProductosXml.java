import java.nio.file.Files;
import java.nio.file.Path;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ExportarProductosXml {
    public static void main(String[] args) throws Exception {

        Path archivo = Path.of("2ºDAM", "AccesoDatos", "UD1", "relacion3", "02_GestionBinaria", "datos", "productos.xml");

        // 1: crear una lista de productos.
        String[][] productos = {
            {"1", "Webcam 720p", "25.95", "4"},
            {"2", "Auriculares inalámbricos", "19.97", "6"}
        };
        // 2: crear un Document y la raíz <productos>.
        Document documento = DocumentBuilderFactory.newInstance()
            .newDocumentBuilder().newDocument();
        Element raiz = documento.createElement("productos");
        documento.appendChild(raiz);
        // 3: añadir un <producto> por cada objeto.
        for (String[] fila : productos) {
            Element producto = documento.createElement("producto");
            producto.setAttribute("id", fila[0]);
            Element nombre = documento.createElement("nombre");
            nombre.setTextContent(fila[1]);
            Element precio = documento.createElement("precio");
            precio.setTextContent(fila[2]);
            Element stock = documento.createElement("stock");
            stock.setTextContent(fila[3]);
            producto.appendChild(nombre);
            producto.appendChild(precio);
            producto.appendChild(stock);
            raiz.appendChild(producto);
        }
        // 4: guardar con Transformer en UTF-8 e indentado.
        Path ruta = Path.of("productos", "productos.xml");
        Files.createDirectories(ruta.getParent());
        Transformer transformador = TransformerFactory.newInstance().newTransformer();
        transformador.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformador.setOutputProperty(OutputKeys.INDENT, "yes");
        transformador.transform(new DOMSource(documento), new StreamResult(ruta.toFile()));
        System.out.println("XML guardado en " + ruta.toAbsolutePath());
    }
}
