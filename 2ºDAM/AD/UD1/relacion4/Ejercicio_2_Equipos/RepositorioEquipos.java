import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class RepositorioEquipos {

    // 2.1 - Recuperar la lista serializada con ObjectInputStream.
    // Si no existe el .dat, devolver lista vacía. Comprobar tipos, IDs y duplicados.
    public static List<Equipo> cargar(Path archivo) throws IOException {
        List<Equipo> equipos = new ArrayList<>();
        if (Files.notExists(archivo)) {
            return equipos;
        }
        try (ObjectInputStream entrada = new ObjectInputStream(Files.newInputStream(archivo))) {
            Object objeto = entrada.readObject();
            if (!(objeto instanceof List<?> lista)) {
                throw new IOException("El fichero no contiene una lista.");
            }
            Set<Integer> ids = new HashSet<>();
            for (Object elemento : lista) {
                if (!(elemento instanceof Equipo equipo)) {
                    throw new IOException("La lista contiene un elemento que no es Equipo.");
                }
                if (equipo.getId() <= 0 || !ids.add(equipo.getId())) {
                    throw new IOException("ID inválido o duplicado: " + equipo.getId());
                }
                equipos.add(equipo);
            }
        } catch (ClassNotFoundException e) {
            throw new IOException("No se encontró la clase del objeto: " + e.getMessage(), e);
        }
        return equipos;
    }

    // 2.2 - Crear carpeta y guardar la LISTA COMPLETA con ObjectOutputStream.
    // No usar APPEND en ficheros serializados.
    public static void guardar(Path archivo, List<Equipo> lista) throws IOException {
        Files.createDirectories(archivo.getParent());
        try (ObjectOutputStream salida = new ObjectOutputStream(Files.newOutputStream(archivo))) {
            salida.writeObject(lista);
        }
    }

    // MÉTODO DE APOYO COMPLETO: busca por ID sin leer archivos.
    public static Equipo buscar(List<Equipo> lista, int id) {
        for (Equipo equipo : lista) {
            if (equipo.getId() == id) {
                return equipo;
            }
        }
        return null;
    }

    // 2.3 - Modificar SOLO en memoria. Devolver false si ID desconocido
    // o unidades < 0. NO guardar aquí: lo hará Main en opción 4.
    public static boolean cambiarUnidades(List<Equipo> lista, int id, int unidades) {
        Equipo equipo = buscar(lista, id);
        if (equipo == null || unidades < 0) {
            return false;
        }
        equipo.setUnidades(unidades);
        return true;
    }

    // 2.4 - Exportar DOM XML. Crear raíz <equipos> y cada <equipo id="...">.
    // Dentro, <nombre> y <unidades>. No concatenar cadenas XML manualmente.
    // Los errores de XML se convierten en IOException para simplificar Main.
    public static void exportarXml(Path archivo, List<Equipo> lista) throws IOException {
        try {
            Document documento = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Element raiz = documento.createElement("equipos");
            documento.appendChild(raiz);

            for (Equipo e : lista) {
                Element equipo = documento.createElement("equipo");
                equipo.setAttribute("id", String.valueOf(e.getId()));

                Element nombre = documento.createElement("nombre");
                nombre.setTextContent(e.getNombre());
                Element unidades = documento.createElement("unidades");
                unidades.setTextContent(String.valueOf(e.getUnidades()));

                equipo.appendChild(nombre);
                equipo.appendChild(unidades);
                raiz.appendChild(equipo);
            }

            Files.createDirectories(archivo.getParent());
            Transformer transformador = TransformerFactory.newInstance().newTransformer();
            transformador.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformador.setOutputProperty(OutputKeys.INDENT, "yes");
            transformador.transform(new DOMSource(documento), new StreamResult(archivo.toFile()));
        } catch (ParserConfigurationException | TransformerException e) {
            throw new IOException("No se pudo exportar el XML: " + e.getMessage(), e);
        }
    }
}