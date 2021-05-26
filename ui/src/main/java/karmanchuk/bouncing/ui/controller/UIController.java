package karmanchuk.bouncing.ui.controller;

import javafx.fxml.Initializable;
import javafx.scene.Node;

import java.io.Serializable;

public interface UIController extends Initializable, Serializable {
    Node getNode();
    void setNode(Node node);

    void show();
}
