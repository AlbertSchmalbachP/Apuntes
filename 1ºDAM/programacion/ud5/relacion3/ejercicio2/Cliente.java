package programacion.ud5.relacion3.ejercicio2;

public class Cliente {
    static int numeroClientes;
    int id;
    String nombre;
    String dni;
    String telefono;
    String email;
    String direccion;

    Cliente(int numeroClientes, int id, String nombre, String dni, String telefono, String email, String direccion) {
        this.id = id; // TODO: autogenerar id
        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Número de clientes: " + numeroClientes + " | Cliente con ID " + id + ", nombre " + nombre + ", número de DNI " + dni + ", teléfono de contacto " + telefono + ", email de contacto " + email + " y dirección " + direccion + ".";
    }
}
