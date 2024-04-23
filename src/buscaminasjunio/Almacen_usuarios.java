package buscaminasjunio;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author edwar
 */
public class Almacen_usuarios implements Serializable {

    private static ArrayList<Usuario> usuariosTotal = new ArrayList<Usuario>();
   
    public void cargarListado(File f) {  // Carga el archivo con la lista de usuarios y los añade a la lista.
        try (FileInputStream fis = new FileInputStream(f)) {

            try (ObjectInputStream ois = new ObjectInputStream(fis)) {
                int users = ois.readInt();
                while (fis.available() > 0) {
                    Usuario u = (Usuario) ois.readObject();
                    this.getUsuariosTotal().add(u);
                }
            } catch (ClassNotFoundException e) {
                System.out.println("Ha ocurrido un error, no se ha encontrado la clase indicada");
            }

        } catch (IOException e) {
            System.out.println("Ha ocurrido un error, no se ha podido leer el archivo de partidas");
        }
    }

    public void cargarListadoNuevosUsuarios(File f) {  // Carga el archivo con la lista de usuarios y los añade a la lista.
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            int numUsers = Integer.parseInt(br.readLine());
            String linea;
            ArrayList<String> lineContent = new ArrayList<String>();
            // Guarda los datos por lineas
            while ((linea = br.readLine()) != null) {
                lineContent.add(linea);
            }
            for (String s : lineContent) {  // Lee los usuarios
                String[] userData = s.split("#");  // Separa la información mediante '#'
                Jugador newUser = new Jugador(userData[0], userData[1]);  // Crea un jugador a partir de un usuario ingresado
                this.alta(newUser);
            }
            br.close();  //Cierra el fichero.
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error en la lectura del fichero: " + e.getMessage());
        }
    }

    public void guardarListado(File f) {  // Guarda los usuarios en un fichero.
//        try (FileOutputStream fos = new FileOutputStream(f)) {
//            try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
//                oos.writeInt(this.getUsuariosTotal().size());  // Número de usuarios
//                for (Usuario u : this.getUsuariosTotal()) {
//                    oos.writeObject(u);
//                }
//            } catch (IOException e) {
//                System.out.println("Ha ocurrido un error, no se ha podido escribir el archivo de usuarios");
//            }
//
//        } catch (FileNotFoundException e) {
//            System.out.println("Ha ocurrido un error, no se ha encontrado el archivo indicado");
//        } catch (IOException e) {
//            System.out.println("Ha ocurrido un error en la entrada/salida" + e.getMessage());
//        }

        for(Usuario user : usuariosTotal){
                try {
                    FileWriter archivo = new FileWriter(f);
                    PrintWriter pw = new PrintWriter(archivo);
                    pw.println("Jugadores: ");
                    pw.println(user.getNombre() + "#" + user.getContrasenia());
                    
                    pw.close();

                } catch (IOException e) {
                }
        }
    }

    public void alta(Jugador j) {
        boolean add = this.usuariosTotal.add(j);
    }

    public void baja(Jugador j) {
        Almacen_usuarios.usuariosTotal.remove(j);
    }
    
    public boolean autenticar(Usuario u) {
        return Almacen_usuarios.usuariosTotal.contains(u);
    }

    public ArrayList<Jugador> clasificacion_por_victorias() {  // Ordena a los jugadores por su número de victorias
        Comparator<Jugador> compared = new Comparator<Jugador>() {
            @Override
            public int compare(Jugador pl1, Jugador pl2) {
                int winP1 = pl1.getEstadisticas().getGanadas();
                int winP2 = pl2.getEstadisticas().getGanadas();
                return Integer.compare(winP1, winP2);
            }
        };
        ArrayList<Jugador> players = new ArrayList<Jugador>();

        for (Usuario u : this.getUsuariosTotal()) {
            if (u instanceof Jugador) {
                players.add((Jugador) u);
            }
        }
        Collections.sort(players, compared);
        return players;
    }

    public ArrayList<Jugador> clasificacion_por_nombre() {      // Ordena a los jugadores por su nombre en orden alfabético
        ArrayList<Jugador> players = new ArrayList<Jugador>();
        for (Usuario u : this.usuariosTotal) {
            if (u instanceof Jugador) {
                players.add((Jugador) u);
            }
        }
        Collections.sort(players, new Comparator<Jugador>() {
            @Override
            public int compare(Jugador j1, Jugador j2) {  // Reescribimos el metodo compare para que ordene de distinta manera
                String p1 = j1.getNombre();
                String p2 = j2.getNombre();
                return p1.compareTo(p2);
            }
        });
        return players;
    }
    
    public ArrayList<Usuario> getUsuariosTotal() {  //Devuelve una lista de usuarios.
        return Almacen_usuarios.usuariosTotal;
    }
}
