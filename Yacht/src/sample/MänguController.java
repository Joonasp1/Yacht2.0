package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MänguController implements Initializable {

    public static MänguController Instance;

    @FXML
    Label käiguLabel;

    @FXML
    HBox täringuteKast;
    @FXML
    ImageView täring1, täring2, täring3, täring4, täring5;

    Image[] täringutePildid;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Instance = this;

        täringutePildid = new Image[5];
        for (int i = 0; i < 5; i++) {
            File fail = new File("src/resources/pildid/täring_" + (i + 1) + ".png");
            täringutePildid[i] = new Image(fail.toURI().toString());
        }
    }

    public void määraKäik(Mängija mängija) {
        käiguLabel.setText(mängija.getNimi() + " käik");
    }

    public void määraTäringud(int[] numbrid) { // Muudab täringute pildid vastavalt etteantud numbritele.

        ImageView[] täringud = new ImageView[] {täring1, täring2, täring3, täring4, täring5};
        for (int i = 0; i < 5; i++) {
            täringud[i].setImage(täringutePildid[numbrid[i]-1]);
        }
    }

    public void valiSkoorimistingimus(ActionEvent sündmus) throws IOException{
        Parent juur = FXMLLoader.load(getClass().getResource("tingimused.fxml"));
        Scene tingimustestseen = new Scene(juur);
        Stage lava = (Stage)((Node)sündmus.getSource()).getScene().getWindow();

        lava.setScene(tingimustestseen);
        lava.show();
    }

    public void ühed(ActionEvent sündmus){

    }


    public void veereta() {
        määraTäringud(new int[] {1,2,3,4,5});
    }
}
