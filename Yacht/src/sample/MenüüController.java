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

    public void mängi(ActionEvent sündmus) throws IOException {
        Parent juur = FXMLLoader.load(getClass().getResource("mäng.fxml"));
        Scene mängustseen = new Scene(juur);
        Stage lava = (Stage)((Node)sündmus.getSource()).getScene().getWindow();

        lava.setScene(mängustseen);
        lava.show();

        new Mäng();
    }

    public void reeglid(ActionEvent sündmus) throws IOException {
        Parent juur = FXMLLoader.load(getClass().getResource("reeglid.fxml"));
        Scene reeglistseen = new Scene(juur);
        Stage lava = (Stage)((Node)sündmus.getSource()).getScene().getWindow();

        lava.setScene(reeglistseen);
        lava.show();
    }

    public void tagasi(ActionEvent sündmus) throws IOException {
        Parent juur = FXMLLoader.load(getClass().getResource("menüü.fxml"));
        Scene reeglistseen = new Scene(juur);
        Stage lava = (Stage)((Node)sündmus.getSource()).getScene().getWindow();

        lava.setScene(reeglistseen);
        lava.show();
    }

    public void tippskoorid(ActionEvent sündmus) {
        final Stage tippskoorid = new Stage();
        tippskoorid.initModality(Modality.APPLICATION_MODAL);
        tippskoorid.initOwner(((Node)sündmus.getSource()).getScene().getWindow());
        VBox kast = new VBox(20);
        kast.getChildren().add(new Text(
                Tippskoor.skoorid()
        ));
        Scene stseen = new Scene(kast, 300, 200);
        tippskoorid.setScene(stseen);
        tippskoorid.show();
    }

    public void lahku() {
        System.exit(0);
    }
}
