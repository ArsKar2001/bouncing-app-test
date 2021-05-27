package karmanchuk.bouncing.ui.view;

import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import karmanchik.clientservice.entity.Agent;

import java.io.FileNotFoundException;
import java.util.List;

public class PageAgentsView {
    private final List<Agent> agents;
    private final Integer pi;
    private final Integer pageSize;

    public PageAgentsView(List<Agent> agents, Integer pi, Integer pageSize) {
        this.agents = agents;
        this.pi = pi;
        this.pageSize = pageSize;
    }

    public ListView<AgentView> build() throws FileNotFoundException {
        ListView<AgentView> alv = new ListView<>();
        alv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        int page = pi * pageSize;
        for (int i = page; i < page + pageSize; i++) {
            Agent agent = agents.get(i);
            alv.getItems().add(new AgentView(agent).build());
        }
        return alv;
    }
}
