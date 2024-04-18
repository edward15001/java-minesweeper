package buscaminasjunio;

/**
 *
 * @author edwar
 */
public class Marcador {

    private int puntos_J1, puntos_J2;

    public Marcador() {
        puntos_J1 = 0;
        puntos_J2 = 0;
    }

    public void addMinaJ1() {
        puntos_J1++;
    }

    public void addMinaJ2() {
        puntos_J2++;
    }

    public int getMinasJ1() {
        return puntos_J1;
    }

    public int getMinasJ2() {
        return puntos_J2;
    }

    public void setMarcador(int pointsJ1, int pointsJ2) {
        this.puntos_J1 = pointsJ1;
        this.puntos_J2 = pointsJ2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (this.getClass() != o.getClass()) {
            return false;
        }

        Marcador cast = (Marcador) o;
        return (cast.getMinasJ1() == this.getMinasJ1() && this.getMinasJ2() == cast.getMinasJ2());
    }
}
