package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class MänguController {
    @FXML
    Label käiguLabel;

    @FXML
    HBox täringuteKast;
    @FXML
    ImageView täring1, täring2, täring3, täring4, täring5;

    public void määraKäik(Mängija mängija) {
        käiguLabel.setText(mängija.getNimi());
    }

    public void määraTäringud(int[] numbrid) {
        
    }

    public void veereta() {

    }
}
