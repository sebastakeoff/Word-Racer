package model;
/**
 * Clase de jugadores. Asigna nombre y los puntos a los jugadores
 * Atributos privados para que no se puedan modificar por equivocación
 * solamente con métodos
 * @author   Grupo 11 - Paradigmas de programación
 */
public class Player {
    
    private String name;
    private int points;
    public WordRacer game;
    
    /**
     * Constructor: Asigna el nombre al jugador e inicializa los puntos en 0
     * @param n 
     */
    public Player(String n) {
        name = n;
        points = 0;
        game = new WordRacer();
    }
    
    /**
     * Método para añadirle puntos al jugador.
     * @return points (la cantidad de puntos sumados)
     */
    public int setPoints() {
        return points += 20;
    }
    
    /**
     * Method that gets the player points
     * @return player's points
     */
    public int getPoints() {
        return points;
    }
    
    /**
     * Method that gets the player's name
     * @return player's name
     */
    public String getName() {
        return name;
    }
    
    
    
}
