package buscaminasjunio;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author edwar
 */
public class Partida implements Serializable {

    private Jugador jugador_actual, jugador_esperando, ganador;
    private Tablero tab = new Tablero();
    private Marcador result = new Marcador();
    private ArrayList<Movimiento> movs = new ArrayList<Movimiento>();
    private static Almacen_partidas aml;
    private transient int posX, posY;   // Posicion que ocupan las casillas
    private transient boolean jugador1; // Identificador para jugador actual y ganador
    private transient Color colorCasilla = Color.RED;

    public Partida(Jugador first, Jugador second) {  // Crea la partida inicializando el tablero y los jugadores
        jugador_actual = first;
        jugador_esperando = second;
        jugador1 = true;
    }

    public void info_partida() {
        aml.info_partida(this);
    }

    public void jugar() {
        if (tab.hayMina(this.posX, this.posY)) {  // Actualiza el marcador si se selecciona una mina
            if (jugador1 == true) {
                result.addMinaJ1();
            } else {
                result.addMinaJ2();
            }
        } else {
            cambiar_turno();  //Cambiamos el turno.
        }
    }

    private void cambiar_turno() {
        Jugador Jaux = this.jugador_actual;
        setJugador_actual(this.getJugador_esperando());
        setJugador_esperando(Jaux);
        jugador1 = !this.jugador1;  // Cambia de jugador
        if (getColorCasilla().equals(Color.GREEN)) {  // Cambia el color a la hora de la selección de las casillas
            setColorCasilla(Color.RED);
        } else {
            setColorCasilla(Color.GREEN);
        }
    }

    public boolean gameOver() { // Si se llega a 26 minas el juego acaba
        if (result.getMinasJ1() == 26 || result.getMinasJ2() == 26) {
            ganador = jugador_actual;
            return true;
        } else {
            return false;
        }
    }

    public String imprimirTablero() {
        String matriz = "";
        String fila = "";
        for (int i = 0; i < 16; i++) {  // Filas
            for (int j = 0; j < 16; j++) {  // Columnas
                fila += (tab.getCasilla(i, j).getContenido() + " ");
            }
            matriz += (fila + "\n");
        }

        return matriz;
    }

    public Jugador getJugador_actual() {
        return jugador_actual;
    }

    public void setJugador_actual(Jugador jugador_actual) {
        this.jugador_actual = jugador_actual;
    }

    public Jugador getJugador_esperando() {
        return jugador_esperando;
    }

    public void setJugador_esperando(Jugador jugador_esperando) {
        this.jugador_esperando = jugador_esperando;
    }

    public Jugador getGanador() {
        return ganador;
    }

    public void setGanador(Jugador ganador) {
        this.ganador = ganador;
    }

    public Tablero getTab() {
        return tab;
    }

    public Color getColorCasilla() {
        return colorCasilla;
    }

    public void setColorCasilla(Color colorCasilla) {
        this.colorCasilla = colorCasilla;
    }

    public ArrayList<Movimiento> getMovs() {
        return movs;
    }

    public void setMovimientos(int x, int y) {
        Movimiento nuevoMovimiento = new Movimiento(jugador_actual.getUsuario(), x, y);
        this.movs.add(nuevoMovimiento);
        this.posX = x;
        this.posY = y;
    }

    public Marcador getResult() {
        return result;
    }

    public String printMovimientos() {
        String movimientos = "";
        for (Movimiento m : this.getMovs()) {
            movimientos += (m.printMov()+ "\n");
        }
        return movimientos;
    }

    @Override
    public boolean equals(Object o) {  // Comparación de partidas
        if (o == this) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (o.getClass() != this.getClass()) {
            return false;
        }

        Partida aux = (Partida) o;
        return ((this.jugador_actual.equals(aux.jugador_actual) || this.jugador_actual.equals(aux.jugador_esperando)) && (this.jugador_esperando.equals(aux.jugador_actual) || this.jugador_esperando.equals(aux.jugador_esperando)) && this.getResult().equals(aux.getResult()) && this.getMovs().containsAll(aux.getMovs()));
    }
    
    @Override
    public String toString(){  //Redescribe el método para obtener nombres de las partidas.
        return(this.getJugador_actual().getUsuario()+ "vs" + this.getJugador_esperando().getUsuario());
    }

    /**
     *
     * @return
     */
    public Almacen_partidas getAlmacen() {
        return aml;
    }
}
