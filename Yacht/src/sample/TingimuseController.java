package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;


public class TingimuseController {

    Skoorimine sk = new Skoorimine();
    int mitu = 0;

    @FXML
    Button nupp1;
    @FXML
    Button nupp2;
    @FXML
    Button nupp3;
    @FXML
    Button nupp4;
    @FXML
    Button nupp5;
    @FXML
    Button nupp6;
    @FXML
    Button nupp7;
    @FXML
    Button nupp8;
    @FXML
    Button nupp9;
    @FXML
    Button nupp10;
    @FXML
    Button nupp11;
    @FXML
    Button nupp12;


    public void lõpukontroll() throws IOException {
        if(mitu == 12){
            //Kuvab tulemuste stseeni
        }
    }

    public void ühed(ActionEvent sündmus)throws IOException{
        //mängija.setSkoor(mängija.getSkoor() += sk.skoori(1,täringud));
        nupp1.setDisable(true);
        mitu++;
        lõpukontroll();
    }

    public void kahed(ActionEvent sündmus)throws IOException{
        //mängija.setSkoor(mängija.getSkoor() += sk.skoori(2,täringud));
        nupp2.setDisable(true);
        mitu++;
        lõpukontroll();
    }

    public void kolmed(ActionEvent sündmus)throws IOException{
        //mängija.setSkoor(mängija.getSkoor() += sk.skoori(3,täringud));
        nupp3.setDisable(true);
        mitu++;
        lõpukontroll();
    }

    public void neljad(ActionEvent sündmus)throws IOException{
        //mängija.setSkoor(mängija.getSkoor() += sk.skoori(4,täringud));
        nupp4.setDisable(true);
        mitu++;
        lõpukontroll();
    }

    public void viied(ActionEvent sündmus)throws IOException{
        //mängija.setSkoor(mängija.getSkoor() += sk.skoori(5,täringud));
        nupp5.setDisable(true);
        mitu++;
        lõpukontroll();
    }

    public void kuued(ActionEvent sündmus)throws IOException{
        //mängija.setSkoor(mängija.getSkoor() += sk.skoori(6,täringud));
        nupp6.setDisable(true);
        mitu++;
        lõpukontroll();
    }

    public void maja(ActionEvent sündmus)throws IOException{
        //mängija.setSkoor(mängija.getSkoor() += sk.skoori(7,täringud));
        nupp7.setDisable(true);
        mitu++;
        lõpukontroll();
    }

    public void nelik(ActionEvent sündmus)throws IOException{
        //mängija.setSkoor(mängija.getSkoor() += sk.skoori(8,täringud));
        nupp8.setDisable(true);
        mitu++;
        lõpukontroll();
    }

    public void allrida(ActionEvent sündmus)throws IOException{
        //mängija.setSkoor(mängija.getSkoor() += sk.skoori(9,täringud));
        nupp9.setDisable(true);
        mitu++;
        lõpukontroll();
    }

    public void ülarida(ActionEvent sündmus)throws IOException{
        //mängija.setSkoor(mängija.getSkoor() += sk.skoori(10,täringud));
        nupp10.setDisable(true);
        mitu++;
        lõpukontroll();
    }

    public void summa(ActionEvent sündmus)throws IOException{
        //mängija.setSkoor(mängija.getSkoor() += sk.skoori(11,täringud));
        nupp11.setDisable(true);
        mitu++;
        lõpukontroll();
    }

    public void yacht(ActionEvent sündmus)throws IOException{
        //mängija.setSkoor(mängija.getSkoor() += sk.skoori(12,täringud));
        nupp12.setDisable(true);
        mitu++;
        lõpukontroll();
    }

}
