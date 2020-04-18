package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MänguController {
    @FXML
    Label käiguLabel;

    public void määraKäik(Mängija mängija) {
        käiguLabel.setText(mängija.getNimi());
    }

    public void veereta() {

    }
}
