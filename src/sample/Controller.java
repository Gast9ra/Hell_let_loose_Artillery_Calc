package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.Text;



public class Controller {

    private static CalcData caculator=new CalcData();

    @FXML
    private TextField textFieldArtilery;

    @FXML
    private TextField textFieldTarget;

    @FXML
    private Text textAsumut;

    @FXML
    private Font x2;

    @FXML
    private Font x1;

    @FXML
    private Text textDistance;

    @FXML
    private Font x3;

    @FXML
    private Button btn;


    public void calc(javafx.event.ActionEvent actionEvent) {
        textAsumut.setVisible(true);
        textDistance.setVisible(true);
        double[] result= caculator.map(textFieldArtilery.getText(),textFieldTarget.getText());
        if (result!=null) {
            textAsumut.setText(result[1]+"°");
            try {
                textDistance.setText(caculator.distanceToMIl(result[0]) + "Mil " + "(" + result[0] + "meter)");
            }catch (NumberFormatException e){
                textDistance.setText("out of Range");
            }
        }

    }
}
