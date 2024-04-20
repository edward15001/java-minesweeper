package buscaminasjunio;

import java.io.*;
import java.util.ArrayList;

/**
 * @author edwar
 */
public class Almacen_partidas implements Serializable {

    private static ArrayList<Partida> partidasTotal = new ArrayList<Partida>();

    public ArrayList<Partida> getPartidasTotal() {
        return this.partidasTotal;
    }

    public String info_partida(Partida p) {
        return ("El marcador quedo:\n" + p.getResult().getMinasJ1() + "minas encontradas por "
                + p.getJugador_actual().getUsuario() + "\n" + p.getResult().getMinasJ2() + "minas encontradas por "
                + p.getJugador_esperando() + "\n");
    }

    public void tablero_y_movimientos(Partida p, File f) {
        for (Partida juego : partidasTotal) {  //Recorre la lista de partidas.
            if (juego.equals(p)) {  //Se ha encontrado la partida en la lista.
                try {
                    FileWriter archivo = new FileWriter(f);
                    PrintWriter pw = new PrintWriter(archivo);
                    pw.println("Jugadores: ");
                    pw.println(juego.getJugador_actual().getUsuario() + "#" + juego.getJugador_actual().getClave());
                    pw.println(juego.getJugador_esperando().getUsuario() + "#" + juego.getJugador_esperando().getClave());
                    pw.println(juego.imprimirTablero());
                    for (Movimiento m : juego.getMovs()) {  //Recorre la lista de movimientos.
                        pw.println(m.printMov());
                    }
                    pw.close();

                } catch (IOException e) {
                }
            }
        }
    }

    public void cargarFichero(File f) {
        try (FileInputStream fis = new FileInputStream(f)) {

            try (ObjectInputStream ois = new ObjectInputStream(fis)) {
                while (fis.available() > 0) {  //Admite leer todos los datos mientras queden bytes en el fichero.
                    Partida p = (Partida) ois.readObject();
                    this.getPartidasTotal().add(p);  //Añade el usuario a la lista.
                }
            } catch (ClassNotFoundException e) {
                System.out.println("Ha ocurrido un error, no se ha encontrado la clase indicada");
            }

        } catch (IOException e) {
            System.out.println("Ha ocurrido un error, no se ha podido leer el archivo de partidas");
        }
    }

    public void guardarFichero(File f) {  // Guarda las partidas en un fichero
        try (FileOutputStream fos = new FileOutputStream(f)) {

            try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                for (Partida p : this.getPartidasTotal()) {  //Recorre todas las partidas almacenadas.
                    oos.writeObject(p);  //Escribe el usuario en el fichero.
                }
            } catch (IOException e) {
                System.out.println("Ha ocurrido un error, no se ha podido escribir el archivo de partidas");
            }

        } catch (FileNotFoundException e) {
            System.out.println("Ha ocurrido un error, no se ha encontrado el archivo de partidas");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error en la entrada/salida" + e.getMessage());
        }
    }
}
