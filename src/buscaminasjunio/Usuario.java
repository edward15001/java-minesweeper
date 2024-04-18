package buscaminasjunio;

import java.io.Serializable;

/**
 * @author edwar
 */
public abstract class Usuario implements Serializable {

    private final String nombre, contrasenia;
    private static Almacen_usuarios usuariosTotal = new Almacen_usuarios();

    public Usuario(String n, String c) {
        this.nombre = n;
        this.contrasenia = c;
    }

    public Almacen_usuarios getUsuariosTotal() {
        return usuariosTotal;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getContrasenia() {
        return this.contrasenia;
    }

    @Override
    public boolean equals(Object o) {  // Comparador de usuarios
        if (o == this) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (this.getClass() != o.getClass()) {
            return false;
        }

        if (o instanceof Jugador && this instanceof Jugador) {
            Jugador cast = (Jugador) o;
            return (this.getNombre().equals(cast.getNombre()) && this.getContrasenia().equals(cast.getContrasenia()));
        } else if (o instanceof Administrador && this instanceof Administrador) {
            Administrador cast = (Administrador) o;
            return (this.getNombre().equals(cast.getNombre()) && this.getContrasenia().equals(cast.getContrasenia()));
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return this.getNombre();
    }

    public String ordenarPorVictorias() {   // Devuelve los jugadores ordenados por vistorias
        String lista = "";
        for (Jugador j : this.getUsuariosTotal().clasificacion_por_victorias()) {
            lista += (j.verPerfil() + "\n");
        }
        return lista;
    }

    public String ordenarPorNombre() {      // Devuelve los jugadores ordenados por nombre
        String lista = "";
        for (Jugador j : this.getUsuariosTotal().clasificacion_por_nombre()) {
            lista += (j.verPerfil() + "\n");
        }
        return lista;
    }

}
