package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class Controller {

    private static CalcData caculator = new CalcData();
    private static final int half=20;
    private static Point box1=new Point(half,half);
    private static Point box2=new Point(half,half);

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
    private Text SVGText1;

    @FXML
    private Text SVGText2;




    public void calc(javafx.event.ActionEvent actionEvent) {
        textAsumut.setVisible(true);
        textDistance.setVisible(true);
        double[] result = caculator.map(textFieldArtilery.getText(),box1, textFieldTarget.getText(),box2);
        if (result != null) {
            textAsumut.setText(result[1] + "°");
            try {
                textDistance.setText(caculator.distanceToMIl(result[0]) + "Mil " + "(" + result[0] + " m)");
            } catch (NumberFormatException e) {
                textDistance.setText("out of Range");
            }
        }

    }
    //small square 40m, box on scene 250px conf=0.16
    public void MouseClick1(MouseEvent mouseEvent) {
        box1.setX((int)(mouseEvent.getX()*0.16));
        box1.setY((int)(mouseEvent.getY()*0.16));
        SVGText1.setText(box1.getX()+":"+box1.getY());
    }

    public void MouseClick2(MouseEvent mouseEvent) {
        box2.setX((int)(mouseEvent.getX()*0.16));
        box2.setY((int)(mouseEvent.getY()*0.16));
        SVGText2.setText(box2.getX()+":"+box2.getY());
    }

    public void Reset1(ActionEvent actionEvent) {
        box1.setX(half);
        box1.setY(half);
        SVGText1.setText(box1.getX()+":"+box1.getY());
    }

    public void Reset2(ActionEvent actionEvent) {
        box2.setX(half);
        box2.setY(half);
        SVGText2.setText(box2.getX()+":"+box2.getY());
    }
}
