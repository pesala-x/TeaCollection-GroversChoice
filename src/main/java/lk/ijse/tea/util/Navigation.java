package lk.ijse.tea.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
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

    public static void changeStage(String fxml, String title) {
        FXMLLoader fxmlLoader = new FXMLLoader(Navigation.class.getResource(String.valueOf(fxml)));
        Parent root1 = null;
        try {
            root1 = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setScene(new Scene(root1));
        stage.setResizable(false);
        stage.show();
        stage.centerOnScreen();
    }

    public static void popUpPane(Pane pane, String path) throws IOException {
        //pane.getChildren().clear();
        FXMLLoader loader = new FXMLLoader(Navigation.class.getResource("/view/" + path));

        Parent root=loader.load();
        //pane.getChildren().add(root);

        Stage popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.initOwner(pane.getScene().getWindow());

        // Set the title if needed
        popupStage.setTitle("Popup Title");

        // Create a new scene with the loaded root and set it to the stage
        Scene scene = new Scene(root);
        popupStage.setScene(scene);

        // Center the stage on the screen
        popupStage.centerOnScreen();

        // Show the stage
        popupStage.showAndWait();

    }
}
