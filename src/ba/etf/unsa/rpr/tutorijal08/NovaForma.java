package ba.etf.unsa.rpr.tutorijal08;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

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

    PostanskiBrojValidator validator;
    Thread th;

    public NovaForma() {
        ime = new SimpleStringProperty("");
        prezime = new SimpleStringProperty("");
        adresa = new SimpleStringProperty("");
        grad = new SimpleStringProperty("");
        postanskiBroj = new SimpleStringProperty("");
        validator = new PostanskiBrojValidator("");
        th = new Thread(validator);

        th.setDaemon(true);
        th.setName("validator");


    }

    @FXML
    public void initialize() {
        imeField.textProperty().bindBidirectional(ime);
        prezimeField.textProperty().bindBidirectional(prezime);
        adresaField.textProperty().bindBidirectional(adresa);
        gradField.textProperty().bindBidirectional(grad);
        brojField.textProperty().bindBidirectional(postanskiBroj);

        dodajListenere();
    }
    
    private void dodajListenere() {
        brojField.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                if (aBoolean && !t1) {
                    validator.setBroj(brojField.getText());
                    th.start();
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                if (!th.isAlive() && validator.getValidan()) {
                                    brojField.getStyleClass().removeAll("poljeNijeIspravno");
                                    brojField.getStyleClass().add("poljeIspravno");
                                } else {
                                    brojField.getStyleClass().removeAll("poljeIspravno");
                                    brojField.getStyleClass().add("poljeNijeIspravno");
                                }
                            } catch (Exception e) {e.printStackTrace();}
                        }
                    });
                }
            }
        });
    }
}
