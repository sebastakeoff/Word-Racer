/**
 *
 * @author  Grupo 11 - Paradigmas de programación
 */
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        
        Player p1 = new Player("Jugador1");
        Player p2 = new Player("Jugador2");
        Player current;

        int players = 2;
        int time = 2;
        
        for(int i = 0; i < players; i++) {
            if(i == 0) current = p1;
            else current = p2;
            
            System.out.println("Usa las siguientes letras: " + current.game.word.getLetters());
            System.out.println("Palabras disponibles: " + current.game.word.getDictionary().keySet());

            for(int j = 0; j < time; j++) {
                System.out.println(current.getName() + " ingresa tu palabra:");
                String insertedWord = s.nextLine().toUpperCase();
                current.game.addWord(insertedWord);
                if(!current.game.word.isInLetters(insertedWord))
                    System.out.println("Debe utilizar las letras dadas");
                else if(!current.game.word.searchWord(insertedWord))
                    System.out.println("No existe esa palabra");
                else {
                    System.out.println("Correcto!");
                    current.setPoints();
                }
            }
        }
        
        
        
        System.out.print("Jugador 1: " + p1.game.getInsertedWords());
        System.out.println(" puntos: " + p1.getPoints());
        System.out.print("Jugador 2: " + p2.game.getInsertedWords());
        System.out.println(" puntos: " + p2.getPoints());

        if(p1.getPoints() == p2.getPoints()) System.out.println("Hubo empate!");
        else if(p1.getPoints() > p2.getPoints()) System.out.println("Ganó Jugador 1!");
        else System.out.println("Ganó Jugador 2!");
    }
    
    
}
