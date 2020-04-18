package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    private final String reeglidTekst = "Reeglid\n" +
            "Siia tulevad reeglid.";

    public void mängi(ActionEvent sündmus) throws IOException {
        Parent juur = FXMLLoader.load(getClass().getResource("mäng.fxml"));
        Scene mäng = new Scene(juur);
        Stage lava = (Stage)((Node)sündmus.getSource()).getScene().getWindow();

        lava.setScene(mäng);
        lava.show();
    }

    public void reeglid(ActionEvent sündmus) {
        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(((Node)sündmus.getSource()).getScene().getWindow());
        VBox dialogVbox = new VBox(20);
        dialogVbox.getChildren().add(new Text(reeglidTekst));
        Scene dialogScene = new Scene(dialogVbox, 300, 200);
        dialog.setScene(dialogScene);
        dialog.show();
    }

    public void lahku() {
        System.exit(0);
    }
}
