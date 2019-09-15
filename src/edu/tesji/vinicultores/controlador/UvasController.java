package edu.tesji.vinicultores.controlador;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleGroup;
import com.noe.uvas.Uvas;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class UvasController implements Initializable{

    @FXML private JFXTextField txtPrecio;
    @FXML private JFXTextField txtkilos;
    @FXML private JFXRadioButton rbTamañoA;
    @FXML private ToggleGroup GrupoTipo;
    @FXML private JFXRadioButton rbTamañoB;
    @FXML private JFXComboBox<String> cmbTipo;
    @FXML private JFXTextArea txtResultado;
    
    ObservableList<String> opTipo=FXCollections.observableArrayList(
            "Tipo A",
            "Tipo B");   
        
    @FXML
    void btnCalcular(ActionEvent event) {
        try{
            
            int precio =Integer.parseInt(txtPrecio.getText());
            int kilos = Integer.parseInt(txtkilos.getText());
            String tipo = cmbTipo.getValue();
            String Tamaño="";
            
            if(rbTamañoA.isSelected()){
                Tamaño="Tamaño 1";
            }else if(rbTamañoB.isSelected()){
                Tamaño="Tamaño 2";
            }  
            
            txtResultado.setText(Uvas.Ganancia(tipo, Tamaño, precio,kilos));
            
        }catch(Exception e){
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Vinicultores");
            alert.setHeaderText("Ingrese un valor valido");
            alert.showAndWait();
        }              
    } 
    
    @FXML
    void btnNuevo(ActionEvent event) {
        txtResultado.setText(null);
        txtPrecio.setText(null);
        rbTamañoA.setSelected(true);
        cmbTipo.setValue(null);
    }

    @FXML
    void btnSalir(ActionEvent event) {
        Platform.exit();
    }    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cmbTipo.setItems(opTipo);
    }
}
