package buscaminasjunio;

/**
 *
 * @author edwar
 */
public class Administrador extends Usuario {

    public Administrador() {
        super("admin", "admin");
    }

    public boolean autenticar(Usuario u) {
        if (u instanceof Administrador) {
            return this.equals(u);
        } else {
            return false;
        }
    }
}
