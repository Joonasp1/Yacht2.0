package sample;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class MänguController implements Initializable {

    public static MänguController Instance;
    private Mäng mäng;

    private static final int täringuKlõpsamiseYmuutus = -50;
    private static final float täringuKlõpsamiseKestvus = 0.2f;

    @FXML
    Label käiguLabel;

    @FXML
    HBox täringuteKast;
    @FXML
    ImageView täring1, täring2, täring3, täring4, täring5;

    Image[] täringutePildid;

    @FXML
    Button veeretaNupp;
    @FXML
    Button tingimuseNupp;

    @FXML
    Button nupp1 = new Button("1. Ühed");
    @FXML
    Button nupp2 = new Button("2. Kahed");
    @FXML
    Button nupp3 = new Button("3. Kolmed");
    @FXML
    Button nupp4 = new Button("4. Neljad");
    @FXML
    Button nupp5 = new Button("5. Viied");
    @FXML
    Button nupp6 = new Button("6. Kuues");
    @FXML
    Button nupp7 = new Button("7. Maja");
    @FXML
    Button nupp8 = new Button("8. Nelik");
    @FXML
    Button nupp9 = new Button("9. 1-2-3-4-5");
    @FXML
    Button nupp10 = new Button("10. 2-3-4-5-6");
    @FXML
    Button nupp11 = new Button("11. Täringute summa");
    @FXML
    Button nupp12 = new Button("12. Yacht");

    boolean t1Valitud = false;
    boolean t2Valitud = false;
    boolean t3Valitud = false;
    boolean t4Valitud = false;
    boolean t5Valitud = false;

    int mitu = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Instance = this;

        täringutePildid = new Image[6];
        for (int i = 0; i < 6; i++) {
            File fail = new File("src/resources/pildid/täring_" + (i + 1) + ".png");
            täringutePildid[i] = new Image(fail.toURI().toString());
        }
    }

    public void alustaMäng(Mäng mäng){
        this.mäng = mäng;
    }

    public void määraKäik(Mängija mängija) {
        käiguLabel.setText(mängija.getNimi() + " käik");
        peidaTäringud();
    }

    public void määraTäringud(int[] numbrid) { // Muudab täringute pildid vastavalt etteantud numbritele.

        ImageView[] täringud = new ImageView[] {täring1, täring2, täring3, täring4, täring5};
        for (int i = 0; i < 5; i++) {
            täringud[i].setImage(täringutePildid[numbrid[i]-1]);
            täringud[i].setVisible(true);
        }
    }

    private void peidaTäringud() { // Peidab täringud ekraanilt.
        ImageView[] täringud = new ImageView[] {täring1, täring2, täring3, täring4, täring5};
        for (int i = 0; i < täringud.length; i++) {
            täringud[i].setVisible(false);
        }
    }

    public void valiSkoorimistingimus(ActionEvent sündmus) {
        final Stage tingimused = new Stage();
        tingimused.initModality(Modality.APPLICATION_MODAL);
        tingimused.initOwner(((Node)sündmus.getSource()).getScene().getWindow());
        VBox tingimusteKast = new VBox(10);
        tingimusteKast.getChildren().add(nupp1);
        nupp1.setOnMouseClicked(event -> {
            ühed(event);
            mäng.getTäringud().setKordus(0);
            tingimused.close();
            mäng.järgmine();
        });
        tingimusteKast.getChildren().add(nupp2);
        nupp2.setOnMouseClicked(event -> {
            kahed(event);
            tingimused.close();
            mäng.järgmine();
        });
        tingimusteKast.getChildren().add(nupp3);
        nupp3.setOnMouseClicked(event -> {
            kolmed(event);
            tingimused.close();
            mäng.järgmine();
        });
        tingimusteKast.getChildren().add(nupp4);
        nupp4.setOnMouseClicked(event -> {
            neljad(event);
            tingimused.close();
            mäng.järgmine();
        });
        tingimusteKast.getChildren().add(nupp5);
        nupp5.setOnMouseClicked(event -> {
            viied(event);
            tingimused.close();
            mäng.järgmine();
        });
        tingimusteKast.getChildren().add(nupp6);
        nupp6.setOnMouseClicked(event -> {
            kuued(event);
            tingimused.close();
            mäng.järgmine();
        });
        tingimusteKast.getChildren().add(nupp7);
        nupp7.setOnMouseClicked(event -> {
            maja(event);
            tingimused.close();
            mäng.järgmine();
        });
        tingimusteKast.getChildren().add(nupp8);
        nupp8.setOnMouseClicked(event -> {
            nelik(event);
            tingimused.close();
            mäng.järgmine();
        });
        tingimusteKast.getChildren().add(nupp9);
        nupp9.setOnMouseClicked(event -> {
            allrida(event);
            tingimused.close();
            mäng.järgmine();
        });
        tingimusteKast.getChildren().add(nupp10);
        nupp10.setOnMouseClicked(event -> {
            ülarida(event);
            tingimused.close();
            mäng.järgmine();
        });
        tingimusteKast.getChildren().add(nupp11);
        nupp11.setOnMouseClicked(event -> {
            summa(event);
            tingimused.close();
            mäng.järgmine();
        });
        tingimusteKast.getChildren().add(nupp12);
        nupp12.setOnMouseClicked(event -> {
            yacht(event);
            tingimused.close();
            mäng.järgmine();
        });
        Scene tingimusteStseen = new Scene(tingimusteKast, 300, 450);
        tingimused.setScene(tingimusteStseen);
        tingimused.show();
    }

    public void veereta() {
        String valik = "";
        Täringud täringud = mäng.getTäringud();
        täringud.lisaKordus();
        if (täringud.võibUuestiVeeretada()) {
            veeretaNupp.setText("Veereta uuesti");

        }
        else {
            veeretaNupp.setText("Veereta");
            veeretaNupp.setDisable(true);
        }
        if(!t1Valitud && !t2Valitud && !t3Valitud && !t4Valitud && !t5Valitud) määraTäringud(mäng.getTäringud().veereta());
        else {
            if(t1Valitud){
                valik += "1,";
                täringTagasiAnimatsioon(täring1);
                t1Valitud = false;
            }
            if(t2Valitud){
                täringTagasiAnimatsioon(täring2);
                valik += "2,";
                t2Valitud = false;
            }
            if(t3Valitud){
                täringTagasiAnimatsioon(täring3);
                valik += "3,";
                t3Valitud = false;
            }
            if(t4Valitud){
                täringTagasiAnimatsioon(täring4);
                valik += "4,";
                t4Valitud = false;
            }if(t5Valitud){
                täringTagasiAnimatsioon(täring5);
                valik += "5,";
                t5Valitud = false;
            }
            String[] valikud = valik.split(",");
            määraTäringud(mäng.getTäringud().veereta(mäng.getTäringud().getTäringuVäärtused(),valikud));

        }
    }

    public void lõpukontroll() {
        if(mitu == 12){
            mäng.kokkuvõte();
        }
    }

    public void ühed(MouseEvent sündmus) {
        mäng.getMängijad()[mäng.getHetkeMängijaIndeks()].liidaSkoor(mäng.getSkoor().skoori(1,mäng.getTäringud().getTäringuVäärtused()));
        nupp1.setDisable(true);
        mitu++;
        lõpukontroll();
    }

    public void kahed(MouseEvent sündmus) {
        mäng.getMängijad()[mäng.getHetkeMängijaIndeks()].liidaSkoor(mäng.getSkoor().skoori(2,mäng.getTäringud().getTäringuVäärtused()));
        nupp2.setDisable(true);
        mitu++;
        lõpukontroll();
    }

    public void kolmed(MouseEvent sündmus) {
        mäng.getMängijad()[mäng.getHetkeMängijaIndeks()].liidaSkoor(mäng.getSkoor().skoori(3,mäng.getTäringud().getTäringuVäärtused()));
        nupp3.setDisable(true);
        mitu++;
        lõpukontroll();
    }

    public void neljad(MouseEvent sündmus) {
        mäng.getMängijad()[mäng.getHetkeMängijaIndeks()].liidaSkoor(mäng.getSkoor().skoori(4,mäng.getTäringud().getTäringuVäärtused()));
        nupp4.setDisable(true);
        mitu++;
        lõpukontroll();
    }

    public void viied(MouseEvent sündmus) {
        mäng.getMängijad()[mäng.getHetkeMängijaIndeks()].liidaSkoor(mäng.getSkoor().skoori(5,mäng.getTäringud().getTäringuVäärtused()));
        nupp5.setDisable(true);
        mitu++;
        lõpukontroll();
    }

    public void kuued(MouseEvent sündmus) {
        mäng.getMängijad()[mäng.getHetkeMängijaIndeks()].liidaSkoor(mäng.getSkoor().skoori(6,mäng.getTäringud().getTäringuVäärtused()));
        nupp6.setDisable(true);
        mitu++;
        lõpukontroll();
    }

    public void maja(MouseEvent sündmus) {
        mäng.getMängijad()[mäng.getHetkeMängijaIndeks()].liidaSkoor(mäng.getSkoor().skoori(7,mäng.getTäringud().getTäringuVäärtused()));
        nupp7.setDisable(true);
        mitu++;
        lõpukontroll();
    }

    public void nelik(MouseEvent sündmus) {
        mäng.getMängijad()[mäng.getHetkeMängijaIndeks()].liidaSkoor(mäng.getSkoor().skoori(8,mäng.getTäringud().getTäringuVäärtused()));
        nupp8.setDisable(true);
        mitu++;
        lõpukontroll();
    }

    public void allrida(MouseEvent sündmus) {
        mäng.getMängijad()[mäng.getHetkeMängijaIndeks()].liidaSkoor(mäng.getSkoor().skoori(9,mäng.getTäringud().getTäringuVäärtused()));
        nupp9.setDisable(true);
        mitu++;
        lõpukontroll();
    }

    public void ülarida(MouseEvent sündmus) {
        mäng.getMängijad()[mäng.getHetkeMängijaIndeks()].liidaSkoor(mäng.getSkoor().skoori(10,mäng.getTäringud().getTäringuVäärtused()));
        nupp10.setDisable(true);
        mitu++;
        lõpukontroll();
    }

    public void summa(MouseEvent sündmus) {
        mäng.getMängijad()[mäng.getHetkeMängijaIndeks()].liidaSkoor(mäng.getSkoor().skoori(11,mäng.getTäringud().getTäringuVäärtused()));
        nupp11.setDisable(true);
        mitu++;
        lõpukontroll();
    }

    public void yacht(MouseEvent sündmus) {
        mäng.getMängijad()[mäng.getHetkeMängijaIndeks()].liidaSkoor(mäng.getSkoor().skoori(12,mäng.getTäringud().getTäringuVäärtused()));
        nupp12.setDisable(true);
        mitu++;
        lõpukontroll();
    }

    //---------- Täringute peale vajutamine ----------

    public void täring1Vajutatud() {
        täringuKlõpsamiseAnimatsioon(täring1);
        t1Valitud = true;
    }

    public void täring2Vajutatud() {
        täringuKlõpsamiseAnimatsioon(täring2);
        t2Valitud = true;
    }

    public void täring3Vajutatud() {
        täringuKlõpsamiseAnimatsioon(täring3);
        t3Valitud = true;
    }

    public void täring4Vajutatud() {
        täringuKlõpsamiseAnimatsioon(täring4);
        t4Valitud = true;
    }

    public void täring5Vajutatud() {
        täringuKlõpsamiseAnimatsioon(täring5);
        t5Valitud = true;
    }

    //------------------------------------------------

    private void täringuKlõpsamiseAnimatsioon(Node täring) {
        käivitaAnimatsioon(täring, 0, täringuKlõpsamiseYmuutus, täringuKlõpsamiseKestvus);
    }

    private void täringTagasiAnimatsioon(Node täring){
        käivitaAnimatsioon(täring, 0, 0, täringuKlõpsamiseKestvus);
    }

    private TranslateTransition käivitaAnimatsioon(Node node, int x, int y, float kestvus) {
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(kestvus));

        transition.setToX(x);
        transition.setToY(y);
        transition.setNode(node);
        transition.play();

        return transition;
    }

}
