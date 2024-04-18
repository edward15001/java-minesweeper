package buscaminasjunio;

import java.util.ArrayList;

/**
 * @author edwar
 */
public class Tablero {

    private static final int MINAS = 51;    // Número total de minas en el tablero
    private Casilla tab[][];                // Matriz del tablero

    public Tablero() {                      // Inicia tablero 16x16
        this.tab = new Casilla[16][16];
        this.iniciarTablero();
        this.rellenarMinas();
        this.rellenarAdyacentes();
    }

    private void iniciarTablero() {         // Rellena el tablero con valores
        for (int fila = 0; fila < 16; fila++) {
            for (int columna = 0; columna < 16; columna++) {
                this.tab[fila][columna] = new Casilla(fila, columna);
            }
        }
    }

    public Casilla[][] getTab() {
        return this.tab;
    }

    public Casilla getCasilla(int cX, int cY) {
        return this.tab[cX][cY];
    }

    private void rellenarMinas() {
        int minas = MINAS;

        while (minas > 0) {                 // Coloca las minas
            int filaAleatoria = (int) (Math.random() * 16);
            int columnaAleatoria = (int) (Math.random() * 16);
            Casilla actualCasilla = this.getCasilla(filaAleatoria, columnaAleatoria);

            if (actualCasilla.getContenido().equals("*") == false) {
                this.tab[filaAleatoria][columnaAleatoria].setContenido("*");
                minas--;
            }
        }
    }

    private void rellenarAdyacentes() {  //Coloca un número en cada casilla referente al número de minas que tiene alrededor.

        int contador;
        for (int filas = 0; filas < 16; filas++) {
            for (int columnas = 0; columnas < 16; columnas++) {

                Casilla casillaActual = this.getCasilla(filas, columnas);

                if (casillaActual.getContenido().equals("*") == false) {
                    ArrayList<Casilla> adyacentes = this.casillasAdyacentes(casillaActual);
                    contador = 0;
                    for (Casilla c : adyacentes) {
                        if (c.getContenido().equals("*")) {
                            contador++;
                        }
                    }
                    String contenido = String.valueOf(contador);
                    casillaActual.setContenido(contenido);
                }
            }
        }
    }

    public ArrayList<Casilla> casillasAdyacentes(Casilla c) {  // Sirve para devolver un array con las casilla al rededor

        ArrayList<Casilla> adyacentes = new ArrayList();
        int fila = c.getX();
        int columna = c.getY();

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (((fila + i) < 16 && (fila + i) >= 0) && ((columna + j) < 16 && (columna + j) >= 0) && (i != 0 || j != 0)) {
                    adyacentes.add(this.getCasilla((fila + i), (columna + j)));
                }
            }
        }
        return adyacentes;
    }

    public boolean hayMina(int posX, int posY) {  // Devuelve si hay mina
        return (this.getCasilla(posX, posY).getContenido().equals("*"));
    }
}
