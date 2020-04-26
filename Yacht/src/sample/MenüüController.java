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

public class MenüüController {

    private final String reeglidTekst = "Reeglid\n" +
            "Siia tulevad reeglid.\n" +
            "Pane need kirja Controller-klassis.";

    public void mängi(ActionEvent sündmus) throws IOException {
        Parent juur = FXMLLoader.load(getClass().getResource("mäng.fxml"));
        Scene mängustseen = new Scene(juur);
        Stage lava = (Stage)((Node)sündmus.getSource()).getScene().getWindow();

        lava.setScene(mängustseen);
        lava.show();
        new Mäng();
    }

    public void reeglid(ActionEvent sündmus) {
        final Stage reeglid = new Stage();
        reeglid.initModality(Modality.APPLICATION_MODAL);
        reeglid.initOwner(((Node)sündmus.getSource()).getScene().getWindow());
        VBox reegliteKast = new VBox(20);
        reegliteKast.getChildren().add(new Text(reeglidTekst));
        Scene reegliteStseen = new Scene(reegliteKast, 300, 200);
        reeglid.setScene(reegliteStseen);
        reeglid.show();
    }

    public void reeglidtest(ActionEvent sündmus) throws IOException {
        Parent juur = FXMLLoader.load(getClass().getResource("reeglid.fxml"));
        Scene reeglistseen = new Scene(juur);
        Stage lava = (Stage)((Node)sündmus.getSource()).getScene().getWindow();

        lava.setScene(reeglistseen);
        lava.show();
    }

    public void lahku() {
        System.exit(0);
    }
}
