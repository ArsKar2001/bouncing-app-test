package karmanchuk.bouncing.ui.view;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import karmanchik.clientservice.entity.Agent;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class AgentView extends HBox {
    private final Agent agent;
    private final Integer percent;
    private final Integer average;

    public AgentView(Agent agent) {
        this.agent = agent;
        this.percent = agent.getPercent();
        this.average = agent.getAverageSaleCount();
    }

    public AgentView build() throws FileNotFoundException {
        this.setPrefWidth(1200);
        this.setPrefHeight(200);
        this.setPadding(new Insets(10));

        ImageView iv = new ImageView();
        iv.setFitWidth(100);
        iv.setFitHeight(100);
        if (agent.getLogo() != null) {
            iv.setImage(new Image(new FileInputStream("img" + agent.getLogo())));
        }

        Label lb1 = new Label(agent.getType().getTitle() + " | " + agent.getTitle());
        lb1.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
        Label lb2 = new Label("Приоритетность: " + agent.getPriority());

        Label lb3 = new Label(agent.getPhone());

        Label lb4 = new Label(getPercent() + "%");
        Label lb5 = new Label(getAverage() + " продаж за год");

        VBox vBox = new VBox(lb1, lb5, lb3, lb2);
        vBox.setPadding(new Insets(10));
        vBox.setPrefWidth(800);
        this.getChildren().addAll(
                iv,
                vBox,
                lb4
        );
        return this;
    }

    public Agent getAgent() {
        return agent;
    }

    public Integer getPercent() {
        return percent;
    }

    public Integer getAverage() {
        return average;
    }
}
