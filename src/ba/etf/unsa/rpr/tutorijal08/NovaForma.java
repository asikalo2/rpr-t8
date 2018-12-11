package ba.etf.unsa.rpr.tutorijal08;

import javafx.beans.property.SimpleStringProperty;
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


    public NovaForma() {
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

    private boolean provjeriPostanskiBroj(String broj) throws Exception {
        // nadjeno na netu
        URL link = new URL("http://c9.etf.unsa.ba/proba/postanskiBroj.php?postanskiBroj=" + broj);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(link.openStream())
        );
        String sadrzaj = "";
        String line;
        while ((line = in.readLine()) != null)
            sadrzaj += line;

        System.out.println(sadrzaj);
        in.close();

        return false;
    }

    private void dodajListenere() {
        brojField.focusedProperty().addListener((observableValue, aBoolean, t1) -> {
            if (!brojField.isFocused()) {
                try {
                    if (provjeriPostanskiBroj(brojField.getText())) {
                        brojField.getStyleClass().removeAll("poljeNijeIspravno");
                        brojField.getStyleClass().add("poljeIspravno");
                    } else {
                        brojField.getStyleClass().removeAll("poljeIspravno");
                        brojField.getStyleClass().add("poljeNijeIspravno");
                    }
                } catch (Exception e) {
                }
            }

        });
    }
}
