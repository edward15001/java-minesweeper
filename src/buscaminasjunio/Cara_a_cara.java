package buscaminasjunio;

import java.util.ArrayList;

/**
 *
 * @author edwar
 */
public class Cara_a_cara {

    private ArrayList<Partida> fights = new ArrayList<Partida>();
    private final Jugador player1, player2;
    Estadisticas stats;

    public Cara_a_cara(Jugador player1, Jugador player2) {
        this.player1 = player1;
        this.player2 = player2;
        fillFights();
    }

    private void fillFights() {  // Completa los cara a cara entre los jugadores
        int contadorVictorias = 0;
        int puntosJ1 = 0, puntosJ2 = 0;
        for (Partida p : this.player1.getPartidasJugadas()) {  // Busca donde participan ambos
            if ((p.getJugador_actual().equals(this.player1) || p.getJugador_actual().equals(this.player2)) && (p.getJugador_esperando().equals(this.player1) || p.getJugador_esperando().equals(this.player2))) {
                this.fights.add(p);
                if (p.getGanador().equals(this.player1)) {  // Player1
                    contadorVictorias++;
                    puntosJ1 += p.getResult().getMinasJ1();
                    puntosJ2 += p.getResult().getMinasJ2();
                } else {  // Player2
                    puntosJ1 += p.getResult().getMinasJ2();
                    puntosJ2 += p.getResult().getMinasJ1();
                }
            }
        }
        this.stats = new Estadisticas(contadorVictorias, this.fights.size() - contadorVictorias, this.fights.size(), puntosJ1, puntosJ2);
    }

    public String playerComparison() {  // Compara todas las estadísticas entre dos jugadores
        String comparison = ("Cara a cara directos: " + this.stats.getJugadas() + "\n"
                + "El jugador: " + this.player1.getUsuario() + ", tiene un total de: " + this.stats.getGanadas() + " victorias.\n"
                + "El jugador: " + this.player2.getUsuario() + ", tiene un total de: " + this.stats.getPerdidas() + " victorias.\n"
                + "El jugador:  " + this.player1.getUsuario() + ", ha encontrado un total de: " + this.stats.getMinasFavor() + " minas.Y en contra: " + this.stats.getMinasContra() + ".\n");
        int i = 1;
        for (Partida p : this.fights) {  //Recorre las partidas disputadas entre ambos jugadores.
            comparison += ("Partida " + i + ": \n" + "Ganó: " + p.getGanador().getUsuario() + "\n"
                    + "y su rival consiguio: ");
            if (p.getResult().getMinasJ1() == 26) {  // Player1
                comparison += (p.getResult().getMinasJ2() + " minas.\n");
            } else {    // Player2
                comparison += (p.getResult().getMinasJ1() + " minas.\n");
            }
            i++;
        }

        return comparison;
    }
}
