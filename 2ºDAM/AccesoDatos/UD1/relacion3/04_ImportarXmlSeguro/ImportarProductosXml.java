import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class ImportarProductosXml {

    public static void main(String[] args) {

        Path correctos = Path.of("2ºDAM", "AccesoDatos", "UD1", "relacion3", "04_ImportarXmlSeguro", "datos", "productos_correctos.xml");
        Path erroneos = Path.of("2ºDAM", "AccesoDatos", "UD1", "relacion3", "04_ImportarXmlSeguro", "datos", "productos_erroneos.xml");
        for (Path archivo : List.of(correctos, erroneos)) {
            List<Producto> productosActuales = new ArrayList<>();
            productosActuales.add(new Producto(99, "Producto existente", 10.0, 1));
            try {
                //  1: comprobar Files.exists(...).
                if (Files.notExists(archivo)) {
                    System.out.println("El archivo no existe.");
                } else {
                    // 2: configurar DocumentBuilderFactory desactivando DTD y entidades externas.
                    DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
                    fabrica.setFeature(
                    "http://apache.org/xml/features/disallow-doctype-decl",
                    true);
                    fabrica.setFeature(
                    "http://xml.org/sax/features/external-general-entities",
                    false);
                    fabrica.setFeature(
                    "http://xml.org/sax/features/external-parameter-entities",
                    false);
                    fabrica.setXIncludeAware(false);
                    fabrica.setExpandEntityReferences(false);
                    Document documento = fabrica.newDocumentBuilder().parse(archivo.toFile());
                    NodeList elementos = documento.getElementsByTagName("producto");
                    Element raiz = documento.getDocumentN
                    List<Producto> importados = new ArrayList<>();
                    // 3: leer y validar todo en una lista temporal.
                    for (int i = 0; i < elementos.getLength(); i++) {
                        Element productoXml = (Element) elementos.item(i);
                        NodeList nombres = productoXml.getElementsByTagName("nombre");
                        NodeList precios = productoXml.getElementsByTagName("precio");
                        NodeList stocks = productoXml.getElementsByTagName("stock");
                        if (nombres.getLength() != 1 || precios.getLength() != 1 || stocks.getLength() != 1) {
                            throw new IllegalArgumentException("Faltan campos en el producto " + (i + 1));
                        }
                        int id = Integer.parseInt(productoXml.getAttribute("id"));
                        String nombre = nombres.item
                    }
                    // TODO 4: comprobar IDs duplicados.
                    // TODO 5: sustituir productosActuales solo si TODO el XML es válido.
                }
            } catch (Exception e) {
                System.err.println("No se pudo importar.");
            }
        }
    }
}
