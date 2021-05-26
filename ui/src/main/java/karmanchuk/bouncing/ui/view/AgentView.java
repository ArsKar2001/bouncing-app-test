package karmanchuk.bouncing.ui.view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import karmanchik.clientservice.entity.Agent;
import karmanchik.clientservice.entity.ProductSale;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.List;

public class AgentView extends Button {
    private final Agent agent;

    public AgentView(Agent agent) {
        this.agent = agent;
    }

    public AgentView build() throws FileNotFoundException {
        HBox hBox = new HBox();
        hBox.setPrefWidth(1200);
        hBox.setPrefHeight(200);
        hBox.setPadding(new Insets(10));

        ImageView iv = new ImageView();
        iv.setFitWidth(200);
        iv.setFitHeight(200);
        if (agent.getLogo() != null) {
            iv.setImage(new Image(new FileInputStream("img" + agent.getLogo())));
        }

        Label lb1 = new Label(agent.getType().getTitle() + " | " + agent.getTitle());
        lb1.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
        Label lb2 = new Label("Приоритетность: " + agent.getPriority());

        Label lb3 = new Label(agent.getPhone());

        Label lb4 = new Label(agent.getPercent() + "%");

        VBox vBox = new VBox(lb1, lb3, lb2);
        vBox.setPadding(new Insets(10));
        vBox.setPrefWidth(800);
        hBox.getChildren().addAll(
                iv,
                vBox,
                lb4
        );
        this.setGraphic(hBox);
        return this;
    }
}
