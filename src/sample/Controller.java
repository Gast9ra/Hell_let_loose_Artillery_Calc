package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class Controller {

    private static CalcData caculator = new CalcData();
    private static final int smallSquare = 20;
    private static final int half = smallSquare/2;
    private static final float factor = (float) smallSquare / 250;
    private static Point box1 = new Point(half, half);
    private static Point box2 = new Point(half, half);

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


    public void calc() {
        textAsumut.setVisible(true);
        textDistance.setVisible(true);
        double[] result = caculator.map(textFieldArtilery.getText(), box1, textFieldTarget.getText(), box2);
        if (result != null) {
            textAsumut.setText(result[1] + "°");
            try {
                textDistance.setText(caculator.distanceToMIl(result[0]) + "Mil " + "(" + result[0] + " m)");
            } catch (NumberFormatException e) {
                textDistance.setText("out of Range");
            }
        }

    }

    //small square 20m, box on scene 250px conf=0.08
    public void MouseClick1(MouseEvent mouseEvent) {
        box1.setX((int) (mouseEvent.getX() * factor));
        box1.setY((int) (mouseEvent.getY() * factor));
        SVGText1.setText(box1.getX() + ":" + box1.getY());
    }

    public void MouseClick2(MouseEvent mouseEvent) {
        box2.setX((int) (mouseEvent.getX() * factor));
        box2.setY((int) (mouseEvent.getY() * factor));
        SVGText2.setText(box2.getX() + ":" + box2.getY());
    }

    public void Reset1() {
        box1.setX(half);
        box1.setY(half);
        SVGText1.setText(box1.getX() + ":" + box1.getY());
    }

    public void Reset2() {
        box2.setX(half);
        box2.setY(half);
        SVGText2.setText(box2.getX() + ":" + box2.getY());
    }
}
