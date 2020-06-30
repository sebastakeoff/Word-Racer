/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Player;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author franciscotabares
 */
public class GameViewController implements Initializable {
    

    Player p1 = new Player("Jugador1");
    Player p2 = new Player("Jugador2");
    Player current;
    
    
    //private int gameInstances = 0;
    //int players = 2;
    int time = 20;
    
    Timeline animation;
    int countDownTime = time;
    
    //int i = 0, j = 0;
    

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
    private Label lblUsrPoints;
    @FXML
    private Label lblUsr1Points;
    @FXML
    private Label lblUsr2Points;
    @FXML
    private Label lblCountDown;
    @FXML
    private Button btnStartGame;
    @FXML
    private Label lblPlayerPointsName1;
    @FXML
    private Label lblPlayerPointsName2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        current = p1;
        this.lblPlayersName.setText(current.getName());
        this.lblLetters.setText(current.game.word.getLetters());
        this.lblDictionary.setText(current.game.word.getDictionary().keySet() + "");
        this.lblPlayerPointsName1.setText(p1.getName());
        this.lblPlayerPointsName2.setText(p2.getName());
        
        this.txtNewWord.setEditable(false);
        //this.txtNewWord.requestFocus();

//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setHeaderText(null);
//        
//        alert.setTitle("Comienza el juego!");
//        alert.setContentText("Turno de " + p1.getName() + " ");                    
//        alert.showAndWait();

        // Cada segundo llama el método countdown()
        animation = new Timeline(new KeyFrame(Duration.seconds(1), e -> countdown()));
        //animation.setCycleCount(Timeline.INDEFINITE);
        // Definir cuántas veces se va a repetir el timeline
        animation.setCycleCount(-1);
        //animation.play();
        
        
        
        

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
            //this.lblMessage.setText("Correcto!");
            String msg = this.txtNewWord.getText().substring(0, 1).toUpperCase();
            msg += this.txtNewWord.getText().substring(1);
            msg += " = ";
            msg += current.game.word.getDictionary().get(insertedWord);
            this.lblMessage.setText(msg);
            current.setPoints();
            
        }
        if(p1.getPoints() > 0) this.lblUsr1Points.setText(p1.getPoints() + "");
        if(p2.getPoints() > 0) this.lblUsr2Points.setText(p2.getPoints() + "");
        

        // Pone en blanco el cuadre de instertar palabras
        this.txtNewWord.setText("");
        // Pone el cursor al cuadro de instertar palabras
        this.txtNewWord.requestFocus();
        
    }
    
    
    public void countdown() {
    
//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setHeaderText(null);
        
        if(countDownTime > 0) {
            // Empieza la cuenta regresiva
            this.countDownTime--;
            // Se actualiza el label con el tiempo actual
            this.lblCountDown.setText(countDownTime + " segundos");
        } else {
            // Se inicia el contador de nuevo
            this.countDownTime = time;
            // Se desabilita edición del texto
            this.txtNewWord.setEditable(false);
            
            
            if(current == p2 && p1.getPoints() != p2.getPoints()) {
                //alert.setTitle("Felicidades");
                String winner;
                int winnerPoints;
                
                if(p1.getPoints() > p2.getPoints()) {
                    //alert.setContentText(p1.getName() + " ganó con " + p1.getPoints() + " puntos!");
                    winner = p1.getName();
                    winnerPoints = p1.getPoints();
                } else {
                    //alert.setContentText(p2.getName() + " ganó con " + p2.getPoints() + " puntos!");                    
                    winner = p2.getName();
                    winnerPoints = p2.getPoints();
                }
                
                //alert.showAndWait();
                
                this.lblGameMessage.setText("Ganó " + winner + " con " + winnerPoints + " puntos!!");
                
                // Reset everything to restart game-There was a Winner!!
                current = p1;
                p1.resetPoints();
                p2.resetPoints();
                this.lblUsr1Points.setText(p1.getPoints() + "0");
                this.lblUsr2Points.setText(p2.getPoints() + "0");
                this.lblPlayersName.setText(current.getName());
                
            } else {
                
                if(current == p2 && p1.getPoints() == p2.getPoints()) {
//                    alert.setTitle("Empate!!");
//                    alert.setContentText("Sigue la revancha!!");
//                    alert.showAndWait();
                    this.lblGameMessage.setText("Empate: Comienza la Revancha!!");
                }
                
                
                current = (current != p1) ? p1: p2;
//                alert.setTitle("Cambio de turno!");
//                alert.setContentText("Turno de " + current.getName() + " ");                    
//                alert.showAndWait();
               // animation.setDelay(Duration.seconds(5));
                
                
                
                
                //this.lblUsrPoints.setText(current.getPoints() + "");
            }
            
            animation.stop();
            this.lblCountDown.setText(countDownTime + " segundos");
            this.lblPlayersName.setText(current.getName());

            
        }
        
        
    }
    

    @FXML
    private void startGame(ActionEvent event) {
    
        lblCountDown.setText(countDownTime + " segundos");
        this.txtNewWord.setText("");
        this.txtNewWord.setEditable(true);
        this.txtNewWord.requestFocus();

        animation.play();
        
    }

    
}
