/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Player;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author franciscotabares
 */
public class GameViewController implements Initializable {

    Player p1 = new Player("Jugador1");
    Player p2 = new Player("Jugador2");
    Player current;
    
    private int gameInstances = 0;
    int players = 2;
    int time = 2;
    
    int i = 0, j = 0;
    

    @FXML
    private Button btnInsertWord;
    @FXML
    private TextField txtNewWord;
    @FXML
    private Label lblPlayersName;
    @FXML
    private Label lblLetters;
    @FXML
    private Label lblDictionary;
    @FXML
    private Label lblGameMessage;
    @FXML
    private Label lblMessage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        
        current = p1;
        this.lblPlayersName.setText(current.getName());
        this.lblLetters.setText(current.game.word.getLetters());
        this.lblDictionary.setText(current.game.word.getDictionary().keySet() + "");
        this.txtNewWord.requestFocus();

        /*
        do {
            
            if(gameInstances != 0) {
                this.lblGameMessage.setText("Hubo empate!! A la Revancha");
            }
            
            for(int i = 0; i < players; i++) {
                if(i == 0) current = p1;
                else current = p2;

                
                this.lblLetters.setText(current.game.word.getLetters());
                this.lblDictionary.setText(current.game.word.getDictionary().keySet() + "");

                for(int j = 0; j < time; j++) {
                    //System.out.println(current.getName() + " ingresa tu palabra:");
                    //String insertedWord = s.nextLine().toUpperCase();
                }
            }
            gameInstances++;
        } while(p1.getPoints() == p2.getPoints());
        
        /*
        System.out.print("Jugador 1: " + p1.game.getInsertedWords());
        System.out.println(" puntos: " + p1.getPoints());
        System.out.print("Jugador 2: " + p2.game.getInsertedWords());
        System.out.println(" puntos: " + p2.getPoints());

        if(p1.getPoints() > p2.getPoints()) System.out.println("Ganó Jugador 1!");
        else System.out.println("Ganó Jugador 2!");
        */
    }    

    @FXML
    private void addWord(ActionEvent event) {
        String insertedWord = this.txtNewWord.getText().toUpperCase();
        
        
        current.game.addWord(insertedWord);
        if(!current.game.word.isInLetters(insertedWord))
            this.lblMessage.setText("Debe utilizar las letras dadas");
        else if(!current.game.word.searchWord(insertedWord))
            this.lblMessage.setText("No existe esa palabra");
        else {
            this.lblMessage.setText("Correcto!");
            current.setPoints();
        }
        
        j++;
        
        if(j > 1) {
            current = (current != p1) ? p1: p2;
            this.lblPlayersName.setText(current.getName());
            j = 0;
        }
        
        this.txtNewWord.setText("");
        this.txtNewWord.requestFocus();
        
        


    }

    
}
