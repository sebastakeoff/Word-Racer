package model;
/**
 * @author Grupo 11 - Paradigmas de programación
 */

import java.util.ArrayList;

public class WordRacer {
    
    // Almacena las palabras ingresadas por el jugador
    private ArrayList<String> insertedWords;
    public Word word;
    
    /**
     * Constructor: inicializa el juego
     */
    public WordRacer() {
        insertedWords = new ArrayList<>();
        word = new Word();
        
    }
    
    /**
     * Método para insertar las palabras ingresadas por el jugador
     * @param w 
     * @return void: solo añade la palabra en el arreglo
     */
    public void addWord(String w) {
        insertedWords.add(w);
    }
    
    
    public ArrayList<String> getInsertedWords(){
        return insertedWords;
    }

    
}
