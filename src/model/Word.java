package model;
/**
 * @author   Grupo 11 - Paradigmas de programación
 */

import java.util.HashMap;
import java.util.Map;

public class Word {
    
    // Donde se almacenan las letras aleatorias
    private String letters;
    // Donde va a estar el diccionario (las palabras a buscar)
    private Map<String, String> dictio = new HashMap<String, String>();
    // 
    private String word;
    
    /**
     * Constructor: Genera las letras aleatorias y crea el diccionario
     */
    public Word() {
        generateLetters();
        createDictionary();
    }
    
    /**
     * Getter para las letras generadas
     * @return las letras generas
     */
    public String getLetters() {
        return letters;
    }
    
    /**
     * Getter dictionario
     * @return el dictionario
     */
    public Map<String, String> getDictionary() {
        return dictio;
    }
    
    /**
     * Método que busca si la palabra ingresada esté en el diccionario
     * @param inWord
     * @return true si encuentra la palabra, falso de lo contrario
     */
    public boolean searchWord(String inWord) {
        if(dictio.get(inWord) != null)
            return true;
        return false;
    }
    
    /**
     * Método para generar letras aleatorias que serán la base para armar las palabras
     * @return la variable letters con las letras asignadas
     */
    public String generateLetters() {
        return letters = "EIOUBCSHR";
    }
    
    /**
     * Método que verifica que la palabra ingresada sí esté usando las letras dadas
     * para armar las palabras
     * @param w = word
     * @return true si no usó otras letras, falso de lo contrario
     */
    public boolean isInLetters(String w) {
        for(int i = 0; i < w.length() ; i++) {
            for(int j = 0; j < letters.length(); j++){
                if(w.charAt(i) == letters.charAt(j)) break;
                if(j == letters.length() -1) return false;
            }
        }
        return true;
    }
    
    /**
     * Método para generar el diccionario
     * @return el diccionario generado
     */
    public Map<String, String> createDictionary() {
    
        dictio.put("BUS", "Servicio público");
        dictio.put("HOUSE", "Casa");
        dictio.put("HORSE", "Caballo");
        
        return dictio;
    }
    
}
