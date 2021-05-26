package karmanchuk.bouncing.ui.controller;

import javafx.scene.Node;
import karmanchuk.bouncing.ui.StageRunner;
import lombok.Getter;
import lombok.Setter;

public abstract class AbstractUIController implements UIController {
    @Getter
    @Setter
    private Node node;

    @Override
    public void show() {
        preShow();
        StageRunner.getNavigate().show(this);
        postShow();
    }

    protected abstract void postShow();

    protected abstract void preShow();
}
