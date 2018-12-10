package ba.etf.unsa.rpr.tutorijal08;

import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Controller {
    public TextField traziStringField;
    public SimpleStringProperty traziString;
    public ListView listaDatotekaField;
    public SimpleListProperty<String> listaDatoteka;
    public Button traziBtn;
    private List<String> rezultat;

    public Controller() {
        traziString = new SimpleStringProperty("");
        listaDatoteka = new SimpleListProperty<String>();
        rezultat = Collections.synchronizedList(new ArrayList<String>());
    }

    @FXML
    public void initialize() {
        traziStringField.textProperty().bindBidirectional(traziString);
        listaDatotekaField.itemsProperty().bindBidirectional(listaDatoteka);
        listaDatoteka.set(FXCollections.observableArrayList(rezultat));
    }


    public void pokreniPretragu(ActionEvent actionEvent) {
    }
}
