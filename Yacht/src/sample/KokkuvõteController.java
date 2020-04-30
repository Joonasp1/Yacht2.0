package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class KokkuvõteController implements Initializable {

    @FXML
    Label mängija1Nimi, mängija1Punktid;
    @FXML
    Label mängija2Nimi, mängija2Punktid;
    @FXML
    Label labelVõitjaNimi, labelVõitjaPunktid;

    private Mäng mäng;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mäng = MänguController.Instance.mäng;
        kuvaMängijad();
        kuvaVõitja();
    }

    private void kuvaMängijad() {
        Mängija[] mängijad = mäng.getMängijad();

        mängija1Nimi.setText(mängijad[0].getNimi());
        mängija1Punktid.setText(String.valueOf(mängijad[0].getSkoor()));

        mängija2Nimi.setText(mängijad[1].getNimi());
        mängija2Punktid.setText(String.valueOf(mängijad[1].getSkoor()));
    }

    private void kuvaVõitja() {
        labelVõitjaNimi.setText(mäng.getVõitja().getNimi());
        labelVõitjaPunktid.setText(String.valueOf(mäng.getVõitja().getSkoor()));
    }
}
