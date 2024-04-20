package buscaminasjunio;

import java.io.File;

public class Clase_Entre_Ventanas {

    private static final Administrador admin=new Administrador();
    private static Almacen_usuarios usuarios=new Almacen_usuarios();  //Recibe el almacen de usuarios.
    private static Almacen_partidas partidasTotal =new Almacen_partidas();  //Contendrá todas las partidas que se han jugado.
    private static Jugador aux, J1, J2;
    private Partida partida;
    private final File ficheroUsuarios = new File("usuarios.ser");
    private final File ficheroNuevosUsuarios = new File("nuevosUsuarios.txt");
    private final File ficheroPartidas = new File("partidas.ser");
    private final File ficheroTableroMovimientos = new File("tableroymovimientos.txt");

    public File getFicheroTableroMovimientos(){
        return this.ficheroTableroMovimientos;
    }

    public Administrador getAdmin(){
        return this.admin;
    }

    public File getFicheroNuevosUsuarios(){
        return this.ficheroNuevosUsuarios;
    }

    public File getFicheroUsuarios(){
        return this.ficheroUsuarios;
    }

    public File getFicheroPartidas(){
        return this.ficheroPartidas;
    }

    public Almacen_usuarios getUsers(){
        return this.usuarios;
    }

    public void setJugadorAux(Jugador j){
        this.aux=j;
    }

    public void organizarPartidas(){  //Reparte las partidas de la lista a cada usuario.
        for(Partida p : this.getAlmacenPartidas().getPartidasTotal()){  //Recorre la lista de partidas.
            Jugador jugador1=p.getJugador_actual();
            Jugador jugador2=p.getJugador_esperando();
            for(Usuario u : this.getUsers().getUsuariosTotal()){  //Recorre los usuarios.
                Jugador j=(Jugador) u;
                if((j.equals(jugador1) || j.equals(jugador2)) && j.partidaRepetida(p)==false){
                    //Si el usuario coincide con alguno de los jugadores y la partida no está ya guardada en su lista.
                    j.addPlay(p);  //Se le añade la partida a su lista.
                    Jugador actual=p.getJugador_actual();
                    if(j.equals(actual)){
                        j.reloadStats(p, p.getResult().getMinasJ1(), p.getResult().getMinasJ2());
                    }else{
                        j.reloadStats(p, p.getResult().getMinasJ2(), p.getResult().getMinasJ1());
                    }
                }
            }
        }
    }

    public void rellenarResultadoPartida(){
        Partida p=this.getPartida();
        Marcador puntuacion=p.getResult();
        this.getJ1().reloadStats(p, puntuacion.getMinasJ1(), puntuacion.getMinasJ2());
        this.getJ2().reloadStats(p, puntuacion.getMinasJ2(), puntuacion.getMinasJ1());
        this.getJ1().addPlay(p);
        this.getJ2().addPlay(p);  //Añade la partida actual a ambos jugadores.
        this.getAlmacenPartidas().getPartidasTotal().add(p);  //Añade la partida a la lista.
    }

    public Almacen_partidas getAlmacenPartidas(){  //Devuelve el almacén con todas las partidas jugadas.
        return Clase_Entre_Ventanas.partidasTotal;
    }

    public void setJ1(Jugador j1){
        Clase_Entre_Ventanas.J1=j1;
    }

    public Jugador getJ1(){
        return Clase_Entre_Ventanas.J1;
    }

    public void setJ2(Jugador j2){
        Clase_Entre_Ventanas.J2=j2;
    }

    public Jugador getJ2(){
        return Clase_Entre_Ventanas.J2;
    }

    public void crearPartida(){
        this.partida=new Partida(getJ1(), getJ2());
    }

    public Partida getPartida(){
        return this.partida;
    }

    public Jugador getJugadorAux(){  //Devuelve el usuario aux.
        return Clase_Entre_Ventanas.aux;
    }

    public boolean existeUsuario(String nombre){
        boolean resultado=false;
        for(Usuario u : this.getUsers().getUsuariosTotal()){  //Recorre la lista comparando los nombres de usuario.
            if(nombre.equals(u.getNombre())){  //Si los usuarios coinciden.
                resultado=true;
            }
        }
        return resultado;
    }

}
