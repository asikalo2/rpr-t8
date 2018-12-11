package ba.etf.unsa.rpr.tutorijal08;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class NovaForma {
    public TextField imeField;
    public TextField prezimeField;
    public TextField adresaField;
    public TextField gradField;
    public TextField brojField;

    public SimpleStringProperty ime;
    public SimpleStringProperty prezime;
    public SimpleStringProperty adresa;
    public SimpleStringProperty grad;
    public SimpleStringProperty postanskiBroj;


    public NovaForma () {
        ime = new SimpleStringProperty("");
        prezime = new SimpleStringProperty("");
        adresa = new SimpleStringProperty("");
        grad = new SimpleStringProperty("");
        postanskiBroj = new SimpleStringProperty("");
    }

    @FXML
    public void initialize() {
        imeField.textProperty().bindBidirectional(ime);
        prezimeField.textProperty().bindBidirectional(prezime);
        adresaField.textProperty().bindBidirectional(adresa);
        gradField.textProperty().bindBidirectional(grad);
        brojField.textProperty().bindBidirectional(postanskiBroj);
    }


}
