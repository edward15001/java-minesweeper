package buscaminasjunio;

/**
 *
 * @author edwar
 */
public class Movimiento {
    private final String nombreJugador;
    private int coordenadaX, coordenadaY;

    public Movimiento(String nombre, int X, int Y){  
        this.nombreJugador=nombre;
        this.coordenadaX=X;
        this.coordenadaY=Y;
    }

    public String printMov(){  // String con los movimientos realizados
        return (this.nombreJugador + " " + Integer.toString(this.coordenadaX) + " " + Integer.toString(this.coordenadaY));
    }

    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if(o==null) return false;
        if(this.getClass()!=o.getClass()) return false;

        Movimiento cast=(Movimiento) o;
        return(this.nombreJugador.equals(cast.nombreJugador) && this.coordenadaX==cast.coordenadaX && this.coordenadaY==cast.coordenadaY);
    }

}
