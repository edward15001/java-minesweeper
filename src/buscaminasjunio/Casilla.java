package buscaminasjunio;

/**
 * @author edwar
 */
public class Casilla {

    private int coordenada_X, coordenada_Y;
    private String simbolo_oculto;

    public Casilla(int X, int Y) {
        this.coordenada_X = X;
        this.coordenada_Y = Y;
        this.simbolo_oculto = "0";
    }

    public int getX() {
        return this.coordenada_X;
    }

    public int getY() {
        return this.coordenada_Y;
    }

    public String getContenido() {
        return this.simbolo_oculto;
    }

    public void setContenido(String simbol) {
        this.simbolo_oculto = simbol;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (o.getClass() != this.getClass()) {
            return false;
        }

        Casilla aux = (Casilla) o;
        return (this.getX() == aux.getX() && this.getY() == aux.getY() && this.getContenido().equals(aux.getContenido()));
    }
}
