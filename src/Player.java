/**
 *
 * @author   Grupo 11 - Paradigmas de programación
 */
public class Player {
    
    /**
     * Francisco Tabares
     * Clase de jugadores. Asigna nombre y los puntos a los jugadores
     * Atributos privados para que no se puedan modificar por equivocación
     * solamente con métodos
     */
    private String name;
    private int points;
    
    public Player(String n) {
        name = n;
        points = 0;
    }
    
    public int setPoints() {
        return points += 20;
    }
    
    public int getPoints() {
        return points;
    }
    
    public String getName() {
        return name;
    }
    
    
    
}
