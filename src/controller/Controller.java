/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Player;
import controller.TutorialController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Controller implements Initializable {
    
    Player p1;
    Player p2;
    
    ObservableList<Player> players;
    
    @FXML
    private Button btnTuto, btnPlay;
    @FXML
    private TextField txtPy1, txtPy2;
    @FXML
    private AnchorPane anchorRoot;
    @FXML
    private StackPane parentContainer;
    @FXML
    private Button btnCred;
    @FXML
    private Label lblPy1;
  
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Primera ejecución del juego
    }
    
    public void initAttributes (ObservableList<Player> players) {
        this.players = players;
    }

    @FXML
    private void loadGamePlay(ActionEvent event) throws IOException {
        
        p1 = new Player(txtPy1.getText());
        p2 = new Player(txtPy2.getText());
        
        Parent root = FXMLLoader.load(getClass().getResource("/view/GameView.fxml"));
        Scene scene = btnPlay.getScene();
        
        root.translateYProperty().set(scene.getHeight());
        parentContainer.getChildren().add(root);
        
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(event1 -> {
            
            parentContainer.getChildren().remove(anchorRoot);
        });
        timeline.play();
        
    }
    
    
    @FXML
    private void loadTuto(ActionEvent eventt) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Tutorial.fxml"));

        //TutorialController controltuto = loader.getController();
        //Scene scene = btnTuto.getScene();
        
        Parent root1 = (Parent) loader.load();
        
        Stage stage = new Stage();
        stage.setTitle("Tutorial");
        stage.setScene(new Scene(root1));
        stage.show();
        
    }
    
}
    
    

