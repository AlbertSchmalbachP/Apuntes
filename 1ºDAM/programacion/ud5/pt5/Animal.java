package programacion.ud5.pt5;

public class Animal {
    private String codigo;
    private String nombre;
    private int cantidadEjemplares;
    private double precio;

    public Animal(String nombre, int cantidadEjemplares, double precio) {
        setCodigo(Faker.codigoAnimal());
        setNombre(nombre);
        setCantidadEjemplares(cantidadEjemplares);
        setPrecio(precio);
        cantidadEjemplares++;
    }

    // setters/getters
    public void setCodigo(String codigo) {
        if (!codigo.isEmpty() && !codigo.equals(null)) {
            this.codigo = codigo;
        } else {
            this.codigo = "-1";
        }
    }

    public void setNombre(String nombre) {
        if (!nombre.isEmpty() && !nombre.equals(null)) {
            this.nombre = nombre;
        } else {
            this.nombre = "-1";
        }
    }

    public void setCantidadEjemplares(int cantidadEjemplares) {
        if (cantidadEjemplares > 0) {
            this.cantidadEjemplares = cantidadEjemplares;
        } else {
            this.cantidadEjemplares = -1;
        }
    }

    public void setPrecio(double precio) {
        if (precio > 0) {
            this.precio = precio;
        } else {
            this.precio = -1;
        }
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidadEjemplares() {
        return cantidadEjemplares;
    }

    public double getPrecio() {
        return precio;
    }

    //metodos output
    public String mostrarCodigo() {
        return codigo.equals("-1")? "[Código malformado]":"El código del animal es el " + codigo + ".";
    }
    public String mostrarCantidadEjemplares() {
        return cantidadEjemplares == -1? "[Cantidad ejemplares mal introducida]":"Existen" + cantidadEjemplares + " animales.";
    }
    public String mostrarPrecio() {
        return precio == -1? "[Precio mal introducido]":"El precio del animal es de " + precio + "€.";
    }
    public String mostrarNombre() {
        return nombre.equals("-1")? "[Nombre mal introducido]":"El nombre del animal es " + nombre + ".";
    }

    @Override
    // formatear el toString
    public String toString() {
        return String.format("Codigo: %7s || Nombre del animal: %-20s || Cantidad de Ejemplares: %3d || Precio: %.2f", codigo, nombre,cantidadEjemplares, precio);
    }
}
