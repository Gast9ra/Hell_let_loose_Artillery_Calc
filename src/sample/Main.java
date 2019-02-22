package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hell let loose Artillery Calc");
        primaryStage.setScene(new Scene(root, 884, 558));
        primaryStage.show();
    }


    public static void main(String[] args) {
//        double[] temp = map("g4-9.3", "h4-4.3");
//        System.out.println(roundTwo(11.49425287356322));
//        System.out.println( distanceTOMIl(650));


        launch(args);
    }


}