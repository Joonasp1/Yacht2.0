package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class MänguController implements Initializable {
    @FXML
    Label käiguLabel;

    @FXML
    HBox täringuteKast;
    @FXML
    ImageView täring1, täring2, täring3, täring4, täring5;

    Image[] täringutePildid;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        täringutePildid = new Image[5];
        for (int i = 0; i < 5; i++) {
            File fail = new File("src/resources/pildid/täring_" + (i + 1) + ".png");
            täringutePildid[i] = new Image(fail.toURI().toString());
        }
    }

    public void määraKäik(Mängija mängija) {
        käiguLabel.setText(mängija.getNimi());
    }

    public void määraTäringud(int[] numbrid) { // Muudab täringute pildid vastavalt etteantud numbritele.

        ImageView[] täringud = new ImageView[] {täring1, täring2, täring3, täring4, täring5};
        for (int i = 0; i < 5; i++) {
            täringud[i].setImage(täringutePildid[numbrid[i]-1]);
        }
    }

    public void veereta() {

        määraTäringud(new int[] {1,2,3,4,5});
    }
}
