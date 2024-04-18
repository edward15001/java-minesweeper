package buscaminasjunio;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author edwar
 */
public class Jugador extends Usuario implements Serializable {

    private Estadisticas info = new Estadisticas();
    private ArrayList<Partida> partidasTotal = new ArrayList<Partida>();
    private Cara_a_cara faceit;

    public Jugador(String nombre, String contrasenia) {
        super(nombre, contrasenia);
        partidasTotal = new ArrayList<Partida>();
    }

    public ArrayList<Partida> getPartidasJugadas() {
        return this.partidasTotal;
    }

    public void reloadStats(Partida p, int minesFound, int minesAgainst) {  // Actualiza las estadísticas
        this.getEstadisticas().statsEdit(this.equals(p.getGanador()), minesFound, minesAgainst);
    }

    public Estadisticas getEstadisticas() {
        return this.info;
    }

    public String getUsuario() {
        return this.getNombre();
    }

    public String getClave() {
        return this.getContrasenia();
    }

    public void addPlay(Partida newPlay) {
        this.partidasTotal.add(newPlay);
    }

    @Override
    public boolean equals(Object o) {  // Comparación de jugadores
        if (o == this) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (o.getClass() != this.getClass()) {
            return false;
        }

        Jugador aux = (Jugador) o;
        return (aux.getClave().equals(this.getClave()) && aux.getUsuario().equals(this.getUsuario()));
    }

    public String verPerfil() {  // Estadísticas de cada jugador
        return ("Nombre: " + this.getUsuario() + "\n"
                + "Estadisticas: \n" + this.getEstadisticas().printStats());
    }

    public void crearComparativa(Jugador j2) {  // Guarda los datos de los cara a cara
        faceit = new Cara_a_cara(this, j2);
    }

    public Cara_a_cara getFaceit() {
        return this.faceit;
    }

    public boolean partidaRepetida(Partida p) {
        boolean resultado = false;
        for (Partida par : this.partidasTotal) {
            if (par.equals(p)) {
                resultado = true;
            }
        }
        return resultado;
    }
}
