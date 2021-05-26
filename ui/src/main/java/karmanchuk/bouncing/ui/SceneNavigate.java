package karmanchuk.bouncing.ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import karmanchuk.bouncing.ui.controller.AbstractUIController;
import karmanchuk.bouncing.ui.controller.UIController;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SceneNavigate {
    private final ApplicationContext context;
    private final List<UIController> controllers = new ArrayList<>();
    private final Scene scene;

    public SceneNavigate(Stage stage, ApplicationContext context) {
        this.context = context;
        scene = new Scene(new Pane());
        stage.setScene(scene);
    }

    public UIController load(Resource resource) throws IOException {
        FXMLLoader loader = new FXMLLoader(resource.getURL());
        loader.setControllerFactory(context::getBean);
        Node root = loader.load();
        UIController controller = loader.getController();
        controller.setNode(root);
        return controller;
    }

    public void show(UIController controller) {
        controllers.add(controller);
        scene.setRoot((Parent) controller.getNode());
    }
}
