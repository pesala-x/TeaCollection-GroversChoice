package lk.ijse.tea.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigation {
    private static Parent rootNode;
    private static Scene scene;
    private static Stage stage;
    public static void switchNavigation(String path, AnchorPane event ) throws IOException {
        event.getChildren().clear();
        FXMLLoader loader = new FXMLLoader(Navigation.class.getResource("/view/" + path));
        Parent root = loader.load();
        event.getChildren().add(root);
    }
//    public static void switchNavigation(String path, AnchorPane pane) throws IOException {
//        pane.getChildren().clear();
//        FXMLLoader loader = new FXMLLoader(Navigation.class.getResource("/view/" + path));
//        Parent root = loader.load();
//        pane.getChildren().add(root);
//    }
    public static void switchPaging(Pane pane, String path) throws IOException {
        pane.getChildren().clear();
        FXMLLoader loader = new FXMLLoader(Navigation.class.getResource("/view/" + path));
        Parent root = loader.load();
        pane.getChildren().add(root);
    }
}
