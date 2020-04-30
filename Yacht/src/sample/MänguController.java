package sample;

import javafx.animation.TranslateTransition;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
    public Mäng mäng;

    private static final int täringuKlõpsamiseYmuutus = -50;
    private static final float täringuKlõpsamiseKestvus = 0.2f;

    @FXML
    Label käiguLabel;
    @FXML
    Label labelMängija1Nimi, labelMängija2Nimi, labelMängija1Punktid, labelMängija2Punktid;

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
        nimedeValimine();
    }

    public void nimedeValimine() { // Mängijate nimede valimise ekraan.
        final Stage nimed = new Stage();
        nimed.initModality(Modality.APPLICATION_MODAL);
        nimed.initOwner(käiguLabel.getScene().getWindow());
        VBox kast = new VBox(20);

        kast.getChildren().add(new Text("Mängija 1 nimi: "));
        TextField nimi1Kast = new TextField();
        kast.getChildren().add(nimi1Kast);

        kast.getChildren().add(new Text("Mängija 1 nimi: "));
        TextField nimi2Kast = new TextField();
        kast.getChildren().add(nimi2Kast);

        Button valmisNupp = new Button("Alusta");
        kast.getChildren().add(valmisNupp);
        valmisNupp.setOnMouseClicked(event -> {
            Mängija mängija1 = new Mängija(nimi1Kast.getText());
            Mängija mängija2 = new Mängija(nimi2Kast.getText());
            Mängija[] mängijad = new Mängija[] {mängija1, mängija2};

            labelMängija1Nimi.setText(mängija1.getNimi());
            labelMängija2Nimi.setText(mängija2.getNimi());

            mäng.alusta(mängijad);

            nimed.close();
        });

        // Nuppu ei saa vajutada enne, kui mõlema mängija nimi on valitud.
        valmisNupp.disableProperty().bind(
                Bindings.isEmpty(nimi1Kast.textProperty())
                        .and(Bindings.isEmpty(nimi2Kast.textProperty()))

                        .or(Bindings.isNotEmpty(nimi1Kast.textProperty())
                                .and(Bindings.isEmpty(nimi2Kast.textProperty())))

                        .or(Bindings.isEmpty(nimi1Kast.textProperty())
                                .and(Bindings.isNotEmpty(nimi2Kast.textProperty())))
        );

        Scene stseen = new Scene(kast, 300, 200);
        nimed.setScene(stseen);
        nimed.show();
    }

    public void määraKäik(Mängija mängija) {
        käiguLabel.setText(mängija.getNimi() + " käik");
        peidaTäringud();
        veeretaNupp.setText("Veereta");
        uuendaPunktiseisu();
    }

    public void uuendaPunktiseisu() {
        labelMängija1Punktid.setText(String.valueOf(mäng.getMängijad()[0].getSkoor()));
        labelMängija2Punktid.setText(String.valueOf(mäng.getMängijad()[1].getSkoor()));
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
            veeretaNupp.setDisable(false);
            tingimused.close();
            mäng.järgmine();
        });
        tingimusteKast.getChildren().add(nupp2);
        nupp2.setOnMouseClicked(event -> {
            kahed(event);
            mäng.getTäringud().setKordus(0);
            veeretaNupp.setDisable(false);
            tingimused.close();
            mäng.järgmine();
        });
        tingimusteKast.getChildren().add(nupp3);
        nupp3.setOnMouseClicked(event -> {
            kolmed(event);
            mäng.getTäringud().setKordus(0);
            veeretaNupp.setDisable(false);
            tingimused.close();
            mäng.järgmine();
        });
        tingimusteKast.getChildren().add(nupp4);
        nupp4.setOnMouseClicked(event -> {
            neljad(event);
            mäng.getTäringud().setKordus(0);
            veeretaNupp.setDisable(false);
            tingimused.close();
            mäng.järgmine();
        });
        tingimusteKast.getChildren().add(nupp5);
        nupp5.setOnMouseClicked(event -> {
            viied(event);
            mäng.getTäringud().setKordus(0);
            veeretaNupp.setDisable(false);
            tingimused.close();
            mäng.järgmine();
        });
        tingimusteKast.getChildren().add(nupp6);
        nupp6.setOnMouseClicked(event -> {
            kuued(event);
            mäng.getTäringud().setKordus(0);
            veeretaNupp.setDisable(false);
            tingimused.close();
            mäng.järgmine();
        });
        tingimusteKast.getChildren().add(nupp7);
        nupp7.setOnMouseClicked(event -> {
            maja(event);
            mäng.getTäringud().setKordus(0);
            veeretaNupp.setDisable(false);
            tingimused.close();
            mäng.järgmine();
        });
        tingimusteKast.getChildren().add(nupp8);
        nupp8.setOnMouseClicked(event -> {
            nelik(event);
            mäng.getTäringud().setKordus(0);
            veeretaNupp.setDisable(false);
            tingimused.close();
            mäng.järgmine();
        });
        tingimusteKast.getChildren().add(nupp9);
        nupp9.setOnMouseClicked(event -> {
            allrida(event);
            mäng.getTäringud().setKordus(0);
            veeretaNupp.setDisable(false);
            tingimused.close();
            mäng.järgmine();
        });
        tingimusteKast.getChildren().add(nupp10);
        nupp10.setOnMouseClicked(event -> {
            ülarida(event);
            mäng.getTäringud().setKordus(0);
            veeretaNupp.setDisable(false);
            tingimused.close();
            mäng.järgmine();
        });
        tingimusteKast.getChildren().add(nupp11);
        nupp11.setOnMouseClicked(event -> {
            summa(event);
            mäng.getTäringud().setKordus(0);
            veeretaNupp.setDisable(false);
            tingimused.close();
            mäng.järgmine();
        });
        tingimusteKast.getChildren().add(nupp12);
        nupp12.setOnMouseClicked(event -> {
            yacht(event);
            mäng.getTäringud().setKordus(0);
            veeretaNupp.setDisable(false);
            tingimused.close();
            mäng.järgmine();
        });
        Scene tingimusteStseen = new Scene(tingimusteKast, 300, 450);
        tingimused.setScene(tingimusteStseen);
        tingimused.show();
    }

    public void kokkuvõte(ActionEvent sündmus) { // Kutsutakse välja kui mäng on lõppenud. Esitab kokkuvõtte mängust.
        try {
            Parent juur = FXMLLoader.load(getClass().getResource("kokkuvõte.fxml"));
            Scene stseen = new Scene(juur);
            Stage lava = (Stage)((Node)sündmus.getSource()).getScene().getWindow();

            lava.setScene(stseen);
            lava.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public void mänguLõpp() {
        try {
            Parent juur = FXMLLoader.load(getClass().getResource("kokkuvõte.fxml"));
            Scene stseen = new Scene(juur);
            Stage lava = (Stage) (käiguLabel.getScene().getWindow());
            lava.setScene(stseen);
            lava.show();
        } catch (IOException e) {
            e.printStackTrace();
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
