package karmanchuk.bouncing.ui;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import karmanchuk.bouncing.ui.JavaFXApplication.StageReadyEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@Component
public class StageRunner implements ApplicationListener<StageReadyEvent> {
    private final ApplicationContext context;
    private final Resource resource;
    private final String appTitle;

    private static SceneNavigate navigate;

    public StageRunner(ApplicationContext context,
                       @Value("classpath:/fxml/Main.fxml") Resource resource,
                       @Value("${spring.application.name}") String appTitle) {
        this.context = context;
        this.resource = resource;
        this.appTitle = appTitle;
    }

    public static SceneNavigate getNavigate() {
        return navigate;
    }

    @Override
    public void onApplicationEvent(StageReadyEvent stageReadyEvent) {
        try {
            Stage stage = stageReadyEvent.getStage();
            navigate = new SceneNavigate(stage, context);
            show(stage);
            getNavigate().load(resource).show();
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK).showAndWait();
            throw new RuntimeException(e);
        }
    }

    private void show(Stage stage) throws FileNotFoundException {
        stage.getIcons().add(new Image(new FileInputStream("img/Попрыженок.png")));
        stage.setTitle(appTitle);
        stage.show();
    }
}
