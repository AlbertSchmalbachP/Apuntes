package programacion.ud5.pt5;

import java.util.ArrayList;

public class Zoologico {
    String nombre;
    ArrayList<Animal> coleccion;
    public static ArrayList<Zoologico> todosZoologicos = new ArrayList<>();

    public Zoologico(String nombre, ArrayList<Animal> coleccion) {
        this.nombre = nombre;
        this.coleccion = coleccion;
        todosZoologicos.add(this);
    }

    public Zoologico(String nombre) {
        this.nombre = nombre;
        this.coleccion = new ArrayList<>();
        todosZoologicos.add(this);
    }

    // ----------- GET Y SET

    public ArrayList<Animal> getColeccion() {
        return coleccion;
    }

    public void setColeccion(ArrayList<Animal> coleccion) {
        this.coleccion = coleccion;
    }

    // ---------------------------- METODOS NUESTROS

    /**
     * Muestra todos los animales de un zoo
     * @return String con todos los animales de un zoo
     */
    public String mostrarTodosAnimales() {
        String todosLosAnimales = "";
        for (Animal animal : coleccion) {
            todosLosAnimales += animal + "\n";
        }
        return todosLosAnimales;
    }

    /**
     * Busca en el Array de animales según un código introducido.
     * Si no existe, igualamos a null y tiramos excepcion 
     * @param codigo Codigo introducido por el usuario
     * @return El animal que se queria encontrar
     */
    public Animal buscarAnimal(String codigo) {
        Animal animalBuscar = null;
        for (Animal animal : coleccion) {
            if (animal.getCodigo().equals(codigo.toUpperCase().trim())) {
                animalBuscar = animal;
            }
        }
        if (animalBuscar == null) {
            throw new NullPointerException("El código " + codigo + " no existe.");
        }
        return animalBuscar;
    }

    /**
     * Suma a la cantidad de ejemplares de un animal buscado por código.
     * Los metodos usados externamente se encagan de lanzar / manejar Excepciones
     * @param codigo            El codigo a introducir para buscar un objeto
     * @param cantidadAgregar   La cantidad que se quiere sumar al animal indicado
     */
    public void agregarEjemplares(String codigo, int cantidadAgregar) {
        Animal animal = buscarAnimal(codigo);
        animal.setCantidadEjemplares(animal.getCantidadEjemplares() + cantidadAgregar);
    }

    /**
     * Resta a la cantidad de ejemplares de un animal buscado por un código
     * Si se restan animales y la cantidad pasase a ser negativa, se lanzaría excepcion.
     * Las funciones ajenas ya manejan que las cantidades introducidas sean positivas y correctas 
     * @param codigo            El codigo a introducir para buscar un objeto
     * @param cantidadRetirar   La cantidad que se quiere restar al animal indicado 
     */
    public void eliminarEjemplares(String codigo, int cantidadRetirar) {
        Animal animal = buscarAnimal(codigo);
        if (animal.getCantidadEjemplares() - cantidadRetirar < 0) {
            // Si se va a quedar en negativo, lanzamos esta excepción
            throw new IllegalStateException("No se pueden quedar los animales en negativo");
        }
        // Si todo está bien, restamos
        animal.setCantidadEjemplares(animal.getCantidadEjemplares() - cantidadRetirar);
    }

    /**
     * Elimina un 'animal' del ArrayList de animales del zoo.
     * No se podrá eliminar si existen ejemplares de dicho animal
     * @param codigo El codigo a introducir para buscar un objeto
     */
    public void eliminarEspecie(String codigo) {
        Animal animal = buscarAnimal(codigo);
        if (animal.getCantidadEjemplares() != 0) {
            throw new IllegalStateException("No se puede eliminar un animal con ejemplares disponibles.");
        }
        coleccion.remove(animal);
    }

    /**
     * Crea un {@link Animal} y lo añade a la coleccion del zoo.
     * @param nombre                Nombre del animal a añadir.
     * @param cantidadEjemplares    Cantidad de ejemplares que tendrá el animal.
     * @param precio                Precio del animal.
     */
    public void agregarEspecie(String nombre, int cantidadEjemplares, double precio) {
        coleccion.add(new Animal(nombre, cantidadEjemplares, precio));
    }

    /**
     * Muestra todos los zoos del ArrayList 'static' de la clase. 
     * @return String con todos los nombres de los zoos
     */
    public static String mostrarZoologicos() {
        String zoos = "";
        for (Zoologico zoologico : todosZoologicos) {
            zoos += zoologico + "\n";
        }
        return zoos;
    }

    /**
     * Busca un {@link Zoologico} por nombre entre todos los creados
     * @param nombre    Nombre del zoo a buscar
     * @return  El zoológico a buscar
     */
    public static Zoologico obtenerZooNombre(String nombre) {
        Zoologico zooBuscar = null;
        for (Zoologico zoologico : todosZoologicos) {
            if (zoologico.nombre.equals(nombre.trim())) {
                zooBuscar = zoologico;
            }
        }
        if (zooBuscar == null) {
            throw new NullPointerException("El zoológico '" + nombre + "' no existe.");
        }
        return zooBuscar;
    }

    @Override
    public String toString() {
        return "nombre del zoo: " + nombre;
    }
}