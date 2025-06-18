import java.util.ArrayList;

public class Servidor {
    private ArrayList<Jugador> jugadores;

    public Servidor() {
        jugadores = new ArrayList<>();
    }

    public void agregarJugador(Jugador j) {
        jugadores.add(j);
    }

    public int cantidadJugadores() {
        return jugadores.size();
    }
    
    public ArrayList<Jugador> obtenerJugadoresConectados()
    {   
        ArrayList<Jugador> obtenerJugadores = new ArrayList<>();
        
        for(Jugador j: jugadores)
        {
            if(j.estaConectado() == true)
            {
                obtenerJugadores.add(j);
            }
        }
        
        assert obtenerJugadores.size() > 0;
        
        return obtenerJugadores;
    }

    public ArrayList<String> nombresJugadoresEnLinea()
    {
        ArrayList<String> obtenerJugadoresString = new ArrayList<>();
        
        for(Jugador j: jugadores)
        {
            if(j.estaConectado() == true)
            {
                obtenerJugadoresString.add(j.getNombre());
            }
        }
        
        assert obtenerJugadoresString.size() > 0;
        
        return obtenerJugadoresString;
    }
    
    public void desconectarJugadoresInactivos()
    {
        for(Jugador j: jugadores)
        {
            if(j.estaConectado() == false){ j.desconectar(); }
        }
    }

    public int contarJugadoresPorNivel(int nivel)
    {
        int contador = 0;
        
        for(Jugador j: jugadores)
        {
            if(j.getNivel() == nivel) 
            { 
                contador += 1;
            }
        }
        return contador;
    }
}
