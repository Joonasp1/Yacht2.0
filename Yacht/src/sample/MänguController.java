package sample;

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

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class MänguController implements Initializable {

    public static MänguController Instance;
    private Mäng mäng;

    @FXML
    Label käiguLabel;

    @FXML
    HBox täringuteKast;
    @FXML
    ImageView täring1, täring2, täring3, täring4, täring5;

    Image[] täringutePildid;

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
    }

    public void määraTäringud(int[] numbrid) { // Muudab täringute pildid vastavalt etteantud numbritele.

        ImageView[] täringud = new ImageView[] {täring1, täring2, täring3, täring4, täring5};
        for (int i = 0; i < 5; i++) {
            täringud[i].setImage(täringutePildid[numbrid[i]-1]);
        }
    }

    public void valiSkoorimistingimus(ActionEvent sündmus) throws IOException{
        final Stage tingimused = new Stage();
        tingimused.initModality(Modality.APPLICATION_MODAL);
        tingimused.initOwner(((Node)sündmus.getSource()).getScene().getWindow());
        VBox tingimusteKast = new VBox(10);
        tingimusteKast.getChildren().add(nupp1);
        //nupp1.setOnMouseClicked(event -> ühed(event));
        tingimusteKast.getChildren().add(nupp2);
        tingimusteKast.getChildren().add(nupp3);
        tingimusteKast.getChildren().add(nupp4);
        tingimusteKast.getChildren().add(nupp5);
        tingimusteKast.getChildren().add(nupp6);
        tingimusteKast.getChildren().add(nupp7);
        tingimusteKast.getChildren().add(nupp8);
        tingimusteKast.getChildren().add(nupp9);
        tingimusteKast.getChildren().add(nupp10);
        tingimusteKast.getChildren().add(nupp11);
        tingimusteKast.getChildren().add(nupp12);
        Scene tingimusteStseen = new Scene(tingimusteKast, 300, 200);
        tingimused.setScene(tingimusteStseen);
        tingimused.show();
    }



    public void veereta() {
        määraTäringud(mäng.getTäringud().veereta());
        System.out.println(mäng);
    }


    public void lõpukontroll() throws IOException {
        if(mitu == 12){
            mäng.kokkuvõte();
        }
    }

    public void ühed(MouseEvent sündmus)throws IOException{
        System.out.println(mäng);
        int skoor = mäng.getSkoor().skoori(1,mäng.getTäringud().getTäringuVäärtused());
        System.out.println(skoor);
        nupp1.setDisable(true);
        mitu++;
        lõpukontroll();
    }

    public void kahed(ActionEvent sündmus)throws IOException{
        mäng.getMängijad()[mäng.getHetkeMängijaIndeks()].liidaSkoor(mäng.getSkoor().skoori(2,mäng.getTäringud().getTäringuVäärtused()));
        nupp2.setDisable(true);
        mitu++;
        lõpukontroll();
    }

    public void kolmed(ActionEvent sündmus)throws IOException{
        mäng.getMängijad()[mäng.getHetkeMängijaIndeks()].liidaSkoor(mäng.getSkoor().skoori(3,mäng.getTäringud().getTäringuVäärtused()));
        nupp3.setDisable(true);
        mitu++;
        lõpukontroll();
    }

    public void neljad(ActionEvent sündmus)throws IOException{
        mäng.getMängijad()[mäng.getHetkeMängijaIndeks()].liidaSkoor(mäng.getSkoor().skoori(4,mäng.getTäringud().getTäringuVäärtused()));
        nupp4.setDisable(true);
        mitu++;
        lõpukontroll();
    }

    public void viied(ActionEvent sündmus)throws IOException{
        mäng.getMängijad()[mäng.getHetkeMängijaIndeks()].liidaSkoor(mäng.getSkoor().skoori(5,mäng.getTäringud().getTäringuVäärtused()));
        nupp5.setDisable(true);
        mitu++;
        lõpukontroll();
    }

    public void kuued(ActionEvent sündmus)throws IOException{
        mäng.getMängijad()[mäng.getHetkeMängijaIndeks()].liidaSkoor(mäng.getSkoor().skoori(6,mäng.getTäringud().getTäringuVäärtused()));
        nupp6.setDisable(true);
        mitu++;
        lõpukontroll();
    }

    public void maja(ActionEvent sündmus)throws IOException{
        mäng.getMängijad()[mäng.getHetkeMängijaIndeks()].liidaSkoor(mäng.getSkoor().skoori(7,mäng.getTäringud().getTäringuVäärtused()));
        nupp7.setDisable(true);
        mitu++;
        lõpukontroll();
    }

    public void nelik(ActionEvent sündmus)throws IOException{
        mäng.getMängijad()[mäng.getHetkeMängijaIndeks()].liidaSkoor(mäng.getSkoor().skoori(8,mäng.getTäringud().getTäringuVäärtused()));
        nupp8.setDisable(true);
        mitu++;
        lõpukontroll();
    }

    public void allrida(ActionEvent sündmus)throws IOException{
        mäng.getMängijad()[mäng.getHetkeMängijaIndeks()].liidaSkoor(mäng.getSkoor().skoori(9,mäng.getTäringud().getTäringuVäärtused()));
        nupp9.setDisable(true);
        mitu++;
        lõpukontroll();
    }

    public void ülarida(ActionEvent sündmus)throws IOException{
        mäng.getMängijad()[mäng.getHetkeMängijaIndeks()].liidaSkoor(mäng.getSkoor().skoori(10,mäng.getTäringud().getTäringuVäärtused()));
        nupp10.setDisable(true);
        mitu++;
        lõpukontroll();
    }

    public void summa(ActionEvent sündmus)throws IOException{
        mäng.getMängijad()[mäng.getHetkeMängijaIndeks()].liidaSkoor(mäng.getSkoor().skoori(11,mäng.getTäringud().getTäringuVäärtused()));
        nupp11.setDisable(true);
        mitu++;
        lõpukontroll();
    }

    public void yacht(ActionEvent sündmus)throws IOException{
        mäng.getMängijad()[mäng.getHetkeMängijaIndeks()].liidaSkoor(mäng.getSkoor().skoori(12,mäng.getTäringud().getTäringuVäärtused()));
        nupp12.setDisable(true);
        mitu++;
        lõpukontroll();
    }

}
